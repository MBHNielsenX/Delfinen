package UI;

import FileReaderWriter.Reader;
import Members.Senior;
import Users.Chairman;
import java.util.Date;
import Members.SwimmingClubMember;
public class Forsjov {
    public static void main(String[] args) {
        SwimmingClubMember.setExistingMemberIds(); //Must be the first thing to run for the existingMemberIDS to have the IDs from the file


        Chairman mads = new Chairman("Mads","hej","jens.dk");

        mads.createNewMember();
        //mads.createNewMember();
        /*
        Reader.printMembersList();
        Reader.showListOfMemberID();

         */


    }
}
