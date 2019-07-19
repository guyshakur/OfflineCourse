package model.daoImpl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import model.transferObjects.Student;

class TestStudentDaoImplForSqlite {
	static Connection connection=null;
	static StudentDaoImplForSqlite studentDaoImplForSqlite=null;
	
	@BeforeAll
	static void runOnce() {
		try {
			connection=DbHandler.connectToDb("offline_courses_for_tests.db");
			studentDaoImplForSqlite=new StudentDaoImplForSqlite();
			studentDaoImplForSqlite.setConnection(connection);
		} catch (Exception e) {
			fail(e.getMessage());
			
		}
	}
	
	//In our test db the user guyshakur exists, so this test should succeed.
	@Test
	void testUserExists() {
		try {
			//true test
			boolean userExist =	studentDaoImplForSqlite.isUserExist("guyshakur");
			assertTrue(userExist,"This user exists in db.");
			//false test
			userExist=studentDaoImplForSqlite.isUserExist("guyshakur1111");
			assertFalse(userExist,"This user doesn't exists in db.");
		} catch (Exception e) {
			fail(e.getMessage());
			
		}
		
	}
	
	@Test
	void testInsertAndGetUser() {
		try {
			//Inserting student to db
			Student student=new Student();
			student.setFirstName("Sharona");
			student.setLastName("Schiff");
			student.setUserName("sharonashakur");
			student.setPassword("12345");
			//Deleting the user, if exists
			studentDaoImplForSqlite.delete(student.getUserName());
			studentDaoImplForSqlite.insert(student);
			
			//Retrieving the student from db
			Student studentFromDb = studentDaoImplForSqlite.getStudent(student.getUserName());
			
			assertEquals(student.getFirstName(), studentFromDb.getFirstName(),"student first name");
			assertEquals(student.getLastName(), studentFromDb.getLastName(),"student last name");
			assertEquals(student.getUserName(), studentFromDb.getUserName(),"student user name");
			assertEquals(student.getPassword(), studentFromDb.getPassword(),"student password");
			
			
		} catch (Exception e) {
			fail(e.getMessage());
			
		}
		
	}
	
	@AfterAll
	static void afterAll() {
		if(connection!=null) {
		try {
			connection.close();
		} catch (SQLException e) {
			fail(e.getMessage());
		
		}
		}
	}
	

}
