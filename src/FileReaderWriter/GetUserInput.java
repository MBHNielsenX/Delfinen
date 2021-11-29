//Jens' kode
package FileReaderWriter;

import java.util.Scanner;

public class GetUserInput {

    public static String string(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int integer(){
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
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
