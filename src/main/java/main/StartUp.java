package main;
import domain.DomainController;
import ui.UserInterface;

public class StartUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DomainController dc = new DomainController();
		new UserInterface(dc).main();
	}

}
