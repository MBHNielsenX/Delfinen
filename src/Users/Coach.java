package Users;

import Competitive.Competition;

public class Coach extends Admin{
    public Coach(String userName, String password, String email) {
        super(userName, password, email);
    }

    public static void registerSwimTime (){ // Vi skal bruge Svømmer (Navn, ID?), disciplin og tiden.
        // String nameOfCompetition, int memberID, String memberName, double swimTime
    }

    public void displayAllCompetitiveSwimmers(){ // Viser navne og ID på alle konkurrencesvømmere

    }

    public void newCompetition(){
        Competition.createNewCompetition();
    }

    public void topFiveResults(){

    }

    public void isTopFive(){

    }
}
