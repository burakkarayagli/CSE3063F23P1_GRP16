
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Json {
    private String databaseFolder = "database";
    private ArrayList<Student> students;
    private ArrayList<Lecturer> lecturers;
    private ArrayList<Advisor> advisors;
    private ArrayList<Course> courses;
    private ArrayList<CourseSection> courseSections;

    Json(String folderPath) {
        this.databaseFolder = folderPath;
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

    private void updateJson() {
        // filesı çekip jsonları oku / jsonların içinden username e eşit olanları
        // updatele / courses ve isApproved
        ArrayList<String> files = getStudentFiles();
        String jsonString;
        ArrayList<Student> students = getStudents();

        for (int i = 0; i < files.size(); i++) {
            jsonString = files.get(i);
            JsonParser parser = new JsonParser();
            JsonElement jsonElement = parser.parse(jsonString);
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            String username = jsonObject.get("username").getAsString();


            jsonObject.addProperty("isApproved", ); //true/false

            JsonArray courses = jsonObject.getAsJsonArray("courses");


            jsonObject.addProperty("courses", );//courses

        }
    }

    public ArrayList<String> getStudentFiles() {
        ArrayList<String> files = new ArrayList<>();
        File folder = new File(this.databaseFolder);
        File[] listOFiles = folder.listFiles();
        for (int i = 0; i < listOFiles.length; i++) {
            String name = listOFiles[i].getName();
            if (name.startsWith("15")) {
                files.add(name);
            }
        }
        return files;
    }
    // private String getAttribute(String path, String key){
    // try(Scanner scanner = new Scanner(Paths.get(path),
    // StandardCharsets.UTF_8.name());){
    // String content = scanner.useDelimiter("\\A").next();
    // scanner.close();
    // JsonParser parser = new JsonParser();
    // JsonElement neoJsonElement = parser.parse(content);
    // Object obj = neoJsonElement.getAsJsonObject().get(key);
    // }
    // catch (IOException e){
    // e.printStackTrace();
    // }

    // return "";
    // }

    public ArrayList<Student> getStudents() {
        ArrayList<String> files = getStudentFiles();
        for (int i = 0; i < files.size(); i++) {
            try (Scanner scanner = new Scanner(Paths.get("database/150120033.json"), StandardCharsets.UTF_8.name());) {
                String content = scanner.useDelimiter("\\A").next();
                scanner.close();
                JsonParser parser = new JsonParser();
                JsonElement neoJsonElement = parser.parse(content);
                JsonObject jsonObject = neoJsonElement.getAsJsonObject();
                // getting the attributes
                int studentID = jsonObject.get("id").getAsInt();
                String name = jsonObject.get("name").getAsString();
                String surname = jsonObject.get("surname").getAsString();
                String username = jsonObject.get("username").getAsString();
                String password = jsonObject.get("password").getAsString();
                String address = jsonObject.get("address").getAsString();
                String phoneNumber = jsonObject.get("phoneNumber").getAsString();
                int studentYear = jsonObject.get("studentYear").getAsInt();
                int entranceYear = jsonObject.get("entranceYear").getAsInt();
                boolean isApproved = jsonObject.get("isApproved").getAsBoolean();

                // get the selected course
                ArrayList<CourseSection> studentCourses = new ArrayList<CourseSection>();
                JsonArray jcourses = jsonObject.get("courses").getAsJsonArray();
                for (int j = 0; j < jcourses.size(); j++) {
                    String shortName = jcourses.get(j).getAsJsonObject().get("shortName").getAsString();
                    String fullName = jcourses.get(j).getAsJsonObject().get("fullName").getAsString();
                    String description = jcourses.get(j).getAsJsonObject().get("description").getAsString();
                    // initialize the dates for courseSection
                    ArrayList<TimeInterval> dates = new ArrayList<TimeInterval>();
                    JsonArray jdates = jcourses.get(j).getAsJsonArray();
                    for (int k = 0; k < jdates.size(); k++) {
                        String startTime = jdates.get(k).getAsJsonObject().get("startTime").getAsString();
                        String endTime = jdates.get(k).getAsJsonObject().get("endTime").getAsString();
                        String dayOfWeek = jdates.get(k).getAsJsonObject().get("dayOfWeek").getAsString();
                        TimeInterval timeInterval = new TimeInterval(startTime, endTime, dayOfWeek);
                        dates.add(timeInterval);
                    }
                    CourseSection course = getCourseSection(shortName, name);
                    if (course == null) {
                        course = new CourseSection(shortName, fullName, dates, name, null, j);
                    }
                    Lecturer lecturer = getLecturer(jcourses.get(j).getAsJsonObject().get("fullName").getAsString());

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

                    // create the course object
                    // create the grade object
                    // add to arraylist or Transkript
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public ArrayList<Lecturer> getLecturers() {
        try (Scanner scanner = new Scanner(Paths.get("database/parameters.json"),
                StandardCharsets.UTF_8.name());) {
            String content = scanner.useDelimiter("\\A").next();
            scanner.close();
            JsonParser parser = new JsonParser();
            JsonElement neoJsonElement = parser.parse(content);

            System.out.println(neoJsonElement.getAsJsonObject().get("surname").getAsString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        // Gson gson = new Gson();

        // try (Reader reader = new FileReader("database/150120033.json")) {

        // // Convert JSON File to Java Object
        // Object object = gson.fromJson(reader, Object.class);

        // // print staff
        // System.out.println(object);

        // } catch (IOException e) {
        // e.printStackTrace();
        // }

        // try (Scanner scanner = new Scanner(Paths.get("database/150120033.json"),
        // StandardCharsets.UTF_8.name());) {
        // // String content = new
        // // String(Files.readAllBytes(Paths.get("database/150120033.json")));
        // String content = scanner.useDelimiter("\\A").next();
        // scanner.close();
        // JsonParser parser = new JsonParser();
        // JsonElement neoJsonElement = parser.parse(content);
        //
        // System.out.println(neoJsonElement.getAsJsonObject().get("surname").getAsString());
        // } catch (IOException e) {
        // e.printStackTrace();
        // }

        Json json = new Json("database");
        json.getStudents();

    }

}