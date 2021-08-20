package theater;

import java.io.Serializable;

public class Conference implements Serializable {
    private String organ;
    private WeekDays conferenceDay;
    private Member owner;
    private Date conferenceDate;
    private ConferenceShift conferenceShift;
    private boolean conferenceHeld = false;

    public Conference(Member owner, WeekDays conferenceDay, String organ, Date conferenceDate, ConferenceShift shift) {
        this.owner = owner;
        this.conferenceDay = conferenceDay;
        this.organ = organ;
        this.conferenceDate = conferenceDate;
        this.conferenceShift = shift;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }

    public void setConferenceDay(WeekDays conferenceDay) {
        this.conferenceDay = conferenceDay;
    }

    public void setOwner(Member owner) {
        this.owner = owner;
    }

    public void setConferenceDate(Date conferenceDate) {
        this.conferenceDate = conferenceDate;
    }

    public void setShift(ConferenceShift shift) {
        this.conferenceShift = shift;
    }

    public void setConferenceHeld(boolean conferenceHeld) {
        this.conferenceHeld = conferenceHeld;
    }

    public String getOrgan() {
        return organ;
    }

    public WeekDays getConferenceDay() {
        return conferenceDay;
    }

    public ConferenceShift getConferenceShift() {
        return conferenceShift;
    }

    public Date getConferenceDate() {
        return conferenceDate;
    }

    public Member getOwner() {
        return owner;
    }

    public boolean getConferenceHeld() {
        return conferenceHeld;
    }

    @Override
    public String toString() {
        return "\nOwner is:" + owner
                + "\nOrgan is:" + organ
                + "\nConferenceDate is:" + conferenceDate
                + "\nConferenceDay is:" + conferenceDay
                + "\nConferenceShift is:" + conferenceShift
                + "\n**************************";
    }


}
