package dat;

import static employees.Artiste.QuickLoad;

public class SimManager {
	
	private BlockGrid grid;
	private User user;
	private Spawner spawn;
	
	//Temp vars
	
	public SimManager(int[][] map) {
		grid = new BlockGrid(map);
		user = new User(grid);
		spawn = new Spawner(2, new Car(QuickLoad("carx"), grid.getBlock(2, 28), grid, 30, 30, 50));
	
		
	}
	
	public void update() {
		//Order is important here for spawning
		grid.draw();
		
		user.update();
		spawn.update();
		
		
	}
}
