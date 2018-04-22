package dat;

public enum BlockType {
		
	Ground("GroundBlock", false), Road("RoadBlock", true), NULL("RoadBlock", false), Building("Building", false), Building2("Building2", false);
	
	String textureName;
	boolean buildable;
	BlockType(String textureName, boolean buildable) {
		this.textureName = textureName;
		}
	}
