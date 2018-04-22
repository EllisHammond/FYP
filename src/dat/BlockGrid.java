package dat;


public class BlockGrid {

	public Block[][] map;
	private int blocksWidth, blocksHeight;
	
	public static final int BLOCK_SIZE = 30;
	
	public BlockGrid() {
		this.blocksWidth = BLOCK_SIZE;
		this.blocksHeight = BLOCK_SIZE;
		map = new Block[blocksWidth][blocksHeight];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = new Block(i * BLOCK_SIZE, j * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE, BlockType.Ground);
			}
		}
	}
	
	public BlockGrid(int[][] newMap) {
		this.blocksWidth = newMap[0].length;
		this.blocksHeight = newMap.length;
		map = new Block[blocksWidth][blocksHeight];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				switch (newMap[j][i]) {
				case 0:
					map[i][j] = new Block(i * BLOCK_SIZE, j * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE, BlockType.Ground);
					break;
				case 1:
					map[i][j] = new Block(i * BLOCK_SIZE, j * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE, BlockType.Road);
					break;
				
				case 2:
					map[i][j] = new Block(i * BLOCK_SIZE, j * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE, BlockType.Building);
					break;	
				case 3:
					map[i][j] = new Block(i * BLOCK_SIZE, j * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE, BlockType.Building2);
					break;	
				}
			}
		}
	}
	
	public void setBlock(int xCoord, int yCoord, BlockType type) {
		map[xCoord][yCoord] = new Block(xCoord * BLOCK_SIZE, yCoord * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE, type);
	}
	
	public Block getBlock(int xPos, int yPos) {
		if (xPos < blocksWidth && yPos < blocksHeight && xPos > -1 && yPos > -1)
			return map[xPos][yPos];
		else
			return new Block(0, 0, 0, 0, BlockType.NULL);
	}

	
	public void draw() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j].Draw();
			}
		}
	}

	public int getBlocksWide() {
		return blocksWidth;
	}

	public void setBlocksWide(int blocksWidth) {
		this.blocksWidth = blocksWidth;
	}

	public int getBlocksHigh() {
		return blocksHeight;
	}

	public void setBlocksHigh(int blocksHeight) {
		this.blocksHeight = blocksHeight;
	}
	
	
}