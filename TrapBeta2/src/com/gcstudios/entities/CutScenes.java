package com.gcstudios.entities;



import java.awt.Graphics;

import com.gcstudios.main.Game;

public class CutScenes {
	public int level;
	public int numero = -1;
	public boolean SegundaCutScene = false;
	public boolean fraseTerminada= false;
	public boolean cutSceneTerminada = false;
	
	public CutScenes() {
		// TODO Auto-generated constructor stub		
	}
	
	public void tick() {		
		if (((level == 1) || (level == 2)) && (!fraseTerminada)) {
			Game.phrases.tick();
		} 
	}
	
	public void render(Graphics g) {	
		if (((level == 1) || (level == 2)) && (!fraseTerminada)) {
			Game.phrases.render(g);
		} 
	}

}
