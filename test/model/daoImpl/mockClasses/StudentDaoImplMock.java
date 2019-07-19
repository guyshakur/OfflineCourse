package model.daoImpl.mockClasses;

import java.util.HashMap;

import model.dao.StudentDao;
import model.transferObjects.Student;


public class StudentDaoImplMock implements StudentDao {

	HashMap <String,Student> students = new HashMap<String, Student>();
	

	public String getConnectionString() {
		return "";
	}

	public void setConnectionString(String connectionString) {
		
	}

	public void connect() throws Exception {
		

	}

	@Override
	public void insert(Student student) throws Exception {
		students.put(student.getUserName(),student);
	}

	public boolean isUserExist(String userName) throws Exception {
		return students.containsKey(userName);
	}

	@Override
	public int getUserId(String userName,String password) throws Exception {
		if(!isUserExist(userName)) {
			return -1;
		}
		
		return students.get(userName).getID();
	}

	@Override
	public Student getStudent(String userName) throws Exception {
		// TODO Auto-generated method stub
		return students.get(userName);
	}

	@Override
	public void delete(String userName) throws Exception {
		students.remove(userName);
		
	}
	
	
	

}
