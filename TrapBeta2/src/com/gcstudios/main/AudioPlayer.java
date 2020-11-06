package com.gcstudios.main;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

public class AudioPlayer {
	private static Clip music,music2,music3;
	private static AudioInputStream inputStream2;
	private static AudioInputStream inputStream3;
	private static AudioInputStream inputStream4;
	public static synchronized void playSound(AudioClip sfx, double vol, int tipo) {
		  new Thread(new Runnable() {
		  // The wrapper thread is unnecessary, unless it blocks on the
		  // Clip finishing; see comments.
		    public void run() {
				  
		      try {
		    	//  System.out.println(clip);
		    	//  System.out.println(inputStream);
		    	Clip clip = AudioSystem.getClip();
		    	AudioInputStream inputStream = sfx.getAudioStream();
		        clip.open(inputStream);
		        setVol(vol,clip);
		        clip.start();
		        clip.addLineListener( new LineListener() {
		        public void update(LineEvent evt) {
		        	    if (evt.getType() == LineEvent.Type.STOP) {
		        	      evt.getLine().close();
		        	    }
		        	  }
		        });
				//System.out.println(clip);
		      } catch (Exception e) {
		    	  System.err.println(e.getMessage());
		      }
		    
		    }
		  }).start();
		  
	}
	
	public static synchronized void playLoopSound(AudioClip sfx, double vol, int tipo) {
		  new Thread(new Runnable() {

		  // The wrapper thread is unnecessary, unless it blocks on the
		  // Clip finishing; see comments.
		    public void run() {
				  
		      try {
		    	music = AudioSystem.getClip();
		    	inputStream2 = sfx.getAudioStream();
		        music.open(inputStream2);
		        setVol(vol,music);
		        music.start();
		        music.loop(Clip.LOOP_CONTINUOUSLY);
				Game.permissao = true;
		        
		      } catch (Exception e) {
		        System.err.println(e.getMessage());
		      }
		    
		    }
		  }).start();
		  
	}
	
	public static synchronized void playLoopSoundRain(AudioClip sfx, double vol, int tipo) {
		  new Thread(new Runnable() {

		  // The wrapper thread is unnecessary, unless it blocks on the
		  // Clip finishing; see comments.
		    public void run() {
				  
		      try {
		    	music2 = AudioSystem.getClip();
		    	inputStream3 = sfx.getAudioStream();
		        music2.open(inputStream3);
		        setVol(vol,music2);
		        music2.start();
		        music2.loop(Clip.LOOP_CONTINUOUSLY);
		        
		      } catch (Exception e) {
		        System.err.println(e.getMessage());
		      }
		    
		    }
		  }).start();
		  
	}
	
	public static synchronized void playLoopSoundShop(AudioClip sfx, double vol, int tipo) {
		  new Thread(new Runnable() {

		  // The wrapper thread is unnecessary, unless it blocks on the
		  // Clip finishing; see comments.
		    public void run() {
				  
		      try {
		    	music3 = AudioSystem.getClip();
		    	inputStream4 = sfx.getAudioStream();
		        music3.open(inputStream4);
		        setVol(vol,music3);
		        music3.start();
		        music3.loop(Clip.LOOP_CONTINUOUSLY);
		        Game.permissao = true;
		        
		      } catch (Exception e) {
		        System.err.println(e.getMessage());
		      }
		    
		    }
		  }).start();
		  
	}
	
	
	public static void abaixarAumentarSound(Double vol) {
		if (music != null) {
			  setVol(vol,music);
			  Game.permissao = true;
		 }

	}
	
	public static void abaixarAumentarSoundRain(Double vol) {
		if (music2 != null) {
			  setVol(vol,music2);
		 }       		     
	}
	
	public static void stopLoopSound() {
		if (music != null) {
			music.close();
		}
		if (inputStream2 != null) {
		try {
			inputStream2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		 
		 
	}
	
	public static void stopLoopSoundRain() {
		if (music2 != null) {
			music2.close();
		}
		if (inputStream3 != null) {
		try {
			inputStream3.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	public static void stopLoopSoundShop() {
		if (music3 != null) {
			music3.close();
		}
		if (inputStream4 != null) {
		try {
			inputStream4.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	private static void setVol(double vol, Clip clip) {
		FloatControl gain = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
		float d8 = (float) (Math.log(vol)/Math.log(10) * 20);
		gain.setValue(d8);
	}
	


}