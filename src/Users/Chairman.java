//Mikkels kode
package Users;

import IO.GetUserInput;
import IO.FileWriter;
import Members.*;

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
                newJunior.setCompetitive(isNewMemberCompetitive());
                System.out.println("\n"+newJunior.getName()+" blev oprettet i systemet, med medlems ID: "+newJunior.getMemberId());
                FileWriter.writeNewMember(newJunior);
            }
            case 2 -> {
                Senior newSenior = new Senior(currentNember.getName(), currentNember.getAddress(), currentNember.getEmail(), currentNember.getPhoneNumber(), date, true);
                newSenior.setCompetitive(isNewMemberCompetitive());
                System.out.println("\n"+newSenior.getName()+" blev oprettet i systemet, med medlems ID: "+newSenior.getMemberId());
                FileWriter.writeNewMember(newSenior);
            }
            case 3 -> {
                Pensioner newPensioner = new Pensioner(currentNember.getName(), currentNember.getAddress(), currentNember.getEmail(), currentNember.getPhoneNumber(), date, true);
                System.out.println("\n"+newPensioner.getName()+" blev oprettet i systemet, med medlems ID: "+newPensioner.getMemberId());
                FileWriter.writeNewMember(newPensioner);
            }
            default -> System.out.println("Fejl, prøv igen");
        }
    }

    public PotentialMember newMember(){
        System.out.println("\nIndtast det nye medlems navn:");
        String name = GetUserInput.string();
        System.out.println("Indtast det nye medlems adresse:");
        String address = GetUserInput.string();
        System.out.println("Indtast det nye medlems email:");
        String email = GetUserInput.string();
        System.out.println("Indtast det nye medlems telefonnummer:");
        int phoneNumber = GetUserInput.integer();
        System.out.println("Indtast det nye medlems fødselsdato (DD-MM-ÅÅÅÅ):");
        String birthdate = GetUserInput.string();
        return new PotentialMember(name, address,email,phoneNumber,birthdate);
    }

    public static LocalDate convertToDate (String birthdate){
        String[] dateOfBirthArray = birthdate.split("-");
        int yearOfBirtDate = Integer.parseInt(dateOfBirthArray[2]);
        int monthOfBirthdate = Integer.parseInt(dateOfBirthArray[1]);
        int dayOfBirthdate = Integer.parseInt(dateOfBirthArray[0]);
        return LocalDate.of(yearOfBirtDate,monthOfBirthdate,dayOfBirthdate);
    }

    public static int getAge(LocalDate birthdate){
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthdate,currentDate).getYears();
    }

    public static boolean isNewMemberCompetitive() {
        System.out.println("Ønsker det nye medlem at blive oprettet som konkurrencesvømmer?\nTast 1 for 'Ja' - Tast 2 for 'Nej'.");
        int userInput = GetUserInput.integer();
        return userInput == 1;
    }


    public static int whichMembership(int age){
        if (age > 65){
            return 3;
        } else if (age < 18) {
            return 1;
        } else {
            return 2;
        }

    }
}
