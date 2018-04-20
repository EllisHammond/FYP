package dat;

import org.newdawn.slick.opengl.Texture;
import static employees.Artiste.*;

public class TrafficLight {
	
	private float x, y, width, height;
	private Texture texture;
	private BlockType type;
	
	public TrafficLight(float x, float y, float width, float height, BlockType type) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.type = type;
		this.texture = QuickLoad(type.textureName);
	}
	
	
}
