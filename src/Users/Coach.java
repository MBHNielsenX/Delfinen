package Users;

import Competitive.Competition;
import IO.FileWriter;
import IO.GetUserInput;
import Members.*;
import Members.Base.SwimmingClubMember;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;


public class Coach extends User {
    public Coach(String userName, String password, String email) {
        super(userName, password, email);
    }

    static void registerNewTrainingTime(ArrayList<SwimmingClubMember> competitiveJuniors, ArrayList<SwimmingClubMember> competitiveSeniors){
        SwimmingClubMember currentMember = findSwimmerFromID(competitiveJuniors,competitiveSeniors);
        String stroke = whichStroke();
        LocalDate currentDate = LocalDate.now();
        double time = timeToRegister();

        FileWriter.writeNewTrainingTime(currentMember,currentDate,stroke, time);

        updateTimes(currentMember,time,stroke);

    }

    static void registerNewCompetitionTime(ArrayList<SwimmingClubMember> competitiveJuniors, ArrayList<SwimmingClubMember> competitiveSeniors){
        SwimmingClubMember currentMember = findSwimmerFromID(competitiveJuniors,competitiveSeniors);
        Competition currentEvent = createNewCompetition();
        String stroke = whichStroke();
        double time = timeToRegister();
        System.out.println("Hvilken placering fik svømmeren ved konkurrencen?");
        int placering = GetUserInput.integer();

        FileWriter.writeNewCompetitionTime(currentMember,currentEvent,stroke,time,placering);

        updateTimes(currentMember,time,stroke);
    }

    static SwimmingClubMember findSwimmerFromID(ArrayList<SwimmingClubMember> competitiveJuniors, ArrayList<SwimmingClubMember> competitiveSeniors) {
        System.out.println("For juniorsvømmere - Tast 1\t\tFor seniorsvømmere - Tast 2");
        int juniorOrSenior = GetUserInput.menu(2);
        int swimmerID = inputIdOrSeeList();

        if (swimmerID == 0) {
            printMemberAndId(competitiveJuniors,competitiveSeniors,juniorOrSenior);
            swimmerID = inputIdOrSeeList();
        }

        switch (juniorOrSenior) {
            case 1 -> {
                return MemberHandler.getMemberFromId(swimmerID, competitiveJuniors);
            }
            case 2 -> {
                return MemberHandler.getMemberFromId(swimmerID, competitiveSeniors);
            }
        } return null;
    }

    static void printMemberAndId (ArrayList<SwimmingClubMember> competitiveJuniors, ArrayList<SwimmingClubMember> competitiveSeniors, int juniorOrSenior) { //fjernet static
        switch (juniorOrSenior) {
            case 1 -> Chairman.printAllMembersNamesAndIds(competitiveJuniors);
            case 2 -> Chairman.printAllMembersNamesAndIds(competitiveSeniors);
        }
    }

    static int inputIdOrSeeList() {
        System.out.println("For at se svømmere og ID - Tast 1\nEller\nIndtast ID nummer for den svømmer du ønsker at registrere en tid for:");
        return GetUserInput.integer();
    }

    public void registerNewTime(ArrayList<SwimmingClubMember> competitiveJuniors, ArrayList<SwimmingClubMember> competitiveSeniors){ //Rename til competition time
        boolean registerMore = true;
        while (registerMore) {
            System.out.println("Registrer en træningstid - Tast 1\t\tRegistrer en konkurrencetid - Tast 2");
            int userInput = GetUserInput.menu(2);
            switch (userInput) {
                case 1 -> registerNewTrainingTime(competitiveJuniors,competitiveSeniors);
                case 2 -> registerNewCompetitionTime(competitiveJuniors,competitiveSeniors);
            }
            registerMore = registerMoreTimes();
        }
    }

    static boolean registerMoreTimes(){
            System.out.println("Vil du registrere flere svømmere?\nJa - Tast 1\t\tNej - Tast 2");
            int userInput = GetUserInput.integer();
            return userInput == 1;
    }

    static Competition createNewCompetition() {
        System.out.println("Indtast navnet på det stævne medlemmet har deltaget i: ");
        String nameOfEvent = GetUserInput.string();
        return new Competition(nameOfEvent);
    }

    static String whichStroke(){
        System.out.println("Butterfly - Tast 1\t\tRygsvømning - Tast 2\nBrystsvømning - Tast 3\t\tCrawl - Tast 4");
        int userInput = GetUserInput.menu(4);
        switch (userInput){
            case 1 -> {return "butterfly";}
            case 2 -> {return "rygsvømning";}
            case 3 -> {return "brystsvømning";}
            case 4 -> {return "crawl";}
        }
        return null;
    }

    static double timeToRegister(){
        System.out.println("Indtast svømmerens resultat:");
        return GetUserInput.doubl();
    }

    static void updateTimes(SwimmingClubMember currentMember, double newTime, String stroke){
        switch (stroke){
            case "butterfly" -> {
                if (currentMember.getButterflyTime() > newTime || currentMember.getButterflyTime() == 0.0){
                    currentMember.setButterflyTime(newTime);}}
            case "backstroke" -> {
                if (currentMember.getBackstrokeTime() > newTime || currentMember.getBackstrokeTime() == 0.0){
                currentMember.setBackstrokeTime(newTime);}}
            case "breaststroke" -> {
                if (currentMember.getBreaststrokeTime() > newTime || currentMember.getBreaststrokeTime() == 0.0){
                    currentMember.setBreaststrokeTime(newTime);}}
            case "crawl" -> {
                if (currentMember.getFreestyleTime() > newTime || currentMember.getFreestyleTime() == 0.0){
                    currentMember.setFreestyleTime(newTime);}}
        }
    }

    public void sortTopResults(ArrayList<SwimmingClubMember> currentCompetitors, String stroke){
        switch (stroke){
            case "butterfly" -> currentCompetitors.sort(Comparator.comparingDouble(SwimmingClubMember::getButterflyTime));
            case "rygsvømning" -> currentCompetitors.sort(Comparator.comparingDouble(SwimmingClubMember::getBackstrokeTime));
            case "brystsvømning" -> currentCompetitors.sort(Comparator.comparingDouble(SwimmingClubMember::getBreaststrokeTime));
            case "crawl" -> currentCompetitors.sort(Comparator.comparingDouble(SwimmingClubMember::getFreestyleTime));
        }
    }

    public void printOutTopResults(ArrayList<SwimmingClubMember> currentList, String stroke){
        for (int i = 0; i < 5; i++) { // Top 5
            SwimmingClubMember m = currentList.get(i);
            double timeToGet = 0.0;
            switch (stroke){
                case "butterfly" -> timeToGet = m.getButterflyTime();
                case "rygsvømning" -> timeToGet = m.getBackstrokeTime();
                case "brystsvømning" -> timeToGet = m.getBreaststrokeTime();
                case "crawl" -> timeToGet = m.getFreestyleTime();
            }
            if (timeToGet == 0.0) {System.out.print("");
            }
            else {
                System.out.println("Tid nummer: "+(i+1)+" tilhørende svømmer: " + m.getName() + " i "+stroke+" er: " + timeToGet + ".");
            }
        }
    }

    public void displayTopFiveResults(ArrayList<SwimmingClubMember> competitiveJuniors, ArrayList<SwimmingClubMember> competitiveSeniors){
        System.out.println("For juniorsvømmere - Tast 1\t\tFor seniorsvømmere - Tast 2");
        int juniorOrSenior = GetUserInput.integer();
        String stroke = whichStroke();

        switch (juniorOrSenior){
            case 1 -> {
                sortTopResults(competitiveJuniors, stroke);
                printOutTopResults(competitiveJuniors, stroke);
            }
            case 2 -> {
                sortTopResults(competitiveSeniors, stroke);
                printOutTopResults(competitiveSeniors, stroke);
            }
        }
    }

}
