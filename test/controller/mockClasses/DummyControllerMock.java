package controller.mockClasses;

import controller.Controller;
import model.dao.StudentDao;

public class DummyControllerMock extends Controller {
	
	boolean wasControllerStarted=false;
	
	public boolean isWasControllerStarted() {
		return wasControllerStarted;
	}

	public void setWasControllerStarted(boolean wasControllerStarted) {
		this.wasControllerStarted = wasControllerStarted;
	}

	@Override
	public void start() {
		wasControllerStarted=true;
	}

	@Override
	public void setStudentDao(StudentDao studentDao) {

	}
	
	

}
