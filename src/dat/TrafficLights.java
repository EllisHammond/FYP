package dat;

import org.newdawn.slick.opengl.Texture;

import static employees.Artiste.*;

public abstract class TrafficLights implements Object {

	private int width, height;
	private float  x, y;
	private Texture texture;
	
	public TrafficLights(Texture texture, Block startBlock) {
		this.x = startBlock.getX();
		this.y = startBlock.getY();
		this.texture = texture;;
		this.width = (int) startBlock.getWidth();
		this.height =(int) startBlock.getHeight();
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
		this.width = width;
		
	}


	public void setHeight(int height) {
		this.height = height;
		
	}


	public void update() {
		
		
	}


	public void draw() {
		DrawBlockTex(texture, x , y, width, height);
		
	}
	


}
