package theater;

import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    private static Administer administer ;

    public Menu() {
        try {
            administer = new Administer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mainMenu() {
        boolean isFinished = false;
        while (!isFinished) {
            System.out.println("Please Enter your choice: \n"
                    + "1. Login as manager: \n"
                    + "2. Login as member: \n"
                    + "3. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Please enter userId:");
                    int userId = scanner.nextInt();
                    System.out.println("Please enter password:");
                    String password = scanner.next();
                    if (administer.checkManager(userId, password))
                        managerMenu();
                    break;
                case 2:
                    memberMenu();
                    break;
                case 3:
                    administer.persistData();
                    isFinished = true;
                    break;
                default:
                    System.out.println("Your choice invalid!");
            }
        }
    }

    public void managerMenu() {
        boolean isFinished = false;
        while (!isFinished) {
            System.out.println("Please Enter your choice: \n"
                    + "1. Accept or Reject requests: \n"
                    + "2. Delete member: \n"
                    + "3. View all Conference: \n"
                    + "4. Set day of Conference: \n"
                    + "5. View date of Conference held: \n"
                    + "6. Delete a conference: \n"
                    + "7. Accept or Reject conference: \n"
                    + "8. Logout\n"
            );
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    administer.viewAllRequest();
                    System.out.println("Enter number of request: ");
                    int index = scanner.nextInt();
                    System.out.println("1. Accept : \n"
                            + "2. Reject: \n ");
                    int accept = scanner.nextInt();
                    administer.acceptOrRejectMember(accept, index);
                    break;
                case 2:
                    administer.viewAllMembers();
                    System.out.println("Please enter your desired userId");
                    int deleteUserId = scanner.nextInt();
                    administer.deleteMember(deleteUserId);
                    break;
                case 3:
                    System.out.println("The conferences has been reserved:");
                    administer.viewAllConferences();
                    System.out.println("The Empty conference ");
                    administer.viewConferenceNotHeld();
                    break;
                case 4:
                    System.out.println("Saturday\n" +
                            "Sunday\n" +
                            "Monday\n" +
                            "Tuesday\n" +
                            "Wednesday\n" +
                            "Thursday\n" +
                            "Enter day:");
                    String day = scanner.next();
                    WeekDays days = WeekDays.valueOf(day.toUpperCase());
                    System.out.println("Enter shift of conference:");
                    String setShift = scanner.next();
                    ConferenceShift conferenceShift = ConferenceShift.valueOf(setShift.toUpperCase());
                    administer.addDay(days, conferenceShift);
                    break;
                case 5:
                    administer.viewAllConferences();
                    break;
                case 6:
                        System.out.println("Please enter conferenceDay:");
                        System.out.println("Saturday\n" +
                                "Sunday\n" +
                                "Monday\n" +
                                "Tuesday\n" +
                                "Wednesday\n" +
                                "Thursday\n" +
                                "Enter day:");
                        String deleteDay = scanner.next();
                        WeekDays deleteDays = WeekDays.valueOf(deleteDay.toUpperCase());
                        System.out.println("Enter shift of conference:");
                        String deleteShift = scanner.next();
                        ConferenceShift deleteConferenceShift = ConferenceShift.valueOf(deleteShift.toUpperCase());
                        System.out.println("If the desiredConference has been reserved Please enter userId of owner else please enter 0:");
                        int memberId = scanner.nextInt();
                        administer.deleteConference(deleteDays,deleteConferenceShift,memberId);
                    break;
                case 7:
                    administer.viewAllConferenceRequests();
                    System.out.println("Enter userId of owner:");
                    int userId = scanner.nextInt();
                    System.out.println("Enter number of request : ");
                    int conferenceIndex = scanner.nextInt();
                    System.out.println("1. Accept : \n"
                            + "2. Reject: \n ");
                    int conferenceAccept = scanner.nextInt();
                    administer.acceptOrRejectConference(conferenceAccept, conferenceIndex, userId);
                    break;
                case 8:
                    isFinished = true;
                    break;
            }
        }
    }

    public void memberMenu() {
        boolean isFinished = false;
        Member newMember;
        while (!isFinished) {
            System.out.println("Please Enter your choice: \n"
                    + "1. Register: \n"
                    + "2. Login: \n"
                    + "3. Status of request: \n"
                    + "4. Logout\n"
            );
            int choice = scanner.nextInt();
            try {
                switch (choice) {
                    case 1:
                        System.out.println("Please Enter your firstName:");
                        String firstName = scanner.next();
                        System.out.println("Please Enter your lastName:");
                        String lastName = scanner.next();
                        System.out.println("Please Enter your favorite password:");
                        String password = scanner.next();
                        System.out.println("Please Enter your nationalCode:");
                        int nationalCode = scanner.nextInt();
                        System.out.println("Please Enter day of your birthDate:");
                        int day = scanner.nextInt();
                        System.out.println("Please Enter month of your birthDate:");
                        int month = scanner.nextInt();
                        System.out.println("Please Enter year of your birthDate:");
                        int year = scanner.nextInt();
                        System.out.println("Please Enter your phoneNumber:");
                        long phoneNumber = scanner.nextLong();
                        System.out.println("Please Enter your emailAddress:");
                        String email = scanner.next();
                        Date date = new Date(day, month, year);
                        newMember = new Member(firstName, lastName, password, nationalCode, date, phoneNumber, email);
                        administer.register(newMember);
                        System.out.println(newMember.toString());
                        break;
                    case 2:
                        System.out.println("Please enter your userId:");
                        int userId = scanner.nextInt();
                        System.out.println("Please enter your password:");
                        String checkPassword = scanner.next();
                        if (administer.checkMember(userId, checkPassword)) {
                            Member member = administer.getMember(userId);
                            logInMember(member);
                        }
                        break;
                    case 3:

                        System.out.println("Please enter your userId:");
                        int statusUserId = scanner.nextInt();
                        System.out.println("Please enter your password:");
                        String statusPassword = scanner.next();
                        if (administer.checkMember(statusUserId, statusPassword))
                            System.out.println("Your request has been accepted");
                        else
                            System.out.println("Your request is being processed");
                        break;
                    case 4:
                        isFinished = true;
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void logInMember(Member owner) {
        boolean isFinished = false;
        while (!isFinished) {
            System.out.println("Please Enter your choice: \n"
                    + "1. View all time of Conference: \n"
                    + "2. Reserve Conference: \n"
                    + "3. Cancelling a conference: \n"
                    + "4. Status of reserve: \n"
                    + "5. Logout");
            int choice = scanner.nextInt();
            try {
                switch (choice) {
                    case 1:
                        administer.viewConferenceNotHeld();
                        break;
                    case 2:
                        administer.viewConferenceNotHeld();
                        System.out.println("Please enter organ:");
                        String organ = scanner.next();
                        System.out.println("Please enter conferenceDay:");
                        System.out.println("Saturday\n" +
                                "Sunday\n" +
                                "Monday\n" +
                                "Tuesday\n" +
                                "Wednesday\n" +
                                "Thursday\n" +
                                "Enter day:");
                        String day = scanner.next();
                        WeekDays days = WeekDays.valueOf(day.toUpperCase());
                        System.out.println("Enter shift of conference:");
                        String setShift = scanner.next();
                        ConferenceShift conferenceShift = ConferenceShift.valueOf(setShift.toUpperCase());
                        System.out.println("Please Enter day of your ConferenceDate:");
                        int conferenceDay = scanner.nextInt();
                        System.out.println("Please Enter month of your conferenceDate:");
                        int conferenceMonth = scanner.nextInt();
                        System.out.println("Please Enter year of your conferenceDate:");
                        int conferenceYear = scanner.nextInt();
                        Date date = new Date(conferenceDay, conferenceMonth, conferenceYear);
                        Conference conference = new Conference(owner, days, organ, date, conferenceShift);
                        administer.reserve(conference);
                        break;
                    case 3:
                        System.out.println("Please enter conferenceDay:");
                        String cancelDay = scanner.next();
                        WeekDays cancelConferenceDay = WeekDays.valueOf(cancelDay.toUpperCase());
                        System.out.println("Enter shift of conference:");
                        String cancelShift = scanner.next();
                        ConferenceShift conferenceCancelShift = ConferenceShift.valueOf(cancelShift.toUpperCase());
                        Conference cancelConference = administer.searchConference(cancelConferenceDay, conferenceCancelShift);
                        administer.cancelConference(cancelConference, owner.getUserId());
                        break;
                    case 4:
                        System.out.println("Please enter conferenceDay:");
                        String statusDay = scanner.next();
                        WeekDays conferenceStatusDays = WeekDays.valueOf(statusDay.toUpperCase());
                        System.out.println("Enter shift of conference:");
                        String statusShift = scanner.next();
                        ConferenceShift conferenceStatusShift = ConferenceShift.valueOf(statusShift.toUpperCase());
                        administer.conferenceReserveStatus(conferenceStatusDays, conferenceStatusShift);
                        break;
                    case 5:
                        isFinished = true;
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
