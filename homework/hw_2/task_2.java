package hw_2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;






/* Дана json строка (читать из файла и сохранить в файл) (ЕСЛИ НЕ ПОЛУЧАЕТСЯ JSON, то сделайте получение через обычный текстовый файл!!!)
Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
*/
public class task_2 {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        File filenameIN = new File("homework\\hw_2\\task_2_input.json");
        File filenameOUT = new File("homework\\hw_2\\task_2_output.txt");

        String jsonString = fileReader(filenameIN);
        System.out.println(jsonString);

        JSONParser parser = new JSONParser();
        JSONArray jsonarray = (JSONArray) parser.parse(jsonString);

        StringBuilder sBuilder = new StringBuilder();

        for (Object item : jsonarray) {
            JSONObject obj = (JSONObject) item;
            sBuilder.append(String.format("Студент %s получил %s по предмету %s.\n", 
                            obj.get("фамилия"), obj.get("оценка"), obj.get("предмет")));
            
            fileWriter(sBuilder, filenameOUT);
            sBuilder.setLength(0);
        }
        
    }

    public static String fileReader(File filename) {
        String str = "";
        try {
            FileReader reader = new FileReader(filename);
            Scanner scan = new Scanner(reader);
            str = scan.nextLine();

            scan.close();
            reader.close();
        } catch (Exception e) {
            System.out.println("reading error");
        }
        return str;
    }

    public static void fileWriter(StringBuilder str, File filename) {
        try {
            FileWriter writer = new FileWriter(filename, true);
            writer.write(str.toString());
            writer.close();
            System.out.println("saved");
        } catch (IOException e) {
            System.out.println("writing error");
        }
        
    }

    // public class Student{
    //         private String lastname;
    //         private String grade;
    //         private String subject;
    //         public String getLastname() {
    //             return lastname;
    //         }
    //         public void setLastname(String lastname) {
    //             this.lastname = lastname;
    //         }
    //         public String getGrade() {
    //             return grade;
    //         }
    //         public void setGrade(String grade) {
    //             this.grade = grade;
    //         }
    //         public String getSubject() {
    //             return subject;
    //         }
    //         public void setSubject(String subject) {
    //             this.subject = subject;
    //         }
    //         @Override
    //         public String toString() {
    //             return "Student [lastname=" + lastname + ", grade=" + grade + ", subject=" + subject + "]";
    //         }
            
    // }
}

