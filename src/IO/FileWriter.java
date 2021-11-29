//Mads' kode
package IO;

import Members.SwimmingClubMember;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class FileWriter {
    public static void writeNewMember(SwimmingClubMember member) {
        try {
            BufferedWriter writer = new BufferedWriter(new java.io.FileWriter("src/Statistics/MemberList/Members.csv",true));
            writer.write(getMemberInfo(member) + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeJuniorComp(SwimmingClubMember member) {
        try {
            BufferedWriter writer = new BufferedWriter(new java.io.FileWriter("src/Statistics/MemberList/JuniorCompetitive.csv",true));
            writer.write(getCompetitiveInfo(member) + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeSeniorComp(SwimmingClubMember member) {
        try {
            BufferedWriter writer = new BufferedWriter(new java.io.FileWriter("src/Statistics/MemberList/SeniorCompetitive.csv",true));
            writer.write(getCompetitiveInfo(member) + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getCompetitiveInfo(SwimmingClubMember member) {
        return "ID : " + member.getMemberId() + "\n" +
                "Name: " + member.getName() + "\n" +
                "Butterfly: " + member.getButterflyTime() + "\n" +
                "Rygsvømmning: " + member.getBackstrokeTime() + "\n" +
                "Brystsvømmning: " + member.getBreaststrokeTime() + "\n" +
                "Crawl: " + member.getFreestyleTime() + "\n";
    }

    public static String getMemberInfo(SwimmingClubMember member) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dateOfBirth = formatter.format(member.getDateOfBirth());

        return "ID: " + member.getMemberId() + "\n" +
                "Name: " + member.getName() + "\n" +
                "Address: " + member.getAddress() + "\n" +
                "Email: " + member.getEmail() + "\n" +
                "Phone number: " + member.getPhoneNumber() + "\n" +
                "Date of birth: " + dateOfBirth + "\n" +
                "Contingent: " + member.getContingent() + "\n" +
                "Arrears: " + member.getArrears() + "\n" +
                "Is member active: " + member.isActive() + "\n" +
                "Is member competitive: " + member.isCompetitive() + "\n";
    }

    //Jens
    public static void updateMembersList(ArrayList<SwimmingClubMember> allMembers){
        //Append set to false -> write nothing = wipe file
        try {
            BufferedWriter writer = new BufferedWriter(new java.io.FileWriter("src/Statistics/MemberList/Members.csv"));
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Write new members to file
        for (SwimmingClubMember member:allMembers) {
            try {
                BufferedWriter writer = new BufferedWriter(new java.io.FileWriter("src/Statistics/MemberList/Members.csv",true));
                writer.write(getMemberInfo(member) + "\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
