package UI;

import IO.FileReader;
import IO.GetUserInput;

import java.util.ArrayList;

import static IO.FileReader.getMemberIdsFromFile;

public class Forsjov {
    public static void main(String[] args) {
        for (int i = 0; i <FileReader.getAllCompetitiveJuniorsToArrayList().size() ; i++) {
            FileReader.getAllCompetitiveJuniorsToArrayList().get(i).toString();
        }

    }
}
