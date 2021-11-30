package Users;

import Competitive.Competition;
import IO.*;
import Members.*;
import Members.Base.SwimmingClubMember;

import java.util.ArrayList;


public class Coach extends Admin{
    public Coach(String userName, String password, String email) {
        super(userName, password, email);
    }

    public void registerNewTime(ArrayList<SwimmingClubMember> allMembers, ArrayList<SwimmingClubMember> competitiveJuniors, ArrayList<SwimmingClubMember> competitiveSeniors){
        System.out.println("Goddag!");
        Competition currentEvent = Competition.createNewCompetition();

        boolean registerMore = true;

        while (registerMore) {
            System.out.println("Tast 1 for juniorsvømmere eller 2 for seniorsvømmere!");
            int juniorOrSenior = GetUserInput.integer();
            System.out.println("Hvilken svømmer vil du register en tid til?");
            int swimmerID = GetUserInput.integer();
            SwimmingClubMember currentMember = MemberHandler.getMemberFromId(swimmerID, allMembers);
            SwimmingClubMember currentSenior = MemberHandler.getCompetitiveSeniorFromId(swimmerID, competitiveSeniors);
            String memberName = currentMember.getName();
            System.out.println("Hvilken disciplin svømmede svømmeren?");
            String stroke = whichStroke(currentMember);
            /*
            System.out.println("Hvilken tid svømmede svømmeren i?");
            double swimTime = GetUserInput.doubl();
             */
            System.out.println("Hvilken placering fik svømmeren?");
            int placering = GetUserInput.integer();

            /*
            System.out.println(currentEvent.getNameOfCompetition());
            System.out.println(memberName);
            System.out.println(stroke);
            System.out.println(placering);
             */

            switch (juniorOrSenior){
                case 1 -> {FileWriter.writeJuniorComp(currentMember);}
                case 2 -> {FileWriter.writeSeniorComp(currentMember);}
            }


            registerMore = registerMoreTimes();
        }
    }

    public boolean registerMoreTimes(){
        System.out.println("Vil du registere flere svømmere?\n1 for ja, 2 for nej.");
        int userInput = GetUserInput.integer();
        return userInput == 1;
    }


    public String whichStroke(SwimmingClubMember currentMember){
        System.out.println("Tast 1 for butterfly.\nTast 2 for rygsvømning.\nTast 3 for brystsvømning.\nTast 4 for crawl.");
        int userInput = GetUserInput.menu(4);
        System.out.println("Hvilken tid svømmede svømmeren på?");
        double swimTime = GetUserInput.doubl();
        switch (userInput){
            case 1 -> {
                currentMember.setButterflyTime(swimTime);
                return "butterfly";
            }
            case 2 -> {
                currentMember.setBackstrokeTime(swimTime);
                return "rygsvømning";
            }
            case 3 -> {
                currentMember.setBreaststrokeTime(swimTime);
                return "brystsvømning";
            }
            case 4 -> {
                currentMember.setFreestyleTime(swimTime);
                return "crawl";
            }
        }
        return null;
    }


    public void displayAllCompetitiveSwimmers(){ // Viser navne og ID på alle konkurrencesvømmere

    }

    public void topFiveResults(){

    }

    public void isTopFive(){

    }
}
