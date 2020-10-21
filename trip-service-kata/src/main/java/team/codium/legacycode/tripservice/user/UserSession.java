package team.codium.legacycode.tripservice.user;

import team.codium.legacycode.tripservice.exception.CollaboratorCallException;

public class UserSession {

	private static final UserSession userSession;

	static {
		userSession = new UserSession(new User()){
			public User getLoggedUser() {
				throw new CollaboratorCallException(
						"UserSession.getInstance() should not be called in an unit test");
			}
		};
	}

	private final User user;

	public UserSession(User loggedUser) {
		this.user = loggedUser;
	}
	
	public static UserSession getInstance() {
		return userSession;
	}

	public User getLoggedUser() {
		return user;
	}
}