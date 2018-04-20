package dat;


import org.lwjgl.LWJGLException; 
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

import employees.SimTime;

import static org.lwjgl.opengl.GL11.*; 
import static employees.Artiste.*; 

public class Simulation 
{ 
    public Simulation() {
        
        BeginSim();
       
        int[][] map = {
				{0,	0, 0, 0, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0,	0, 0, 0, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0,	0, 0, 0, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0,	0, 0, 0, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0,	0, 0, 0, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0,	1, 1, 1, 1, 1, 1, 1, 1,	1, 0, 0, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0,	1, 0, 0, 0, 0, 0, 0, 0,	1, 0, 0, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0,	1, 0, 0, 0, 0, 0, 0, 0,	1, 0, 0, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0,	1, 0, 0, 0, 0, 0, 0, 0,	1, 0, 0, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0,	1, 0, 0, 0, 0, 0, 0, 0,	1, 0, 0, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0,	1, 0, 0, 0, 0, 0, 0, 0,	1, 0, 0, 4, 3, 4, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0,	1, 0, 0, 0, 0, 0, 0, 0,	1, 1, 1, 1, 1, 1, 1, 1,	1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
				{0,	1, 0, 0, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 1, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
				{0,	1, 0, 0, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 1, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
				{0,	1, 0, 0, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 1, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
				{0,	1, 0, 0, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 1, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
				{0,	1, 0, 0, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 1, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
				{0,	1, 0, 0, 0, 0, 0, 0, 0,	0, 0, 3, 3, 3, 1, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
				{1,	1, 1, 1, 1, 1, 1, 1, 1,	1, 1, 1, 1, 1, 1, 1, 1,	1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
				{0,	0, 0, 0, 1, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0,	0, 0, 0, 1, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0,	0, 1, 1, 1, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0,	0, 1, 4, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0,	0, 1, 1, 1, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0,	0, 0, 0, 1, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0,	0, 0, 0, 1, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0,	0, 0, 0, 1, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0,	0, 4, 3, 1, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{1,	1, 1, 1, 1, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0,	0, 0, 0, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0} 
        };
       
       SimManager manager = new SimManager(map);
       
        while(!Display.isCloseRequested()) {
                SimTime.update();
               
                manager.update();
                Display.update();
                Display.sync(60);
        }
       
        Display.destroy();
}

public static void main(String[] args) {
        new Simulation();
}

}