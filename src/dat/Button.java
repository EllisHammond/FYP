package dat;

import org.newdawn.slick.opengl.Texture;

public class Button {
	
	private String id;
	private Texture texture;
	private float x, y, height, width;
	
	public Button(String id, Texture texture,float x,float y, float width,float height) {
	this.id = id;
	this.texture =texture;
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
	
	}
	
	public Button(String id, Texture texture, float x, float y) {
		this.id = id;
		this.texture =texture;
		this.x = x;
		this.y = y;
		//Gets the texture and sets it as the width, so there is tweaking needed
		this.width = texture.getImageWidth();
		this.height = texture.getImageHeight();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
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

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}
	
	
	
	
}
