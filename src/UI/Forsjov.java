package UI;

import Members.Senior;
import Users.Chairman;

import java.time.LocalDate;
import java.util.Date;

public class Forsjov {
    public static void main(String[] args) {

        Chairman mads = new Chairman("Mads","hej","jens.dk");

        Date date = new Date(1994,10,10);
        mads.createNewMember();
        //System.out.println(date);


    }
}
