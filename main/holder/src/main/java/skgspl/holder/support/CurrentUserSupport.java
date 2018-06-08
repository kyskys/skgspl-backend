package skgspl.holder.support;

import skgspl.entity.User;
import skgspl.holder.provider.ApplicationContextProvider;
import skgspl.holder.user.CurrentUserHolder;

public interface CurrentUserSupport {
	public default User getCurrentUser() {
		return ApplicationContextProvider.getApplicationContext().getBean(CurrentUserHolder.class).getCurrentUser();
	}
}
