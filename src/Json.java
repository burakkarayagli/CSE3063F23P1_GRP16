
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

    private void writePretty() {
        File file = getParametersFile();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (Scanner scanner = new Scanner(file, StandardCharsets.UTF_8.name())) {
            String content = scanner.useDelimiter("\\A").next();
            scanner.close();
            JsonParser parser = new JsonParser();
            JsonElement neoJsonElement = parser.parse(content);
            FileWriter writer = new FileWriter(file);
            writer.write(gson.toJson(neoJsonElement)); // just an example how you can write a 1String to it
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Student> readStudents() {
        ArrayList<File> files = getStudentFiles();
        ArrayList<Student> students = new ArrayList<Student>();
        for (int i = 0; i < files.size(); i++) {
            try (Scanner scanner = new Scanner(files.get(i), StandardCharsets.UTF_8.name());) {
                String content = scanner.useDelimiter("\\A").next();
                scanner.close();

                Gson gson = new Gson();
                Student student = gson.fromJson(content, Student.class);
                students.add(student);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return students;

    }

    public void writeStudents(ArrayList<Student> students) {
        ArrayList<File> files = getStudentFiles();
        for (int i = 0; i < files.size(); i++) {
            try (Scanner scanner = new Scanner(files.get(i), StandardCharsets.UTF_8.name())) {
                String content = scanner.useDelimiter("\\A").next();
                scanner.close();
                JsonObject jObject = new JsonParser().parse(content).getAsJsonObject();
                for (int j = 0; j < students.size(); j++) {
                    Student student = students.get(j);
                    if (student.getUsername().equals(jObject.get("username").getAsString())) {
                        String updatedString;
                        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                        updatedString = gson.toJson(student);
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

    public ArrayList<Course> readCourses() {
        File file = getParametersFile();
        ArrayList<Course> courses = new ArrayList<Course>();
        try (Scanner scanner = new Scanner(file, StandardCharsets.UTF_8.name())) {
            String content = scanner.useDelimiter("\\A").next();
            scanner.close();
            JsonParser parser = new JsonParser();
            JsonElement neoJsonElement = parser.parse(content);
            JsonObject jObject = neoJsonElement.getAsJsonObject();
            JsonArray jCourses = jObject.get("courses").getAsJsonArray();
            for (int i = 0; i < jCourses.size(); i++) {
                Gson gson = new Gson();
                Course course = gson.fromJson(jCourses.get(i), Course.class);
                courses.add(course);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return courses;
    }

    public void writeCourses(ArrayList<Course> courses) {
        File file = getParametersFile();
        try (Scanner scanner = new Scanner(file, StandardCharsets.UTF_8.name())) {
            String content = scanner.useDelimiter("\\A").next();
            scanner.close();
            String sCourses = "";
            for (int i = 0; i < courses.size(); i++) {
                Course course = courses.get(i);
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                sCourses += gson.toJson(course, Course.class);
                if (i + 1 < courses.size())
                    sCourses += ",";
                sCourses += "\n";
            }
            sCourses = "[" + sCourses + "]";
            String updatedString = updateValue("courses", sCourses, content);
            FileWriter writer = new FileWriter(file);
            writer.write(updatedString); // just an example how you can write a String to it
            writer.flush();
            writer.close();
        } catch (

        IOException e) {
            e.printStackTrace();
        }
        writePretty();
    }

    public ArrayList<Lecturer> readLecturers() {
        File file = getParametersFile();
        ArrayList<Lecturer> lecturers = new ArrayList<Lecturer>();
        try (Scanner scanner = new Scanner(file, StandardCharsets.UTF_8.name())) {
            String content = scanner.useDelimiter("\\A").next();
            scanner.close();
            JsonParser parser = new JsonParser();
            JsonElement neoJsonElement = parser.parse(content);
            JsonObject jObject = neoJsonElement.getAsJsonObject();
            JsonArray jlecturers = jObject.get("lecturers").getAsJsonArray();
            for (int i = 0; i < jlecturers.size(); i++) {
                Gson gson = new Gson();
                Lecturer lecturer = gson.fromJson(jlecturers.get(i), Lecturer.class);
                lecturers.add(lecturer);
            }
        } catch (

        IOException e) {
            e.printStackTrace();
        }
        return lecturers;
    }

    public void writeLecturers(ArrayList<Lecturer> lecturers) {
        File file = getParametersFile();
        try (Scanner scanner = new Scanner(file, StandardCharsets.UTF_8.name())) {
            String content = scanner.useDelimiter("\\A").next();
            scanner.close();
            String sLecturers = "";
            for (int i = 0; i < lecturers.size(); i++) {
                Lecturer lecturer = lecturers.get(i);
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                sLecturers += gson.toJson(lecturer, Lecturer.class);
                if (i + 1 < lecturers.size())
                    sLecturers += ",";
                sLecturers += "\n";
            }
            sLecturers = "[" + sLecturers + "]";
            String updatedString = updateValue("lecturers", sLecturers, content);
            FileWriter writer = new FileWriter(file);
            writer.write(updatedString); // just an example how you can write a String to it
            writer.flush();
            writer.close();
        } catch (

        IOException e) {
            e.printStackTrace();
        }
        writePretty();
    }

    public ArrayList<Advisor> readAdvisors() {
        File file = getParametersFile();
        ArrayList<Advisor> advisors = new ArrayList<Advisor>();
        try (Scanner scanner = new Scanner(file, StandardCharsets.UTF_8.name())) {
            String content = scanner.useDelimiter("\\A").next();
            scanner.close();
            JsonParser parser = new JsonParser();
            JsonElement neoJsonElement = parser.parse(content);
            JsonObject jObject = neoJsonElement.getAsJsonObject();
            JsonArray jAdvisors = jObject.get("advisors").getAsJsonArray();
            for (int i = 0; i < jAdvisors.size(); i++) {
                Gson gson = new Gson();
                Advisor advisor = gson.fromJson(jAdvisors.get(i), Advisor.class);
                advisors.add(advisor);
            }
        } catch (

        IOException e) {
            e.printStackTrace();
        }
        return advisors;
    }

    public void writeAdvisors(ArrayList<Advisor> advisors) {
        File file = getParametersFile();
        try (Scanner scanner = new Scanner(file, StandardCharsets.UTF_8.name())) {
            String content = scanner.useDelimiter("\\A").next();
            scanner.close();
            String sAdvisors = "";
            for (int i = 0; i < advisors.size(); i++) {
                Advisor advisor = advisors.get(i);
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                sAdvisors += gson.toJson(advisor, Advisor.class);
                if (i + 1 < advisors.size())
                    sAdvisors += ",";
                sAdvisors += "\n";
            }
            sAdvisors = "[" + sAdvisors + "]";
            String updatedString = updateValue("advisors", sAdvisors, content);
            FileWriter writer = new FileWriter(file);
            writer.write(updatedString); // just an example how you can write a String to it
            writer.flush();
            writer.close();
        } catch (

        IOException e) {
            e.printStackTrace();
        }
        writePretty();
    }

    public ArrayList<CourseSection> readCourseSections() {
        File file = getParametersFile();
        ArrayList<CourseSection> courseSections = new ArrayList<CourseSection>();
        try (Scanner scanner = new Scanner(file, StandardCharsets.UTF_8.name())) {
            String content = scanner.useDelimiter("\\A").next();
            scanner.close();
            JsonParser parser = new JsonParser();
            JsonElement neoJsonElement = parser.parse(content);
            JsonObject jObject = neoJsonElement.getAsJsonObject();
            JsonArray jCourses = jObject.get("sections").getAsJsonArray();
            for (int i = 0; i < jCourses.size(); i++) {
                Gson gson = new Gson();
                CourseSection courseSection = gson.fromJson(jCourses.get(i), CourseSection.class);
                courseSections.add(courseSection);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return courseSections;
    }

    public void writeCourseSections(ArrayList<CourseSection> courseSections) {
        File file = getParametersFile();
        try (Scanner scanner = new Scanner(file, StandardCharsets.UTF_8.name())) {
            String content = scanner.useDelimiter("\\A").next();
            scanner.close();
            String sCourseSections = "";
            for (int i = 0; i < courseSections.size(); i++) {
                CourseSection courseSection = courseSections.get(i);
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                sCourseSections += gson.toJson(courseSection, CourseSection.class);
                if (i + 1 < courseSections.size())
                    sCourseSections += ",\n";
            }
            sCourseSections = "[\n" + sCourseSections + "\n]";
            String updatedString = updateValue("sections", sCourseSections, content);
            FileWriter writer = new FileWriter(file);
            writer.write(updatedString); // just an example how you can write a String to it
            writer.flush();
            writer.close();
        } catch (

        IOException e) {
            e.printStackTrace();
        }
        writePretty();
    }

    // public static void main(String[] args) {
    // Json json = new Json();
    // json.writeStudents(json.readStudents());
    // json.writeCourses(json.readCourses());
    // json.writeLecturers(json.readLecturers());
    // json.writeAdvisors(json.readAdvisors());
    // json.writeCourseSections(json.readCourseSections());
    // }
}
