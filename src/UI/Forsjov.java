package UI;

import java.util.ArrayList;

import static IO.FileReader.getMemberIdsFromFile;

public class Forsjov {
    public static void main(String[] args) {
        ArrayList<String> memberIds = getMemberIdsFromFile();
        for (String string:memberIds) {
            System.out.println(string);

        }
    }
}
