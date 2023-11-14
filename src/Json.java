
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Json {
    private String databaseFolder = "database";

    Json(String folderPath) {
        this.databaseFolder = folderPath;
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
                // add soon
                System.out.println(jsonObject.get("courses"));

                // create transcript objects
                JsonArray transcipt = jsonObject.get("transcript").getAsJsonArray();
                for (int j = 0; j < transcipt.size(); j++) {
                    String shortName = transcipt.get(j).getAsJsonObject().get("shortName").getAsString();
                    String fullName = transcipt.get(j).getAsJsonObject().get("fullName").getAsString();
                    String description = transcipt.get(j).getAsJsonObject().get("description").getAsString();
                    String grade = transcipt.get(j).getAsJsonObject().get("grade").getAsString();
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