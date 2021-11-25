package Users;

import Members.SwimmingClubMember;

import java.util.ArrayList;

public class Cashier extends Admin{

    public Cashier(String userName, String password, String email) {
        super(userName, password, email);
    }

    public void checkArrears(int memberId, ArrayList<SwimmingClubMember> allMembers){
        SwimmingClubMember memberToCheck = null;
        for (SwimmingClubMember member:allMembers) {
            if (member.getMemberId()==memberId){
                memberToCheck=member;
            }
        }
        System.out.println(memberToCheck.getName()+" is DKK "+memberToCheck.getArrears()+" in arrears.");
    }

    public void checkEstimatedIncome(ArrayList<SwimmingClubMember> allMembers){
        int estimatedIncome=0;
        for (SwimmingClubMember member:allMembers) {
            estimatedIncome+=member.getContingent();
        }
        System.out.println("Estimated income for this year is DKK "+estimatedIncome+",-");
    }

    public void registerContingentPayment(int memberId, double amountPayed, ArrayList<SwimmingClubMember> allMembers){
        SwimmingClubMember memberToCheck = null;
        for (SwimmingClubMember member:allMembers) {
            if (member.getMemberId()==memberId){
                memberToCheck=member;
            }
        }
    }
}
