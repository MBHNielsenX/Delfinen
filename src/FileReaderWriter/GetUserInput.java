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



}
