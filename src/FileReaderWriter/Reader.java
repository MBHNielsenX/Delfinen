package FileReaderWriter;

import Members.SwimmingClubMember;
import Users.Chairman;

import java.io.*;
import java.util.ArrayList;

public class Reader { //Mads
    public static void showListOfMemberID() {
         ArrayList<Integer> allMemberID = new ArrayList<Integer>(SwimmingClubMember.getExistingMemberIds());
         for (int i = 0; i < allMemberID.size(); i++) {
             System.out.println("\n" + allMemberID.get(i) + "\n");
         }
    }

    public static void addExistingMemberToArrayList(ArrayList<String> memberData){
        switch (Chairman.whichMembership(Chairman.getAge()))
    }

    public static ArrayList<SwimmingClubMember> getAllMembersToArrayList(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/Statistics.MemberList/Members.csv"));
            String currentLine;
            ArrayList<String> memberData = new ArrayList<>();
            while((currentLine = reader.readLine()) !=null)
                if (currentLine.contains("ID:")) {
                    for (int i = 0; i < 10; i++) {
                        currentLine = reader.readLine();
                        String[] currentLineArray = currentLine.split(":");
                        memberData.add(currentLineArray[1]);
                    }
                }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getMemberIdsFromFile() {
        //Method that grabs the IDs form the .csv file and is used for the existingMemberIDs variable in SwimmingClubMember.java
        ArrayList<String> grabbedIDFromFile = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/Statistics/MemberList/Members.csv"));
            String currentLine;
            while((currentLine = reader.readLine()) !=null)
                if (currentLine.contains("ID")) {
                    grabbedIDFromFile.add(currentLine);
                }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return grabbedIDFromFile;
    }

    public static void printMembersList() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/Statistics/MemberList/Members.csv"));
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
