package seedu.flirtfork;

public class Gift extends Favourites {

    protected String completionStatus;
    protected String gender; // M, F, U, any

    public Gift(String name, String gender, String completionStatus) {
        super(name);
        this.gender = gender;
        this.completionStatus = completionStatus;
    }

    @Override
    public String toString() {
        return (description);
    }

    public void markComplete() {
        this.completionStatus = "C";
    }

    public String getCompletionStatus() {
        return completionStatus;
    }

    public String getGender() { return gender; }

}
