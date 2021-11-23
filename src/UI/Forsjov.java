package UI;

import Members.Senior;
import Users.Chairman;

public class Forsjov {
    public static void main(String[] args) {

        Chairman mads = new Chairman("Mads","hej","jens.dk");
        Senior jens = new Senior("Jens Ryge","Vølundsgade 4","jens@politiken.dk",10203040,"10-5-96");

        mads.createNewMember();



    }
}
