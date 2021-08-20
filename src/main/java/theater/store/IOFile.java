package theater.store;

import java.io.*;
import theater.Manager;
import theater.lists.ConferenceList;
import theater.lists.MemberList;

public class IOFile {
    private static String memberFilePath = "C://Users/Asus/Desktop/memberFile.pd";
    private static String conferenceFilePath = "C://Users/Asus/Desktop/conferenceFile.pd";
    private static String managerFilePath = "C://Users/Asus/Desktop/managerFile.pd";

    public MemberList readMember() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(memberFilePath))) {
            return (MemberList) inputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ConferenceList readConference() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(conferenceFilePath))) {
            return (ConferenceList) inputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Manager readManager() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(managerFilePath))) {
            return (Manager) inputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void writeMembers(MemberList memberList) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(memberFilePath))) {
            outputStream.writeObject(memberList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeConference(ConferenceList conferenceList) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(conferenceFilePath))) {
            outputStream.writeObject(conferenceList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeManager(Manager manager) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(managerFilePath))) {
            outputStream.writeObject(manager);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
