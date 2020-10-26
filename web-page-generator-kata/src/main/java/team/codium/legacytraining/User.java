package team.codium.legacytraining;

import java.util.Locale;

public class User {

    private String name;
    private String biography;

    public User(String name, String biography) {
        this.name = name;
        this.biography = biography;
    }

    public String getName() {
        return name;
    }

    public String getBiography() {
        return biography;
    }

}
