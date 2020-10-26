package team.codium.legacytraining;

import java.util.List;
import java.util.Locale;

public class User {

	private String name;
	private String biography;
	private int score;
	private String location;

	public User(String name, String biography) {
		this.name = name;
		this.biography = biography;
		this.score = calculateScore(biography);
		this.location = calculateLocation(biography);
	}

	private String calculateLocation(String biography2) {
		String location = "";
		String[] keywords = { "Barcelona", "Madrid", "Granada", "Vigo", "Palma de Mallorca" };
		for (int i = 0; i < keywords.length; i++) {
			if (biography.indexOf(keywords[i]) != -1) {
				location = keywords[i];
			}
		}
		return location;
	}

	private int calculateScore(String biography) {
		String[] keywords = { "edición", "sociedad", "mundo", "libro", "texto", "revista", "valores", "educación",
				"teatro", "social" };
		int tempScore = 0;
		for (int i = 0; i < keywords.length; i++) {
			int lastIndex = 0;
			while (lastIndex != -1) {
				lastIndex = biography.indexOf(keywords[i], lastIndex);
				if (lastIndex != -1) {
					lastIndex += 1;
					tempScore++;
				}
			}
		}
		return tempScore;

	}

	public String getName() {
		return name;
	}

	public String getBiography() {
		return biography;
	}

	public int getScore() {
		return score;
	}

	public String getLocation() {
		return location;
	}
}
