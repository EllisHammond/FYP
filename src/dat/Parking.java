package dat;

import org.newdawn.slick.opengl.Texture;

public class Parking {
	
	private Texture texture;
	private float x, y;
	private boolean arrived = false;
	private Car carSpace;
	private float distanceX, distanceY;
	public Parking(Texture texture,float x, float y, boolean arrived, Car carSpace ) {
		this.texture = texture;
		this.x = x;
		this.y = y;
		this.arrived = arrived;
		this.carSpace = carSpace;
	}
	
	private void DistanceFrom() {
		distanceX = (float) Math.sqrt((carSpace.getX()-x)*(carSpace.getX()-x));
		distanceY = (float) Math.sqrt((carSpace.getY()-y)*(carSpace.getY()-y));
		float totalDistance = distanceX + distanceY;
		float movementPercentageX = distanceX / totalDistance;
		float movementPercentageY = distanceY / totalDistance;
	}
	
	public void draw() {
	
	}
}
