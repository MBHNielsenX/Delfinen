package Members;

import java.util.Date;

public class Pensioner extends SwimmingClubMember{
    public Pensioner(String name, String address, String email, int phoneNumber, Date dateOfBirth, boolean isActive) {
        super(name, address, email, phoneNumber, dateOfBirth, isActive);
        if (isActive){
            setArrears(1200);
            setContingent(1200);
        } else{
            setArrears(500);
            setContingent(500);
        }

    }
}
