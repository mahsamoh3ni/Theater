package theater.lists;

import theater.Conference;
import theater.ConferenceShift;
import theater.WeekDays;
import java.io.Serializable;
import java.util.*;

public class ConferenceList  implements Serializable {
   private LinkedList<Conference> conferences;

    public ConferenceList() {
        conferences = new LinkedList<Conference>();
    }

    public void addConference(Conference conference) {
        conferences.add(conference);
    }

    public Conference searchConference(WeekDays day, ConferenceShift shift) {
        for (int i = 0; i <conferences.size() ; i++) {
            Conference conference = conferences.get(i);
            if(conference.getConferenceDay() == day
               && conference.getConferenceShift() == shift)
                return conference;
        }
        return null;
    }

    public void viewAllConferences() {
        System.out.println(conferences.toString());
    }

    public void deleteConference(WeekDays days , ConferenceShift shift) {
       Conference conference = searchConference(days,shift);
      conferences.remove(conference);
    }
}
