//Jens' kode
package FileReaderWriter;

import java.util.Scanner;

public class GetUserInput {

    public static String string(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int integer(){
        int userInput = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            userInput =  Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ugyldigt input. Indtast venligst et nummer: ");
            return integer();
        }
        return userInput;
    }

    public static int menu(int amountOfOptions){
        Scanner scanner = new Scanner(System.in);
        int optionChoice = Integer.parseInt(scanner.nextLine());
        while (optionChoice>amountOfOptions || optionChoice < 0){
            System.out.println("Ugyldigt valg - Prøv igen: ");
            optionChoice = Integer.parseInt(scanner.nextLine());
        }
        return optionChoice;
    }

    public static double doubl(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }



}
