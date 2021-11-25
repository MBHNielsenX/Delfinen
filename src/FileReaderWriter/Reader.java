package FileReaderWriter;

import Members.SwimmingClubMember;
import java.io.*;
import java.util.ArrayList;

public class Reader { //Mads
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

    public static void showListOfMemberID() {
         ArrayList<Integer> allMemberID = new ArrayList<Integer>(SwimmingClubMember.getExistingMemberIds());
         for (int i = 0; i < allMemberID.size(); i++) {
             System.out.println("\n" + allMemberID.get(i) + "\n");
         }
    }

    public static ArrayList<String[]> grabMemberIDFromFile() {
        //Method that grabs the IDs form the .csv file and is used for the existingMemberIDs variable in SwimmingClubMember.java
        ArrayList<String[]> grabbedIDFromFile = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/Statistics.MemberList/Members.csv"));
            String currentLine;
            while((currentLine = reader.readLine()) !=null)
                if (currentLine.contains("ID")) {
                    String[] ID = currentLine.split(": ");
                    grabbedIDFromFile.add(ID);

                }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return grabbedIDFromFile;
    }

    public static void printMembersList() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/Statistics.MemberList/Members.csv"));
            String line;
            System.out.println();
            while((line = reader.readLine()) !=null)
                System.out.println(line);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
