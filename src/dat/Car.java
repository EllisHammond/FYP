package dat;

import static employees.Artiste.DrawBlockTex;
import static employees.Artiste.DrawRotateCar;
import static employees.SimTime.Delta;
import static employees.Artiste.CollisionDetection;
import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;

public class Car implements Object {
	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	private int width, height, currentQuadrantPoint;
	private float velocity, x, y;
	private Texture texture;
	private Block startBlock;
	private boolean first, exists = true;
	private BlockGrid grid;
	

	private ArrayList<QuadrantPoint> corner;
	private int[] directions;
	private boolean collides;
	private ID id;

	public Car(Texture texture, Block startBlock, BlockGrid grid, int width, int height, float velocity, ID id) {
		this.texture = texture;
		this.id = id;
		this.startBlock = startBlock;
		this.x = startBlock.getX();
		this.y = startBlock.getY();
		this.width = width;
		this.height = height;
		this.velocity = velocity;
		this.grid = grid;
		this.first = true;
		this.collides = false;
		this.corner = new ArrayList<QuadrantPoint>();
		this.directions = new int[2];
		// X direction
		this.directions[0] = 0;
		// Y direction
		this.directions[1] = 0;

		this.directions = chooseDirection(startBlock);
		this.currentQuadrantPoint = 0;
		populateQuadrantPointList();

	}

	public void update() {
		// Check if it's the first time this class is updated, if so do nothing
		if (first)
			first = false;
		else {
			if (checkpointReached()) {
				// Check if there are more corner before moving on
				if (currentQuadrantPoint + 1 == corner.size()) {
					deleteCar();

				} else
					currentQuadrantPoint++;		
 			}

			else {
				
				// If not at a checkpoint, continue in current direction
				x += Delta() * corner.get(currentQuadrantPoint).getxDirection() * velocity;
				y += Delta() * corner.get(currentQuadrantPoint).getyDirection() * velocity;

			}

		}
	}

	// Run when last checkpoint is reached by car

	
	private void deleteCar() {
		exists = false;
	}

	private boolean checkpointReached() {
		boolean reached = false;
		Block t = corner.get(currentQuadrantPoint).getBlock();
		// Check if position reached tile within variance of 3 (arbitrary)
		if (x > t.getX() - 2 && x < t.getX() + 2 && y > t.getY() - 2 && y < t.getY() + 2) {

			reached = true;
			x = t.getX();
			y = t.getY();
		}
		return reached;
	}
	
	
	
	private void populateQuadrantPointList() {
		// Add first checkpoint manually based on startBlock
		corner.add(findNextC(startBlock, directions = chooseDirection(startBlock)));
		int counter = 0;
		boolean cont = true;
		while (cont) {
			int[] currentD = chooseDirection(corner.get(counter).getBlock());
			// Check if a next direction/checkpoint exists, end after 20 corner (arbitrary)
			if (currentD[0] == 2) {
				cont = false;
			} else {
				corner.add(findNextC(corner.get(counter).getBlock(),
						directions = chooseDirection(corner.get(counter).getBlock())));
			}
			counter++;
		}
	}

	private QuadrantPoint findNextC(Block s, int[] dir) {
		Block next = null;
		QuadrantPoint c = null;

		// Boolean to decide if next checkpoint is found
		boolean found = false;

		// Integer to increment each loop
		int counter = 1;

		while (!found) {

			if (s.getXPos() + dir[0] * counter == grid.getBlocksWide()
					|| s.getYPos() + dir[1] * counter == grid.getBlocksHigh() || s.getType() != grid
							.getBlock(s.getXPos() + dir[0] * counter, s.getYPos() + dir[1] * counter).getType()) {

				found = true;
				// Move counter back 1 to find tile before new tiletype
				counter -= 1;
				next = grid.getBlock(s.getXPos() + dir[0] * counter, s.getYPos() + dir[1] * counter);
			}

			counter++;
		}

		c = new QuadrantPoint(next, dir[0], dir[1]);
		return c;
	}

	private int[] chooseDirection(Block s) {
		// Creates a logical impossibility just in case
		int[] dir = new int[2];
		// This states the position of every block that is 1 block away in 4 directions
		Block u = grid.getBlock(s.getXPos(), s.getYPos() - 1);
		Block r = grid.getBlock(s.getXPos() + 1, s.getYPos());
		Block d = grid.getBlock(s.getXPos(), s.getYPos() + 1);
		Block l = grid.getBlock(s.getXPos() - 1, s.getYPos());

		// Check if current Block type matches the Block type in all directions,a nd if
		// not travelling in this direction then turn if ther block is different
		if (s.getType() == u.getType() && directions[1] != 1) {
			dir[0] = 0;
			dir[1] = -1;
		} else if (s.getType() == r.getType() && directions[0] != -1) {
			dir[0] = 1;
			dir[1] = 0;
		} else if (s.getType() == d.getType() && directions[1] != -1) {
			dir[0] = 0;
			dir[1] = 1;
		} else if (s.getType() == l.getType() && directions[0] != 1) {
			dir[0] = -1;
			dir[1] = 0;
		} else {
			dir[0] = 2;
			dir[1] = 2;
		}
		return dir;
	}

	public void draw() {

		// Car texture

		if (Delta() * corner.get(currentQuadrantPoint).getyDirection() * velocity != 0) {
			DrawRotateCar(texture, x, y, width, height, 90);
		} else if (Delta() * corner.get(currentQuadrantPoint).getxDirection() * velocity != 0) {
			DrawBlockTex(texture, x, y, width, height);
		}
	}
	
	

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public float getVelocity() {
		return velocity;
	}

	public void setVelocity(float velocity) {
		this.velocity = velocity;
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

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public Block getStartBlock() {
		return startBlock;
	}

	public void setStartBlock(Block startBlock) {
		this.startBlock = startBlock;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	public BlockGrid getBlockGrid() {
		return grid;
	}

	public boolean isExists() {
		return exists;
	}

}
