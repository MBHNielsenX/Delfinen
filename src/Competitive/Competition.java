package Competitive;

import IO.GetUserInput;
import Members.Base.SwimmingClubMember;
import Members.MemberHandler;
import Users.Chairman;

import java.time.LocalDate;



public class Competition {
    private String nameOfCompetition;
    private LocalDate timeOfEvent;

    public Competition(String nameOfCompetition, LocalDate timeOfEvent) {
        this.nameOfCompetition = nameOfCompetition;
        this.timeOfEvent = timeOfEvent;
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
