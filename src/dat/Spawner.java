package dat;

import java.util.ArrayList;
import static employees.SimTime.*;

public class Spawner {

	private float timeSinceLastSpawn, spawnTime;
	private Car carType;
	private ArrayList<Car> carList;

	public Spawner(float spawnTime, Car carType) {
		this.carType = carType;
		this.spawnTime = spawnTime;
		timeSinceLastSpawn = 0;
		carList = new ArrayList<Car>();
	}

	public void update() {
		timeSinceLastSpawn += Delta();
		if (timeSinceLastSpawn > spawnTime) {
			Spawn();
			timeSinceLastSpawn = 0;
		}
		
		for (Car e : carList) {
			if (e.isExists()) {
				e.update();
				e.draw();
			}
		}

	}

	private void Spawn() {
		carList.add(new Car(carType.getTexture(), carType.getStartBlock(), carType.getBlockGrid(), 30, 30,
				carType.getVelocity()));

	}
}