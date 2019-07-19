package view.mockClasses;

import controller.LoginController;
import controller.SignUpController;
import view.screens.SignUpdialog;

public class SignUpDialogMock implements SignUpdialog {

	SignUpController signUpController=null;
	LoginController loginController=null;
	
	@Override
	public SignUpController getSignUpController() {
		return signUpController;
	}

	@Override
	public void setSignUpController(SignUpController signUpController) {
		this.signUpController=signUpController;

	}

	@Override
	public LoginController getLoginController() {
		return loginController;
	}

	@Override
	public void setLoginController(LoginController loginController) {
		this.loginController=loginController;

	}

	@Override
	public void displayStatus() {
	}

	@Override
	public boolean validateInput() {
		return true;
	}

	@Override
	public void clearAllTextFields() {

	}

}
