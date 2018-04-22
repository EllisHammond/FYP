package dat;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

import employees.StateManager;
import employees.StateManager.State;

import static employees.Artiste.*;

public class Menu {
	
	private Texture background;
	private UserInterface menuUI;
	
	public Menu() {
		background = QuickLoad("Menu");
		menuUI = new UserInterface();
		menuUI.addButton("Begin", "beginButton",0.1f * WIDTH, 0.2f * HEIGHT);
		menuUI.addButton("Edit", "editButton",0.1f * WIDTH, 0.29f * HEIGHT);
		menuUI.addButton("Load", "loadButton",0.1f * WIDTH, 0.38f * HEIGHT);
		menuUI.addButton("Quit", "quitButton",0.1f * WIDTH, 0.47f * HEIGHT);
	}
	
	public void updateButtons() {
		if(Mouse.isButtonDown(0)) {
			if(menuUI.isButtonClicked("Begin"))
				StateManager.setState(State.SIM);
			
			if(menuUI.isButtonClicked("Quit")) {
				System.exit(0);
			}
			
			if(menuUI.isButtonClicked("Edit")) {
				StateManager.setState(State.MAPEDIT);
			}
			
		}
			
	}
	
	public void update() {
		DrawBlockTex(background, 0, 0, 1160, 1080);
		menuUI.draw();
		updateButtons();
	}
}
