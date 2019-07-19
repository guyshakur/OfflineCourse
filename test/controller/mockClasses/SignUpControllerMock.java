package controller.mockClasses;

import controller.SignUpController;
import model.dao.StudentDao;
import view.screens.LoginScreenImpl;
import view.screens.SignUpDialogImpl;
import view.screens.SignUpdialog;

public class SignUpControllerMock implements SignUpController {

	@Override
	public SignUpdialog getRegistrationScreen() {
		return null;
	}

	@Override
	public void setSignUpDialog(SignUpDialogImpl signUpDialog) {

	}

	
	@Override
	public void start() {

	}

	@Override
	public void setEnable() {

	}

	@Override
	public void setLoginScreen(LoginScreenImpl loginScreen) {

	}

	@Override
	public int saveUser(String firstName, String lastName, String userName, String password) {
		return 0;
	}

}
