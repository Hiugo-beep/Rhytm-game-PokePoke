  package by.mk.mvnex.Poke_Poke_01;
  class JThread extends Thread {
      
	  private boolean musicRun = true;
	  private ThreadPlaySong playMusic;
      private String music1 = "src/main/java/music/nao.wav";
      
      public JThread(){
    	  playMusic = new ThreadPlaySong ();
      }
    public void run(){
    	playMusic.getString(music1);
    	playMusic.start();
    	
    }
    public void getNewSong(String music) {
    	playMusic.stopT();
    	music1 = music;
    	playMusic.getString(music1);
    	playMusic = new ThreadPlaySong ();
    	playMusic.getString(music1);
    	playMusic.start();
    }
}

class ThreadPlaySong extends Thread {
	private String music = "src/main/java/music/nao.wav";
	private Sound play;
	private boolean musicRun = true;
    public void run(){
    	while(musicRun ) {
    		play = Sound.playSound(music);//.start();
    		play.start();
    		try {
    			sleep(200000);
    		} catch(Exception w) {}
    	}
    		
    }
    
    public void getString(String newMusic) {
    	music = newMusic;
    }
    public void stopT() {
    	musicRun = false;
    	play.close();
    }
}