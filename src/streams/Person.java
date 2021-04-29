package streams;

import java.util.List;

/**
 * Created by elamurugan on 2019-03-27.
 */
public class Person {
    private String name;
    private Integer age;
    private String gender;
    private List<String> phoneNumbers;

    public  Person(){
    }
    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Person(String name, Integer age, String gender, List<String> phoneNumbers) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phoneNumbers = phoneNumbers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "[Name ="+name+" Age="+age+" Gender="+gender+" PhoneNumbers="+phoneNumbers.toString()+"]";
    }
}
