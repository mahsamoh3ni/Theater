package theater;

import java.io.Serializable;

public abstract class Person implements Serializable {
    private String firstName;
    private String lastName;
    private int userId;
    private String password;
    private int nationalCode;
    private Date birthDate;

    public Person() {
        this(null, null, 0, null, 0, null);
    }

    public Person(String firstName, String lastName, int userId, String password, int nationalCode, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
        this.password = password;
        this.nationalCode = nationalCode;
        this.birthDate = birthDate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNationalCode(int nationalCode) {
        this.nationalCode = nationalCode;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public int getUserId() {
        return userId;
    }

    public int getNationalCode() {
        return nationalCode;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "FirstName is:" + firstName +
                "\nLastName is:" + lastName +
                "\nUserId is:" + userId +
                "\nNationalCode is:" + nationalCode +
                "\nBirthDate is:" + birthDate
                ;
    }
}
