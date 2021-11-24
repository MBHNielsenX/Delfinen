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
             System.out.println(allMemberID.get(i));
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
