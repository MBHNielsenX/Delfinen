package Members;

import Members.Base.SwimmingClubMember;
import java.util.ArrayList;

public class MemberHandler {
    public static SwimmingClubMember getMemberFromId(int memberId, ArrayList<SwimmingClubMember> allMembers){
        SwimmingClubMember memberToCheck = null;
        for (SwimmingClubMember member:allMembers) {
            if (member.getMemberId()==memberId){
                memberToCheck=member;
            }
        } return memberToCheck;
    }


}
