package controller;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

import model.Session;
import model.dao.StudentDao;
import model.transferObjects.Student;
import view.screens.LoginScreenImpl;
import view.screens.LoginScreen;
import view.screens.MainScreen;
import view.screens.SignUpdialog;
import view.utilities.InputValidator;

public class LoginController extends Controller {
	//private static LoginController thisObj=null;
	private  LoginScreen loginScreen=null;
	private  SignUpdialog signUpDialog=null;
	private  NavigationFactory navigationFactory = null;
	//private MainScreen mainScreen=null;

	public LoginController() {
		//thisObj=this;
	}


	public LoginScreen getLoginScreen() {
		return loginScreen;
	}



	public void setLoginScreen(LoginScreen loginScreen) {
		this.loginScreen = loginScreen;
	}



//	public MainScreen getTestScreen() {
//		return mainScreen;
//	}
//
//
//
//	public void setTestScreen(MainScreen testScreen) {
//		this.mainScreen = testScreen;
//	}



	



	public  NavigationFactory getNavigationFactory() {
		return navigationFactory;
	}


	public  void setNavigationFactory(NavigationFactory navigationFactory) {
		this.navigationFactory = navigationFactory;
	}


	
	@Override
	public void start() {
		//EventQueue.invokeLater(new Runnable() {
			//public void run() {
				try {
					
					loginScreen.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
		//	}
	//	});

	}






	public void login(String userName,String password) {
		try {

			Student student=studentDao.getStudent(userName);
			if(student==null) {
				loginScreen.displayStatus("Invalid username or password");
			}
			else if(student.getPassword().equals(password)) {
				Session.getInstance().setCurrentUser(student);
				loginScreen	.close();
				Controller controller=
						navigationFactory.getController("After Successfull Login");
				
				controller.start();
				

			}
			else {

				loginScreen.displayStatus("invalid username or password");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}


	public  SignUpdialog getSignUpScreen() {
		return signUpDialog;
	}


	public  void setSignUpDialog(SignUpdialog signUpDialog) {
		this.signUpDialog = signUpDialog;
	}


	public void cleanTextFields() {
		loginScreen.clearTextFields();
	}


	public void setLoginScreenEnableAgainAndClearAllFields() {
		loginScreen.setEnabled(true);
		loginScreen.clearTextFields();
		signUpDialog.clearAllTextFields();
		
	}





}
