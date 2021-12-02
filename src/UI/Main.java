//Jens' kode
package UI;
import IO.GetUserInput;
import IO.FileReader;
import Members.Base.SwimmingClubMember;
import Users.*;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        User[] users = {
                new Chairman("Mads", "hej", "jens.dk"),
                new Cashier("Jens", "nej", "jens.dk"),
                new Coach("Mikkel", "dig", "jens.dk")};

        SwimmingClubMember.addExistingMemberIdsToStaticArraylist();
        ArrayList<SwimmingClubMember> allMembers = FileReader.getAllExistingMembersFromCsvToArrayList(FileReader.getExistingMemberDataToArrayList());
        ArrayList<SwimmingClubMember> juniorCompetitiveMembers = FileReader.getExistingCompetitiveJuniorsFromCsvToArrayList(FileReader.getAllCompetitiveJuniorsToArrayList());//test
        ArrayList<SwimmingClubMember> seniorCompetitiveMembers = FileReader.getExistingCompetitiveSeniorsFromCsvToArrayList(FileReader.getAllCompetitiveSeniorsToArrayList());//test
        while (true){
            int userNumber = logInSequence(users);
            giveRespectiveMenuOptions(userNumber,users,allMembers, juniorCompetitiveMembers, seniorCompetitiveMembers);
        }
    }

    static int logInSequence(User[] users) {
        int userNumber = 4;
        System.out.println("Indtast dit brugernavn: ");
        while (userNumber > 3) {
            String userInputUsername = GetUserInput.string().toLowerCase();
            for (int i = 0; i < users.length; i++) {
                if (users[i].getUserName().toLowerCase().equals(userInputUsername)) {
                    userNumber = i;
                }
            }
            if(userNumber>3){
                System.out.println("Vi kunne ikke finde en bruger med det angivne brugernavn - Prøv igen: ");
            }
        }
        System.out.println("Indtast din adgangskode: ");
        String userInputPassword = GetUserInput.string();
        while (!users[userNumber].getPassword().equals(userInputPassword)){
            System.out.println("Forkert adgangskode - Prøv igen: ");
            userInputPassword = GetUserInput.string();
        }
        System.out.println("Welcome "+users[userNumber].getUserName());
        return userNumber;
    }

    public static void giveRespectiveMenuOptions(int userNumber, User[] users, ArrayList<SwimmingClubMember>allMembers, ArrayList<SwimmingClubMember>competitiveJuniors, ArrayList<SwimmingClubMember>competitiveSeniors){
        switch(userNumber){
            case 0 -> getChairmanMenu(users,allMembers);
            case 1 -> getCashierMenu(users,allMembers);
            case 2 -> getCoachMenu(users, competitiveJuniors, competitiveSeniors);
        }
    }

    public static void getChairmanMenu(User[] users, ArrayList<SwimmingClubMember> allMembers){
        Chairman cn = (Chairman) users[0];
        int userChoice = 0;
        while (userChoice!=3){
            System.out.println("\nRegistrer nyt medlem i Svømmeklubben Delfinen - Tast 1\tVis alle medlemmer - Tast 2\nForlad menu - Tast 3");
            userChoice = GetUserInput.menu(3);
            switch (userChoice){
                case 1 -> cn.registerNewMember();
                case 2 -> cn.printAllMembersNamesAndIds(allMembers); //Skal rettes
            }
        }
    }

    public static void getCashierMenu(User[] users, ArrayList<SwimmingClubMember> allMembers){
        Cashier cr = (Cashier) users[1];
        int userChoice = 0;
        while (userChoice!=4){
            System.out.println("\nRegistrer kontingentbetaling - Tast 1\t\tTjek restance for medlem - Tast 2\nTjek årlig indkomst - Tast 3\t\t\t\tForlad menu - Tast 4");
            userChoice = GetUserInput.menu(4);
            switch (userChoice){
                case 1 -> {
                    System.out.println("\nIndtast beløb: ");
                    double amountPayed = GetUserInput.doubl();
                    System.out.println("\nIndtast medlemsnummer: ");
                    int memberId = GetUserInput.integer();
                    cr.registerContingentPayment(memberId,amountPayed,allMembers);
                }
                case 2 -> {
                    System.out.println("\nIndtast medlemsnummer: ");
                    int memberId = GetUserInput.integer();
                    cr.checkArrears(memberId, allMembers);
                }
                case 3 -> cr.checkEstimatedIncome(allMembers);
            }
        }
    }

    public static void getCoachMenu(User[] users, ArrayList<SwimmingClubMember> competitiveJuniors, ArrayList<SwimmingClubMember> competitiveSeniors){ //Ændret til static
        Coach ch = (Coach) users[2];
        int userChoice = 0;
        while (userChoice!=3){
            System.out.println("\nRegistrer konkurrenceresultat for medlem - Tast 1\t\tTjek Delfinens Top 5-resultater - Tast 2\nForlad menu - Tast 3");
            userChoice = GetUserInput.menu(3);
            switch (userChoice){
                case 1 -> ch.registerNewTime(competitiveJuniors,competitiveSeniors); //ch.registerSwimTime();
                case 2 -> ch.topFiveResults(competitiveJuniors, competitiveSeniors); // FileReader.printSeniorCompetitiveList();
            }
        }
    }
}
