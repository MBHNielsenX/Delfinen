package Competitive;

import FileReaderWriter.GetUserInput;

import java.awt.*;
import java.util.Date;

public class Competition {
    private Date timeOfEvent;
    private Stroke stroke;
    private int distance;
    private int swimTime;

    public Competition(Stroke stroke, int distance, int time) {
        this.stroke = stroke;
        this.distance = distance;
        this.swimTime = time;
    }

    public static void createNewCompetition() {
        System.out.println("Type in time of event: (hh-mm-dd-MM-yyyy");
        String timeOfEvent = GetUserInput.string();
        System.out.println("Type in stroke type: ");
        String stroke = GetUserInput.string();
        System.out.println("Type in distance :");
        int distance = GetUserInput.integer();

        //Date date = convertToDate(birthdate);

        /* Continue
        String[] dateOfEventArray = timeOfEvent.split("-");
        int yearOfEvent = Integer.parseInt(dateOfBirthArray[2]);
        int monthOfEvent = Integer.parseInt(dateOfBirthArray[1])-1;
        int dayOfEvent = Integer.parseInt(dateOfBirthArray[0]);
        int hourOfEvent = Integer.parseInt(hour)
        Date date = new Date (yearOfBirtDate-1900,monthOfBirthdate,dayOfBirthdate);

         */

    }

    public Stroke getStroke() {
        return stroke;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return swimTime;
    }
}
