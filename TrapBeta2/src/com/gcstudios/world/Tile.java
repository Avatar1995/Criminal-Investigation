package com.gcstudios.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;

public class Tile {
	
	public static BufferedImage TILE_FLOOR = Game.spritesheet.getSprite(0,35,10,16);
	public static BufferedImage TILE_FLOOR2 = Game.spritesheet.getSprite(0,383,10,16);
	public static BufferedImage TILE_FLOOR3 = Game.spritesheet.getSprite(10,383,10,16);
	public static BufferedImage TILE_FLOOR4 = Game.spritesheet.getSprite(20,401,10,16);
	public static BufferedImage TILE_FLOOR5 = Game.spritesheet.getSprite(80,420,10,16);
	public static BufferedImage TILE_FLOOR6 = Game.spritesheet.getSprite(90,420,10,16);
	public static BufferedImage TILE_FLOOR7 = Game.spritesheet.getSprite(30,401,10,16);
	public static BufferedImage TILE_FLOOR8 = Game.spritesheet.getSprite(79,401,10,16);
	public static BufferedImage TILE_FLOOR9 = Game.spritesheet.getSprite(70,585,10,16);
	public static BufferedImage TILE_FLOOR10 = Game.spritesheet.getSprite(80,585,10,16);
	public static BufferedImage TILE_FLOOR11 = Game.spritesheet.getSprite(90,585,10,16);
	public static BufferedImage TILE_FLOOR12 = Game.spritesheet.getSprite(60,551,10,16);
	public static BufferedImage TILE_FLOOR13 = Game.spritesheet.getSprite(0,1283,10,16);
	public static BufferedImage TILE_FLOOR14 = Game.spritesheet.getSprite(30,1283,10,16);
	public static BufferedImage TILE_WALL2 = Game.spritesheet.getSprite(91,383,10,16);
	public static BufferedImage TILE_WALL3 = Game.spritesheet.getSprite(60,585,10,16);
	public static BufferedImage TILE_WALL4 = Game.spritesheet.getSprite(40,636,10,16);
	public static BufferedImage TILE_WALL5 = Game.spritesheet.getSprite(10,1283,10,16);
	public static BufferedImage TILE_WALL6 = Game.spritesheet.getSprite(20,1283,10,16);
	public static BufferedImage TILE_WALL = Game.spritesheet.getSprite(10,35,10,16);
	public static BufferedImage TILE_WINDOW = Game.spritesheet.getSprite(0,437,10,16);
	public static BufferedImage TILE_HOUSE= Game.spritesheet.getSprite(91,436,10,16); 
	public static BufferedImage TILE_DOOR= Game.spritesheet.getSprite(68,366,10,16);
	public static BufferedImage TILE_DOOR2= Game.spritesheet.getSprite(78,366,10,16);
	public static BufferedImage TILE_WALLEXIT = Game.spritesheet.getSprite(16,314,10,16);
	public static BufferedImage TILE_WALLEXIT2 = Game.spritesheet.getSprite(69,366,10,16);
	public static BufferedImage TILE_LETTER_M = Game.spritesheet.getSprite(0,401,10,16);
	public static BufferedImage TILE_LETTER_F = Game.spritesheet.getSprite(10,401,10,16);
	public static BufferedImage TILE_EMPTY = Game.spritesheet.getSprite(101,0,8,16);
	public static BufferedImage POCA_EN = Game.spritesheet.getSprite(93,483,10,16);
	public static BufferedImage TILE_GLASS = Game.spritesheet.getSprite(110,108,10,16);
	public static BufferedImage TILE_GLASS2 = Game.spritesheet.getSprite(121,108,10,16);
	public static BufferedImage TILE_GLASS3 = Game.spritesheet.getSprite(132,108,10,16);

	private BufferedImage sprite;
	private int x,y;
	
	public Tile(int x,int y,BufferedImage sprite){
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}
	
	public void render(Graphics g){
		g.drawImage(sprite, x - Camera.x, y - Camera.y, null);
	}

}
