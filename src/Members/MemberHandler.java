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

    public static SwimmingClubMember getCompetitiveJuniorFromId(int memberId, ArrayList<SwimmingClubMember> competitiveJuniors){
        SwimmingClubMember memberToCheck = null;
        for (SwimmingClubMember member:competitiveJuniors) {
            if (member.getMemberId()==memberId){
                memberToCheck=member;
            }
        } return memberToCheck;
    }

    public static SwimmingClubMember getCompetitiveSeniorFromId(int memberId, ArrayList<SwimmingClubMember> competitiveSeniors){
        SwimmingClubMember memberToCheck = null;
        for (SwimmingClubMember member:competitiveSeniors) {
            if (member.getMemberId()==memberId){
                memberToCheck=member;
            }
        } return memberToCheck;
    }


}
