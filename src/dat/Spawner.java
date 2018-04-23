package dat;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import org.newdawn.slick.opengl.Texture;

import dat.Car;

import static employees.Artiste.QuickLoad;
import static employees.SimTime.*;
import static employees.Artiste.CollisionDetection;

public class Spawner {
	Random a = new Random();
	int Low = 50;
	int High = 80;
	int Result = a.nextInt(High - Low) + Low;

	private float timeSinceLastSpawn, spawnTime;
	private Car carType;
	private CopyOnWriteArrayList<Car> carList;
	private boolean spawnMore;
	private int vehiclesSpawned;

	public Spawner(float spawnTime, Car carType) {
		this.carType = carType;
		this.spawnTime = spawnTime;
		timeSinceLastSpawn = 0;
		carList = new CopyOnWriteArrayList<Car>();
		this.spawnMore = false;
		this.vehiclesSpawned = 0;
	}

	public void update() {
		boolean noVehicles = true;
		timeSinceLastSpawn += Delta();
		if (timeSinceLastSpawn > spawnTime) {
			Spawn();
			timeSinceLastSpawn = 0;
		}

		for (Car e : carList) {
			if (e.isExists()) {
				noVehicles = false;
				e.update();
				e.draw();
			} else
				carList.remove(e);
		}
		if (noVehicles) {
			spawnMore = true;
		}

	}

	private void Spawn() {
		carList.add(new Car(randomColor(), carType.getStartBlock(), carType.getBlockGrid(), BlockGrid.BLOCK_SIZE,
				BlockGrid.BLOCK_SIZE, a.nextInt(High - Low) + Low, carType.getId()));
		
		vehiclesSpawned++;
		System.out.println(vehiclesSpawned);
	}

	public boolean needMoreVehicles() {
		return spawnMore;
	}

	public CopyOnWriteArrayList<Car> getCarList() {
		return carList;
	}
	
	public Texture randomColor() {
		int colorIndicator = (int) (Math.random() * (4 - 0) + 1);
		if(colorIndicator == 1) {
			return QuickLoad("cara");
		} else if(colorIndicator == 2) {
			return QuickLoad("carb");
		} else if(colorIndicator == 3) {
			return QuickLoad("carc"); 
		} else if(colorIndicator == 4){
			return QuickLoad("carx");
		}
		return QuickLoad("carx");
		
		
	}
	
	

}
