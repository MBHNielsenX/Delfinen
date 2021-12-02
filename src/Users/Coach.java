package Users;

import Competitive.Competition;
import IO.*;
import Members.*;
import Members.Base.SwimmingClubMember;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;


public class Coach extends User {
    public Coach(String userName, String password, String email) {
        super(userName, password, email);
    }


    public void registerNewTrainingTime(ArrayList<SwimmingClubMember> competitiveJuniors, ArrayList<SwimmingClubMember> competitiveSeniors){
        SwimmingClubMember currentMember = whichSwimmer(competitiveJuniors,competitiveSeniors);
        String stroke =  whichStroke();
        LocalDate currentDate = LocalDate.now();
        double time = timeOfSwim();

        FileWriter.writeNewTrainingTime(currentMember,currentDate,stroke, time);

        switch (stroke) {
            case "butterfly" -> updateButterflyTime(currentMember,time);
            case "backstroke" -> updateBackstrokeTime(currentMember,time);
            case "breaststroke" -> updateBreaststrokeTime(currentMember,time);
            case "crawl" -> updateFreestyleTime(currentMember,time);
        }

    }

    public void registerNewCompetitionTime(ArrayList<SwimmingClubMember> competitiveJuniors, ArrayList<SwimmingClubMember> competitiveSeniors){
        SwimmingClubMember currentMember = whichSwimmer(competitiveJuniors,competitiveSeniors);
        Competition currentEvent = Competition.createNewCompetition();
        String stroke = whichStroke();
        double time = timeOfSwim();
        System.out.println("Hvilken placering fik svømmeren ved konkurrencen?");
        int placering = GetUserInput.integer();
        FileWriter.writeNewCompetitionTime(currentMember,currentEvent,stroke,time,placering);

        switch (stroke) {
            case "butterfly" -> updateButterflyTime(currentMember, time);
            case "backstroke" -> updateBackstrokeTime(currentMember, time);
            case "breaststroke" -> updateBreaststrokeTime(currentMember, time);
            case "crawl" -> updateFreestyleTime(currentMember, time);
        }
    }

    public SwimmingClubMember whichSwimmer(ArrayList<SwimmingClubMember> competitiveJuniors, ArrayList<SwimmingClubMember> competitiveSeniors) {
        System.out.println("Tast 1 for juniorsvømmere eller 2 for seniorsvømmere!");
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

    public static void printMemberAndId (ArrayList<SwimmingClubMember> competitiveJuniors, ArrayList<SwimmingClubMember> competitiveSeniors, int juniorOrSenior) {
        switch (juniorOrSenior) {
            case 1 -> Chairman.printAllMembersNamesAndIds(competitiveJuniors);
            case 2 -> Chairman.printAllMembersNamesAndIds(competitiveSeniors);
        }
    }

    public static int inputIdOrSeeList() {
        System.out.println("Indtast ID nummer for den svømmer du ønsker at registrere en tid for  -  tast 0 for at se en liste over svømmere og deres ID");

        return GetUserInput.integer();
    }

    public void registerNewTime(ArrayList<SwimmingClubMember> competitiveJuniors, ArrayList<SwimmingClubMember> competitiveSeniors){ //Rename til competition time
        boolean registerMore = true;
        while (registerMore) {
            System.out.println("Tast 1 for at registerer en træningstid eller tast 2 for at registrer en konkurrencetid.");
            int userInput = GetUserInput.menu(2);
            switch (userInput) {
                case 1 -> registerNewTrainingTime(competitiveJuniors,competitiveSeniors);
                case 2 -> registerNewCompetitionTime(competitiveJuniors,competitiveSeniors);
            }
            registerMore = registerMoreTimes();
        }
    }

    public void checkFastestTime(ArrayList<SwimmingClubMember> competitiveJuniors, ArrayList<SwimmingClubMember> competitiveMembers) {
        FileWriter.updateJuniorsList(competitiveJuniors);
        FileWriter.updateSeniorsList(competitiveMembers);
    }

    public boolean registerMoreTimes(){
            System.out.println("Vil du registere flere svømmere?\n1 for ja, 2 for nej.");
            int userInput = GetUserInput.integer();
            return userInput == 1;
    }

    public String whichStroke(){
        System.out.println("Tast 1 for butterfly.\nTast 2 for rygsvømning.\nTast 3 for brystsvømning.\nTast 4 for crawl.");
        int userInput = GetUserInput.menu(4);
        switch (userInput){
            case 1 -> {return "butterfly";}
            case 2 -> {return "rygsvømning";}
            case 3 -> {return "brystsvømning";}
            case 4 -> {return "crawl";}
        }
        return null;
    }

    public double timeOfSwim(){
        System.out.println("Indtast tiden som der blev svømmet på.");
        return GetUserInput.doubl();
    }

    public void updateButterflyTime(SwimmingClubMember currentMember, double newTime){
        if (currentMember.getButterflyTime() > newTime || currentMember.getButterflyTime() == 0.0){
            currentMember.setButterflyTime(newTime);
        }
    }

    public void updateBackstrokeTime(SwimmingClubMember currentMember, double newTime){
        if (currentMember.getBackstrokeTime() > newTime && currentMember.getBackstrokeTime() == 0.0){
            currentMember.setBackstrokeTime(newTime);
        }
    }

    public void updateBreaststrokeTime(SwimmingClubMember currentMember, double newTime){
        if (currentMember.getBreaststrokeTime() > newTime && currentMember.getBreaststrokeTime() == 0.0){
            currentMember.setBreaststrokeTime(newTime);
        }
    }

    public void updateFreestyleTime(SwimmingClubMember currentMember, double newTime){
        if (currentMember.getFreestyleTime() > newTime && currentMember.getFreestyleTime() == 0.0){
            currentMember.setFreestyleTime(newTime);
        }
    }

    public void topFiveResults(ArrayList<SwimmingClubMember> competitiveJuniors, ArrayList<SwimmingClubMember> competitiveSeniors){
        checkFastestTime(competitiveJuniors,competitiveSeniors);
        System.out.println("Indtast 1 for at se Juniorsvømmere eller 2 for Seniorsvømmere.");
        int juniorOrSenior = GetUserInput.integer();
        System.out.println("Tast 1 for butterfly, 2 for rygsvømning, 3 for brystsvømning eller 4 for crawl.");
        int strokeChoice = GetUserInput.integer();

        switch(juniorOrSenior){
            case 1 -> {
                switch (strokeChoice){
                    case 1 -> {
                        competitiveJuniors.sort(Comparator.comparingDouble(SwimmingClubMember::getButterflyTime));
                        for (SwimmingClubMember m: competitiveJuniors) {
                            if (m.getButterflyTime() == 0.0) {
                                System.out.print("");}
                            else {
                                System.out.println("Svømmer: " + m.getName() + "'s bedste tid i butterfly er: " + m.getButterflyTime() + ".");}
                        }
                    }
                    case 2 -> {
                        competitiveJuniors.sort(Comparator.comparingDouble(SwimmingClubMember::getBackstrokeTime));
                        for (SwimmingClubMember m:competitiveJuniors) {
                            if (m.getBackstrokeTime() == 0.0) {
                                System.out.print("");
                            } else {
                                System.out.println("Svømmer: " + m.getName() + "'s bedste tid i rygsvømning er: " + m.getBackstrokeTime() + ".");
                            }
                        }
                    }
                    case 3 -> {
                        competitiveJuniors.sort(Comparator.comparingDouble(SwimmingClubMember::getBreaststrokeTime));
                        for (SwimmingClubMember m:competitiveJuniors) {
                            if (m.getBreaststrokeTime() == 0.0) {
                                System.out.print("");
                            } else {
                                System.out.println("Svømmer: +" + m.getName() + "'s bedste tid i brystsvømning er: " + m.getBreaststrokeTime());
                            }
                        }
                    }
                    case 4 -> {
                        competitiveJuniors.sort(Comparator.comparingDouble(SwimmingClubMember::getFreestyleTime));
                        for (SwimmingClubMember m:competitiveJuniors) {
                            if (m.getFreestyleTime() == 0.0) {
                                System.out.print("");
                            } else {
                                System.out.println("Svømmer: " + m.getName() + "'s bedste tid i crawl er: " + m.getFreestyleTime());
                            }
                        }
                    }
                }
            }
            case 2 -> {
                switch (strokeChoice) {
                    case 1 -> {
                        competitiveSeniors.sort(Comparator.comparingDouble(SwimmingClubMember::getButterflyTime));
                        for (SwimmingClubMember m :competitiveSeniors) {
                            if (m.getButterflyTime() == 0.0) {
                                System.out.print("");
                            } else {
                                System.out.println("Svømmer: " + m.getName() + "'s bedste tid i butterfly er: " + m.getButterflyTime());}
                        }
                    }
                    case 2 -> {
                        competitiveSeniors.sort(Comparator.comparingDouble(SwimmingClubMember::getBackstrokeTime));
                        for (SwimmingClubMember m :competitiveSeniors) {
                            if (m.getBackstrokeTime() == 0.0) {
                                System.out.print("");
                            } else {
                                System.out.println("Svømmer: "+m.getName()+"'s bedste tid i rygsvømning er: "+m.getBackstrokeTime());
                            }
                        }
                    }
                    case 3 -> {
                        competitiveSeniors.sort(Comparator.comparingDouble(SwimmingClubMember::getBreaststrokeTime));
                        for (SwimmingClubMember m :competitiveSeniors) {
                            if (m.getBreaststrokeTime() == 0.0) {
                                System.out.print("");
                            } else {
                                System.out.println("Svømmer: " + m.getName() + "'s bedste tid i brystsvømning er: " + m.getBreaststrokeTime());
                            }
                        }
                    }
                    case 4 -> {
                        competitiveSeniors.sort(Comparator.comparingDouble(SwimmingClubMember::getFreestyleTime));
                        for (SwimmingClubMember m :competitiveSeniors) {
                            if (m.getFreestyleTime() == 0.0) {
                                System.out.print("");
                            } else {
                                System.out.println("Svømmer: " + m.getName() + "'s bedste tid i crawl er: " + m.getFreestyleTime());
                            }
                        }
                    }
                }
            }
        }
    }

}
