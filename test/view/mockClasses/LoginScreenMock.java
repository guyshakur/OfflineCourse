package view.mockClasses;




import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.LoginController;
import controller.SignUpController;
import controller.SignUpControllerImpl;
import controller.SignUpController;
import model.dao.StudentDao;
import model.daoImpl.StudentDaoImplForSqlite;
import view.screens.LoginScreen;
import view.utilities.HintPasswordField;
import view.utilities.HintTextField;

public class LoginScreenMock extends JFrame implements LoginScreen  {
	
	LoginController loginController=null;
	private SignUpController signUpController;

	public LoginScreenMock() {


	}

	

	@Override
	public LoginController getLoginController() {
		return loginController;
	}



	@Override
	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}
	
	

	@Override
	public void displayStatus(String status) {
		
	}
	
	@Override
	public void close() {
		
	}



	@Override
	public SignUpController getSignUpController() {
		return signUpController;
	}



	@Override
	public void setSignUpController(SignUpController signUpController) {
		this.signUpController = signUpController;
	}
	
	
	@Override
	public boolean validateInput() {
		return true;

	}



	



	@Override
	public void clearTextFields() {
		// TODO Auto-generated method stub
		
	}



	


	

//	public SignUpController getSignUpController() {
//		return signUpController;
//	}
//
//
//
//	public void setSignUpController(SignUpController signUpController) {
//		this.signUpController = signUpController;
//	}

	
	

}
