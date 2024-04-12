package seedu.flirtfork;

public class Favourites {
    protected String description;

    public Favourites(String description) {
        if (description == null) {
            throw new IllegalArgumentException("Description cannot be null");
        }
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return description;
    }

    public String toFileFormat() {
        return description;
    }

}
