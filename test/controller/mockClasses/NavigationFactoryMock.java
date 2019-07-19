package controller.mockClasses;

import controller.Controller;
import controller.NavigationFactory;

public class NavigationFactoryMock implements NavigationFactory {
	
	Controller controller=null;
	
	public NavigationFactoryMock(Controller controller) {
		this.controller=controller;
	}
	@Override
	public Controller getController(String controllerName) {
		return controller;
	}
	@Override
	public void addController(String controllerName, Controller controller) {
		
		
	}
	
	

}
