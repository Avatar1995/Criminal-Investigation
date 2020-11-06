package com.gcstudios.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import com.gcstudios.world.Camera;


import java.awt.Graphics;
import java.awt.Graphics2D;

public class Encerramento {

	private int time = 0,pagina = 0, maxTime = 350, maxPagina = 6;
	public static boolean controle = true;
	

	public void tick() {
		if (controle) {
			AudioPlayer.playLoopSound(AudioClip.encerramento,1.5,1);
			controle = false;
		}
		time++;
		if (time > maxTime) {
			pagina++;
			time = 0;
			if (pagina > maxPagina) {
				Game.sairDoJogo = true;
			}
		}

	}
	
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH*Game.SCALE, Game.HEIGHT*Game.SCALE);
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial",Font.BOLD,22));	
		
		if (Game.sairDoJogo) {			
			g.drawString("Pressione ENTER para sair do jogo.", (Game.WIDTH*Game.SCALE) / 2 - 180 , (Game.HEIGHT*Game.SCALE) / 2);
		} else if (pagina == 0) {
			g.drawString("Esse é o primeiro capítulo de uma história", ((Game.WIDTH*Game.SCALE) / 2) - 210 , ((Game.HEIGHT*Game.SCALE) / 2) - 30);
			g.drawString("com muito mistério e revelações.", (Game.WIDTH*Game.SCALE) / 2 - 170 , ((Game.HEIGHT*Game.SCALE) / 2) + 10);
			
		} else if (pagina == 1) {
			g.drawString("Será que Leon é capaz de se tornar o", ((Game.WIDTH*Game.SCALE) / 2) - 190 , ((Game.HEIGHT*Game.SCALE) / 2) - 30);
			g.drawString("o grande detetive que almeja ser?", (Game.WIDTH*Game.SCALE) / 2 - 175 , ((Game.HEIGHT*Game.SCALE) / 2) + 10);	
			g.drawString("Apostamos que sim, e você?", ((Game.WIDTH*Game.SCALE) / 2) - 150 , ((Game.HEIGHT*Game.SCALE) / 2) + 70);
			
			
		} else if (pagina == 2) {
			g.drawString("Obrigado por jogar!", ((Game.WIDTH*Game.SCALE) / 2) - 100 , ((Game.HEIGHT*Game.SCALE) / 2) - 30);
			g.drawString("Estamos muito gratos por você fazer parte", (Game.WIDTH*Game.SCALE) / 2 - 220 , ((Game.HEIGHT*Game.SCALE) / 2) + 30);	
			g.drawString("desse mundo.", ((Game.WIDTH*Game.SCALE) / 2) - 70 , ((Game.HEIGHT*Game.SCALE) / 2) + 70);

			
		} else if (pagina == 3) {
			
			g.drawString("Testadores", ((Game.WIDTH*Game.SCALE) / 2) - 55 , ((Game.HEIGHT*Game.SCALE) / 2) - 150);
			g.drawString("Breno Venâncio", ((Game.WIDTH*Game.SCALE) / 2) - 80 , ((Game.HEIGHT*Game.SCALE) / 2) - 90);
			g.drawString("André Omine", ((Game.WIDTH*Game.SCALE) / 2) - 65 , ((Game.HEIGHT*Game.SCALE) / 2) - 50);
			g.drawString("Lucas Manuel", ((Game.WIDTH*Game.SCALE) / 2) - 70 , ((Game.HEIGHT*Game.SCALE) / 2) - 10);
			g.drawString("Thiago Farias", ((Game.WIDTH*Game.SCALE) / 2) - 70 , ((Game.HEIGHT*Game.SCALE) / 2) + 30);
			g.drawString("Douglas Carvalho", ((Game.WIDTH*Game.SCALE) / 2) - 90 , ((Game.HEIGHT*Game.SCALE) / 2) + 70);
			g.drawString("Paulo Gomes", ((Game.WIDTH*Game.SCALE) / 2) - 65 , ((Game.HEIGHT*Game.SCALE) / 2) + 110);
			g.drawString("Vinícius Simão", ((Game.WIDTH*Game.SCALE) / 2) - 74 , ((Game.HEIGHT*Game.SCALE) / 2) + 150);
		} else if (pagina == 4) {
			
			g.drawString("Testadores", ((Game.WIDTH*Game.SCALE) / 2) - 55 , ((Game.HEIGHT*Game.SCALE) / 2) - 150);
			g.drawString("Guilherme Henrique", ((Game.WIDTH*Game.SCALE) / 2) - 95 , ((Game.HEIGHT*Game.SCALE) / 2) - 90);
			g.drawString("Matheus Vieira", ((Game.WIDTH*Game.SCALE) / 2) - 70 , ((Game.HEIGHT*Game.SCALE) / 2) - 50);
			g.drawString("André Nishimoto", ((Game.WIDTH*Game.SCALE) / 2) - 83 , ((Game.HEIGHT*Game.SCALE) / 2) - 10);
			g.drawString("Rafael Souza", ((Game.WIDTH*Game.SCALE) / 2) - 69 , ((Game.HEIGHT*Game.SCALE) / 2) + 30);
			g.drawString("Vinicius Borges", ((Game.WIDTH*Game.SCALE) / 2) - 82 , ((Game.HEIGHT*Game.SCALE) / 2) + 70);
			g.drawString("Lucas Luiz Rodrigues", ((Game.WIDTH*Game.SCALE) / 2) - 111 , ((Game.HEIGHT*Game.SCALE) / 2) + 110);
			g.drawString("Roberto Luiz Rodrigues Jr.", ((Game.WIDTH*Game.SCALE) / 2) - 135 , ((Game.HEIGHT*Game.SCALE) / 2) + 150);
		} else if (pagina == 6) {
			
			g.drawString("Instagram da Empresa", ((Game.WIDTH*Game.SCALE) / 2) - 110, ((Game.HEIGHT*Game.SCALE) / 2) - 100);
			g.drawString("@bluemiraicompany", ((Game.WIDTH*Game.SCALE) / 2) - 102 , ((Game.HEIGHT*Game.SCALE) / 2) - 60);
			g.drawString("Facebook da Empresa", ((Game.WIDTH*Game.SCALE) / 2) - 112 , ((Game.HEIGHT*Game.SCALE) / 2));		
			g.drawString("facebook.com/103422568140819", ((Game.WIDTH*Game.SCALE) / 2) - 160 , ((Game.HEIGHT*Game.SCALE) / 2) + 40);
			g.drawString("E - mail para contato", ((Game.WIDTH*Game.SCALE) / 2) - 100 , ((Game.HEIGHT*Game.SCALE) / 2) + 100);
			g.drawString("bluemiraicompany@gmail.com", ((Game.WIDTH*Game.SCALE) / 2) - 155 , ((Game.HEIGHT*Game.SCALE) / 2) + 130);
		} else if (pagina == 5) {
			
			g.drawString("Programador/Roteirista", ((Game.WIDTH*Game.SCALE) / 2) - 119 , ((Game.HEIGHT*Game.SCALE) / 2) - 140);
			g.drawString("Efeito Sonoros/Designer", ((Game.WIDTH*Game.SCALE) / 2) - 127 , ((Game.HEIGHT*Game.SCALE) / 2) - 110);
			g.drawString("Vitor Borges Vieira Fraga", (Game.WIDTH*Game.SCALE) / 2 - 125 , ((Game.HEIGHT*Game.SCALE) / 2) - 60);	
			g.drawString("Instagram: @vitor.borges.1995", ((Game.WIDTH*Game.SCALE) / 2) - 155 , ((Game.HEIGHT*Game.SCALE) / 2) - 30);
			g.drawString("Facebook: facebook.com/vitor.borges.1232", ((Game.WIDTH*Game.SCALE) / 2) - 220 , ((Game.HEIGHT*Game.SCALE) / 2));
			
			g.drawString("Artista Gráfico", ((Game.WIDTH*Game.SCALE) / 2) - 70 , ((Game.HEIGHT*Game.SCALE) / 2) + 60);
			g.drawString("Bruno José da Silva Alves", ((Game.WIDTH*Game.SCALE) / 2) - 130 , ((Game.HEIGHT*Game.SCALE) / 2) + 100);
			g.drawString("Instagram: @bruno_brunenhos", ((Game.WIDTH*Game.SCALE) / 2) - 155 , ((Game.HEIGHT*Game.SCALE) / 2) + 130);
			g.drawString("Facebook: facebook.com/100002727490888", ((Game.WIDTH*Game.SCALE) / 2) - 220 , ((Game.HEIGHT*Game.SCALE) / 2) + 160);
		}
		
		
	}
	
}