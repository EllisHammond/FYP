package dat;

import static employees.Artiste.DrawBlockTex;
import static employees.Artiste.HEIGHT;
import static employees.Artiste.QuickLoad;

import java.util.ArrayList;

import org.lwjgl.input.Mouse;

public class UserInterface {

	private ArrayList<Button> buttonList;
	public static final int STATE_IDLE = 0;
	public static final int STATE_HOVER = 0;

	public UserInterface() {
		buttonList = new ArrayList<Button>();

	}

	public void addButton(String id, String textureName, float x, float y) {
		buttonList.add(new Button(id, QuickLoad(textureName), x, y));
	}

	// Allows us to draw all the buttons in the list
	public void draw() {
		for (Button b : buttonList) {
			DrawBlockTex(b.getTexture(), b.getX(), b.getY(), b.getWidth(), b.getHeight());
		}

	}

	// This method looks really complex but, all it really is, is saying that if the
	// mouse is over this image, then true, else it is false
	public boolean isButtonClicked(String buttonId) {
		Button b = getButton(buttonId);
		float mouseY = HEIGHT - Mouse.getY() - 1;
		if (Mouse.getX() > b.getX() && Mouse.getX() < b.getX() + b.getWidth() && mouseY > b.getY()
				&& mouseY < b.getY() + b.getHeight()) {
			return true;
		}
		return false;
	}

	

	// Iterates through the buttonList to match the buttonId with the button
	private Button getButton(String buttonId) {
		for (Button b : buttonList) {
			if (b.getId().equals(buttonId)) {
				return b;
			}
		}
		return null;
	}
}
