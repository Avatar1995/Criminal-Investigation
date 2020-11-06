package com.gcstudios.main;



import java.awt.Graphics;
import java.awt.Graphics2D;

public class Load {	
	public int time = 0;
	public int maxTime= 290;
	public boolean fimCarregamento,chamaCarregamento = false;
	
	public Load() {
		// TODO Auto-generated constructor stub		
	}
	
	public void tick() {
		if (chamaCarregamento) {
		Game.gameState = "TRAVADO";
		this.time++;
		if (this.time >= this.maxTime) {
			fimCarregamento = true;
			chamaCarregamento = false;
			Game.gameState = "NORMAL";
			this.time = 0;
			Game.controleTela = true;
		}
		}

	}
	
	public void render(Graphics g) {

	}
	
}