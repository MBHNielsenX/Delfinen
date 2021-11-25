//Jens' kode
package Members;

import java.time.LocalDate;
import java.util.Date;

public class Senior extends SwimmingClubMember{
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
