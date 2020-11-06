package com.gcstudios.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.gcstudios.world.Camera;
import com.gcstudios.main.Game;

public class Entity {
	public static BufferedImage LIFEPACK_EN	= Game.spritesheet.getSprite(60,17,9,16);
	public static BufferedImage SHIELD_EN	= Game.spritesheet.getSprite(78,35,9,16);
	public static BufferedImage GUN_EN	= Game.spritesheet.getSprite(70,23,9,6);
	public static BufferedImage COIN_EN	= Game.spritesheet.getSprite(60,653,8,12);
	public static BufferedImage KNIFE_EN	= Game.spritesheet.getSprite(80,22,9,8);
	public static BufferedImage ENEMY_EN	= Game.spritesheet.getSprite(60,0,9,16);
	public static BufferedImage NPCMOV1_EN	= Game.spritesheet.getSprite(60,0,9,16);
	public static BufferedImage NPCMOV2_EN	= Game.spritesheet.getSprite(60,534,9,16);
	public static BufferedImage NPCMOV3_EN	= Game.spritesheet.getSprite(60,568,9,16);
	public static BufferedImage NPCMOV4_EN	= Game.spritesheet.getSprite(60,602,9,16);
	public static BufferedImage BULLET_EN	= Game.spritesheet.getSprite(99,21,6,13);
	public static BufferedImage BIGORNA_EN	= Game.spritesheet.getSprite(70,554,10,8);
	public static BufferedImage GUN_LEFT = Game.spritesheet.getSprite(65,43,9,6);
	public static BufferedImage GUN_UP = Game.spritesheet.getSprite(102,45,2,4);
	public static BufferedImage GUN_DOWN = Game.spritesheet.getSprite(75,45,2,4);
	public static BufferedImage KNIFE_LEFT = Game.spritesheet.getSprite(92,43,9,8);
	public static BufferedImage[][] itemsPersonagem;
	public static BufferedImage MONOCULO_EN = Game.spritesheet.getSprite(44,334,1,2);
	public static BufferedImage UMBRELLA_UPRIGTH = Game.spritesheet.getSprite(73,278,11,7);
	public static BufferedImage UMBRELLA_DOWNLEFT = Game.spritesheet.getSprite(85,278,11,19);
	public static BufferedImage NPC_EN = Game.spritesheet.getSprite(0,420,9,16);
	public static BufferedImage NPC_EN_LEVEL2 = Game.spritesheet.getSprite(40,470,9,16);
	public static BufferedImage NPC_EN_LEVEL3 = Game.spritesheet.getSprite(64,225,9,16);
	public static BufferedImage NPC_EN_LEVEL4 = Game.spritesheet.getSprite(0,801,9,16);
	public static BufferedImage NPC_EN2 = Game.spritesheet.getSprite(40,420,9,16);
	public static BufferedImage NPC_EN2_LEVEL2 = Game.spritesheet.getSprite(0,146,9,16);
	public static BufferedImage NPC_EN2_LEVEL3 = Game.spritesheet.getSprite(0,636,10,16);
	public static BufferedImage NPC_EN2_LEVEL5 = Game.spritesheet.getSprite(67,726,9,16);
	public static BufferedImage NPC_EN3 = Game.spritesheet.getSprite(40,436,9,16);
	public static BufferedImage NPC_EN3_LEVEL2  = Game.spritesheet.getSprite(40,486,9,16);
	public static BufferedImage NPC_EN3_LEVEL3  = Game.spritesheet.getSprite(20,636,10,16);
	public static BufferedImage NPC_EN4 = Game.spritesheet.getSprite(40,453,9,16);
	public static BufferedImage NPC_EN4_LEVEL2 = Game.spritesheet.getSprite(40,502,9,16);
	public static BufferedImage NPC_EN4_LEVEL3 = Game.spritesheet.getSprite(0,653,10,16);
	public static BufferedImage NPC_EN5 = Game.spritesheet.getSprite(59,366,9,16);
	public static BufferedImage NPC_EN5_LEVEL2 = Game.spritesheet.getSprite(93,401,9,16);
	public static BufferedImage NPC_EN5_LEVEL3 = Game.spritesheet.getSprite(0,470,10,16);
	public static BufferedImage NPC_EN5_LEVEL4 = Game.spritesheet.getSprite(0,819,9,16);
	public static BufferedImage NPC_EN6 = Game.spritesheet.getSprite(40,401,9,16);
	public static BufferedImage NPC_EN9_LEVEL2 = Game.spritesheet.getSprite(40,518,9,16);
	public static BufferedImage NPC_EN9_LEVEL3 = Game.spritesheet.getSprite(59,401,10,16);
	public static BufferedImage NPC_EN14_LEVEL7 = Game.spritesheet.getSprite(0,1448,9,16);
	public static BufferedImage TREE_EN = Game.spritesheet.getSprite(70,383,10,16);
	public static BufferedImage BED_EN = Game.spritesheet.getSprite(60,619,10,16);
	public static BufferedImage DEATHBODY_EN = Game.spritesheet.getSprite(0,776,10,16);
	public static BufferedImage DEATHBODY2_EN = Game.spritesheet.getSprite(10,776,10,16);
	public static BufferedImage BED2_EN = Game.spritesheet.getSprite(60,635,10,16);
	public static BufferedImage TOILET_EN = Game.spritesheet.getSprite(10,653,10,16);
	public static BufferedImage TREE_EN_LEVEL2 = Game.spritesheet.getSprite(91,383,9,16);
	public static BufferedImage MURO_EN = Game.spritesheet.getSprite(80,436,9,16);
	public static BufferedImage TREE2_EN = Game.spritesheet.getSprite(80,383,10,16);
	public static BufferedImage DESK_EN = Game.spritesheet.getSprite(20,383,10,16);
	public static BufferedImage CHAIR_EN = Game.spritesheet.getSprite(50,383,10,16);
	public static BufferedImage CHAIR2_EN = Game.spritesheet.getSprite(20,437,8,16);
	public static BufferedImage CHAIR3_EN = Game.spritesheet.getSprite(20,453,8,16);
	public static BufferedImage LOCKER_EN = Game.spritesheet.getSprite(99,366,9,16);
	public static BufferedImage LOCKER2_EN = Game.spritesheet.getSprite(99,689,9,16);
	public static BufferedImage WARDROBE_EN = Game.spritesheet.getSprite(60,383,10,16);
	public static BufferedImage DOOR_EN = Game.spritesheet.getSprite(59,401,10,16);
	public static BufferedImage DESK2_EN = Game.spritesheet.getSprite(30,383,10,16);
	public static BufferedImage DESK3_EN = Game.spritesheet.getSprite(40,383,10,16);
	public static BufferedImage DESK4_EN = Game.spritesheet.getSprite(69,332,10,16);
	public static BufferedImage DESK5_EN = Game.spritesheet.getSprite(79,332,10,16);
	public static BufferedImage DESK6_EN = Game.spritesheet.getSprite(89,332,10,16);
	public static BufferedImage DESK7_EN = Game.spritesheet.getSprite(69,349,10,16);
	public static BufferedImage DESK8_EN = Game.spritesheet.getSprite(79,349,10,16);
	public static BufferedImage DESK9_EN = Game.spritesheet.getSprite(89,349,10,16);
	public static BufferedImage DESK10_EN = Game.spritesheet.getSprite(49,332,10,16);
	public static BufferedImage DESK11_EN = Game.spritesheet.getSprite(10,437,10,16);
	public static BufferedImage DESK12_EN = Game.spritesheet.getSprite(10,453,10,16);
	public static BufferedImage EXIT_EN = Game.spritesheet.getSprite(0,436,10,16);
	public static BufferedImage EXIT2_EN = Game.spritesheet.getSprite(10,436,10,16);
	public static BufferedImage EXIT3_EN = Game.spritesheet.getSprite(20,436,10,16);
	public static BufferedImage EXIT4_EN = Game.spritesheet.getSprite(30,436,10,16);
	public static BufferedImage SETA_EN = Game.spritesheet.getSprite(10,452,10,16);
	public static BufferedImage CAR1_EN = Game.spritesheet.getSprite(81,470,10,13);
	public static BufferedImage CAR2_EN = Game.spritesheet.getSprite(91,470,10,13);
	public static BufferedImage CAR3_EN = Game.spritesheet.getSprite(101,470,7,13);
	public static BufferedImage CAR4_EN = Game.spritesheet.getSprite(81,300,10,13);
	public static BufferedImage CAR5_EN = Game.spritesheet.getSprite(91,300,10,13);
	public static BufferedImage CAR6_EN = Game.spritesheet.getSprite(101,300,7,13);
	public static BufferedImage CAR7_EN = Game.spritesheet.getSprite(81,504,10,13);
	public static BufferedImage CAR8_EN = Game.spritesheet.getSprite(91,504,10,13);
	public static BufferedImage CAR9_EN = Game.spritesheet.getSprite(101,504,7,13);
	public static BufferedImage CAR10_EN = Game.spritesheet.getSprite(0,1300,10,16);
	public static BufferedImage CAR11_EN = Game.spritesheet.getSprite(10,1300,10,16);
	public static BufferedImage CAR12_EN = Game.spritesheet.getSprite(0,1316,10,16);
	public static BufferedImage CAR13_EN = Game.spritesheet.getSprite(10,1316,10,16);
	public static BufferedImage CAR14_EN = Game.spritesheet.getSprite(0,1332,10,16);
	public static BufferedImage CAR15_EN = Game.spritesheet.getSprite(10,1332,10,16);
	public static BufferedImage CAR16_EN = Game.spritesheet.getSprite(0,1391,10,16);
	public static BufferedImage CAR17_EN = Game.spritesheet.getSprite(10,1391,10,16);
	public static BufferedImage CAR18_EN = Game.spritesheet.getSprite(20,1391,10,16);
	public static BufferedImage CAR19_EN = Game.spritesheet.getSprite(30,1391,10,16);
	public static BufferedImage CAR20_EN = Game.spritesheet.getSprite(40,1391,10,16);
	public static BufferedImage CAR21_EN = Game.spritesheet.getSprite(50,1391,10,16);
	public static BufferedImage CAR22_EN = Game.spritesheet.getSprite(0,1407,10,16);
	public static BufferedImage CAR23_EN = Game.spritesheet.getSprite(10,1407,10,16);
	public static BufferedImage CAR24_EN = Game.spritesheet.getSprite(20,1407,10,16);
	public static BufferedImage CAR25_EN = Game.spritesheet.getSprite(30,1407,10,16);
	public static BufferedImage CAR26_EN = Game.spritesheet.getSprite(40,1407,10,16);
	public static BufferedImage CAR27_EN = Game.spritesheet.getSprite(50,1407,10,16);
	public static BufferedImage SPECIALTREE1_EN = Game.spritesheet.getSprite(0,509,10,16);
	public static BufferedImage SPECIALTREE2_EN = Game.spritesheet.getSprite(10,509,10,16);
	public static BufferedImage SPECIALTREE3_EN = Game.spritesheet.getSprite(20,509,10,16);
	public static BufferedImage PICTURE_EN = Game.spritesheet.getSprite(70,619,10,16);
	public static BufferedImage PICTURE2_EN = Game.spritesheet.getSprite(80,619,10,16);
	public static BufferedImage SOFA_EN = Game.spritesheet.getSprite(30,655,10,16);
	public static BufferedImage SOFA2_EN = Game.spritesheet.getSprite(40,655,10,16);
	public static BufferedImage SOFA3_EN = Game.spritesheet.getSprite(50,655,10,16);
	public static BufferedImage ARMARIO_EN = Game.spritesheet.getSprite(20,653,10,16);
	public static BufferedImage GELADEIRA_EN = Game.spritesheet.getSprite(0,670,10,16);
	public static BufferedImage TV_EN = Game.spritesheet.getSprite(10,670,10,16);
	public static BufferedImage TV2_EN = Game.spritesheet.getSprite(20,670,10,16);
	public static BufferedImage PORTAO1_EN = Game.spritesheet.getSprite(0,1264,9,16);
	public static BufferedImage PORTAO2_EN = Game.spritesheet.getSprite(11,1264,9,16);
	public static BufferedImage PORTAO3_EN = Game.spritesheet.getSprite(22,1264,9,16);
	public static BufferedImage PORTAO4_EN = Game.spritesheet.getSprite(33,1264,9,16);
	public static BufferedImage PORTAO5_EN = Game.spritesheet.getSprite(44,1264,9,16);
	public static BufferedImage PORTAO6_EN = Game.spritesheet.getSprite(55,1264,9,16);
	public static BufferedImage PNEU_EN = Game.spritesheet.getSprite(40,1283,9,16);
	public static BufferedImage ENGINE1_EN = Game.spritesheet.getSprite(50,1283,9,16);
	public static BufferedImage WALL5 = Game.spritesheet.getSprite(10,1283,10,16);
	public double x;
	protected double y;
	protected int width;
	protected int height;
	private BufferedImage sprite;
	public int maskx,masky,mwidth,mheight;
	
	public Entity(int x, int y, int width, int height, BufferedImage sprite, int tipo) {
		itemsPersonagem = new BufferedImage[Game.itemsPersonagem.maxItemsInventario][2];
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.sprite = sprite;
		
		this.maskx = 0;
		this.masky = 0;
		this.mwidth = width;
		this.mheight = height;
		
		for (int i = 0;i < Game.itemsPersonagem.maxItemsInventario;i++) {
			if (i == 0) {
				itemsPersonagem[i][0] = Game.spritesheet.getSprite(36,245,30,30);
				itemsPersonagem[i][1] = Game.spritesheet.getSprite(70,244,33,32);
			}
			if (i == 1) {
				itemsPersonagem[i][0] = Game.spritesheet.getSprite(34,281,17,29);
				itemsPersonagem[i][1] = Game.spritesheet.getSprite(0,279,20,34);
			}
			if (i == 2) {
				itemsPersonagem[i][0] = Game.spritesheet.getSprite(19,686,19,36);
				itemsPersonagem[i][1] = Game.spritesheet.getSprite(19,686,19,36);
			}
			if (i == 3) {
				itemsPersonagem[i][0] = Game.spritesheet.getSprite(0,686,19,36);
				itemsPersonagem[i][1] = Game.spritesheet.getSprite(0,686,19,36);
			}
			if (i == 4) {
				itemsPersonagem[i][0] = Game.spritesheet.getSprite(0,749,20,27);
				itemsPersonagem[i][1] = Game.spritesheet.getSprite(0,749,20,27);
			}
			if (i == 5) {
				itemsPersonagem[i][0] = Game.spritesheet.getSprite(0,722,20,27);
				itemsPersonagem[i][1] = Game.spritesheet.getSprite(0,722,20,27);
			}
			if (i == 6) { 
				itemsPersonagem[i][0] = Game.spritesheet.getSprite(0,224,25,17);
				itemsPersonagem[i][1] = Game.spritesheet.getSprite(0,241,30,20);
			}
			if (i == 7) {
				itemsPersonagem[i][0] = Game.spritesheet.getSprite(35,357,24,24);
				itemsPersonagem[i][1] = Game.spritesheet.getSprite(0,351,31,31);
			}
			
			if (i == 8) {
				itemsPersonagem[i][0] = Game.spritesheet.getSprite(38,686,19,36);
				itemsPersonagem[i][1] = Game.spritesheet.getSprite(38,686,19,36);
			}
			
			if (i == 9) {
				itemsPersonagem[i][0] = Game.spritesheet.getSprite(20,749,20,18);
				itemsPersonagem[i][1] = Game.spritesheet.getSprite(20,749,20,18);
			}
			
			if (i == 10) {
				itemsPersonagem[i][0] = Game.spritesheet.getSprite(40,749,16,15);
				itemsPersonagem[i][1] = Game.spritesheet.getSprite(40,749,16,15);
			}
			
			if (i == 11) {
				itemsPersonagem[i][0] = Game.spritesheet.getSprite(58,686,14,28);
				itemsPersonagem[i][1] = Game.spritesheet.getSprite(58,686,14,28);
			}
			
			if (i == 12) {
				itemsPersonagem[i][0] = Game.spritesheet.getSprite(21,725,42,24);
				itemsPersonagem[i][1] = Game.spritesheet.getSprite(21,725,42,24);
			}
			
			if (i == 13) {
				itemsPersonagem[i][0] = Game.spritesheet.getSprite(190, 62, 18, 17);
				itemsPersonagem[i][1] = Game.spritesheet.getSprite(190, 62, 18, 17);
			}
			
			
			
			

		}
		
		
		
	}
	
	public void setMask(int maskx,int masky,int mwidth,int mheight){
		this.maskx = maskx;
		this.masky = masky;
		this.mwidth = mwidth;
		this.mheight = mheight;
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

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}
	
	public static boolean isColidding(Entity e1,Entity e2){
		Rectangle e1Mask = new Rectangle(e1.getX() + e1.maskx,e1.getY()+e1.masky,e1.mwidth,e1.mheight);
		Rectangle e2Mask = new Rectangle(e2.getX() + e2.maskx,e2.getY()+e2.masky,e2.mwidth,e2.mheight);
		
		return e1Mask.intersects(e2Mask);
	}
	
	public static boolean isColiddingItem(Entity e1,Entity e2){
		Rectangle e1Mask = new Rectangle(e1.getX() + e1.maskx,e1.getY()+e1.masky,e1.mwidth,e1.mheight);
		Rectangle e2Mask = new Rectangle(e2.getX() + e2.maskx,e2.getY()+e2.masky,e2.mwidth,e2.mheight);
		if (e1Mask.intersects(e2Mask)) {
			return true;
		} else
			return false; 
	}

	public void render(Graphics g) {
		g.drawImage(sprite,this.getX() - Camera.x,this.getY() - Camera.y, null);
	}
	
	public void tick() {
		
	}
}
