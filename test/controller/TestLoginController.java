package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import controller.mockClasses.DummyControllerMock;
import controller.mockClasses.NavigationFactoryMock;
import controller.mockClasses.SignUpControllerMock;
import model.daoImpl.DbHandler;
import model.daoImpl.StudentDaoImplForSqlite;
import model.daoImpl.mockClasses.StudentDaoImplMock;
import model.transferObjects.Student;
import view.mockClasses.LoginScreenMock;
import view.mockClasses.SignUpDialogMock;
import view.screens.LoginScreen;

class TestLoginController {

	@BeforeAll
	static void runOnce() {
		try {
			
		} catch (Exception e) {
			fail(e.getMessage());
			
		}
	}
	
	@Test
	void test() {
		//Injecting mock dependencies to loginController
		LoginController loginController=new LoginController();
		SignUpControllerMock signUpControllerMock=new SignUpControllerMock();
		LoginScreenMock loginScreenMock=new LoginScreenMock();
		SignUpDialogMock signUpDialogMock=new SignUpDialogMock();
		loginController.setSignUpDialog(signUpDialogMock);
		loginScreenMock.setLoginController(loginController);
		loginScreenMock.setSignUpController(signUpControllerMock);
		loginController.setLoginScreen(loginScreenMock);
		StudentDaoImplMock studentDaoImplMock=new StudentDaoImplMock();
		Student student=new Student();
		student.setFirstName("guy");
		student.setLastName("Schiff");
		student.setUserName("shakur");
		student.setPassword("12345");
		try {
			studentDaoImplMock.insert(student);
		} catch (Exception e) {
			
		}
		loginController.setStudentDao(studentDaoImplMock);
		DummyControllerMock dummyControllerMock=new DummyControllerMock();
		NavigationFactoryMock navigationFactoryMock=new NavigationFactoryMock(dummyControllerMock);
		loginController.setNavigationFactory(navigationFactoryMock);
		
		loginController.login(student.getUserName(), student.getPassword());
		assertTrue(dummyControllerMock.isWasControllerStarted(),"dummyController not started");
		
	}

}
