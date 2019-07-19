package controller;

import java.util.HashMap;

import javax.swing.JFrame;

import view.screens.MainScreen;

public  class NavigationFactoryImpl implements NavigationFactory {
	
	
	private HashMap<String, Controller> controllersMap = new HashMap<String, Controller>();
	
    //factory method
	@Override
	public  Controller getController(String controllerName) {
		
		return controllersMap.get(controllerName);
		
		
		
//		switch (controllerName){
//			case "Login":
//				return new LoginController();
//			
//			case "After Successfull Login":
//				MainScreenController mainScreenController=new MainScreenController();
//				return    mainScreenController;
//			
//			case "Sign Up":
//				return new SignUpControllerImpl();
//				
//			case "C":
//			case "Java":
//			case "Data Structures":
//			case "SQL":
//				return new QuizController();
//				
//			
//				
//			default :
//				return null;
//		}
		
	}
	
	public void addController(String controllerName,Controller controller) {
		controllersMap.put(controllerName, controller);
	}
}
