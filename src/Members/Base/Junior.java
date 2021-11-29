//Jens' kode
package Members.Base;

import java.time.LocalDate;

public class Junior extends SwimmingClubMember {

    public Junior(int memberId, String name, String address, String email, int phoneNumber, LocalDate dateOfBirth, int contingent, double arrears, boolean isActive, boolean isCompetitive) {
        super(memberId, name, address, email, phoneNumber, dateOfBirth, contingent, arrears, isActive, isCompetitive);
    }

    public Junior(String name, String address, String email, int phoneNumber, LocalDate dateOfBirth, boolean isActive) {
        super(name, address, email, phoneNumber, dateOfBirth, isActive);
        if (isActive){
            setArrears(1000);
            setArrears(1000);
        } else{
            setArrears(500);
            setContingent(500);
        }
    }
}
