//Jens' kode
package Members;

import java.time.LocalDate;

public class Senior extends SwimmingClubMember{

    public Senior(int memberId, String name, String address, String email, int phoneNumber, LocalDate dateOfBirth, int contingent, double arrears, boolean isActive, boolean isCompetitive) {
        super(memberId, name, address, email, phoneNumber, dateOfBirth, contingent, arrears, isActive, isCompetitive);
    }

    public Senior(String name, String address, String email, int phoneNumber, LocalDate dateOfBirth, boolean isActive) {
        super(name, address, email, phoneNumber, dateOfBirth, isActive);
        if (isActive){
            setArrears(1600);
            setContingent(1600);
        } else{
            setArrears(500);
            setContingent(500);
        }
    }
}
