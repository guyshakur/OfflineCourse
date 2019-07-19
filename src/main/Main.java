package main;

import java.awt.EventQueue;
import java.net.URLDecoder;
import java.nio.file.Paths;
import java.sql.Connection;

import javax.swing.JOptionPane;

import controller.GoalsController;
import controller.LoginController;
import controller.SignUpControllerImpl;
import controller.SolvedQuizController;
import controller.MainScreenController;
import controller.MyMedalsController;
import controller.NavigationFactory;
import controller.NavigationFactoryImpl;
import controller.QuizController;
import model.dao.QuizDao;
import model.dao.StudentDao;
import model.daoImpl.DbHandler;
import model.daoImpl.QuizDaoImplForSqlite;
import model.daoImpl.StudentDaoImplForSqlite;
import model.daoImpl.mockClasses.StudentDaoImplMock;
import model.transferObjects.Student;
import view.screens.GoalsScreen;
import view.screens.LoginScreenImpl;
import view.screens.SignUpDialogImpl;
import view.screens.SolvedQuizScreen;
import view.screens.MainScreen;
import view.screens.MyMedalsScreen;
import view.screens.OutOfQuizDialog;
import view.screens.QuizScreen;
import view.screens.SelectCategoryToSolveQuizScreen;

public class Main {

	public static void main(String[] args) {
		try {

			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						startApplication();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});



		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}

	}

	


	public static void startApplication() {
		try {
			
			//injuctions
			Configuration configuration = new Configuration();
		}
		catch (Exception e){
			System.out.println("Failed to Start Application. "+e.getMessage());

		}
	}

	

}
