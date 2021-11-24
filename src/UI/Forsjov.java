package UI;

import FileReaderWriter.Reader;
import Members.Senior;
import Users.Chairman;

import java.time.LocalDate;
import java.util.Date;

public class Forsjov {
    public static void main(String[] args) {

        Chairman mads = new Chairman("Mads","hej","jens.dk");
        Senior jens = new Senior("Jens Ryge","Vølundsgade 4","jens@politiken.dk",10203040,"10-5-96");

        //mads.createNewMember();

        Writer.write(jens);
        Reader.printMembersList();
        Reader.printMembersList();
        Reader.findMemberID();

        mads.createNewMember();


    }
}
