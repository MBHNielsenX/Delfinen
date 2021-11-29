package Competitive;

import FileReaderWriter.GetUserInput;
import Members.SwimmingClubMember;
import Users.Chairman;

import java.awt.*;
import java.time.LocalDate;


public class Competition {
    private String nameOfCompetition;
    private LocalDate timeOfEvent;
    /*
    private Stroke stroke;
    private int distance;
     */

    public Competition(String nameOfCompetition, LocalDate timeOfEvent) {
        this.nameOfCompetition = nameOfCompetition;
        this.timeOfEvent = timeOfEvent;
    }

    public void registerNewTime(){
        System.out.println("Hej! Hvilket stævne har du været til?");
        String competitionName = GetUserInput.string();

        System.out.println("Hvilken svømmer vil du registererererere en tid til?");
        int swimmerID = GetUserInput.integer();

        System.out.println("Hvilken disciplin svømmede svømmeren?");
        String stroke = GetUserInput.string();

        System.out.println("Hvilken tid svømmede svømmeren i?");
        double swimTime = GetUserInput.doubleInput();

    }


    public static Competition createNewCompetition() {
        System.out.println("Type in the name of the competition: ");
        String nameOfEvent = GetUserInput.string();
        System.out.println("Type in time of event: (dd-MM-yyyy");
        String timeOfEvent = GetUserInput.string();

        LocalDate dateOfEvent = Chairman.convertToDate(timeOfEvent);

        return new Competition(nameOfEvent,dateOfEvent);

    }

    /*
    public Stroke getStroke() {
        return stroke;
    }

    public int getDistance() {
        return distance;
    }
     */

}
