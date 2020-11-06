package com.gcstudios.main;


import java.io.File;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioClip {
	private String file;
	public static final  AudioClip hurt = new AudioClip("/hurt.wav");
	public static final  AudioClip shoot = new AudioClip("/shoot.wav");
	public static final  AudioClip health = new AudioClip("/health.wav");
	public static final  AudioClip ammo = new AudioClip("/ammo.wav");
	public static final  AudioClip gun = new AudioClip("/gun.wav");
	public static final  AudioClip knife = new AudioClip("/knife.wav");
	public static final  AudioClip attackKnife = new AudioClip("/attackKnife.wav");
	public static final  AudioClip shield = new AudioClip("/shield.wav");
	public static final  AudioClip umbrella = new AudioClip("/umbrella.wav");
	public static final  AudioClip monoculo = new AudioClip("/monoculo.wav");
	public static final  AudioClip phrases = new AudioClip("/phrases.wav");
	public static final  AudioClip secret = new AudioClip("/secret.wav");
	public static final  AudioClip passos = new AudioClip("/passos.wav");
	public static final  AudioClip monoculoSelecionado = new AudioClip("/monoculoSelecionado.wav");
	public static final  AudioClip monoculoDeselecionado = new AudioClip("/monoculoDeselecionado.wav");
	public static final  AudioClip umbrellaSelecionado = new AudioClip("/umbrellaSelecionado.wav");
	public static final  AudioClip umbrellaDeselecionado = new AudioClip("/umbrellaDeselecionado.wav");	
	public static final  AudioClip death = new AudioClip("/death.wav");
	public static final  AudioClip rain = new AudioClip("/rain.wav");
	public static final  AudioClip door = new AudioClip("/door.wav");
	public static final  AudioClip movingInventary = new AudioClip("/movingInventary.wav");
	public static final  AudioClip itemSelected = new AudioClip("/itemSelected.wav");
	public static final  AudioClip chave = new AudioClip("/chave.wav");
	public static final  AudioClip papel = new AudioClip("/papel.wav");
	public static final  AudioClip diario = new AudioClip("/diario.wav");
	public static final  AudioClip itemNaoPermitido = new AudioClip("/itemNaoPermitido.wav");
	public static final  AudioClip itemComprado = new AudioClip("/itemComprado.wav");
	public static final  AudioClip coin = new AudioClip("/coin.wav");
	public static final  AudioClip bigorna = new AudioClip("/bigorna.wav");
	public static final  AudioClip gunSelecionado = new AudioClip("/gunSelecionado.wav");
	public static final  AudioClip gunDeselecionado = new AudioClip("/gunDeselecionado.wav");
	public static final  AudioClip knifeSelecionado = new AudioClip("/knifeSelecionado.wav");
	public static final  AudioClip knifeDeselecionado = new AudioClip("/knifeDeselecionado.wav");	
	public static final  AudioClip bossDerrotado = new AudioClip("/bossDerrotado.wav");
	public static final  AudioClip pause = new AudioClip("/pause.wav");
	public static final  AudioClip inventary = new AudioClip("/inventary.wav");
	public static final  AudioClip exitInventary = new AudioClip("/exitInventary.wav");
	public static final  AudioClip trovao = new AudioClip("/trovao.wav");
	public static final  AudioClip enterManual = new AudioClip("/enterManual.wav");
	public static final  AudioClip exitManual = new AudioClip("/exitManual.wav");
	public static final  AudioClip shop = new AudioClip("/shop.wav");
	public static final  AudioClip menu = new AudioClip("/menu.wav");
	public static final  AudioClip delegacia = new AudioClip("/Delegacia.wav");
	public static final  AudioClip condominio = new AudioClip("/Condominio.wav");
	public static final  AudioClip cenaCrime = new AudioClip("/cenaCrime.wav");
	public static final  AudioClip oficina = new AudioClip("/Oficina.wav");
	public static final  AudioClip boss = new AudioClip("/boss.wav");
	public static final  AudioClip oficina2 = new AudioClip("/Oficina2.wav");
	public static final  AudioClip encerramento = new AudioClip("/Encerramento.wav");
	public static final  AudioClip abertura = new AudioClip("/Abertura.wav");
	public AudioClip(String path) {
		file = path;		
	}
			
	public AudioInputStream getAudioStream() {
		try {
			return AudioSystem.getAudioInputStream(getClass().getResource(file));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
