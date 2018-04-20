package dat;

import org.newdawn.slick.opengl.Texture;

import dat.QuadrantPoint;
import dat.User;
import dat.Block;
import dat.BlockGrid;

import static employees.Artiste.*;
import static employees.SimTime.*;


import java.util.ArrayList;
public class Car {
	private int width, height, currentQuadrantPoint;
	private float velocity, x, y;
	private Texture texture;
	private Block startBlock;
	private boolean first, exists = true;
	private BlockGrid grid;
	
	private ArrayList<QuadrantPoint> checkpoints;
	private int[] directions;

	public Car(Texture texture, Block startBlock, BlockGrid grid, int width,
			int height, float velocity) {
		this.texture = texture;
	
		this.startBlock = startBlock;
		this.x = startBlock.getX();
		this.y = startBlock.getY();
		this.width = width;
		this.height = height;
		this.velocity = velocity;
		this.grid = grid;
		this.first = true;
		this.checkpoints = new ArrayList<QuadrantPoint>();
		this.directions = new int[2];
		//X direction
		this.directions[0] = 0;
		//Y direction
		this.directions[1] = 0;
		this.directions = findNextD(startBlock);
		this.currentQuadrantPoint = 0;
		populateQuadrantPointList();
	}

	public void update() {
		//Check if it's the first time this class is updated, if so do nothing
		if (first)
			first = false;
		else {
			if (checkpointReached()) {
				//Check if there are more checkpoints before moving on
				if(currentQuadrantPoint + 1 == checkpoints.size()) {
					DeleteCar();
				} else				
				currentQuadrantPoint++;
			}else {
		
				//If not at a checkpoint, continue in current direction
				x += Delta() * checkpoints.get(currentQuadrantPoint).getxDirection() * velocity;
				y += Delta() * checkpoints.get(currentQuadrantPoint).getyDirection() * velocity;
			}
		}
	}
	
	//Run when last checkpoint is reached by car

	private void DeleteCar() {
		exists = false;
	}
	private boolean checkpointReached() {
		boolean reached = false;
		Block t = checkpoints.get(currentQuadrantPoint).getBlock();
		//Check if position reached tile within variance of 3 (arbitrary)
		if (x > t.getX() - 3 && 
				x < t.getX() + 3 &&
				y > t.getY() - 3 &&
				y < t.getY() + 3) {
			
			reached = true;
			x = t.getX();
			y = t.getY();
		}
		return reached;
	}
	
	private void populateQuadrantPointList() {
		//Add first checkpoint manually based on startBlock
		checkpoints.add(findNextC(startBlock, directions = findNextD(startBlock)));
		int counter = 0;
		boolean cont = true;
		while (cont) {
			int[] currentD = findNextD(checkpoints.get(counter).getBlock());
			//Check if a next direction/checkpoint exists, end after 20 checkpoints (arbitrary)
			if (currentD[0] == 2 || counter == 10000) {
				cont = false;
			} else {
				checkpoints.add(findNextC(checkpoints.get(counter).getBlock(), 
						directions = findNextD(checkpoints.get(counter).getBlock())));
			}
			counter++;
		}
	}
	
	private QuadrantPoint findNextC(Block s, int[] dir) {
		Block next = null;
		QuadrantPoint c = null;
		
		//Boolean to decide if next checkpoint is found
		boolean found = false;
		
		//Integer to increment each loop
		int counter = 1;
		
		while (!found) {
			
			if (s.getXPos() + dir[0] * counter ==  grid.getBlocksWide() ||
					s.getYPos() + dir[1] * counter == grid.getBlocksHigh() ||
					s.getType() != grid.getBlock(s.getXPos() + dir[0] * counter, 
							s.getYPos() + dir[1] * counter).getType()) {
				
				found = true;
				//Move counter back 1 to find tile before new tiletype
				counter -= 1;
				next = grid.getBlock(s.getXPos() + dir[0] * counter, 
						s.getYPos() + dir[1] * counter);
			}
			
			counter++;
		}
		
		c = new QuadrantPoint(next, dir[0], dir[1]);
		return c;
	}
	
	private int[] findNextD(Block s) {
		int[] dir = new int[2];
		Block u = grid.getBlock(s.getXPos(), s.getYPos() - 1);
		Block r = grid.getBlock(s.getXPos() + 1, s.getYPos());
		Block d = grid.getBlock(s.getXPos(), s.getYPos() + 1);
		Block l = grid.getBlock(s.getXPos() - 1, s.getYPos());
		
		//Check if current inhabited tiletype matches tiletype above, right, down or left
		if (s.getType() == u.getType() && directions[1] != 1) {
			dir[0] = 0;
			dir[1] = -1;
		} else if (s.getType() == r.getType() && directions[0] != -1) {
			dir[0] = 1;
			dir[1] = 0;
		} else if (s.getType() == d.getType() && directions[1] != -1) {
			dir[0] = 0;
			dir[1] = 1;
		} else if (s.getType() == l.getType() && directions[0] != 1) {
			dir[0] = -1;
			dir[1] = 0;
		} else {
			dir[0] = 2;
			dir[1] = 2;
		}
		return dir;
	}
	


	public void draw() {

		//Car texture
		if(Delta() * checkpoints.get(currentQuadrantPoint).getyDirection() * velocity != 0) {
		DrawRotateCar(texture, x, y, width, height, 90);
		}
		else if( Delta() * checkpoints.get(currentQuadrantPoint).getxDirection() * velocity != 0) {
		DrawBlockTex(texture, x, y, width, height);
		System.out.println("Turn");
		}
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public float getVelocity() {
		return velocity;
	}

	public void setVelocity(float velocity) {
		this.velocity = velocity;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public Block getStartBlock() {
		return startBlock;
	}

	public void setStartBlock(Block startBlock) {
		this.startBlock = startBlock;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}
	
	public BlockGrid getBlockGrid() {
		return grid;
	}
	
	public boolean isExists() {
		return exists;
	}
	
	
}
