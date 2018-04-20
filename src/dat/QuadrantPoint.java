package dat;

public class QuadrantPoint {
	
    
    private Block block;
    private int xDirection, yDirection;
   
    public QuadrantPoint(Block block, int xDirection, int yDirection) {
            this.block = block;
            this.xDirection = xDirection;
            this.yDirection = yDirection;
    }

    public Block getBlock() {
            return block;
    }

    public int getxDirection() {
            return xDirection;
    }

    public int getyDirection() {
            return yDirection;
    }
   
   
}

