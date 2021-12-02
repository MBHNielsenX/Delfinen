//Mads' kode
package IO;

import Competitive.Competition;
import Members.Base.SwimmingClubMember;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class FileWriter {
    public static void writeNewMember(SwimmingClubMember member) {
        try {
            BufferedWriter writer = new BufferedWriter(new java.io.FileWriter("src/Statistics/MemberList/Members.txt",true));
            writer.write(getMemberInfo(member) + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeNewCompetitionTime(SwimmingClubMember clubMember, Competition competition, String disciplin, double time, int placering){
        try {
            BufferedWriter writer = new BufferedWriter(new java.io.FileWriter("src/Statistics/Memberlist/CompetitionTimes.txt",true));
            writer.write(getCompetitionInfo(clubMember,competition,disciplin,time,placering)+"\n");
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void writeNewTrainingTime(SwimmingClubMember currentMember, LocalDate date, String disciplin, double time){
        try {
            BufferedWriter writer = new BufferedWriter(new java.io.FileWriter("src/Statistics/Memberlist/TrainingTimes.txt",true));
            writer.write(getTrainingInfo(currentMember, date, disciplin, time)+"\n");
            writer.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void writeJuniorComp(SwimmingClubMember member) {
        try {
            BufferedWriter writer = new BufferedWriter(new java.io.FileWriter("src/Statistics/MemberList/JuniorCompetitive.txt",true));
            writer.write(getCompetitiveInfo(member) + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeSeniorComp(SwimmingClubMember member) {
        try {
            BufferedWriter writer = new BufferedWriter(new java.io.FileWriter("src/Statistics/MemberList/SeniorCompetitive.txt",true));
            writer.write(getCompetitiveInfo(member) + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getCompetitionInfo(SwimmingClubMember member, Competition competition, String disciplin, double time, int placering){
        return  "ID: " + member.getMemberId() + "\n"+
                "Navn: " + member.getName() + "\n" +
                "Svømmestævne: " + competition.getNameOfCompetition() + "\n" +
                "Disciplin: " + disciplin + "\n" +
                "Tid: " + time + "\n" +
                "Placering: " + placering+"\n";
    }

    public static String getTrainingInfo(SwimmingClubMember member, LocalDate date, String disciplin, double time){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dateOfTraining = formatter.format(date);

        return  "ID: " + member.getMemberId() + "\n"+
                "Name: " + member.getName() + "\n" +
                "Disciplin: " + disciplin + "\n" +
                "Tid: " + time + "\n" +
                "Dato: " + dateOfTraining + "\n";
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

    public static String getCompetitiveInfo(SwimmingClubMember member) {
        return "ID : " + member.getMemberId() + "\n" +
                "Name: " + member.getName() + "\n" +
                "Butterfly: " + member.getButterflyTime() + "\n" +
                "Rygsvømmning: " + member.getBackstrokeTime() + "\n" +
                "Brystsvømmning: " + member.getBreaststrokeTime() + "\n" +
                "Crawl: " + member.getFreestyleTime() + "\n";
    }

    //Jens
    public static void updateMembersList(ArrayList<SwimmingClubMember> allMembers, ArrayList<SwimmingClubMember> juniorCompetitive, ArrayList<SwimmingClubMember> seniorCompetitive, String memberType){
        //Append set to false -> write nothing = wipe file
        String filePath = null;
        String members ="src/Statistics/MemberList/Members.txt";
        String senior ="src/Statistics/MemberList/SeniorCompetitive.txt";
        String junior ="src/Statistics/MemberList/JuniorCompetitive.txt";

        if (memberType.equals("general")){
            filePath=members;
        } else if (memberType.equals("junior")){
            filePath=junior;
        }else if (memberType.equals("senior")){
            filePath=senior;
        }

        try {
            BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(filePath));
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Write new members to file
        ArrayList<SwimmingClubMember> memberList = null;
        if (memberType.equals("general")){
            memberList = allMembers;
        } else if (memberType.equals("junior")){
            memberList = juniorCompetitive;
        } else if (memberType.equals("senior")){
            memberList = seniorCompetitive;
        }

        for (SwimmingClubMember member:memberList) {
            try {
                BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(filePath,true));
                if (memberType.equals("general")){
                    writer.write(getMemberInfo(member) + "\n");
                } else if (memberType.equals("junior") || memberType.equals("senior")){
                    writer.write(getCompetitiveInfo(member) + "\n");
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
