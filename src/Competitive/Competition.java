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
        System.out.println("type in time of event: (01-03-1994");
        String name = GetUserInput.string();
        System.out.println("Type in your address");
        String address = GetUserInput.string();
        System.out.println("type in your email");
        String email = GetUserInput.string();
        System.out.println("type in your phonenumber");
        int phoneNumber = GetUserInput.integer();
        System.out.println("Type in your birthdate; (01-03-1994)");
        String birthdate = GetUserInput.string();

        //Date date = convertToDate(birthdate);

        String[] dateOfBirthArray = birthdate.split("-");
        int yearOfBirtDate = Integer.parseInt(dateOfBirthArray[2]);
        int monthOfBirthdate = Integer.parseInt(dateOfBirthArray[1])-1;
        int dayOfBirthdate = Integer.parseInt(dateOfBirthArray[0]);
        Date date = new Date (yearOfBirtDate-1900,monthOfBirthdate,dayOfBirthdate);

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
