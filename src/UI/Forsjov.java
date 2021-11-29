package UI;

import IO.GetUserInput;

import java.util.ArrayList;

import static IO.FileReader.getMemberIdsFromFile;

public class Forsjov {
    public static void main(String[] args) {
        System.out.println("Hello World");
        ArrayList<String> memberIds = getMemberIdsFromFile();
        for (String string:memberIds) {
            System.out.println(string);

        }
        System.out.println(GetUserInput.integer());
    }
}
