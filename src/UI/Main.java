//Jens' kode

package UI;

import FileReaderWriter.GetUserInput;
import Users.*;


public class Main {
    public static void main(String[] args) {
        Admin[] users = {
                new Chairman("Mads", "hej", "jens.dk"),
                new Cashier("Jens", "nej", "jens.dk"),
                new Coach("Mikkel", "dig", "jens.dk")
        };

        giveRespectiveMenuOptions(logInSequence(users),users);
    }

    public static void giveRespectiveMenuOptions(int userNumber, Admin[] users){
        switch(userNumber){
            case 0 -> getChairmanMenu(users);
            case 1 -> getCashierMenu(users);
            case 2 -> getCoachMenu(users);
            }
        }

    public static int logInSequence(Admin[] users) {
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

    public static void getChairmanMenu(Admin[] users){
        Chairman cn = (Chairman) users[0];
        int userChoice = GetUserInput.menu(1);
        switch (userChoice){
            case 1 -> cn.createNewMember();
        }
        cn.createNewMember();
    }
    public static void getCashierMenu(Admin[] users){
        Cashier cr = (Cashier) users[1];
        int userChoice = GetUserInput.menu(3);
        switch (userChoice){
            //case 1 -> cr.registerContingentPayment();
            //case 2 -> cr.checkArrears();
            //case 3 -> cr.checkEstimatedIncome();
        }
    }
    public static void getCoachMenu(Admin[] users){
        Coach ch = (Coach) users[2];
        int userChoice = GetUserInput.menu(3);
        switch (userChoice){
            case 1 -> ch.registerSwimTime();
            case 2 -> ch.topFiveResults();
        }

    }
}
