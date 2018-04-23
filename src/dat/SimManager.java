package dat;

import static employees.Artiste.QuickLoad;

public class SimManager {
	
	public static final int BLOCK_SIZE = 30;
	private BlockGrid grid;
	private User user;
	private Spawner spawn;
	private TrafficLight1 tL1;
	private TrafficLight2 tL2;
	private TrafficLight3 tL3;
	int tCounter = 0;
	//Temp vars
	
	public SimManager(int[][] map) {
	
		grid = new BlockGrid(map);
		user = new User(grid);
		spawn = new Spawner(3, new Car(QuickLoad("carx"), grid.getBlock(0, 28), grid, BLOCK_SIZE/4, BLOCK_SIZE/4, 60, ID.Car));
		
		tL1 = new TrafficLight1(QuickLoad("Intersection1"), grid.getBlock(4, 18));
		tL2 = new TrafficLight2(QuickLoad("Intersection2"),  grid.getBlock(4, 18));
		tL3 = new TrafficLight3(QuickLoad("Intersection3"),  grid.getBlock(4, 18));
		
		
	}
	
	public void update() {
		//Order is important because you want the vehicles to be travelling above the road	
		tCounter++;
		grid.draw();
		spawn.update();
		if(tCounter < 70) {
		tL1.draw();
		}else if(tCounter < 140) {
		tL2.draw(); 
		}else if(tCounter < 210) {
		tL3.draw();		
		} else if(tCounter < 280) {
		tL2.draw();
		} else if(tCounter < 350) {
			tCounter = 0;
		}
		user.update();
		
		
		
	}
}
