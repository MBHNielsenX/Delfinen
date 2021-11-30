package IO;

import Members.Base.*;
import Users.Chairman;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class FileReader {
    //Jens og Mikkels kode
    public static ArrayList<String> getAllMembersToArrayList(){
        ArrayList<String> memberData = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader("src/Statistics/MemberList/Members.csv"));
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

    public static ArrayList<SwimmingClubMember> getExistingMembersFromCsvToArrayList(ArrayList<String> memberData) {
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


    public static ArrayList<String> getAllCompetitiveJuniorsToArrayList() {//test
        ArrayList<String> juniorCompetitiveData = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader("src/Statistics/MemberList/JuniorCompetitive.csv"));
            String currentLine;
            while ((currentLine = reader.readLine()) != null)
                if (currentLine.contains("ID:")) {
                    String[] currentLineArray = currentLine.split(": ");
                    juniorCompetitiveData.add(currentLineArray[1]);
                    for (int i = 0; i < 9; i++) {
                        currentLine = reader.readLine();
                        String[] currentLineArrayTwo = currentLine.split(": ");
                        juniorCompetitiveData.add(currentLineArrayTwo[1]);
                    }
                }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return juniorCompetitiveData;
    }

    public static ArrayList<SwimmingClubMember> getExistingCompetitiveJuniorsFromCsvToArrayList(ArrayList<String> memberCompetitiveData) { //Test
        ArrayList<SwimmingClubMember> existingCompetitiveJuniors = new ArrayList<>();

        for (int i = 0; i < memberCompetitiveData.size(); i+=6) {
            int currentId = Integer.parseInt(memberCompetitiveData.get(0+i));
            String currentName = memberCompetitiveData.get(1+i);
            double butterflyTime = Double.parseDouble(memberCompetitiveData.get(2+i));
            double backstrokeTime = Double.parseDouble(memberCompetitiveData.get(3+i));
            double breaststrokeTime = Double.parseDouble(memberCompetitiveData.get(4+i));
            double freestyleTime = Double.parseDouble(memberCompetitiveData.get(5+i));

            existingCompetitiveJuniors.add(new Junior(currentId,currentName,butterflyTime,backstrokeTime,breaststrokeTime,freestyleTime));

        }
        return existingCompetitiveJuniors;
    }

    public static ArrayList<String> getAllCompetitiveSeniorsToArrayList() {//test
        ArrayList<String> seniorsCompetitiveData = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader("src/Statistics/MemberList/SeniorCompetitive.csv"));
            String currentLine;
            while ((currentLine = reader.readLine()) != null)
                if (currentLine.contains("ID:")) {
                    String[] currentLineArray = currentLine.split(": ");
                    seniorsCompetitiveData.add(currentLineArray[1]);
                    for (int i = 0; i < 9; i++) {
                        currentLine = reader.readLine();
                        String[] currentLineArrayTwo = currentLine.split(": ");
                        seniorsCompetitiveData.add(currentLineArrayTwo[1]);
                    }
                }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return seniorsCompetitiveData;
    }

    public static ArrayList<SwimmingClubMember> getExistingCompetitiveSeniorsFromCsvToArrayList(ArrayList<String> memberCompetitiveData) { // test
        ArrayList<SwimmingClubMember> existingCompetitiveSeniors = new ArrayList<>();

        for (int i = 0; i < memberCompetitiveData.size(); i+=6) {
            int currentId = Integer.parseInt(memberCompetitiveData.get(0+i));
            String currentName = memberCompetitiveData.get(1+i);
            double butterflyTime = Double.parseDouble(memberCompetitiveData.get(2+i));
            double backstrokeTime = Double.parseDouble(memberCompetitiveData.get(3+i));
            double breaststrokeTime = Double.parseDouble(memberCompetitiveData.get(4+i));
            double freestyleTime = Double.parseDouble(memberCompetitiveData.get(5+i));

            existingCompetitiveSeniors.add(new Junior(currentId,currentName,butterflyTime,backstrokeTime,breaststrokeTime,freestyleTime));

        }
        return existingCompetitiveSeniors;
    }





    //Mads' code
    public static ArrayList<String> getMemberIdsFromFile() {
        //Method that grabs the IDs form the .csv file and is used for the existingMemberIDs variable in SwimmingClubMember.java
        ArrayList<String> grabbedIDFromFile = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader("src/Statistics/MemberList/Members.csv"));
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
            BufferedReader reader = new BufferedReader(new java.io.FileReader("src/Statistics/MemberList/Members.csv"));
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
