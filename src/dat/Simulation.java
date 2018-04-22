package dat;



import org.lwjgl.opengl.Display;


import employees.SimTime;
import employees.StateManager;


import static employees.Artiste.*; 

public class Simulation 
{ 
    public Simulation() {
        
        BeginSim();
       
        
       
     //  SimManager manager = new SimManager(map);
       
        while(!Display.isCloseRequested()) {
                SimTime.update();
                StateManager.update();
          
                Display.update();
                Display.sync(60);
        }
       
        Display.destroy();
}

public static void main(String[] args) {
        new Simulation();
}

}