package com.gcstudios.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.gcstudios.world.Camera;
import com.gcstudios.main.Game;

public class NpcMovimento extends Entity {
	public int speed = 1;
	private int frames = 0, maxFrames = 4, indexVert=0, maxIndexVert =2, indexHor=0, maxIndexHor =3;
	private boolean movedHor,movedVert = false;
	public int right_dir = 0, left_dir = 1, up_dir = 2, down_dir= 3;
	public int dir = 0;
	private BufferedImage[] rightPlayer;
	private BufferedImage[] leftPlayer;
	private BufferedImage[] downPlayer;
	private BufferedImage[] upPlayer;
	private int tipo;
	public int time, time2, time3, time4 = 0;
	public int maxTime= 200;
	private boolean controle, controle2 = false;
	private int posicaox,posicaoy;
	private boolean staticRight,staticLeft, staticUp, staticDown = false;

	public NpcMovimento(int x, int y, int width, int height, BufferedImage sprite, int tipo) {
		super(x, y, width, height, null, tipo);
		rightPlayer = new BufferedImage[4];
		leftPlayer = new BufferedImage[4];
		downPlayer = new BufferedImage[3];
		upPlayer = new BufferedImage[3];
		this.tipo = tipo;
		posicaox = x;
		posicaoy = y;
		
		if (((Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7)) && (this.tipo == 1)) {
		
		for (int i = 0;i < 4;i++) {
			
			rightPlayer[i] = Game.spritesheet.getSprite(60 + (i * 10), 0, 9, 16);
		}
		
		for (int i = 0;i < 4;i++) {
			
			leftPlayer[i] = Game.spritesheet.getSprite(30 + (i * -1 * 10), 0, 9, 16);
		}
		
		for (int i = 0;i < 3;i++) {
			
			downPlayer[i] = Game.spritesheet.getSprite(0 + (i * 10), 17, 9, 16);
		}
		
		for (int i = 0;i < 3;i++) {		
			upPlayer[i] = Game.spritesheet.getSprite(30 + (i * 10), 17, 9, 16);
		}
		}
		
		if (((Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7)) && (this.tipo == 2)) {
			
			for (int i = 0;i < 4;i++) {
				
				rightPlayer[i] = Game.spritesheet.getSprite(60 + (i * 10), 534, 9, 16);
			}
			
			for (int i = 0;i < 4;i++) {
				
				leftPlayer[i] = Game.spritesheet.getSprite(30 + (i * -1 * 10), 534, 9, 16);
			}
			
			for (int i = 0;i < 3;i++) {
				
				downPlayer[i] = Game.spritesheet.getSprite(0 + (i * 10), 551, 9, 16);
			}
			
			for (int i = 0;i < 3;i++) {		
				upPlayer[i] = Game.spritesheet.getSprite(30 + (i * 10), 551, 9, 16);
			}
		}
		
		if (((Game.CUR_LEVEL == 1) || (Game.CUR_LEVEL == 4) || (Game.CUR_LEVEL == 7)) && (this.tipo == 3)) {
			
			for (int i = 0;i < 4;i++) {
				
				rightPlayer[i] = Game.spritesheet.getSprite(60 + (i * 10), 568, 9, 16);
			}
			
			for (int i = 0;i < 4;i++) {
				
				leftPlayer[i] = Game.spritesheet.getSprite(30 + (i * -1 * 10), 568, 9, 16);
			}
			
			for (int i = 0;i < 3;i++) {
				
				downPlayer[i] = Game.spritesheet.getSprite(0 + (i * 10), 585, 9, 16);
			}
			
			for (int i = 0;i < 3;i++) {		
				upPlayer[i] = Game.spritesheet.getSprite(30 + (i * 10), 585, 9, 16);
			}
		}
		
		if (Game.CUR_LEVEL == 2) {
			
			for (int i = 0;i < 4;i++) {
				
				rightPlayer[i] = Game.spritesheet.getSprite(60 + (i * 10), 602, 9, 16);
			}
			
			for (int i = 0;i < 4;i++) {
				
				leftPlayer[i] = Game.spritesheet.getSprite(30 + (i * -1 * 10), 602, 9, 16);
			}
			
			for (int i = 0;i < 3;i++) {
				
				downPlayer[i] = Game.spritesheet.getSprite(0 + (i * 10), 619, 9, 16);
			}
			
			for (int i = 0;i < 3;i++) {		
				upPlayer[i] = Game.spritesheet.getSprite(30 + (i * 10), 619, 9, 16);
			}
		}
		
	}
	
	public void tick() {
		movedHor = false;
		movedVert = false;
		if (Game.rand.nextInt(100) < 50) {
			if (this.tipo == 1) {
				if (!controle) {
					this.time2++;
					movedHor = false;
					movedVert = false;
					staticLeft = true;
					if (this.time2 >= this.maxTime) {
						dir = right_dir;
						staticLeft = false;
						x+=speed;
						movedHor = true;
						movedVert = false;
					}
				}
				
				if (staticLeft)
					indexHor = 0;

				if(x == posicaox + 100) {
					controle = true;
					this.time2 = 0;
				}
				
				if (controle) {	
					this.time++;
					movedHor = false;
					movedVert = false;
					staticRight = true;
					if (this.time >= this.maxTime) {
						staticRight = false;
						dir = left_dir;
						x-=speed;
						movedHor = true;
						movedVert = false;
					}
				}
				
				if (staticRight)
					indexHor = 0;
				
				if(x == posicaox) {
					controle = false;
					this.time = 0;
					indexHor = 0;
				}


/*
				dir = down_dir;
				y+=speed;
				movedHor = false;
				movedVert = true;


				dir = up_dir;
				y-=speed;
				movedHor = false;
				movedVert = true;
				*/
			}
			
			if (this.tipo == 2) {
				if (!controle) {
					this.time2++;
					movedHor = false;
					movedVert = false;
					staticUp = true;
					if (this.time2 >= this.maxTime) {
						dir = down_dir;
						y+=speed;
						movedHor = false;
						movedVert = true;
						staticUp = false;

					}
				}
				
				if (staticUp)
					indexVert = 0;

				if(y == posicaoy + 50) {
					controle = true;
					this.time2 = 0;
				}
				
				if (controle) {	
					this.time++;
					movedHor = false;
					movedVert = false;
					staticDown = true;
					if (this.time >= this.maxTime) {
						staticDown = false;
						dir = up_dir;
						y-=speed;
						movedHor = false;
						movedVert = true;
					}
				}
				
				if (staticDown)
					indexVert = 0;
				
				if(y == posicaoy) {
					controle = false;
					this.time = 0;
					indexVert = 0;
				}


/*
				dir = down_dir;
				y+=speed;
				movedHor = false;
				movedVert = true;


				dir = up_dir;
				y-=speed;
				movedHor = false;
				movedVert = true;
				*/
			}
			
			if (this.tipo == 3) {
				if ((!controle2) && (!controle)) {
					this.time2++;
					movedHor = false;
					movedVert = false;
					staticLeft = true;
					staticUp = false;
					staticDown = false;
					staticRight = false;
					if (this.time2 >= this.maxTime) {
						dir = right_dir;
						staticLeft = false;
						x+=speed;
						movedHor = true;
						movedVert = false;
					}
				}
				
				if (staticLeft)
					indexHor = 0;

				if(x == posicaox + 100) {
					controle = true;
					controle2 = true;
					this.time2 = 0;
				}
				
				if ((controle) && (controle2)) {
					this.time++;
					movedHor = false;
					movedVert = false;
					staticUp = true;
					staticLeft = false;
					staticDown = false;
					staticRight = false;

					if (this.time >= this.maxTime) {
						dir = down_dir;
						y+=speed;
						movedHor = false;
						movedVert = true;
						staticUp = false;

					}
				}
				
				if (staticUp)
					indexVert = 0;
				
				if(y == posicaoy + 50) {
					controle2 = true;
					controle = false;
					this.time = 0;
				}
								
				
				if ((controle2) && (!controle)) {	
					this.time3++;
					movedHor = false;
					movedVert = false;
					staticRight = true;
					staticLeft = false;
					staticDown = false;
					staticUp = false;
					if (this.time3 >= this.maxTime) {
						staticRight = false;
						dir = left_dir;
						x-=speed;
						movedHor = true;
						movedVert = false;
					}
				}
				
				if (staticRight)
					indexHor = 0;
				
				if(x == posicaox) {
					controle = true;
					controle2 = false;
					this.time3 = 0;
					indexHor = 0;
				}
				
				if ((controle) && (!controle2)) {	
					this.time4++;
					movedHor = false;
					movedVert = false;
					staticDown = true;
					staticLeft = false;
					staticUp = false;
					staticRight = false;
					if (this.time4 >= this.maxTime) {
						staticDown = false;
						dir = up_dir;
						y-=speed;
						movedHor = false;
						movedVert = true;
					}
				}
				
				if (staticDown)
					indexVert = 0;
				
				if(y == posicaoy) {
					controle = false;
					controle2 = false;
					this.time4 = 0;
					indexVert = 0;
				}			
			}

			
			
				if (movedHor) {
					frames++;
					if (frames == maxFrames) {
						frames = 0;
						indexHor++;
						if (indexHor > maxIndexHor) {
							indexHor = 2;

						}
					}
				}
			
				if (movedVert) {
					frames++;
					if (frames == maxFrames) {
						frames = 0;
						indexVert++;
						if (indexVert > maxIndexVert) {
							indexVert = 0;

						}
					}
				}

		}

	}
		
	
	public void render(Graphics g) {
			if (dir == right_dir) {
				g.drawImage(rightPlayer[indexHor], this.getX() - Camera.x,this.getY() - Camera.y, null);
			} else if (dir == left_dir) {
				g.drawImage(leftPlayer[indexHor], this.getX() - Camera.x,this.getY() - Camera.y, null);		
			}
		
			if (dir == down_dir) {
				g.drawImage(downPlayer[indexVert], this.getX() - Camera.x,this.getY() - Camera.y, null);
			} else if (dir == up_dir) {
				g.drawImage(upPlayer[indexVert], this.getX() - Camera.x,this.getY() - Camera.y, null);		
			}
	
	}

}