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
        LocalDate currentDate = LocalDate.now();

        // Skal vi oprette klasser til at gemme vores resultater? Evt under competitive? TrainingResult og CompetitionResult evt? Construktor? Er det nemmere?

        switch (userInput){
            case 1 -> {

            }
            case 2 -> {

            }
        }


    }

    public void registerNewTime(ArrayList<SwimmingClubMember> allMembers, ArrayList<SwimmingClubMember> competitiveJuniors, ArrayList<SwimmingClubMember> competitiveSeniors){ //Rename til competition time
        System.out.println("Goddag!");
        Competition currentEvent = Competition.createNewCompetition();

        boolean registerMore = true;

        while (registerMore) {
            System.out.println("Tast 1 for juniorsvømmere eller 2 for seniorsvømmere!");
            int juniorOrSenior = GetUserInput.integer();
            System.out.println("Hvilken svømmer vil du register en tid til?");
            int swimmerID = GetUserInput.integer();


            switch (juniorOrSenior) {
                case 1 -> {
                    SwimmingClubMember currentJuniorMember = MemberHandler.getMemberFromId(swimmerID, competitiveJuniors);
                    executeMember(currentJuniorMember, juniorOrSenior, swimmerID, competitiveJuniors);
                }
                case 2 -> {
                    SwimmingClubMember currentSeniorMember = MemberHandler.getMemberFromId(swimmerID, competitiveSeniors);
                    executeMember(currentSeniorMember, juniorOrSenior, swimmerID, competitiveSeniors);
                }
            }

            /*
            SwimmingClubMember currentMember = MemberHandler.getMemberFromId(swimmerID,competitiveSeniors);
            //SwimmingClubMember currentMember = MemberHandler.getMemberFromId(swimmerID, allMembers);
            String memberName = currentMember.getName();
            System.out.println("Hvilken disciplin svømmede svømmeren?");
            whichStroke(currentMember);
            System.out.println("Hvilken placering fik svømmeren?");
            int placering = GetUserInput.integer();

            switch (juniorOrSenior){
                case 1 -> {FileWriter.writeJuniorComp(currentMember);}
                case 2 -> {
                    //FileWriter.writeSeniorComp(currentMember);
                    FileWriter.updateSeniorsList(competitiveSeniors);
                }
            }

             */

            registerMore = registerMoreTimes();
        }
    }
    public void executeMember(SwimmingClubMember competitiveMember, int juniorOrSenior, int swimmerID, ArrayList<SwimmingClubMember> competitiveMembers) {
        SwimmingClubMember currentMember = MemberHandler.getMemberFromId(swimmerID,competitiveMembers);
        //SwimmingClubMember currentMember = MemberHandler.getMemberFromId(swimmerID, allMembers);
        String memberName = currentMember.getName();
        System.out.println("Hvilken disciplin svømmede svømmeren?");
        whichStroke(currentMember);
        System.out.println("Hvilken placering fik svømmeren?");
        int placering = GetUserInput.integer();

        switch (juniorOrSenior){
            case 1 -> {FileWriter.updateJuniorsList(competitiveMembers);}
            case 2 -> {FileWriter.updateSeniorsList(competitiveMembers);
            }
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
            case 1 -> {
                currentMember.setButterflyTime(swimTime);
                //return "butterfly";
            }
            case 2 -> {
                currentMember.setBackstrokeTime(swimTime);
                //return "rygsvømning";
            }
            case 3 -> {
                currentMember.setBreaststrokeTime(swimTime);
                //return "brystsvømning";
            }
            case 4 -> {
                currentMember.setFreestyleTime(swimTime);
                //return "crawl";
            }
        }
        //return null;
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
                            System.out.println("Svømmer: " + m.getName() + "'s bedste tid i butterfly er: " + m.getButterflyTime() + ".");
                        }
                    }
                    case 2 -> {
                        competitiveJuniors.sort(Comparator.comparingDouble(SwimmingClubMember::getBackstrokeTime));
                        for (SwimmingClubMember m:competitiveJuniors) {
                            System.out.println("Svømmer: "+m.getName()+"'s bedste tid i rygsvømning er: "+m.getBackstrokeTime()+".");
                        }
                    }
                    case 3 -> {
                        competitiveJuniors.sort(Comparator.comparingDouble(SwimmingClubMember::getBreaststrokeTime));
                        for (SwimmingClubMember m:competitiveJuniors) {
                            System.out.println("Svømmer: +"+m.getName()+"'s bedste tid i brystsvømning er: "+m.getBreaststrokeTime());
                        }
                    }
                    case 4 -> {
                        competitiveJuniors.sort(Comparator.comparingDouble(SwimmingClubMember::getFreestyleTime));
                        for (SwimmingClubMember m:competitiveJuniors) {
                            System.out.println("Svømmer: "+m.getName()+"'s bedste tid i crawl er: "+m.getFreestyleTime());
                        }
                    }
                }
            }
            case 2 -> {
                switch (strokeChoice) {
                    case 1 -> {
                        competitiveSeniors.sort(Comparator.comparingDouble(SwimmingClubMember::getButterflyTime));
                        for (SwimmingClubMember m :competitiveSeniors) {
                            System.out.println("Svømmer: "+m.getName()+"'s bedste tid i butterfly er: "+m.getButterflyTime());
                        }

                    }
                    case 2 -> {
                        competitiveSeniors.sort(Comparator.comparingDouble(SwimmingClubMember::getBackstrokeTime));
                        for (SwimmingClubMember m :competitiveSeniors) {
                            System.out.println("Svømmer: "+m.getName()+"'s bedste tid i rygsvømning er: "+m.getBackstrokeTime());
                        }
                    }
                    case 3 -> {
                        competitiveSeniors.sort(Comparator.comparingDouble(SwimmingClubMember::getBreaststrokeTime));
                        for (SwimmingClubMember m :competitiveSeniors) {
                            System.out.println("Svømmer: "+m.getName()+"'s bedste tid i brystsvømning er: "+m.getBreaststrokeTime());
                        }
                    }
                    case 4 -> {
                        competitiveSeniors.sort(Comparator.comparingDouble(SwimmingClubMember::getFreestyleTime));
                        for (SwimmingClubMember m :competitiveSeniors) {
                            System.out.println("Svømmer: "+m.getName()+"'s bedste tid i crawl er: "+m.getFreestyleTime());
                        }
                    }
                }
            }
        }
    }


    public void isTopFive(){

    }
}
