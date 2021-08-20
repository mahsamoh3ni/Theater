package theater;

import theater.lists.ConferenceList;
import theater.lists.MemberList;
import theater.store.IOFile;


public class Administer {
    private MemberList memberList = new MemberList();
    private Manager manager = new Manager();
    private ConferenceList conferenceList = new ConferenceList();
    private IOFile ioFile = new IOFile();

    public Administer() throws Exception {
        try {
            loadData();
        } catch (Exception e) {
        }
    }

    public void loadData() {
        if (memberList != null)
            memberList = ioFile.readMember();
        if (conferenceList != null)
            conferenceList = ioFile.readConference();
        if (manager != null)
            manager = ioFile.readManager();
    }

    public void persistData() {
        ioFile.writeMembers(memberList);
        ioFile.writeConference(conferenceList);
        ioFile.writeManager(manager);
    }

    public void register(Member member) {
        manager.addRequest(member);
    }

    public void acceptOrRejectMember(int choice, int index) {
        if (manager.acceptOrReject(choice)) {
            memberList.register(manager.returnData(index - 1));
            manager.deleteRequest(index - 1);
        } else
            manager.deleteRequest(index - 1);
    }

    public void viewAllRequest() {
        manager.viewAllMemberRequest();
    }

    public void viewAllMembers() {
        memberList.viewAllMembers();
    }

    public boolean checkMember(int userId, String checkPassword) throws Exception {
        return memberList.checkMember(userId, checkPassword);
    }

    public void deleteMember(int userId) {
        memberList.deleteMember(userId);
    }

    public void addDay(WeekDays day, ConferenceShift shift) {
        manager.addConferenceDay(day, shift);
    }

    public void reserve(Conference conference) {
        manager.addReserve(conference);
    }

    public void acceptOrRejectConference(int choice, int index, int userId) {
        Member member = memberList.getMember(userId);
        if (member.getSize() < 3) {
            if (manager.acceptOrReject(choice)) {
                conferenceList.addConference(manager.returnConference(index - 1));
                manager.deleteConferenceRequest(manager.returnConference(index - 1));
                manager.deleteConferenceDay(manager.returnConference(index - 1).getConferenceDay()
                        , manager.returnConference(index - 1).getConferenceShift());
                member.add(manager.returnConference(index - 1));
            }
        } else
            System.out.println("your reserve is full");
    }

    public void viewAllConferenceRequests() {
        manager.viewConferenceRequest();
    }

    public void viewConferenceNotHeld() {
        manager.viewConferenceNotHeld();
    }

    public void viewAllConferences() {
        conferenceList.viewAllConferences();
    }

    public void conferenceReserveStatus(WeekDays day, ConferenceShift shift) {
        if (conferenceList.searchConference(day, shift) != null)
            System.out.println("Your conference has accepted");
        else
            System.out.println("your conference not accepted");
    }

    public boolean checkManager(int userId, String password) {
        return userId == manager.getUserId() && password.equals(manager.getPassword());
    }

    public Conference searchConference(WeekDays day, ConferenceShift shift) {
        return conferenceList.searchConference(day, shift);
    }

    public void cancelConference(Conference conference, int userId) {
        manager.addConferenceDay(conference.getConferenceDay(), conference.getConferenceShift());
        Member member = memberList.getMember(userId);
        member.delete(conference.getConferenceDay(), conference.getConferenceShift());
        conferenceList.deleteConference(conference.getConferenceDay(), conference.getConferenceShift());
    }

    public void deleteConference(WeekDays day, ConferenceShift shift, int userId) {
        manager.deleteConferenceDay(day, shift);
        conferenceList.deleteConference(day, shift);
        Member member = memberList.getMember(userId);
        member.delete(day, shift);

    }

    public Member getMember(int userId) {
        return memberList.getMember(userId);
    }
}
