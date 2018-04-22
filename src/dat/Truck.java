package dat;

import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;

public class Truck implements Object  {
	private int width, height, currentQuadrantPoint;
	private float velocity, x, y;
	private Texture texture;
	private Block startBlock;
	private boolean first, exists = true;
	private BlockGrid grid;
	
	public Truck(Texture texture, Block startBlock, BlockGrid grid, int width, int height, float velocity) {
		this.x = startBlock.getX();
		this.y = startBlock.getY();
		this.width = width;
		this.height = height;
		this.velocity = velocity;
		this.grid = grid;
		this.first = true;
		
	}
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setX(float x) {
		this.x = x;
		
	}

	public void setY(float y) {
	this.y = y;
		
	}

	public void setWidth(int width) {
		// TODO Auto-generated method stub
		
	}

	public void setHeight(int height) {
		// TODO Auto-generated method stub
		
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}

	public void draw() {
		// TODO Auto-generated method stub
		
	}

}
