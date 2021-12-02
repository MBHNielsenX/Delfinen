package Users;

import Competitive.Competition;
import IO.*;
import Members.*;
import Members.Base.SwimmingClubMember;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;


public class Coach extends Admin{
    public Coach(String userName, String password, String email) {
        super(userName, password, email);
    }

    public void registerNewTrainingTime(ArrayList<SwimmingClubMember> competitiveJuniors, ArrayList<SwimmingClubMember> competitiveSeniors){
        SwimmingClubMember currentMember = findSwimmerFromID(competitiveJuniors,competitiveSeniors);
        String stroke =  whichStroke();
        LocalDate currentDate = LocalDate.now();
        double time = timeToRegister();

        FileWriter.writeNewTrainingTime(currentMember,currentDate,stroke, time);

        switch (stroke) {
            case "butterfly" -> updateButterflyTime(currentMember,time);
            case "backstroke" -> updateBackstrokeTime(currentMember,time);
            case "breaststroke" -> updateBreaststrokeTime(currentMember,time);
            case "crawl" -> updateFreestyleTime(currentMember,time);
        }

    }

    public void registerNewCompetitionTime(ArrayList<SwimmingClubMember> competitiveJuniors, ArrayList<SwimmingClubMember> competitiveSeniors){
        SwimmingClubMember currentMember = findSwimmerFromID(competitiveJuniors,competitiveSeniors);
        Competition currentEvent = createNewCompetition();
        String stroke = whichStroke();
        double time = timeToRegister();
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

    public SwimmingClubMember findSwimmerFromID(ArrayList<SwimmingClubMember> competitiveJuniors, ArrayList<SwimmingClubMember> competitiveSeniors) {
        System.out.println("For juniorsvømmere - Tast 1\t\tFor seniorsvømmere - Tast 2");
        int juniorOrSenior = GetUserInput.menu(2);
        System.out.println("Indtast MedlemsID for svømmeren du ønsker at registrere tid for: ");
        int swimmerID = GetUserInput.integer();
        switch (juniorOrSenior) {
            case 1 -> {
                return MemberHandler.getMemberFromId(swimmerID, competitiveJuniors);
            }
            case 2 -> {
                return MemberHandler.getMemberFromId(swimmerID, competitiveSeniors);
            }
        } return null;
    }

    public void registerNewTime(ArrayList<SwimmingClubMember> competitiveJuniors, ArrayList<SwimmingClubMember> competitiveSeniors){ //Rename til competition time
        boolean registerMore = true;
        while (registerMore) {
            System.out.println("Registerer en træningstid - Tast 1\t\tRegistrer en konkurrencetid - Tast 2");
            int userInput = GetUserInput.menu(2);
            switch (userInput) {
                case 1 -> registerNewTrainingTime(competitiveJuniors,competitiveSeniors);
                case 2 -> registerNewCompetitionTime(competitiveJuniors,competitiveSeniors);
            }
            registerMore = registerMoreTimes();
        }
    }

    public void updateFastestTimes(ArrayList<SwimmingClubMember> competitiveJuniors, ArrayList<SwimmingClubMember> competitiveMembers) {
        FileWriter.updateJuniorsList(competitiveJuniors);
        FileWriter.updateSeniorsList(competitiveMembers);
    }

    public boolean registerMoreTimes(){
            System.out.println("Vil du registere flere svømmere?\nJa - Tast 1\t\tNej - Tast 2");
            int userInput = GetUserInput.integer();
            return userInput == 1;
    }

    public Competition createNewCompetition() {
        System.out.println("Indtast navnet for det svømmestævne du har været til: ");
        String nameOfEvent = GetUserInput.string();
        return new Competition(nameOfEvent);
    }

    public String whichStroke(){
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

    public double timeToRegister(){
        System.out.println("Indtast svømmerens resultat:");
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

    public void displayTopFiveResults(ArrayList<SwimmingClubMember> competitiveJuniors, ArrayList<SwimmingClubMember> competitiveSeniors){
        updateFastestTimes(competitiveJuniors,competitiveSeniors);
        System.out.println("For juniorsvømmere - Tast 1\t\tFor seniorsvømmere - Tast 2");
        int juniorOrSenior = GetUserInput.integer();
        System.out.println("Butterfly - Tast 1\t\tRygsvømning - Tast 2\nBrystsvømning - Tast 3\t\tCrawl - Tast 4");
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
