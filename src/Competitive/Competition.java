package Competitive;

import java.awt.*;
import java.time.LocalDate;


public class Competition {
    private String nameOfCompetition;
    private LocalDate timeOfEvent;
    private Stroke stroke;
    private int distance;

    public Competition(String nameOfCompetition, LocalDate timeOfEvent, Stroke stroke, int distance) {
        this.nameOfCompetition = nameOfCompetition;
        this.timeOfEvent = timeOfEvent;
        this.stroke = stroke;
        this.distance = distance;
    }
/*
    public static Competition createNewCompetition() {
        System.out.println("Type in the name of the competition: ");
        String nameOfEvent = GetUserInput.string();
        System.out.println("Type in time of event: (dd-MM-yyyy");
        String timeOfEvent = GetUserInput.string();
        System.out.println("Type in stroke type: ");
        String stroke = GetUserInput.string();
        System.out.println("Type in distance :");
        int distance = GetUserInput.integer();

        LocalDate dateOfEvent = Chairman.convertToDate(timeOfEvent);

        return new 

    }

 */

    public Stroke getStroke() {
        return stroke;
    }

    public int getDistance() {
        return distance;
    }

}
