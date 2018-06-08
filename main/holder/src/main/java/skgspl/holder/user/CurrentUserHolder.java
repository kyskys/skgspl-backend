package skgspl.holder.user;

import skgspl.entity.User;

public class CurrentUserHolder {

	private User currentUser;

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

}
