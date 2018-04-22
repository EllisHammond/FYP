package dat;


import org.newdawn.slick.opengl.Texture;
import static employees.Artiste.*;
public enum SignalType {
	
	
	Intersection1(new Texture[] {QuickLoad("Intersection1")}),
	Intersection2(new Texture[] {QuickLoad("Intersection2")}),
	Intersection3(new Texture[] {QuickLoad("Intersection3")});
	
	Texture[] textures;
	
	SignalType(Texture[] textures) {
		this.textures = textures;
}
}
