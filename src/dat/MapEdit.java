package dat;

import static employees.Cartographer.loadMap;
import static employees.Cartographer.saveMap;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import employees.Artiste;

public class MapEdit {

	private BlockGrid grid;
	private BlockType[] bType;
	
	private int index;

	public MapEdit() {
		this.grid = loadMap("Map1");
		this.index = 0;
		this.bType = new BlockType[3];
		this.bType[0] = BlockType.Ground;
		this.bType[1] = BlockType.Road;
	}

	public void update() {
		grid.draw();

		if (Mouse.isButtonDown(0)) {
			SetBlock();

		}

		while (Keyboard.next()) {
			if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()) {
				IterateIndex();
			}
			
			if(Keyboard.getEventKey() == Keyboard.KEY_S && Keyboard.getEventKeyState()) {
				saveMap("Map1", grid);
			}

		}
	}

	

	public void SetBlock() {
		grid.setBlock((int) Math.floor(Mouse.getX() / 30), (int) Math.floor((Artiste.HEIGHT - Mouse.getY() - 1) / 30),
				bType[index]);
	}
	
	private void IterateIndex() {
		index++;
		if(index > bType.length - 1) {
			index = 0;
		}
	}

}
