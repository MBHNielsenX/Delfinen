package FileReaderWriter;

import Members.*;
import Users.Chairman;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Reader {

    //Jens og Mikkels kode
    public static ArrayList<String> getAllMembersToArrayList(){
        ArrayList<String> memberData = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/Statistics/MemberList/Members.csv"));
            String currentLine;
            while((currentLine = reader.readLine()) !=null)
                if (currentLine.contains("ID:")) {
                    String[] currentLineArray = currentLine.split(": ");
                    memberData.add(currentLineArray[1]);
                    for (int i = 0; i < 9; i++) {
                        currentLine = reader.readLine();
                        String[] currentLineArrayTwo = currentLine.split(": ");
                        memberData.add(currentLineArrayTwo[1]);
                    }
                }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } return memberData;
    }
    public static ArrayList<SwimmingClubMember> getExistingMembersArrayList(ArrayList<String> memberData) {
        ArrayList<SwimmingClubMember> existingMembers = new ArrayList<>();

        for (int i = 0; i < memberData.size(); i+=10) {
            int currentId = Integer.parseInt(memberData.get(0+i));
            String currentName = memberData.get(1+i);
            String currentAddress = memberData.get(2+i);
            String currentEmail = memberData.get(3+i);
            int currentPhoneNumber = Integer.parseInt(memberData.get(4+i));
            LocalDate currentUsersBirthday = Chairman.convertToDate(memberData.get(5+i));
            int currentAge = Chairman.getAge(currentUsersBirthday);
            int currentContingent = Integer.parseInt(memberData.get(6+i));
            double currentArrears = Double.parseDouble(memberData.get(7+i));
            boolean currentIsActive = Boolean.parseBoolean(memberData.get(8+i));
            boolean currentIsCompetitive = Boolean.parseBoolean(memberData.get(9+i));

            switch (Chairman.whichMembership(currentAge)){
                case 1 -> existingMembers.add(new Junior(currentId,currentName,currentAddress,currentEmail,currentPhoneNumber,currentUsersBirthday,currentContingent,currentArrears,currentIsActive,currentIsCompetitive));
                case 2 -> existingMembers.add(new Senior(currentId,currentName,currentAddress,currentEmail,currentPhoneNumber,currentUsersBirthday,currentContingent,currentArrears,currentIsActive,currentIsCompetitive));
                case 3 -> existingMembers.add(new Pensioner(currentId,currentName,currentAddress,currentEmail,currentPhoneNumber,currentUsersBirthday,currentContingent,currentArrears,currentIsActive,currentIsCompetitive));
            }
        }
        return existingMembers;
    }

    //Mads' kode
    public static void showListOfMemberID() {
        ArrayList<Integer> allMemberID = new ArrayList<Integer>(SwimmingClubMember.getExistingMemberIds());
        for (int i = 0; i < allMemberID.size(); i++) {
            System.out.println("\n" + allMemberID.get(i) + "\n");
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
