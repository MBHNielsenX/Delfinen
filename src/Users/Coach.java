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


    public void registerNewTrainingTime(ArrayList<String> allMembers, ArrayList<SwimmingClubMember> competitiveJuniors, ArrayList<SwimmingClubMember> competitiveSeniors){
        System.out.println("Goddag!");
        System.out.println("Tast 1 for juniorsvømmer eller 2 for seniorsvømmer.");
        int userInput = GetUserInput.menu(2);
        System.out.println("Tast 1 for at vælge butterfly, 2 for rygsvømning, 3 for brystsvømning eller 4 for crawl.");
        int strokeChoice = GetUserInput.menu(4);
        LocalDate currentDate = LocalDate.now(); //remove later

        // Skal vi oprette klasser til at gemme vores resultater? Evt under competitive? TrainingResult og CompetitionResult evt? Construktor? Er det nemmere?

        switch (userInput){
            case 1 -> {

            }
            case 2 -> {

            }
        }


    }

    public void registerNewTime(ArrayList<SwimmingClubMember> competitiveJuniors, ArrayList<SwimmingClubMember> competitiveSeniors){ //Rename til competition time
        System.out.println("Goddag!");
        Competition currentEvent = Competition.createNewCompetition(); //remove later

        boolean registerMore = true;

        while (registerMore) {
            System.out.println("Tast 1 for juniorsvømmere eller 2 for seniorsvømmere!");
            int juniorOrSenior = GetUserInput.integer();
            System.out.println("Hvilken svømmer vil du register en tid til?");
            int swimmerID = GetUserInput.integer();


            switch (juniorOrSenior) {
                case 1 -> {
                    SwimmingClubMember currentJuniorMember = MemberHandler.getMemberFromId(swimmerID, competitiveJuniors);
                    executeMember(currentJuniorMember, juniorOrSenior, swimmerID, competitiveJuniors);}
                case 2 -> {
                    SwimmingClubMember currentSeniorMember = MemberHandler.getMemberFromId(swimmerID, competitiveSeniors);
                    executeMember(currentSeniorMember, juniorOrSenior, swimmerID, competitiveSeniors);}
            }
            registerMore = registerMoreTimes();
        }
    }

    public void executeMember(SwimmingClubMember competitiveMember, int juniorOrSenior, int swimmerID, ArrayList<SwimmingClubMember> competitiveMembers) {
        SwimmingClubMember currentMember = MemberHandler.getMemberFromId(swimmerID,competitiveMembers);
        String memberName = currentMember.getName(); //remove later
        System.out.println("Hvilken disciplin svømmede svømmeren?");
        whichStroke(currentMember);
        System.out.println("Hvilken placering fik svømmeren?");
        int placering = GetUserInput.integer(); //remove later

        switch (juniorOrSenior){
            case 1 -> FileWriter.updateJuniorsList(competitiveMembers);
            case 2 -> FileWriter.updateSeniorsList(competitiveMembers);
        }
    }

    public boolean registerMoreTimes(){
        System.out.println("Vil du registere flere svømmere?\n1 for ja, 2 for nej.");
        int userInput = GetUserInput.integer();
        return userInput == 1;
    }

    public void whichStroke(SwimmingClubMember currentMember){
        System.out.println("Tast 1 for butterfly.\nTast 2 for rygsvømning.\nTast 3 for brystsvømning.\nTast 4 for crawl.");
        int userInput = GetUserInput.menu(4);
        System.out.println("Hvilken tid svømmede svømmeren på?");
        double swimTime = GetUserInput.doubl();
        switch (userInput){
            case 1 -> currentMember.setButterflyTime(swimTime);
            case 2 -> currentMember.setBackstrokeTime(swimTime);
            case 3 -> currentMember.setBreaststrokeTime(swimTime);
            case 4 -> currentMember.setFreestyleTime(swimTime);
        }
    }

    public void topFiveResults(ArrayList<SwimmingClubMember> competitiveJuniors, ArrayList<SwimmingClubMember> competitiveSeniors){
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

    public void isTopFive(){

    }
}
