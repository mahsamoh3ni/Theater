package theater.lists;

import theater.Member;

import java.io.Serializable;
import java.util.*;

public class MemberList implements Serializable {
    private LinkedList<Member> members;

    public MemberList() {
        members = new LinkedList<Member>();
    }

    public void register(Member member) {
        members.add(member);
    }

    public boolean checkMember(int userId, String password) throws Exception {
        for (int i = 0; i < members.size(); i++) {
            Member member = members.get(i);
            if (member.getPassword().equals(password) && member.getUserId() == userId)
                return true;
        }
        throw new Exception("User not found!");
    }

    public void viewAllMembers() {
        System.out.println(members.toString());
    }

    public void deleteMember(int userId) {
        for (int i = 0; i < members.size(); i++) {
            Member member = members.get(i);
            if (member.getUserId() == userId)
                members.remove(members.get(i));
        }
    }

    public Member getMember(int userId) {
        for (int i = 0; i < members.size(); i++) {
            Member member = members.get(i);
            if (member.getUserId() == userId) {
                return member;
            }
        }
        return null;
    }

    public int length() {
        return members.size();
    }
}
