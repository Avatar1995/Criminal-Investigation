package com.gcstudios.world;

import com.gcstudios.main.Game;

public class Camera {

	public static int x;
	public static int y;
	
	public static void definirCameraInicio() {
		if (Game.CUR_LEVEL == 1) {
			x = 0;
			y = 0;
		}
		
		if (Game.CUR_LEVEL == 2) {
			x = 500;
			y = 900;
		}
		
		if (Game.CUR_LEVEL == 3) {
			x = 30;
			y = 250;
		}
		
		if (Game.CUR_LEVEL == 4) {
			x = 60;
			y = 0;
		}
		
		if (Game.CUR_LEVEL == 5) {
			x = 0;
			y = 970;
		}
		
		if (Game.CUR_LEVEL == 6) {
			x = 0;
			y = 0;
		}
		
		
		if (Game.CUR_LEVEL == 7) {
			x = 0;
			y = 0;
		}
	}
	
	public static int clamp(int Atual,int Min,int Max){
		if(Atual < Min){
			Atual = Min;
		}
		
		if(Atual > Max) {
			Atual = Max;
		}
		
		return Atual;
	}
	
}
