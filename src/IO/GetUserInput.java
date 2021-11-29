//Jens' kode
package IO;

import java.util.Scanner;

public class GetUserInput {

    public static String string(){//Jens
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int integer(){//Jens og Mads
        int userInput;
        try {
            Scanner scanner = new Scanner(System.in);
            userInput =  Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ugyldigt input. Indtast venligst et nummer: ");
            return integer();
        }
        return userInput;
    }

    public static int menu(int amountOfOptions){// Jens
        Scanner scanner = new Scanner(System.in);
        int optionChoice = Integer.parseInt(scanner.nextLine());
        while (optionChoice>amountOfOptions || optionChoice < 0){
            System.out.println("Ugyldigt valg - Prøv igen: ");
            optionChoice = Integer.parseInt(scanner.nextLine());
        }
        return optionChoice;
    }

    public static double doubl(){// Jens, Mads og Mikkel
        double userInput;
        try {
            Scanner scanner = new Scanner(System.in);
            userInput = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ugyldigt input. Indtast venligst et nummer: ");
            return doubl();
        }
        return userInput;
    }



}
