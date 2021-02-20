package sample;

public class Person {

    String firstName, lastName, email;
    int number;
    public Person(String firstName, String lastName, String email, int number){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getNumber(){
        return number;
    }

    public String getLastName() {
        return lastName;
    }



    public String getEmail() {
        return email;
    }

}
