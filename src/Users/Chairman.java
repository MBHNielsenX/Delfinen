package Users;

import FileReaderWriter.GetUserInput;
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
        System.out.println("Type in your birthdate; (01-03-94)");
        String birthdate = GetUserInput.string();

        String[] dateOfBirthArray = birthdate.split("-");
        int yearOfBirtDate = Integer.parseInt(dateOfBirthArray[2]);
        int monthOfBirthdate = Integer.parseInt(dateOfBirthArray[1])-1;
        int dayOfBirthdate = Integer.parseInt(dateOfBirthArray[0]);
        Date date = new Date (yearOfBirtDate,monthOfBirthdate,dayOfBirthdate);

        int howOldInYears = getAge(yearOfBirtDate,monthOfBirthdate,dayOfBirthdate);
        //Date date = new Date(Integer.parseInt(dateOfBirthArray[2]), Integer.parseInt(dateOfBirthArray[1])-1, Integer.parseInt(dateOfBirthArray[0]));


        switch(whichMembership(howOldInYears)){
            case "junior": Junior newJunior = new Junior(name,address,email,phoneNumber,date,true);
            case "senior": Senior newSenior = new Senior(name,address,email,phoneNumber,date,true);
            case "pensionst": Pensioner newPensioner = new Pensioner(name,address,email,phoneNumber,date,true);
            default:
                System.out.println("Fejl, prøv igen");
        }



    }

    public String whichMembership(int age){
        if (age > 65){
            return "pensionist";
        } else if (age < 18) {
            return "junior";
        } else {
            return "senior";
        }

    }

    public int getAge(int year, int month, int day) {
        Date now = new Date();
        int nowMonth = now.getMonth()+1;
        int nowYear = now.getYear()+1900;
        int result = nowYear - year;

        if (month > nowMonth) {
            result--;
        }
        else if (month == nowMonth) {
            int nowDay = now.getDate();

            if (day > nowDay) {
                result--;
            }
        }
        return result;
    }

}
