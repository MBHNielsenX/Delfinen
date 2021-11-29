package Users;

import Competitive.Competition;

public class Coach extends Admin{

    public Coach(String userName, String password, String email) {
        super(userName, password, email);
    }

    public void registerSwimTime (){ // Vi skal bruge Svømmer (Navn, ID?), disciplin og tiden.

    }

    public void newCompetition(){
        Competition.createNewCompetition();
    }

    public void topFiveResults(){

    }

    public void isTopFive(){

    }
}
