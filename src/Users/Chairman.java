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
                newJunior.setCompetitive(isNewMemberCompetitive());
                System.out.println(newJunior.getName()+" blev oprettet i systemet, med medlems ID: "+newJunior.getMemberId());
                Writer.write(newJunior);
            }
            case 2 -> {
                Senior newSenior = new Senior(currentNember.getName(), currentNember.getAddress(), currentNember.getEmail(), currentNember.getPhoneNumber(), date, true);
                newSenior.setCompetitive(isNewMemberCompetitive());
                System.out.println(newSenior.getName()+" blev oprettet i systemet, med medlems ID: "+newSenior.getMemberId());
                Writer.write(newSenior);
            }
            case 3 -> {
                Pensioner newPensioner = new Pensioner(currentNember.getName(), currentNember.getAddress(), currentNember.getEmail(), currentNember.getPhoneNumber(), date, true);
                System.out.println(newPensioner.getName()+" blev oprettet i systemet, med medlems ID: "+newPensioner.getMemberId());
                Writer.write(newPensioner);
            }
            default -> System.out.println("Fejl, prøv igen");
        }
    }

    public PotentialMember newMember(){
        System.out.println("Velkommen til oprettelsessystemet!");
        System.out.println("Indtast det nye medlems navn.");
        String name = GetUserInput.string();
        System.out.println("Indtast det nye medlems adresse.");
        String address = GetUserInput.string();
        System.out.println("Indtast det nye medlems email.");
        String email = GetUserInput.string();
        System.out.println("Indtast det nye medlems telefonnummer.");
        int phoneNumber = GetUserInput.integer();
        System.out.println("Indtast det nye medlems fødselsdato; (01-03-1994)");
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
        System.out.println("Ønsker det nye medlem at blive oprettet som konkurrencesvømmer??\n1 for ja, 2 for nej.");
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
