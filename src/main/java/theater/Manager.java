package theater;

import java.util.*;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Manager extends Person {
    private ArrayList<Member> requestMember;
    private ArrayList<Conference> conferenceDay;
    private ArrayList<Conference> requestConference;
    private static Config config = ConfigFactory.load();


    public Manager() throws Exception {
        super(config.getString("userInfo.firstName"),
                config.getString("userInfo.lastName"),
                config.getInt("userInfo.userId"),
                config.getString("userInfo.password"),
                config.getInt("userInfo.nationalCode"),
                new Date(config.getInt("userInfo.date.day"),
                        config.getInt("userInfo.date.month"),
                        config.getInt("userInfo.date.year")));

        requestMember = new ArrayList<Member>();
        conferenceDay = new ArrayList<Conference>();
        requestConference = new ArrayList<Conference>();
    }

    public void addRequest(Member member) {
        requestMember.add(member);
    }

    public boolean acceptOrReject(int choice) {
        return choice == 1;
    }

    public Member returnData(int index) {
        return requestMember.get(index);
    }

    public void deleteRequest(int index) {
        requestMember.remove(index);
    }

    public void viewAllMemberRequest() {
        System.out.println(requestMember.toString());
    }

    public void addConferenceDay(WeekDays day, ConferenceShift shift) {
        conferenceDay.add(new Conference(null, day, null, null, shift));
    }

    public void addReserve(Conference conference) {
        requestConference.add(conference);
    }

    public Conference returnConference(int index) {
        return requestConference.get(index);
    }

    public void viewConferenceRequest() {
        System.out.println(requestConference.toString());
    }

    public void deleteConferenceRequest(Conference conference) {
        for (int i = 0; i < conferenceDay.size(); i++) {
            Conference conference1 = conferenceDay.get(i);
            if (conference.getConferenceShift() == conference1.getConferenceShift()
                    && conference.getConferenceDay() == conference1.getConferenceDay()) {
                conference1.setConferenceHeld(true);
            }
        }
    }

    public void viewConferenceNotHeld() {
        System.out.println(conferenceDay.toString());
    }

    public void deleteConferenceDay(WeekDays day, ConferenceShift shift) {
        Conference conference = new Conference(null, day, null, null, shift);
        for (int i = 0; i < conferenceDay.size(); i++) {
            Conference conference1 = conferenceDay.get(i);
            if (conference.getConferenceShift() == conference1.getConferenceShift()
                    && conference.getConferenceDay() == conference1.getConferenceDay())
                conferenceDay.remove(conference1);
        }
    }

}
