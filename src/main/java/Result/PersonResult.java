package Result;
import Model.Person;

public class PersonResult {

    Person[] person;
    private boolean success;

    /**
     * This is a constructor for the PersonResults
     * @param person
     * @param success
     */
    public PersonResult(Person[] person, boolean success) {
        this.person = person;
        this.success = success;
    }

    public Person[] getPerson() {
        return person;
    }

    public void setPerson(Person[] person) {
        this.person = person;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
