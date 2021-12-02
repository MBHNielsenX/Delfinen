//Mikkels kode
package Users;

import IO.GetUserInput;
import IO.FileWriter;
import Members.*;
import Members.Base.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;


public class Chairman extends User {
    public Chairman(String userName, String password, String email) {
        super(userName, password, email);
    }

    public void registerNewMember(ArrayList<SwimmingClubMember> allMembers){
        PotentialMember currentNember = newMember();

        LocalDate date = convertToDate(currentNember.getBirthdate());

        int howOldInYears = getAge(convertToDate(currentNember.getBirthdate()));

        switch (whichMembership(howOldInYears)) {
            case 1 -> {
                Junior newJunior = new Junior(currentNember.getName(), currentNember.getAddress(), currentNember.getEmail(), currentNember.getPhoneNumber(), date,true);
                newJunior.setCompetitive(isNewMemberCompetitive());
                if (newJunior.isCompetitive()){
                    Junior newCompetitiveJunior = new Junior(newJunior.getMemberId(),newJunior.getName(),0.0,0.0,0.0,0.0);
                    FileWriter.writeJuniorComp(newCompetitiveJunior);
                }
                System.out.println("\n"+newJunior.getName()+" blev oprettet i systemet, med medlems ID: "+newJunior.getMemberId());
                allMembers.add(newJunior);
                FileWriter.writeNewMember(newJunior);
            }
            case 2 -> {
                Senior newSenior = new Senior(currentNember.getName(), currentNember.getAddress(), currentNember.getEmail(), currentNember.getPhoneNumber(), date, true);
                newSenior.setCompetitive(isNewMemberCompetitive());
                if (newSenior.isCompetitive()){
                    Senior newCompetitiveSenior = new Senior (newSenior.getMemberId(), newSenior.getName(),0.0,0.0,0.0,0.0);
                    FileWriter.writeSeniorComp(newCompetitiveSenior);
                }
                System.out.println("\n"+newSenior.getName()+" blev oprettet i systemet, med medlems ID: "+newSenior.getMemberId());
                allMembers.add(newSenior);
                FileWriter.writeNewMember(newSenior);
            }
            case 3 -> {
                Pensioner newPensioner = new Pensioner(currentNember.getName(), currentNember.getAddress(), currentNember.getEmail(), currentNember.getPhoneNumber(), date, true);
                System.out.println("\n"+newPensioner.getName()+" blev oprettet i systemet, med medlems ID: "+newPensioner.getMemberId());
                allMembers.add(newPensioner);
                FileWriter.writeNewMember(newPensioner);
            }
            default -> System.out.println("Fejl, prøv igen");
        }
    }

    static PotentialMember newMember(){ //ændret til static
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

    static boolean isNewMemberCompetitive() { //ændret til static
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

    public static void printAllMembersNamesAndIds(ArrayList<SwimmingClubMember> allMembers){
        int listNo=1;
        for (SwimmingClubMember member:allMembers) {
            System.out.println(listNo+". Medlems-Id: "+member.getMemberId());
            System.out.println("Navn: "+member.getName());
            System.out.println();
            listNo++;
        }
    }
}
