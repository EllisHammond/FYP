package dat;

import java.awt.event.MouseEvent;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import employees.Artiste;
import employees.Artiste.*;
import employees.SimTime;

public class User {
	
	boolean mouseDown = false;
	private BlockGrid grid;
	private BlockType[] bType;
	private int index;
	
	public User(BlockGrid grid) {
		this.grid = grid;
		this.bType = new BlockType[3];
		this.bType[0] = BlockType.Ground;
		this.bType[1] = BlockType.Road;
		this.bType[2] = BlockType.Intersection;
		this.index = 0;		
	}
	
	public void SetBlock() {
		grid.setBlock((int)Math.floor(Mouse.getX() / 30),(int) Math.floor((Artiste.HEIGHT -Mouse.getY() - 1) / 30), bType[index]);
	}
	
	public void update() {
		if(Mouse.isButtonDown(0)) {
		SetBlock();
		
		}
		
		while(Keyboard.next()) {
			if(Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()) {
				IterateIndex();
			}
			
			if(Keyboard.getEventKey() == Keyboard.KEY_UP && Keyboard.getEventKeyState() && SimTime.Multiplier() < 3) {
				SimTime.ChangeMultiplier(0.2f);
			}
			
			if(Keyboard.getEventKey() == Keyboard.KEY_DOWN && Keyboard.getEventKeyState() && SimTime.Multiplier() >= 0.2) {
				SimTime.ChangeMultiplier(-0.2f);
			}
		}		
	}

	private void IterateIndex() {
		index++;
		if(index > bType.length - 1) {
			index = 0;
		}
	}
}
