package com.gcstudios.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;

import com.gcstudios.world.Camera;

public class Rain{

	private double spd = 4;
	public double x;
	protected double y;
	protected int width;
	protected int height;
	
	
	public Rain(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	
	}
	public void setX(int newX) {
		this.x = newX;
	}
	
	public void setY(int newY) {
		this.y = newY;
	}
	
	public int getX() {
		return (int)this.x;
	}
	
	public int getY() {
		return (int)this.y;
	}
	
	public void tick() {
		y+=spd;
		if (y >= Camera.y + Game.HEIGHT) {
			Game.rain.remove(this);
			return;
		}
		

	}
	
	public void render(Graphics g){
		g.setColor(Color.CYAN);
		g.fillOval(this.getX() - Camera.x,this.getY() - Camera.y,width,height);
	}
	
}
