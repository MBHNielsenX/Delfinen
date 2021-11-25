package UI;

import FileReaderWriter.Reader;
import Members.Senior;
import Users.Chairman;

import java.util.ArrayList;
import java.util.Date;

public class Forsjov {
    public static void main(String[] args) {
        Chairman mads = new Chairman("Mads","hej","jens.dk");

        ArrayList liste = new ArrayList();
        int a = 1;
        String b = "Hej";
        liste.add(a);
        liste.add(b);
        System.out.println(liste);

        //mads.createNewMember();
        //mads.createNewMember();
        mads.createNewMember();

    }
}
