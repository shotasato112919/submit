package restaurantapp.model;

import restaurantapp.dao.AdminUserDao;

public class LoginAdminLogic {
	LoginEntity loginEntity;

	public LoginAdminLogic(LoginEntity login) {
		this.loginEntity = login;
	}

	public AdminUserEntity searchAdminUser() {
		System.out.println("LoginAdminLogic:searchAdminUser");
		AdminUserDao adminUserDao = new AdminUserDao();
		AdminUserEntity adminUserEntity = adminUserDao.searchAdminUser(this.loginEntity);

		return adminUserEntity;

	}
}
