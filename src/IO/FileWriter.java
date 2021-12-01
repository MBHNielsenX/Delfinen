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
            BufferedWriter writer = new BufferedWriter(new java.io.FileWriter("src/Statistics/MemberList/Members.csv",true));
            writer.write(getMemberInfo(member) + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeNewCompetitionTime(SwimmingClubMember clubMember, Competition competition, String disciplin, double time, int placering){
        try {
            BufferedWriter writer = new BufferedWriter(new java.io.FileWriter("src/Statistics/Memberlist/CompetitionTimes.csv",true));
            writer.write(getCompetitionInfo(clubMember,competition,disciplin,time,placering));
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void writeNewTrainingTime(SwimmingClubMember currentMember, LocalDate date, String disciplin, double time){
        try {
            BufferedWriter writer = new BufferedWriter(new java.io.FileWriter("src/Statistics/Memberlist/TrainingTimes.csv",true));
            writer.write(getTrainingInfo(currentMember, date, disciplin, time));
            writer.close();

        }catch (IOException e){
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

    public static void updateSeniorsList(ArrayList<SwimmingClubMember> competitiveSeniors) {
        try {
            BufferedWriter writer = new BufferedWriter(new java.io.FileWriter("src/Statistics/MemberList/SeniorCompetitive.csv"));
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (SwimmingClubMember competitiveMember:competitiveSeniors) {
            try {
                BufferedWriter writer = new BufferedWriter(new java.io.FileWriter("src/Statistics/MemberList/SeniorCompetitive.csv",true));
                writer.write(getCompetitiveInfo(competitiveMember) + "\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void updateJuniorsList(ArrayList<SwimmingClubMember> competitiveJuniors) {
        try {
            BufferedWriter writer = new BufferedWriter(new java.io.FileWriter("src/Statistics/MemberList/JuniorCompetitive.csv"));
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (SwimmingClubMember competitiveMember:competitiveJuniors) {
            try {
                BufferedWriter writer = new BufferedWriter(new java.io.FileWriter("src/Statistics/MemberList/JuniorCompetitive.csv",true));
                writer.write(getCompetitiveInfo(competitiveMember) + "\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
