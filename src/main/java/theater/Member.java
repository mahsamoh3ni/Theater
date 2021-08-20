package theater;


import java.util.LinkedList;

public class Member extends Person  {

    private double phoneNumber;
    private String email;
    private static int memberCounter = 0;
    private LinkedList<Conference> conferences;

    public Member(String firstName,
                  String lastName,
                  String password,
                  int nationalCode,
                  Date birthDate,
                  long phoneNumber,
                  String email) throws Exception {
        super(firstName, lastName, ++memberCounter, password, nationalCode, birthDate);
        setPhoneNumber(phoneNumber);
        this.email = email;
        conferences = new LinkedList<>();
    }

    public void setPhoneNumber(long phoneNumber) throws Exception {
        if (countDigit(phoneNumber) == 10)
            this.phoneNumber = phoneNumber;
        else
            throw new Exception("Your phoneNumber invalid!");
    }

    public int getSize() {
        return conferences.size();
    }

    public void add(Conference conference) {
        conferences.add(conference);
    }

    public void delete(WeekDays days , ConferenceShift shift) {
        for (int i = 0; i <conferences.size() ; i++) {
            Conference conference = conferences.get(i);
            if (conference.getConferenceDay() == days && conference.getConferenceShift() == shift)
                conferences.remove(conference);
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nphoneNumber is:" + phoneNumber +
                "\nEmail is:" + email + "\n";
    }

    public int countDigit(long n) {
        int count = 0;
        while (n != 0) {
            n = n / 10;
            ++count;
        }
        return count;
    }

}
