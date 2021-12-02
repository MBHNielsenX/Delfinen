package Competitive;

import IO.GetUserInput;
import Members.Base.SwimmingClubMember;
import Members.MemberHandler;
import Users.Chairman;

import java.time.LocalDate;



public class Competition {
    private String nameOfCompetition;

    public Competition(String nameOfCompetition) {
        this.nameOfCompetition = nameOfCompetition;
    }

    public String getNameOfCompetition(){
        return nameOfCompetition;
    }
}
