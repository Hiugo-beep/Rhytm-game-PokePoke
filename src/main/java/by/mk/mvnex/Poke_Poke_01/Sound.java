package by.mk.mvnex.Poke_Poke_01;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound extends Thread implements AutoCloseable {
	private boolean released = false;
	private AudioInputStream stream = null;
	private Clip clip = null;
	private FloatControl volumeControl = null;
	private boolean playing = false;
	
	private String music;
	public Sound () {}
	public Sound(File f) {
		try {
			stream = AudioSystem.getAudioInputStream(f);
			clip = AudioSystem.getClip();
			clip.open(stream);
			clip.addLineListener(new Listener());
			volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			released = true;
		} catch (IOException | UnsupportedAudioFileException | LineUnavailableException exc) {
			exc.printStackTrace();
			released = false;
			
			close();
		}
	}

    public void getString(String newMusic) {
    	music = newMusic;
    }
	public void run() {
		//this.setVolume(0.75);
		join1();
	}
	
	// true если звук успешно загружен, false если произошла ошибка
	public boolean isReleased() {
		return released;
	}
	
	// проигрывается ли звук в данный момент
	public boolean isPlaying() {
		return playing;
	}

	// Запуск
	/*
	  breakOld определяет поведение, если звук уже играется
	  Если breakOld==true, о звук будет прерван и запущен заново
	  Иначе ничего не произойдёт
	*/
	public void play(boolean breakOld) {
		if (released) {
			if (breakOld) {
				clip.stop();
				clip.setFramePosition(0);
				clip.start();
				playing = true;
			} else if (!isPlaying()) {
				clip.setFramePosition(0);
				clip.start();
				playing = true;
			}
		}
	}
	
	// То же самое, что и play(true)
	public void play() {
		play(true);
	}
	
	// Останавливает воспроизведение
	public void stop1() {
		if (playing) {
			clip.stop();
		}
	}
	
	public void close() {
		if (clip != null)
			clip.close();
		
		if (stream != null)
			try {
				stream.close();
			} catch (IOException exc) {
				exc.printStackTrace();
			}
	}
	public void setVolume(double d) {
		if (d<0) d = 0;
		if (d>1) d = 1;
		float min = volumeControl.getMinimum();
		float max = volumeControl.getMaximum();
		volumeControl.setValue((float) ((max-min)*d+min));
	}
	
	// Статический метод, для удобства
	public static  Sound playSound(String path) {
		File f = new File(path);
		Sound snd = new Sound(f);
		snd.play();
		return snd;
	}

	// Дожидается окончания проигрывания звука
		public void join1() {
			if (!released) return;
			synchronized(clip) {
				try {
					while (playing)
						clip.wait();
				} catch (InterruptedException exc) {}
			}
		}
	private class Listener implements LineListener {
		public void update(LineEvent ev) {
			if (ev.getType() == LineEvent.Type.STOP) {
				playing = false;
				synchronized(clip) {
					clip.notify();
				}
			}
		}
	}
}

