package Users;

import FileReaderWriter.GetUserInput;
import FileReaderWriter.Writer;
import Members.Junior;
import Members.Pensioner;
import Members.Senior;

import java.util.Date;


public class Chairman extends Admin{
    public Chairman(String userName, String password, String email) {
        super(userName, password, email);
    }

    public void createNewMember(){
        System.out.println("type in your name");
        String name = GetUserInput.string();
        System.out.println("Type in your address");
        String address = GetUserInput.string();
        System.out.println("type in your email");
        String email = GetUserInput.string();
        System.out.println("type in your phonenumber");
        int phoneNumber = GetUserInput.integer();
        System.out.println("Type in your birthdate; (01-03-1994)");
        String birthdate = GetUserInput.string();

        String[] dateOfBirthArray = birthdate.split("-");
        int yearOfBirtDate = Integer.parseInt(dateOfBirthArray[2]);
        int monthOfBirthdate = Integer.parseInt(dateOfBirthArray[1])-1;
        int dayOfBirthdate = Integer.parseInt(dateOfBirthArray[0]);
        Date date = new Date (yearOfBirtDate-1900,monthOfBirthdate,dayOfBirthdate); // -1900 "magic number" for at få dateOfBirth til at passe.

        int howOldInYears = getAge(yearOfBirtDate,monthOfBirthdate,dayOfBirthdate);
        //int howOldInYears = getAge(94,02,01);
        //Date date = new Date(Integer.parseInt(dateOfBirthArray[2]), Integer.parseInt(dateOfBirthArray[1])-1, Integer.parseInt(dateOfBirthArray[0]));


        switch(whichMembership(howOldInYears)){
            case 1:
                Junior newJunior = new Junior(name,address,email,phoneNumber,date,true);
                System.out.println("junior created");
                newJunior.setCompetitive(isNewMemberCompetitive());
                Writer.write(newJunior);
                System.out.println(newJunior);
                break;
            case 2:
                Senior newSenior = new Senior(name,address,email,phoneNumber,date,true);
                System.out.println("senior created");
                newSenior.setCompetitive(isNewMemberCompetitive());
                Writer.write(newSenior);
                System.out.println(newSenior);
                break;
            case 3:
                Pensioner newPensioner = new Pensioner(name,address,email,phoneNumber,date,true);
                System.out.println("pensioner created");
                Writer.write(newPensioner);
                System.out.println(newPensioner);
                break;
            default:
                System.out.println("Fejl, prøv igen");
        }
    }

    private boolean isNewMemberCompetitive() {
        System.out.println("Does the new member want to be competitive?\n1 for yes, 2 for no.");
        int userInput = GetUserInput.integer();
        return userInput == 1;
    }
    private int whichMembership(int age){
        if (age > 65){
            return 3;
        } else if (age < 18) {
            return 1;
        } else {
            return 2;
        }

    }
    private int getAge(int year, int month, int day) { // method found @ https://stackoverflow.com/questions/1116123/how-do-i-calculate-someones-age-in-java
        Date now = new Date();
        int nowMonth = now.getMonth()+1;
        int nowYear = now.getYear()+1900;
        int result = nowYear - year;

        if (month > nowMonth) {
            result--;
        } else if (month == nowMonth) {
            int nowDay = now.getDate();
            if (day > nowDay) {
                result--;
            }
        }
        return (result);
    }

}
