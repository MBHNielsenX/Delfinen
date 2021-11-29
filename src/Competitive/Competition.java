package Competitive;

import IO.GetUserInput;
import Members.Base.SwimmingClubMember;
import Members.MemberHandler;
import Users.Chairman;

import java.time.LocalDate;
import java.util.ArrayList;


public class Competition {
    private String nameOfCompetition;
    private LocalDate timeOfEvent;

    public Competition(String nameOfCompetition, LocalDate timeOfEvent) {
        this.nameOfCompetition = nameOfCompetition;
        this.timeOfEvent = timeOfEvent;
    }

    public static void registerNewTime(ArrayList<SwimmingClubMember> allMembers){
        System.out.println("Hej! Hvilket stævne har du været til?");
        Competition currentEvent = createNewCompetition();

        boolean registerMore = true;

        while (registerMore) {
            System.out.println("Hvilken svømmer vil du registererererere en tid til?");
            int swimmerID = GetUserInput.integer();
            SwimmingClubMember currentMember = MemberHandler.getMemberFromId(swimmerID, allMembers);
            String memberName = currentMember.getName();
            System.out.println("Hvilken disciplin svømmede svømmeren?");
            String stroke = whichStroke();
            System.out.println("Hvilken tid svømmede svømmeren i?");
            double swimTime = GetUserInput.doubl();
            System.out.println("Hvilken placering fik svømmeren?");
            int placering = GetUserInput.integer();

            //Coach.registerSwimTime(currentEvent.getNameOfCompetition(), swimmerID, memberName, swimTime);
            System.out.println(currentEvent.getNameOfCompetition());
            System.out.println(memberName);
            System.out.println(stroke);
            System.out.println(swimTime);
            System.out.println(placering);



            registerMore = registerMoreTimes();
        }
    }

    public static boolean registerMoreTimes(){
        System.out.println("Vil du registere flere svømmere?\n1 for ja, 2 for nej.");
        int userInput = GetUserInput.integer();
        return userInput == 1;
    }

    public static String whichStroke(){
        System.out.println("Tast 1 for butterfly.\nTast 2 for rygsvømning.\nTast 3 for brystsvømning.\nTast 4 for crawl.");
        int userInput = GetUserInput.menu(4);
        switch (userInput){
            case 1 -> {
                return "butterfly";
            }
            case 2 -> {
                return "rygsvømning";
            }
            case 3 -> {
                return "brystsvømning";
            }
            case 4 -> {
                return "crawl";
            }
        }
        return null;
    }

    public static Competition createNewCompetition() {
        System.out.println("Indtast navnet for det svømmestævne du har været til: ");
        String nameOfEvent = GetUserInput.string();
        System.out.println("Indtast datoen for svømmestævnet: (dd-MM-yyyy)");
        String timeOfEvent = GetUserInput.string();
        LocalDate dateOfEvent = Chairman.convertToDate(timeOfEvent);
        return new Competition(nameOfEvent,dateOfEvent);

    }

    public String getNameOfCompetition(){
        return nameOfCompetition;
    }

}
