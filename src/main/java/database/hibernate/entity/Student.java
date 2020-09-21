package database.hibernate.entity;

/*
@project SQL-Examples
@author katkeit
Created on 9/20/2020.
*/

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The student table for Hibernate.
 */
@Table(name = "student")
public class Student
{
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private long studentID;

    @Column(nullable = false)
    private String firstName;

    // Not everyone has a middle name.
    private String middleName;

    @Column(nullable = false)
    private String lastName;

    // Not everyone has a suffix.
    private String suffix;

    @Column(nullable = false)
    private String birthday;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    private int zip;

    @UpdateTimestamp
    @Column(nullable = false)
    private String lastUpdated;

    /**
     * Get student's ID number.
     * @return Returns the student's ID as a long.
     */
    public long getStudentID() {
        return studentID;
    }

    /**
     * Set the student's ID number.
     * @param studentID The student's ID number as a long.
     */
    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    /**
     * Get the student's first name.
     * @return Return the student's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the student's first name.
     * @param firstName The student's first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the student's middle name.
     * @return Return the student's middle name.
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Set the student's middle name.
     * @param middleName The student's middle name.
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Get the student's last name.
     * @return Returns the student's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the student's last name.
     * @param lastName The student's last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *  Gets the student's suffix name.
     * @return Returns the student's suffix name.
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * Set the student's suffix name.
     * @param suffix The student's suffix name.
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    /**
     * Get the student's birthday.
     * @return Returns the student's birthday as a String.
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * Set the student's birthday.
     * @param birthday Returns the student's birthday as a String.
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * Get the student's address.
     * @return Return the student's address as String.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the student's address.
     * @param address The student's address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get the student's city portion of the address.
     * @return Returns the name of the city the student resides in.
     */
    public String getCity() {
        return city;
    }

    /**
     * Set the student's city portion of the address.
     * @param city The city in which the student resides in.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get the student's zip code.
     * @return Returns the student's zip code.
     */
    public int getZip() {
        return zip;
    }

    /**
     * Set the student's zip code.
     * @param zip The student's zip code area.
     */
    public void setZip(int zip) {
        this.zip = zip;
    }

    /**
     * Get the last time the student's records were updated.
     * @return Returns a date and time as a String
     */
    public String getLastUpdated() {
        return lastUpdated;
    }

    /**
     * Set the last time the student's records were updated.
     * @param lastUpdated DateTime as a String.
     */
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * Output the Student's variables as a String.
     * @return Returns a String output for
     */
    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", suffix='" + suffix + '\'' +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", zip=" + zip +
                ", lastUpdated='" + lastUpdated + '\'' +
                '}';
    }
}
