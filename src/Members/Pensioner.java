//Jens' kode
package Members;

import java.time.LocalDate;

public class Pensioner extends SwimmingClubMember{

    public Pensioner(int memberId, String name, String address, String email, int phoneNumber, LocalDate dateOfBirth, int contingent, double arrears, boolean isActive, boolean isCompetitive) {
        super(memberId, name, address, email, phoneNumber, dateOfBirth, contingent, arrears, isActive, isCompetitive);
    }

    public Pensioner(String name, String address, String email, int phoneNumber, LocalDate dateOfBirth, boolean isActive) {
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
