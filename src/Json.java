
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
// import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Json {
    private String databaseFolder = "database";
    private ArrayList<Course> courses = new ArrayList<Course>();
    private ArrayList<Lecturer> lecturers = new ArrayList<Lecturer>();
    private ArrayList<CourseSection> courseSections = new ArrayList<CourseSection>();
    private ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<Advisor> advisors = new ArrayList<Advisor>();

    Json(String folderPath) {
        this.databaseFolder = folderPath;
        this.initCourse();
        this.initLecturers();
        this.initCourseSection();
        this.initStudents();
        this.initAdvisor();
    }

    Json() {
        this.initCourse();
        this.initLecturers();
        this.initCourseSection();
        this.initStudents();
        this.initAdvisor();
    }

    private ArrayList<File> getStudentFiles() {
        ArrayList<File> files = new ArrayList<>();
        File folder = new File(this.databaseFolder);
        File[] listOFiles = folder.listFiles();
        for (int i = 0; i < listOFiles.length; i++) {
            String name = listOFiles[i].getName();
            if (name.startsWith("15")) {
                files.add(listOFiles[i]);
            }
        }
        return files;
    }

    private File getParametersFile() {
        File folder = new File(this.databaseFolder);
        File[] listOFiles = folder.listFiles();
        for (int i = 0; i < listOFiles.length; i++) {
            String name = listOFiles[i].getName();
            if (name.startsWith("para")) {
                return listOFiles[i];
            }
        }
        return null;
    }

    // return the lecturer if alrady initialized
    private Student getStudent(String username) {
        for (int i = 0; i < students.size(); i++) {
            Student student = this.students.get(i);
            if (student.getUsername().equals(username)) {
                return student;
            }
        }
        return null;
    }

    // return the lecturer if alrady initialized
    private Lecturer getLecturer(String username) {
        for (int i = 0; i < lecturers.size(); i++) {
            Lecturer lecturer = this.lecturers.get(i);
            if (lecturer.getUsername().equals(username)) {
                return lecturer;
            }
        }
        return null;
    }

    // return the course if already initialized
    private Course getCourse(String shortName) {
        for (int i = 0; i < courses.size(); i++) {
            Course course = this.courses.get(i);
            if (course.getShortName().equals(shortName)) {
                return course;
            }
        }
        return null;
    }

    // return the course section if already initialized
    private CourseSection getCourseSection(String shortName, String sectionName) {
        for (int i = 0; i < courseSections.size(); i++) {
            CourseSection courseSection = this.courseSections.get(i);
            if (courseSection.getShortName().equals(shortName) && courseSection.getSectionName().equals(sectionName)) {
                return courseSection;
            }
        }
        return null;
    }

    private void initCourse() {
        File paraFile = getParametersFile();
        try (Scanner scanner = new Scanner(paraFile,
                StandardCharsets.UTF_8.name());) {
            String content = scanner.useDelimiter("\\A").next();
            scanner.close();
            JsonParser parser = new JsonParser();
            JsonElement neoJsonElement = parser.parse(content);
            JsonObject jObject = neoJsonElement.getAsJsonObject();
            JsonArray jCourses = jObject.get("courses").getAsJsonArray();
            for (int i = 0; i < jCourses.size(); i++) {
                JsonObject jCourse = jCourses.get(i).getAsJsonObject();
                String shortName = jCourse.get("shortName").getAsString();
                String fullName = jCourse.get("fullName").getAsString();
                String description = jCourse.get("description").getAsString();
                Course course = new Course(shortName, fullName, description);
                courses.add(course);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initLecturers() {
        File paraFile = getParametersFile();
        try (Scanner scanner = new Scanner(paraFile,
                StandardCharsets.UTF_8.name());) {
            String content = scanner.useDelimiter("\\A").next();
            scanner.close();
            JsonParser parser = new JsonParser();
            JsonElement neoJsonElement = parser.parse(content);
            JsonObject jObject = neoJsonElement.getAsJsonObject();
            JsonArray jlecturers = jObject.get("lecturers").getAsJsonArray();
            for (int i = 0; i < jlecturers.size(); i++) {
                // getting the attributes
                JsonObject jsonObject = jlecturers.get(i).getAsJsonObject();
                String name = jsonObject.get("personName").getAsString();
                String surname = jsonObject.get("personSurname").getAsString();
                String username = jsonObject.get("username").getAsString();
                String password = jsonObject.get("password").getAsString();
                String reputation = jsonObject.get("reputation").getAsString();
                // get office hours
                ArrayList<TimeInterval> dates = new ArrayList<TimeInterval>();
                JsonArray jdates = jsonObject.get("officeHours").getAsJsonArray();
                for (int j = 0; j < jdates.size(); j++) {
                    String startTime = jdates.get(j).getAsJsonObject().get("startTime").getAsString();
                    String endTime = jdates.get(j).getAsJsonObject().get("endTime").getAsString();
                    String dayOfWeek = jdates.get(j).getAsJsonObject().get("dayOfWeek").getAsString();
                    TimeInterval timeInterval = new TimeInterval(startTime, endTime, dayOfWeek);
                    dates.add(timeInterval);
                }
                // salary, employee status
                int salary = jsonObject.get("salary").getAsInt();
                String employementStatus = jsonObject.get("employmentStatus").getAsString();

                // get the courses (empty)
                ArrayList<Course> lecturerCourses = new ArrayList<Course>();
                JsonArray jCourses = jsonObject.get("courses").getAsJsonArray();
                for (int j = 0; j < jCourses.size(); j++) {
                    String shortName = jCourses.get(j).getAsJsonObject().get("shortName").getAsString();
                    Course course = getCourse(shortName);
                    lecturerCourses.add(course);
                }
                // init the lecturer
                Lecturer lecturer = new Lecturer(name, surname, username, password, reputation, dates, salary,
                        employementStatus, lecturerCourses);
                lecturers.add(lecturer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initCourseSection() {
        File paraFile = getParametersFile();
        try (Scanner scanner = new Scanner(paraFile,
                StandardCharsets.UTF_8.name());) {
            String content = scanner.useDelimiter("\\A").next();
            scanner.close();
            JsonParser parser = new JsonParser();
            JsonElement neoJsonElement = parser.parse(content);
            JsonObject jObject = neoJsonElement.getAsJsonObject();
            JsonArray jCourses = jObject.get("sections").getAsJsonArray();
            for (int i = 0; i < jCourses.size(); i++) {
                JsonObject jCourse = jCourses.get(i).getAsJsonObject();
                String shortName = jCourse.get("shortName").getAsString();
                String sectionName = jCourse.get("sectionName").getAsString();
                String lecturerUsername = jCourse.get("lecturerUsername").getAsString();
                int quota = jCourse.get("quota").getAsInt();
                ArrayList<TimeInterval> dates = new ArrayList<TimeInterval>();
                JsonArray jdates = jCourse.get("dates").getAsJsonArray();
                for (int k = 0; k < jdates.size(); k++) {
                    String startTime = jdates.get(k).getAsJsonObject().get("startTime").getAsString();
                    String endTime = jdates.get(k).getAsJsonObject().get("endTime").getAsString();
                    String dayOfWeek = jdates.get(k).getAsJsonObject().get("dayOfWeek").getAsString();
                    TimeInterval timeInterval = new TimeInterval(startTime, endTime, dayOfWeek);
                    dates.add(timeInterval);
                }
                Course course = getCourse(shortName);
                Lecturer lectuer = getLecturer(lecturerUsername);
                // init the course section
                CourseSection courseSection = new CourseSection(
                        course.getShortName(),
                        course.getFullName(),
                        course.getDescription(),
                        dates,
                        sectionName,
                        lectuer,
                        quota

                );
                courseSections.add(courseSection);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initStudents() {
        ArrayList<File> files = getStudentFiles();
        for (int i = 0; i < files.size(); i++) {
            try (Scanner scanner = new Scanner(files.get(i), StandardCharsets.UTF_8.name());) {
                String content = scanner.useDelimiter("\\A").next();
                scanner.close();
                JsonParser parser = new JsonParser();
                JsonElement neoJsonElement = parser.parse(content);
                JsonObject jsonObject = neoJsonElement.getAsJsonObject();
                // getting the attributes
                String name = jsonObject.get("name").getAsString();
                String surname = jsonObject.get("surname").getAsString();
                String username = jsonObject.get("username").getAsString();
                String password = jsonObject.get("password").getAsString();
                String address = jsonObject.get("address").getAsString();
                String phoneNumber = jsonObject.get("phoneNumber").getAsString();
                int studentYear = jsonObject.get("studentYear").getAsInt();
                int entranceYear = jsonObject.get("entranceYear").getAsInt();
                boolean isApproved = jsonObject.get("isApproved").getAsBoolean();

                // get the course sections
                ArrayList<CourseSection> studentCourses = new ArrayList<CourseSection>();

                JsonArray jCourses = jsonObject.get("courses").getAsJsonArray();
                for (int j = 0; j < jCourses.size(); j++) {
                    String shortName = jCourses.get(j).getAsJsonObject().get("shortName").getAsString();
                    String sectionName = jCourses.get(j).getAsJsonObject().get("sectionName").getAsString();
                    CourseSection courseSection = getCourseSection(shortName, sectionName);
                    studentCourses.add(courseSection);

                }

                // create transcript objects
                Transcript transcipt = new Transcript();
                JsonArray jtranscipt = jsonObject.get("transcript").getAsJsonArray();
                for (int j = 0; j < jtranscipt.size(); j++) {
                    String shortName = jtranscipt.get(j).getAsJsonObject().get("shortName").getAsString();
                    String fullName = jtranscipt.get(j).getAsJsonObject().get("fullName").getAsString();
                    String description = jtranscipt.get(j).getAsJsonObject().get("description").getAsString();
                    String jgrade = jtranscipt.get(j).getAsJsonObject().get("grade").getAsString();
                    Course course = getCourse(shortName);
                    if (course == null) {
                        course = new Course(shortName, fullName, description);
                        courses.add(course);
                    }
                    Grade grade = new Grade(course, jgrade);
                    transcipt.addGrade(grade);
                }

                // create student object
                Student student = new Student(name, surname, username, password, address, phoneNumber, studentYear,
                        entranceYear, isApproved, studentCourses, transcipt);
                students.add(student);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void initAdvisor() {
        File paraFile = getParametersFile();
        try (Scanner scanner = new Scanner(paraFile,
                StandardCharsets.UTF_8.name());) {
            String content = scanner.useDelimiter("\\A").next();
            scanner.close();
            JsonParser parser = new JsonParser();
            JsonElement neoJsonElement = parser.parse(content);
            JsonObject jObject = neoJsonElement.getAsJsonObject();
            JsonArray jAdvisors = jObject.get("advisors").getAsJsonArray();
            for (int i = 0; i < jAdvisors.size(); i++) {
                // getting the attributes
                JsonObject jsonObject = jAdvisors.get(i).getAsJsonObject();
                String name = jsonObject.get("personName").getAsString();
                String surname = jsonObject.get("personSurname").getAsString();
                String username = jsonObject.get("username").getAsString();
                String password = jsonObject.get("password").getAsString();
                String reputation = jsonObject.get("reputation").getAsString();
                // get office hours
                ArrayList<TimeInterval> dates = new ArrayList<TimeInterval>();
                JsonArray jdates = jsonObject.get("officeHours").getAsJsonArray();
                for (int j = 0; j < jdates.size(); j++) {
                    String startTime = jdates.get(j).getAsJsonObject().get("startTime").getAsString();
                    String endTime = jdates.get(j).getAsJsonObject().get("endTime").getAsString();
                    String dayOfWeek = jdates.get(j).getAsJsonObject().get("dayOfWeek").getAsString();
                    TimeInterval timeInterval = new TimeInterval(startTime, endTime, dayOfWeek);
                    dates.add(timeInterval);
                }
                // salary, employee status
                int salary = jsonObject.get("salary").getAsInt();
                String employementStatus = jsonObject.get("employmentStatus").getAsString();

                // get the students
                ArrayList<Student> students = new ArrayList<Student>();
                JsonArray jStudents = jsonObject.get("students").getAsJsonArray();
                for (int j = 0; j < jStudents.size(); j++) {
                    String studentUsername = jStudents.get(j).getAsJsonObject().get("username").getAsString();
                    Student student = getStudent(studentUsername);
                    students.add(student);
                }
                // init the Advisors
                Advisor advisor = new Advisor(name, surname, username, password, reputation, dates, salary,
                        employementStatus, students);
                advisors.add(advisor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Lecturer> getLecturers() {
        return lecturers;
    }

    public ArrayList<CourseSection> getCourseSections() {
        return courseSections;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Advisor> getAdvisors() {
        return advisors;
    }

    private String updateValue(String keyPath, String updateText, String jsonText) {
        String[] keys = keyPath.split("/");
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject) jsonParser.parse(jsonText);
        JsonObject returnVal = jsonObject; // This holds the ref to target json object
        JsonPrimitive jp = new JsonPrimitive(updateText);
        String finalKey = keys[keys.length - 1];
        for (String key : keys) {
            if (jsonObject.get(key) != null && jsonObject.get(key).isJsonObject()) {
                jsonObject = (JsonObject) jsonObject.get(key);
                jsonObject.remove(finalKey);
                jsonObject.add(finalKey, jp);
                return returnVal.toString();
            } else if (jsonObject.get(finalKey) == null) {
                return returnVal.toString();
            }
        }
        jsonObject.remove(finalKey);
        if (jp.toString().startsWith("\"[")) {
            JsonElement je = jsonParser.parse(updateText).getAsJsonArray();
            jsonObject.add(finalKey, je);

        } else {
            jsonObject.add(finalKey, jp);

        }
        return returnVal.toString();
    }

    public void updateStudents(ArrayList<Student> studentss) {
        this.students = studentss;
        ArrayList<File> files = getStudentFiles();
        ArrayList<Student> students = getStudents();
        for (int i = 0; i < files.size(); i++) {
            try (Scanner scanner = new Scanner(files.get(i), StandardCharsets.UTF_8.name())) {
                String content = scanner.useDelimiter("\\A").next();
                scanner.close();
                JsonObject jObject = new JsonParser().parse(content).getAsJsonObject();
                for (int j = 0; j < students.size(); j++) {
                    Student student = students.get(j);
                    if (student.getUsername().equals(jObject.get("username").getAsString())) {
                        boolean isApproved = student.getApproved();
                        ArrayList<CourseSection> courses = student.getCourses();
                        String newCourses;
                        if (courses.size() == 0) {
                            newCourses = "[]";
                        } else {
                            newCourses = "[";
                            for (int k = 0; k < courses.size(); k++) {
                                CourseSection course = courses.get(k);
                                newCourses += "{";
                                newCourses += String.format("\"shortName\": \"%s\"", course.getShortName());
                                newCourses += ",";
                                newCourses += String.format("\"sectionName\": \"%s\"", course.getSectionName());
                                newCourses += ",";
                                newCourses += String.format("\"lecturerUsername\": \"%s\"",
                                        course.getLecturer().getUsername());
                                newCourses += ",";
                                newCourses += String.format("\"quota\": \"%s\"", course.getQuota());
                                newCourses += ",";
                                ArrayList<TimeInterval> dates = course.getDates();
                                String datesString = "[";
                                for (int l = 0; l < dates.size(); l++) {
                                    TimeInterval date = dates.get(l);
                                    datesString += "{";
                                    datesString += String.format("\"startTime\": \"%s\"", date.getStartTime());
                                    datesString += ",";
                                    datesString += String.format("\"endTime\": \"%s\"", date.getEndTime());
                                    datesString += ",";
                                    datesString += String.format("\"dayOfWeek\": \"%s\"", date.getDayOfWeek());
                                    datesString += "}";
                                    if (l + 1 < dates.size()) {
                                        datesString += ",";
                                    }
                                }
                                datesString += "]";
                                newCourses += String.format("\"dates\": %s", datesString);
                                newCourses += "}";
                                if (k + 1 < courses.size()) {
                                    newCourses += ",";
                                }

                            }
                            newCourses += "]";
                        }
                        System.out.println(newCourses);
                        String updatedString = updateValue("isApproved",
                                String.valueOf(isApproved), content);
                        updatedString = updateValue("courses",
                                newCourses, updatedString);
                        // System.out.println(updatedString);
                        FileWriter writer = new FileWriter(files.get(i));
                        writer.write(updatedString); // just an example how you can write a String to it
                        writer.flush();
                        writer.close();

                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateParametes() {
        File file = getParametersFile();
        try (Scanner scanner = new Scanner(file, StandardCharsets.UTF_8.name())) {
            String content = scanner.useDelimiter("\\A").next();
            scanner.close();
            ArrayList<Course> courses = getCourses();
            ArrayList<Lecturer> lecturers = getLecturers();
            ArrayList<CourseSection> courseSections = getCourseSections();
            ArrayList<Advisor> advisors = getAdvisors();
            String sCourses = "[";
            for (int i = 0; i < courses.size(); i++) {
                Course course = courses.get(i);
                Gson gson = new Gson();
                String jgson = gson.toJson(course);
                sCourses += jgson;
                if (i + 1 < courses.size())
                    sCourses += ",";

            }
            sCourses += "]";
            String sLecturers = "[";
            for (int i = 0; i < lecturers.size(); i++) {
                Lecturer lecturer = lecturers.get(i);
                Gson gson = new Gson();
                String jgson = gson.toJson(lecturer);
                sLecturers += jgson;
                if (i + 1 < lecturers.size())
                    sLecturers += ",";
            }
            sLecturers += "]";
            String sCourseSections = "[";
            for (int i = 0; i < courseSections.size(); i++) {
                CourseSection courseSection = courseSections.get(i);
                Gson gson = new Gson();
                String jgson = gson.toJson(courseSection);
                JsonParser parser = new JsonParser();
                JsonObject jCourseSection = parser.parse(jgson).getAsJsonObject();
                jCourseSection.remove("lecturer");
                jCourseSection.add("lecturerUsername", new JsonPrimitive(courseSection.getLecturer().getUsername()));
                sCourseSections += jCourseSection.toString();
                if (i + 1 < courseSections.size())
                    sCourseSections += ",";
            }
            sCourseSections += "]";
            String sAdvisors = "[";
            for (int i = 0; i < advisors.size(); i++) {
                Advisor advisor = advisors.get(i);
                Gson gson = new Gson();
                String jgson = gson.toJson(advisor);
                sAdvisors += jgson;
                if (i + 1 < advisors.size())
                    sAdvisors += ",";
            }
            sAdvisors += "]";
            // update the params files
            String updatedString = updateValue("courses",
                    sCourses, content);
            updatedString = updateValue("lecturers", sLecturers, updatedString);
            updatedString = updateValue("sections", sCourseSections, updatedString);
            updatedString = updateValue("advisors", sAdvisors, updatedString);

            FileWriter writer = new FileWriter(file);
            writer.write(updatedString); // just an example how you can write a String to it
            writer.flush();
            writer.close();

        } catch (

        IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // try (Scanner scanner = new Scanner(Paths.get("database/150120033.json"),
        // StandardCharsets.UTF_8.name());) {
        // // String content = new
        // // String(Files.readAllBytes(Paths.get("database/150120033.json")));
        // String content = scanner.useDelimiter("\\A").next();
        // scanner.close();
        // JsonParser parser = new JsonParser();
        // JsonElement neoJsonElement = parser.parse(content);
        //
        //
        // System.out.println(neoJsonElement.getAsJsonObject().get("surname").getAsString());
        // } catch (IOException e) {
        // e.printStackTrace();
        // }

        // Json json = new Json("database");
        // json.updateStudents();
        // json.updateParametes();

        // for (int i = 0; i < json.getCourseSections().size(); i++) {
        // System.out.println(json.getCourseSections().get(i).getCourseInfo());
        // System.out.println(json.getCourseSections().get(i).getLecturer().getUsername());
        // }

    }

}

// Create Course Section
// JsonArray jcourses = jsonObject.get("courses").getAsJsonArray();
// for (int j = 0; j < jcourses.size(); j++) {
// String shortName =
// jcourses.get(j).getAsJsonObject().get("shortName").getAsString();
// String fullName =
// jcourses.get(j).getAsJsonObject().get("fullName").getAsString();
// String description =
// jcourses.get(j).getAsJsonObject().get("description").getAsString();
// // initialize the dates for courseSection
// ArrayList<TimeInterval> courseDates = new ArrayList<TimeInterval>();
// JsonArray jCourseDates =
// jcourses.get(j).getAsJsonObject().get("dates").getAsJsonArray();
// for (int k = 0; k < jCourseDates.size(); k++) {
// String startTime =
// jCourseDates.get(k).getAsJsonObject().get("startTime").getAsString();
// String endTime =
// jCourseDates.get(k).getAsJsonObject().get("endTime").getAsString();
// String dayOfWeek =
// jCourseDates.get(k).getAsJsonObject().get("dayOfWeek").getAsString();
// TimeInterval timeInterval = new TimeInterval(startTime, endTime, dayOfWeek);
// courseDates.add(timeInterval);
// }
// Lecturer lecturer =
// getLecturer(jcourses.get(j).getAsJsonObject().get("fullName").getAsString());
// if (lecturer == null) {
// System.out.println("Lecturer must be initialize first!!");
// }
// int quota = jcourses.get(j).getAsJsonObject().get("quota").getAsInt();
// CourseSection course = getCourseSection(shortName, name);
// if (course == null) {
// // add the description part
// /////// **** update
// course = new CourseSection(shortName, fullName, dates, name, lecturer,
// quota);
// courseSections.add(course);
// }
// studentCourses.add(course);
// }

// // get the given course sections(STUDENTS)
// ArrayList<CourseSection> studentCourses = new ArrayList<CourseSection>();
// JsonArray jcourses = jsonObject.get("courses").getAsJsonArray();
// for (int j = 0; j < jcourses.size(); j++) {
// String shortName =
// jcourses.get(j).getAsJsonObject().get("shortName").getAsString();
// String fullName =
// jcourses.get(j).getAsJsonObject().get("fullName").getAsString();
// String description =
// jcourses.get(j).getAsJsonObject().get("description").getAsString();
// // initialize the dates for courseSection
// ArrayList<TimeInterval> dates = new ArrayList<TimeInterval>();
// JsonArray jdates =
// jcourses.get(j).getAsJsonObject().get("dates").getAsJsonArray();
// for (int k = 0; k < jdates.size(); k++) {
// String startTime =
// jdates.get(k).getAsJsonObject().get("startTime").getAsString();
// String endTime =
// jdates.get(k).getAsJsonObject().get("endTime").getAsString();
// String dayOfWeek =
// jdates.get(k).getAsJsonObject().get("dayOfWeek").getAsString();
// TimeInterval timeInterval = new TimeInterval(startTime, endTime, dayOfWeek);
// dates.add(timeInterval);
// }
// Lecturer lecturer =
// getLecturer(jcourses.get(j).getAsJsonObject().get("fullName").getAsString());
// if (lecturer == null) {
// System.out.println("Lecturer must be initialize first!!");
// }
// int quota = jcourses.get(j).getAsJsonObject().get("quota").getAsInt();
// CourseSection course = getCourseSection(shortName, name);
// if (course == null) {
// // add the description part
// /////// **** update
// course = new CourseSection(shortName, fullName, dates, name, lecturer,
// quota);
// courseSections.add(course);
// }
// studentCourses.add(course);
// }
