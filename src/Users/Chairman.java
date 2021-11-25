package Users;

import FileReaderWriter.GetUserInput;
import FileReaderWriter.Writer;
import Members.Junior;
import Members.Pensioner;
import Members.PotentialMember;
import Members.Senior;

import java.time.LocalDate;
import java.time.Period;


public class Chairman extends Admin{
    public Chairman(String userName, String password, String email) {
        super(userName, password, email);
    }

    public void createNewMember(){
        PotentialMember currentNember = newMember();

        LocalDate date = convertToDate(currentNember.getBirthdate());

        int howOldInYears = getAge(convertToDate(currentNember.getBirthdate()));

        switch (whichMembership(howOldInYears)) {
            case 1 -> {
                Junior newJunior = new Junior(currentNember.getName(), currentNember.getAddress(), currentNember.getEmail(), currentNember.getPhoneNumber(), date,true);
                System.out.println("junior created");
                newJunior.setCompetitive(isNewMemberCompetitive());
                Writer.write(newJunior);
                System.out.println(newJunior);
            }
            case 2 -> {
                Senior newSenior = new Senior(currentNember.getName(), currentNember.getAddress(), currentNember.getEmail(), currentNember.getPhoneNumber(), date, true);
                System.out.println("senior created");
                newSenior.setCompetitive(isNewMemberCompetitive());
                Writer.write(newSenior);
                System.out.println(newSenior);
            }
            case 3 -> {
                Pensioner newPensioner = new Pensioner(currentNember.getName(), currentNember.getAddress(), currentNember.getEmail(), currentNember.getPhoneNumber(), date, true);
                System.out.println("pensioner created");
                Writer.write(newPensioner);
                System.out.println(newPensioner);
            }
            default -> System.out.println("Fejl, prøv igen");
        }
    }

    public PotentialMember newMember(){
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
        return new PotentialMember(name, address,email,phoneNumber,birthdate);
    }

    public LocalDate convertToDate (String birthdate){
        String[] dateOfBirthArray = birthdate.split("-");
        int yearOfBirtDate = Integer.parseInt(dateOfBirthArray[2]);
        int monthOfBirthdate = Integer.parseInt(dateOfBirthArray[1]);
        int dayOfBirthdate = Integer.parseInt(dateOfBirthArray[0]);
        return LocalDate.of(yearOfBirtDate,monthOfBirthdate,dayOfBirthdate);
    }

    public int getAge(LocalDate birthdate){
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthdate,currentDate).getYears();
    }

    public boolean isNewMemberCompetitive() {
        System.out.println("Does the new member want to be competitive?\n1 for yes, 2 for no.");
        int userInput = GetUserInput.integer();
        return userInput == 1;
    }

    public int whichMembership(int age){
        if (age > 65){
            return 3;
        } else if (age < 18) {
            return 1;
        } else {
            return 2;
        }

    }
}
