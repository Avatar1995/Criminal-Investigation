package com.gcstudios.main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.gcstudios.entities.Entity;
import com.gcstudios.world.Camera;
import com.gcstudios.world.World;

public class Ball {
	
		public double x,y;
		public int width,height;
		public int tipo;
		
		public double dx,dy;
		public double speed = 2;
		
		public Ball(int x,int y,int tipo) {
			this.x = x;
			this.y = y;
			this.width = 4;
			this.height = 4;
			this.tipo = tipo;
			
			//int angle = new Random().nextInt(120 - 45) + 45 + 1;
			//dx = Math.cos(Math.toRadians(angle));
			//dy = Math.sin(Math.toRadians(angle));
			dx = Math.cos(Math.toRadians(100));
			dy = Math.sin(Math.toRadians(100));
		}
		
		public static boolean isColidding(Entity e1,Ball e2){
			Rectangle e1Mask = new Rectangle(e1.getX(),e1.getY(),e1.mwidth,e1.mheight);
			Rectangle e2Mask = new Rectangle((int)e2.x,(int)e2.y,e2.width,e2.height);
			
			return e1Mask.intersects(e2Mask);
		}
		
		
		public void tick() {
			
			if ((World.verificaErroBola((int)(x+(dx*speed)),(int)y)) 
					|| (World.verificaErroBola((int)(x-(dx*speed)),(int)y))
					|| (World.verificaErroBola((int)x,(int)(y-(dy*speed)))) 
					|| (World.verificaErroBola((int)x,(int)(y+(dy*speed)))) ) {
				Game.criarBola = true;
				Game.tipoBola = this.tipo;
				Game.ball.remove(this);
				return;
			}
			
			if (!World.isFree((int)(x+(dx*speed)),(int)y,this.tipo)) {
				dx*=-1;
			} else
			
				if (!World.isFree((int)(x-(dx*speed)),(int)y,this.tipo)) {
					dx*=-1;
				} else
					if (!World.isFree((int)x,(int)(y+(dy*speed)),this.tipo)) {
						dy*=-1;
					} else
						if (!World.isFree((int)x,(int)(y-(dy*speed)),this.tipo)) {
							dy*=-1;
						} 


			

			
			x+=dx*speed;
			y+=dy*speed;
			
			
			
		}
		
		public void render(Graphics g) {
			g.setColor(Color.yellow);
			g.fillRect((int)x - Camera.x,(int)y - Camera.y,width,height);
		}
}
