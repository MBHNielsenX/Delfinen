package FileReaderWriter;

import java.io.*;
import java.util.ArrayList;

public class Reader {
    /*
    public static void read() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/FileReaderWriter/Members.csv"));
            String line;
            while((line = reader.readLine()) !=null)
                System.out.println(line);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     */
     static ArrayList<String> listOfMemberID() {
        System.out.println("Enter the ID of the member you want to find: \n");
        String memberID = String.valueOf(GetUserInput.integer());
        ArrayList<String> IDOfMembers = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/FileReaderWriter/Members.csv"));
            String currentLine;
            while((currentLine = reader.readLine()) !=null)
                if (currentLine.contains("ID")) {
                    IDOfMembers.add(currentLine);
                }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return IDOfMembers;
    }

    public static void findMemberID() {
       ArrayList<String> IDMembers = listOfMemberID();
        for (int i = 0; i < IDMembers.size(); i++) {
            System.out.println(IDMembers.get(i));

        }
    }

    public static void printMembersList() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/FileReaderWriter/Members.csv"));
            String line;
            while((line = reader.readLine()) !=null)
                System.out.println(line);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
