package dat;

import static employees.Artiste.*;
import org.newdawn.slick.opengl.Texture;

public enum TrafficLightType {
	xGreen(new Texture[] {QuickLoad("Intersection1")}),
	xYellow(new Texture[] {QuickLoad("Intersection2")}),
	xRed(new Texture[] {QuickLoad("Intersection3")});

	
	Texture[] textures;
	
	TrafficLightType(Texture[] textures) {
		this.textures = textures;
	}

}



