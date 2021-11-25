package UI;

import Users.Cashier;
import Users.Chairman;
import Users.Coach;

public class Forsjov {
    public static void main(String[] args) {

        Chairman mads = new Chairman("Mads","hej","jens.dk");
        Cashier jens = new Cashier("Jens","nej","jens.dk");
        Coach mikkel = new Coach("Mikkel","dig","jens.dk");

        mads.createNewMember();


    }
}
