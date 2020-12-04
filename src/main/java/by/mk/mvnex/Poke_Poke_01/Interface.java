package by.mk.mvnex.Poke_Poke_01;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;
import javax.swing.*;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Interface {
	private  JFrame mainMenuFrame;
	private JLabel phaseLabel1;
	private JLabel phaseLabel2;
	private InterfaceHandler handler;
	private Notation notation;
	private int scoreNow = 0;
	private int comboNow = 0;
	private int gemsGainNow = 0;
	private int maxNotesNow = 0;
	private TeamSelectFrame panelTeamSelectFrame;
	public Interface() {
		notation = new Notation();
        mainMenuFrame = new JFrame ("PokePoke!");
		mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.startMainMenu();
    }
	public void setHandler (InterfaceHandler h) {
		handler = h;
		
	}
	public void startMainMenu() {
		mainMenuFrame.getContentPane().removeAll();
		MyDrawPanelMainMenu mainPanel= new MyDrawPanelMainMenu ();;
		phaseLabel1 = new JLabel();
		 phaseLabel2 = new JLabel();
		
		
		mainPanel.add(notation.favorite);
		
		
		JButton characterButton = new JButton ("");
		

		characterButton.setOpaque(false);
        characterButton.setContentAreaFilled(false);
        characterButton.setBorderPainted(false);
		characterButton.setBorder(null);
		characterButton.addActionListener(new MainMenuCharacterPhraseButtonListener ());

		
		
		mainPanel.setLayout(null);
		mainPanel.add(characterButton);
		characterButton.setLocation(100, 100);
		characterButton.setSize(900,900);
		
		
		setPhraseCharacter();
		mainPanel.add(phaseLabel1);
		mainPanel.add(phaseLabel2);
		Font bigFontLabel = new Font("TimesRoman", Font.BOLD, 35);
		phaseLabel1.setFont(bigFontLabel);
		phaseLabel1.setForeground(Color.ORANGE);
		phaseLabel1.setLocation(250, 665);
		phaseLabel1.setSize(700, 50);
		
		phaseLabel2.setFont(bigFontLabel);
		phaseLabel2.setForeground(Color.ORANGE);
		phaseLabel2.setLocation(250, 705);
		phaseLabel2.setSize(750, 50);
		
		
		JLabel nameLabel = new JLabel();
		mainPanel.add(nameLabel);
		nameLabel.setText("PokePoke!");
		Font niceFont = new Font("Serif", Font.ITALIC,100);
		nameLabel.setForeground(Color.ORANGE);
		nameLabel.setFont(niceFont);
		nameLabel.setLocation(50, 50);
		nameLabel.setSize(500,100);
		
		
		
		Font BigFontButton = new Font("TimesRoman", Font.BOLD, 80);
		JButton playButton = new JButton("PLAY");
		mainPanel.add(playButton);
		setButtonSetting(playButton,BigFontButton);
		playButton.addActionListener(new MainMenuPlayButtonListener ());
		playButton.setLocation(1160, 80);
		playButton.setSize(670,130);
		
		JButton charactersButton = new JButton("CHARACTERS");
		mainPanel.add(charactersButton);
		setButtonSetting(charactersButton,BigFontButton);
		charactersButton.addActionListener(new MainMenuCharactersButtonListener ());
		charactersButton.setLocation(1160, 260);
		charactersButton.setSize(670,130);
		
		JButton settingsButton = new JButton("SETTINGS");
		mainPanel.add(settingsButton);
		setButtonSetting(settingsButton,BigFontButton);
		settingsButton.addActionListener(new MainMenuSettingsButtonListener ());
		settingsButton.setLocation(1160, 260+180);
		settingsButton.setSize(670,130);
		
		
		JButton helpButton = new JButton("HELP");
		mainPanel.add(helpButton);
		setButtonSetting(helpButton,BigFontButton);
		helpButton.addActionListener(new MainMenuHelpButtonListener ());
		helpButton.setLocation(1160, 260+180*2);
		helpButton.setSize(670,130);
		
		JButton exitButton = new JButton("EXIT");
		mainPanel.add(exitButton);
		setButtonSetting(exitButton,BigFontButton);
		exitButton.addActionListener(new MainMenuExitButtonListener ());
		exitButton.setLocation(1160, 260+180*3);
		exitButton.setSize(670,130);
		
		mainMenuFrame.getContentPane().add(mainPanel);
		mainMenuFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainMenuFrame.setVisible(true);
		
	}
	
	/////////////////////////////////////////////////////////////////BUTTON SETTINGS
	private void setButtonSetting(JButton b, Font font) {
		b.setFocusPainted(false);
		b.setOpaque(false);
		b.setContentAreaFilled(false);
		b.setFont(font);
		b.setBorderPainted(false);
		b.setBorder(null);
	}
	private Image getCharacterImage() {
		switch(notation.favorite) {
		case 1:
			return new ImageIcon("src/main/java/images/CHIKA.png").getImage();
		case 2:
			return new ImageIcon("src/main/java/images/RIKO.png").getImage();
		case 3:
			return new ImageIcon("src/main/java/images/YOU.png").getImage();
		case 4:
			return new ImageIcon("src/main/java/images/DIA.png").getImage();
		case 5:
			return new ImageIcon("src/main/java/images/MARI.png").getImage();
		case 6:
			return new ImageIcon("src/main/java/images/KANAN.png").getImage();
		case 7:
			return new ImageIcon("src/main/java/images/MARU.png").getImage();
		case 8:
			return new ImageIcon("src/main/java/images/YOSHIKO.png").getImage();
		case 9:
			return new ImageIcon("src/main/java/images/RUBY.png").getImage();
		default:
			return null;
		}
	}
	
	private void setPhraseCharacter() {
		String phraseCharacter1 = "";
		String phraseCharacter2 = "";
		int rangeStart = 0; //начальное значение диапозона
        int rangeEnd = 4;//9 //конечное значение диапозона
        int phraseNumber = rangeStart + (int)(Math.random() * rangeEnd);
		switch(phraseNumber) {
		case 1:
			phraseCharacter1 = "I'm very happy to see you:)";
			phraseCharacter2 = "How is your mood?";
			break;
		case 2:
			phraseCharacter1 = "How about playing a";
			phraseCharacter2 = "great new map? >:3";
			break;
		case 3:
			phraseCharacter1 = "Hello! it seems like it's time to level up!";
			phraseCharacter2 = "The main thing is not to give up!";
			break;
		case 4:
			phraseCharacter1 = "How was your day today?";
			phraseCharacter2 = " I can listen to you :)";
			break;
		/*case 5:
			phraseCharacter
		case 6:
			phraseCharacter
		case 7:
			phraseCharacter
		case 8:
			phraseCharacter
		case 9:
			phraseCharacter*/
		default:
			phraseCharacter1 = "I'm very happy to see you:)";
			phraseCharacter2 = "How is your mood?";
		}
		phaseLabel1.setText(phraseCharacter1);
		phaseLabel2.setText(phraseCharacter2);
	}
	
	class MyDrawPanelMainMenu extends JPanel {
		private Image character;
        public void paintComponent(Graphics g){
            Image backGround = new ImageIcon("src/main/java/images/mainMenu.jpg").getImage();
            Image conversCloud = new ImageIcon("src/main/java/images/conversСloud.png").getImage();
            Image button = new ImageIcon("src/main/java/images/button.png").getImage();
            g.drawImage(backGround, 0,0,this);
            g.drawImage(character, 0,0,this);
            g.drawImage(conversCloud, 0,0,this);
            for(int i=0;i<5;i++) {
            	g.drawImage(button, 1150,80 + i *180,this);
            	
            }
            
        }
		public void add(int characterNumber) {
			character = getCharacterImage();
			this.repaint();
		}
    }
	
	class MainMenuCharacterPhraseButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			setPhraseCharacter();
		}
	}
	
	class MainMenuPlayButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			handler.changeFrame(2);
		}
	}
	
	class MainMenuCharactersButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			handler.changeFrame(5);
		}
	}
	
	class MainMenuSettingsButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			handler.changeFrame(12);
			
		}
	}
	
	class MainMenuHelpButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			handler.changeFrame(10);
		}
	}
	
	class MainMenuExitButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//Сохранение игры
			System.exit(0);
		}
	}
	
	
	
////////////////////////////////////////////////ОКНО ПЕРСОНАЖЕЙ
	public void startCharactersFrame() {
		
		MyDrawPanelCharactersFrame panel = new MyDrawPanelCharactersFrame();
		panel.setLayout(null);
		JButton chikaButton = new JButton("");
		panel.add(chikaButton);
		setButtonSetting(chikaButton, null);
		chikaButton.addActionListener(new CharactersChikaButtonListener());
		chikaButton.setLocation(0,0);
		chikaButton.setSize(210,541);
		
		JButton youButton = new JButton("");
		panel.add( youButton);
		setButtonSetting( youButton, null);
		youButton.addActionListener(new CharactersYouButtonListener());
		youButton.setLocation(219,0);
		youButton.setSize(216,541);
		
		
		JButton rubyButton = new JButton("");
		panel.add(rubyButton);
		setButtonSetting( rubyButton, null);
		rubyButton.addActionListener(new CharactersRubyButtonListener());
		rubyButton.setLocation(444,0);
		rubyButton.setSize(216,541);
		
		JButton maruButton = new JButton("");
		panel.add(maruButton);
		setButtonSetting(maruButton, null);
		maruButton.addActionListener(new CharactersMaruButtonListener());
		maruButton.setLocation(669,0);
		maruButton.setSize(192,541);
		
		
		JButton diaButton = new JButton("");
		panel.add(diaButton);
		setButtonSetting(diaButton, null);
		diaButton.addActionListener(new CharactersDiaButtonListener());
		diaButton.setLocation(870,0);
		diaButton.setSize(179,541);
		
		
		JButton kananButton = new JButton("");
		panel.add(kananButton);
		setButtonSetting(kananButton, null);
		kananButton.addActionListener(new CharactersKananButtonListener());
		kananButton.setLocation(1058,0);
		kananButton.setSize(193,541);
		
		JButton mariButton = new JButton("");
		panel.add(mariButton);
		setButtonSetting(mariButton, null);
		mariButton.addActionListener(new CharactersMariButtonListener());
		mariButton.setLocation(1260,0);
		mariButton.setSize(211,541);
		
		JButton rikoButton = new JButton("");
		panel.add(rikoButton);
		setButtonSetting(rikoButton, null);
		rikoButton.addActionListener(new CharactersRikoButtonListener());
		rikoButton.setLocation(1480,0);
		rikoButton.setSize(207,541);
		
		JButton yoshikoButton = new JButton("");
		panel.add(yoshikoButton);
		setButtonSetting(yoshikoButton, null);
		yoshikoButton.addActionListener(new CharactersYoshikoButtonListener());
		yoshikoButton.setLocation(1696,0);
		yoshikoButton.setSize(230,541);
		
		JButton back = new JButton("BACK");
		Font BigFontButton = new Font("TimesRoman", Font.BOLD, 80);
		panel.add(back);
		setButtonSetting(back,BigFontButton);
		back.addActionListener(new MainMenuBackButtonListener ());
		back.setLocation(0, 900);
		back.setSize(630,130);
		
		
		JButton strengthen = new JButton("STRENGTHEN");
		panel.add(strengthen);
		setButtonSetting(strengthen,BigFontButton);
		strengthen.addActionListener(new CharactersStrengthenButtonListener ());
		strengthen.setLocation(1290, 900);
		strengthen.setSize(630,130);
		//mainMenuFrame.setVisible(false);
		mainMenuFrame.getContentPane().removeAll();
		mainMenuFrame.getContentPane().add(panel);
		mainMenuFrame.setVisible(true);
		
	}
	class MyDrawPanelCharactersFrame extends JPanel {		
		public void paintComponent(Graphics g){
	        Image backGround = new ImageIcon("src/main/java/images/characterFrame.png").getImage();
	        g.drawImage(backGround, 0,0,this);
	        
	    }
	}
	class MainMenuBackButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			handler.changeFrame(1);
		}
	}
	class CharactersStrengthenButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			handler.changeFrame(8);
		}
	}
	
	////////////////////////////////////////////////ОКНО ПЕРСОНАЖА
	public void CharacterFrame(int selectedCharacter) {
		
		DrawPanelCharacter panel = new DrawPanelCharacter();
		panel.getSelectedCharacter(selectedCharacter);
		panel.setLayout(null);
		Font font = new Font("TimesRoman", Font.BOLD, 80);
		JButton back = new JButton("BACK");
		panel.add(back);
		setButtonSetting(back,font);
		back.addActionListener(new Character6BackButtonListener ());
		back.setLocation(0, 900);
		back.setSize(630,130);
		
		mainMenuFrame.getContentPane().removeAll();
		mainMenuFrame.getContentPane().add(panel);
		mainMenuFrame.setVisible(true);
	}
	
	class DrawPanelCharacter extends JPanel{
		int selectedCharacter;
		DrawPanelCharacter myPanel = this;
		
		public void paintComponent(Graphics g){
			JLabel level = new JLabel();
			this.add(level);
			Font font = new Font("TimesRoman", Font.BOLD, 80);
			level.setFont(font);
			level.setForeground(Color.BLACK);
			level.setSize(500,100);
			Integer levelN = notation.levels[selectedCharacter-1];
			level.setText(levelN.toString());
			
			
			JLabel power= new JLabel();
			this.add(power);
			power.setFont(font);
			power.setForeground(Color.BLACK);
			power.setSize(500,100);
			Integer powerN = notation.levelDesignation[levelN-1];
			power.setText(powerN.toString());
			
			
	        Image backGround;
	        Image favoriteImage = favoriteImage = new ImageIcon("").getImage();
	        
	        
	        switch(selectedCharacter) {
	        case 1:
	        	backGround = new ImageIcon("src/main/java/imagesCharacters/characterCHIKA.png").getImage();
		        if(1 == notation.favorite) {
		        	favoriteImage = new ImageIcon("src/main/java/imagesCharacters/favorite1.png").getImage();
		        	
		        } 
				level.setLocation(240, 690);
				power.setLocation(260, 775);
	        	break;
	        case 2:
	        	backGround = new ImageIcon("src/main/java/imagesCharacters/characterRIKO.png").getImage();
		        if(2 == notation.favorite) {
		        	favoriteImage = new ImageIcon("src/main/java/imagesCharacters/favorite1.png").getImage();
		        	
		        } 
		        level.setLocation(240, 650);
				power.setLocation(260, 735);
	        	break;
	        case 3:
	        	backGround = new ImageIcon("src/main/java/imagesCharacters/characterYOU.png").getImage();
		        if(3 == notation.favorite) {
		        	favoriteImage = new ImageIcon("src/main/java/imagesCharacters/favorite1.png").getImage();
		        	
		        } 
		        level.setLocation(240, 690);
				power.setLocation(260, 775);
	        	break;
	        case 4:
	        	backGround = new ImageIcon("src/main/java/imagesCharacters/characterDIA.png").getImage();
		        if(4 == notation.favorite) {
		        	favoriteImage = new ImageIcon("src/main/java/imagesCharacters/favorite1.png").getImage();
		        	
		        } 
		        level.setLocation(240, 690);
				power.setLocation(260, 775);
	        	break;
	        case 5:
	        	backGround = new ImageIcon("src/main/java/imagesCharacters/characterMARI.png").getImage();
		        if(5 == notation.favorite) {
		        	favoriteImage = new ImageIcon("src/main/java/imagesCharacters/favorite1.png").getImage();
		        	
		        } 
		        level.setLocation(240, 690);
				power.setLocation(260, 775);
	        	break;
	        case 6: 
	        	backGround = new ImageIcon("src/main/java/imagesCharacters/characterKANAN.png").getImage();
		        if(6 == notation.favorite) {
		        	favoriteImage = new ImageIcon("src/main/java/imagesCharacters/favorite1.png").getImage();
		        	
		        } 
		        level.setLocation(240, 690);
				power.setLocation(260, 775);
	        	break;
	        case 7:
	        	backGround = new ImageIcon("src/main/java/imagesCharacters/characterMARU.png").getImage();
		        if(7 == notation.favorite) {
		        	favoriteImage = new ImageIcon("src/main/java/imagesCharacters/favorite1.png").getImage();
		        	
		        } 
		        level.setLocation(240, 725);
				power.setLocation(260, 810);
	        	break;
	        case 8:
	        	backGround = new ImageIcon("src/main/java/imagesCharacters/characterYOSHIKO.png").getImage();
		        if(8 == notation.favorite) {
		        	favoriteImage = new ImageIcon("src/main/java/imagesCharacters/favorite1.png").getImage();
		        	
		        } 
		        level.setLocation(220, 725);
				power.setLocation(240, 810);
	        	break;
	        case 9:
	        	backGround = new ImageIcon("src/main/java/imagesCharacters/characterRUBY.png").getImage();
		        if(9 == notation.favorite) {
		        	favoriteImage = new ImageIcon("src/main/java/imagesCharacters/favorite1.png").getImage();
		        	
		        } 
		        level.setLocation(240, 690);
				power.setLocation(260, 775);
	        	break;
	        default:
				level.setLocation(240, 690);
				power.setLocation(260, 775);
	        	backGround = new ImageIcon("src/main/java/imagesCharacters/characterCHIKA.png").getImage();
	        	break;
	        }
	        g.drawImage(backGround, 0,0,this);
	        g.drawImage(favoriteImage, 1580,0,this);
	        
			JButton favorite = new JButton("");
			this.setLayout(null);
			this.add(favorite );
			setButtonSetting(favorite , null);
			favorite .addActionListener(new SetFavoriteButtonListener());
			favorite .setLocation(1640,110);
			favorite .setSize(200,200);
	    }
    	class SetFavoriteButtonListener implements ActionListener{
    		public void actionPerformed(ActionEvent e) {
    			notation.favorite = selectedCharacter;
    			 myPanel.repaint();
    		}
    	}
		public void getSelectedCharacter(int x) {
			selectedCharacter = x;
		}
	}
	class Character6BackButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//setPhraseCharacter();
			handler.changeFrame(5);
		}
	}
	
	class CharactersChikaButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			handler.changeFrame(6, 1);
		}
	}
	class CharactersYouButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			handler.changeFrame(6, 3);
		}
	}
	class CharactersRikoButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			handler.changeFrame(6, 2);
		}
	}
	class CharactersDiaButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			handler.changeFrame(6, 4);
		}
	}
	class CharactersMariButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			handler.changeFrame(6, 5);
		}
	}
	class CharactersKananButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			handler.changeFrame(6, 6);
		}
	}
	class CharactersRubyButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			handler.changeFrame(6, 9);
		}
	}
	class CharactersMaruButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			handler.changeFrame(6, 7);
		}
	}
	class CharactersYoshikoButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			handler.changeFrame(6, 8);
		}
	}

	

	////////////////////////////////////ОКНО ПРОКАЧКИ///////////////////
	public void setStrengthenFrame() {
		PanelStrengtenFrame panel = new PanelStrengtenFrame();
		panel.setLayout(null);
		
		JButton back = new JButton("BACK");
		Font font = new Font("TimesRoman", Font.BOLD, 80);
		panel.add(back);
		setButtonSetting(back, font);
		back.addActionListener(new Back8ButtonListener ());
		back.setLocation(0, 900);
		back.setSize(630,130);
		
	
		JButton chikaButton = new JButton("");
		panel.add(chikaButton);
		setButtonSetting(chikaButton, null);
		chikaButton.addActionListener(new StrengtenChikaButtonListener());
		chikaButton.setLocation(0,0);
		chikaButton.setSize(210,541);
		
		JButton youButton = new JButton("");
		panel.add( youButton);
		setButtonSetting( youButton, null);
		youButton.addActionListener(new StrengtenYouButtonListener());
		youButton.setLocation(219,0);
		youButton.setSize(216,541);
		
		
		JButton rubyButton = new JButton("");
		panel.add(rubyButton);
		setButtonSetting( rubyButton, null);
		rubyButton.addActionListener(new StrengtenRubyButtonListener());
		rubyButton.setLocation(444,0);
		rubyButton.setSize(216,541);
		
		JButton maruButton = new JButton("");
		panel.add(maruButton);
		setButtonSetting(maruButton, null);
		maruButton.addActionListener(new StrengtenMaruButtonListener());
		maruButton.setLocation(669,0);
		maruButton.setSize(192,541);
		
		
		JButton diaButton = new JButton("");
		panel.add(diaButton);
		setButtonSetting(diaButton, null);
		diaButton.addActionListener(new StrengtenDiaButtonListener());
		diaButton.setLocation(870,0);
		diaButton.setSize(179,541);
		
		
		JButton kananButton = new JButton("");
		panel.add(kananButton);
		setButtonSetting(kananButton, null);
		kananButton.addActionListener(new StrengtenKananButtonListener());
		kananButton.setLocation(1058,0);
		kananButton.setSize(193,541);
		
		JButton mariButton = new JButton("");
		panel.add(mariButton);
		setButtonSetting(mariButton, null);
		mariButton.addActionListener(new StrengtenMariButtonListener());
		mariButton.setLocation(1260,0);
		mariButton.setSize(211,541);
		
		JButton rikoButton = new JButton("");
		panel.add(rikoButton);
		setButtonSetting(rikoButton, null);
		rikoButton.addActionListener(new StrengtenRikoButtonListener());
		rikoButton.setLocation(1480,0);
		rikoButton.setSize(207,541);
		
		JButton yoshikoButton = new JButton("");
		panel.add(yoshikoButton);
		setButtonSetting(yoshikoButton, null);
		yoshikoButton.addActionListener(new StrengtenYoshikoButtonListener());
		yoshikoButton.setLocation(1696,0);
		yoshikoButton.setSize(230,541);
		
		JLabel gem = new JLabel();
		panel.add(gem);
		gem.setFont(font);
		gem.setLocation(1380, 900);
		gem.setForeground(Color.BLACK);
		gem.setSize(500,100);
		Integer comboN = notation.gems;
		gem.setText(comboN.toString());
		
		
		mainMenuFrame.getContentPane().removeAll();
		mainMenuFrame.getContentPane().add(panel);
		mainMenuFrame.setVisible(true);
	}
	class PanelStrengtenFrame extends JPanel {		
		public void paintComponent(Graphics g){
	        Image backGround = new ImageIcon("src/main/java/images/strengthFrame.png").getImage();
	        g.drawImage(backGround, 0,0,this);
	        
	    }
	}
	class Back8ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//setPhraseCharacter();
			handler.changeFrame(5);
		}
	}
	class StrengtenChikaButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			handler.changeFrame(9, 1);
		}
	}
	class StrengtenYouButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			handler.changeFrame(9, 3);
		}
	}
	class StrengtenRikoButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			handler.changeFrame(9, 2);
		}
	}
	class StrengtenDiaButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			handler.changeFrame(9, 4);
		}
	}
	class StrengtenMariButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			handler.changeFrame(9, 5);
		}
	}
	class StrengtenKananButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			handler.changeFrame(9, 6);
		}
	}
	class StrengtenRubyButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			handler.changeFrame(9, 9);
		}
	}
	class StrengtenMaruButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			handler.changeFrame(9, 7);
		}
	}
	class StrengtenYoshikoButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			handler.changeFrame(9, 8);
		}
	}
	////////////////////////////////ОКНО ПРОКАЧКИ ПЕРСОНАЖА
	public void strengthenCharacterFrame(int selectedCharacter) {
		
		StrengthenPanelCharacter panel = new StrengthenPanelCharacter();
		panel.getSelectedCharacter(selectedCharacter);
		panel.setLayout(null);
		
		panel.level = new JLabel();
		panel.power= new JLabel();
		panel.gem = new JLabel();
		
		JButton back = new JButton("BACK");
		Font font = new Font("TimesRoman", Font.BOLD, 80);
		panel.add(back);
		setButtonSetting(back,font);
		back.addActionListener(new Strengthen9BackButtonListener ());
		back.setLocation(0, 900);
		back.setSize(640,130);
		
		
		panel.add(panel.level);
		panel.level.setFont(font);
		panel.level.setForeground(Color.BLACK);
		panel.level.setSize(500,100);
		
		panel.level.setLocation(280,200);
		
		
		panel.add(panel.power);
		panel.power.setFont(font);
		panel.power.setForeground(Color.BLACK);
		panel.power.setSize(500,100);

		panel.power.setLocation(330,310);
		

		panel.add(panel.gem);
		Font font1 = new Font("TimesRoman", Font.BOLD, 120);
		panel.gem.setFont(font1);
		panel.gem.setLocation(450, 717);
		panel.gem.setForeground(Color.BLACK);
		panel.gem.setSize(500,100);
		
		
		Integer levelN = notation.levels[selectedCharacter-1];
		
		
		
		
		
		panel.costLab = new JLabel();
		panel.add(panel.costLab);
		panel.costLab.setFont(font);;
		panel.costLab.setLocation(735, 510);
		panel.costLab.setSize(500,130);
		
		JButton cost = new JButton("");
		panel.add(cost);
		setButtonSetting(cost,font);
		Strengthen9BuyButtonListener buyListner = new  Strengthen9BuyButtonListener ();
		 buyListner.selectedCharacter = selectedCharacter;
		 buyListner.panel = panel;
		cost.addActionListener(buyListner);
		cost.setLocation(535, 510);
		cost.setSize(550,130);
		
		mainMenuFrame.getContentPane().removeAll();
		mainMenuFrame.getContentPane().add(panel);
		mainMenuFrame.setVisible(true);
	}

	class StrengthenPanelCharacter extends JPanel{
		int selectedCharacter;
		JLabel level;
		JLabel power;
		JLabel gem;
		JLabel costLab;
		public void paintComponent(Graphics g){
			

	        Image backGround;
	        switch(selectedCharacter) {
	        case 1:
	        	backGround = new ImageIcon("src/main/java/imagesCharacters/strengthenCHIKA.png").getImage();
	        	break;
	        case 2:
	        	backGround = new ImageIcon("src/main/java/imagesCharacters/strengthenRIKO.png").getImage();
	        	break;
	        case 3:
	        	backGround = new ImageIcon("src/main/java/imagesCharacters/strengthenYOU.png").getImage();
	        	break;
	        case 4:
	        	backGround = new ImageIcon("src/main/java/imagesCharacters/strengthenDIA.png").getImage();
	        	break;
	        case 5:
	        	backGround = new ImageIcon("src/main/java/imagesCharacters/strengthenMARI.png").getImage();
	        	break;
	        case 6: 
	        	backGround = new ImageIcon("src/main/java/imagesCharacters/strengthenKANAN.png").getImage();
	        	break;
	        case 7:
	        	backGround = new ImageIcon("src/main/java/imagesCharacters/strengthenMARU.png").getImage();
	        	break;
	        case 8:
	        	backGround = new ImageIcon("src/main/java/imagesCharacters/strengthenYOSHIKO.png").getImage();
	        	break;
	        case 9:
	        	backGround = new ImageIcon("src/main/java/imagesCharacters/strengthenRUBY.png").getImage();
	        	costLab.setLocation(715, 510);
	        	break;
	        default:
	        	backGround = new ImageIcon("src/main/java/imagesCharacters/strengthenCHIKA.png").getImage();
	        }
	        
	        g.drawImage(backGround, 0,0,this);
	       
	        Integer levelN = notation.levels[selectedCharacter-1];
	        if(levelN == 10)  g.drawImage(new ImageIcon("src/main/java/images/forbiddenButton.png").getImage(), 535,510,this);
	        else  if(notation.levelCost[levelN-1] > notation.gems) {
	        	 g.drawImage(new ImageIcon("src/main/java/images/forbiddenButton.png").getImage(), 535,510,this);
	        }
	        
	        
			level.setText(levelN.toString());
			
			Integer comboN = notation.gems;
			gem.setText(comboN.toString());
			
			Integer powerN =notation.levelDesignation[levelN-1];
			power.setText(powerN.toString());
			
			
			if(levelN == 10) costLab.setText("-");
			else {
				Integer costL = notation.levelCost[levelN-1];
				costLab.setText(costL.toString());
			}

	    }
		public void getSelectedCharacter(int x) {
			selectedCharacter = x;
		}
	}
	class Strengthen9BackButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//setPhraseCharacter();
			handler.changeFrame(8);
		}
	}
	class Strengthen9BuyButtonListener implements ActionListener{
		public StrengthenPanelCharacter panel;
		public int selectedCharacter=1;
		public void actionPerformed(ActionEvent e) {
			 if(notation.levels[selectedCharacter-1] != 10) 
			 if( notation.levelCost[notation.levels[selectedCharacter-1]] <= notation.gems) {
				 notation.gems -=notation.levelCost[notation.levels[selectedCharacter-1]];
				 notation.levels[selectedCharacter-1]++;
		        }
			 panel.repaint();
		}
	}
	//////////////////////////////////////////////////////////////////////////////ОКНО ПОМОЩИ.
	public void setHelpFrame() {
		helpPanel panel = new helpPanel();
		panel.setButton();
		JButton back = new JButton("BACK");
		Font BigFontButton = new Font("TimesRoman", Font.BOLD, 80);
		panel.setLayout(null);
		panel.add(back);
		setButtonSetting(back,BigFontButton);
		back.addActionListener(new MainMenuBackButtonListener ());
		back.setLocation(0, 900);
		back.setSize(630,130);
		
		mainMenuFrame.getContentPane().removeAll();
		mainMenuFrame.getContentPane().add(panel);
		mainMenuFrame.setVisible(true);
	}
	class helpPanel extends JPanel{
		int counter = 1;
		int maxValue = 3;
		helpPanel thisPanel = this;
		String[] images = {"src/main/java/help/HELP1.png" , "src/main/java/help/HELP2.png","src/main/java/help/HELP3.png"};
		public void setButton() {
			JButton switchLeftButton = new JButton("");
			this.setLayout(null);
			
			Font BigFontButton = new Font("TimesRoman", Font.BOLD, 80);
			this.add(switchLeftButton);
			setButtonSetting(switchLeftButton, null );
			switchLeftButton.addActionListener(new SwitchLeftButtonListener ());
			switchLeftButton.setLocation(50, 280);
			switchLeftButton.setSize(150,300);
			
			JButton switchRightButton = new JButton("");
			this.add(switchRightButton);
			setButtonSetting(switchRightButton, null);
			switchRightButton.addActionListener(new SwitchRightButtonListener ());
			switchRightButton.setLocation(1750, 280);
			switchRightButton.setSize(150,300);
		}
		public void paintComponent(Graphics g){
			
			if(counter > maxValue) {
				counter = 1;
			} else if(counter <= 0) {
				counter = maxValue;
			}
			Image backGround = new ImageIcon(images[counter-1]).getImage();
			g.drawImage(backGround, 0,0,this);
			
		}
		class SwitchLeftButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				counter--;
				thisPanel.repaint();
			}
		}
		class SwitchRightButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				counter++;
				thisPanel.repaint();
			}
		}
	}

	
	/////////////////////////////////////////////////////////////ОКНО ВЫБОРА КАРТЫ 2 /////////////
	public void setMapSelectionWindow() {
		mapSelect panel = new mapSelect();
		JButton back = new JButton("BACK");
		Font BigFontButton = new Font("TimesRoman", Font.BOLD, 80);
		panel.setLayout(null);
		panel.add(back);
		setButtonSetting(back,BigFontButton);
		back.addActionListener(new MainMenuBackButtonListener ());
		back.setLocation(10, 900);
		back.setSize(620,130);
		
		
		JButton team = new JButton("TEAM");
		panel.add(team);
		setButtonSetting(team,BigFontButton);
		team.addActionListener(new MapSelectTeam2ButtonListener ());
		team.setLocation(640, 900);
		team.setSize(630,130);
		
		JButton play = new JButton("PLAY");
		panel.add(play);
		setButtonSetting(play,BigFontButton);
		play.addActionListener(new MapSelect2PlayButtonListener ());
		play.setLocation(1285, 900);
		play.setSize(630,130);
		
		JButton statistis = new JButton("");
		panel.add(statistis);
		setButtonSetting(statistis,BigFontButton);
		statistis.addActionListener(new MapSelectStatisctics2ButtonListener  ());
		statistis.setLocation(1300, 700);
		statistis.setSize(80,80);


		JButton switchLeftButton = new JButton("");
		panel.add(switchLeftButton);
		setButtonSetting(switchLeftButton, null );
		switchLeftButton.addActionListener(new MapSwitchLeftButtonListener ());
		switchLeftButton.setLocation(50, 280);
		switchLeftButton.setSize(150,300);
		
		JButton switchRightButton = new JButton("");
		panel.add(switchRightButton);
		setButtonSetting(switchRightButton, null);
		switchRightButton.addActionListener(new MapSwitchRightButtonListener ());
		switchRightButton.setLocation(1750, 280);
		switchRightButton.setSize(150,300);
		
		mainMenuFrame.getContentPane().removeAll();
		mainMenuFrame.getContentPane().add(panel);
		mainMenuFrame.setVisible(true);
	}
	class mapSelect extends JPanel{
		public void paintComponent(Graphics g) {

			Image backGround = new ImageIcon("src/main/java/playImages/mapSelect.png").getImage();
			g.drawImage(backGround, 0,0,this);
			
		}
	}
	class MapSelectStatisctics2ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			handler.changeFrame(3);
		}
	}
	
	class MapSwitchLeftButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			handler.changeFrame(2);
		}
	}
	class MapSwitchRightButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			handler.changeFrame(2);
		}
	}

	class MapSelectTeam2ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			handler.changeFrame(7);
		}
	}
	class MapSelect2PlayButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			handler.changeFrame(4);
		}
	}
/////////////////////////////////////////////////////////////ОКНО СТАТИСТИКИ 3 /////////////
	public void setStatisticsWindow() {
		
		StatisticsFrame panel = new StatisticsFrame();
		JButton back = new JButton("BACK");
		Font font = new Font("TimesRoman", Font.BOLD, 80);
		panel.setLayout(null);
		panel.add(back);
		setButtonSetting(back,font);
		back.addActionListener(new Statistics3BackButtonListener ());
		back.setLocation(10, 900);
		back.setSize(620,130);
		
		
		
		JLabel playedOnce = new JLabel();
		panel.add(playedOnce);
		playedOnce.setFont(font);
		playedOnce.setLocation(810, 235);
		playedOnce.setForeground(Color.BLACK);
		playedOnce.setSize(500,100);
		Integer playedOnceN = notation.playedOnce;
		playedOnce.setText(playedOnceN.toString());
		
		
		
		JLabel combo = new JLabel();
		panel.add(combo);
		combo.setFont(font);
		combo.setLocation(940, 342);
		combo.setForeground(Color.BLACK);
		combo.setSize(500,100);
		Integer comboN = notation.maxCombo;
		combo.setText(comboN.toString());
		
		JLabel allNotes = new JLabel();
		panel.add(allNotes );
		allNotes.setFont(font);
		allNotes.setLocation(1390, 450);
		allNotes.setForeground(Color.BLACK);
		allNotes.setSize(500,100);
		Integer allNotesN = notation.maxNotes;
		allNotes.setText(allNotesN.toString());
		
		JLabel score = new JLabel();
		panel.add(score);
		score.setFont(font);
		score.setLocation(1155, 558);
		score.setForeground(Color.BLACK);
		score.setSize(500,100);
		Integer scoreN = notation.maxScore;
		score.setText(scoreN.toString());

		
		
		JLabel earnedGEM = new JLabel();
		panel.add(earnedGEM);
		earnedGEM.setFont(font);
		earnedGEM.setLocation(1405,663);
		earnedGEM.setForeground(Color.BLACK);
		earnedGEM.setSize(500,100);
		Integer earnedGEMN = notation.earnedGEM;
		earnedGEM.setText(earnedGEMN.toString());
		
		mainMenuFrame.getContentPane().removeAll();
		mainMenuFrame.getContentPane().add(panel);
		mainMenuFrame.setVisible(true);
	}
	class StatisticsFrame extends JPanel{
		public void paintComponent(Graphics g) {
			Image backGround = new ImageIcon("src/main/java/playImages/statistic.png").getImage();
			g.drawImage(backGround, 0,0,this);
			
		}
	}
	class Statistics3BackButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			handler.changeFrame(2);
		}
	}
	//////////////////////////////////////////////////////////////////////////ОКНО ИГРЫ 4/////////////////////////////
	public void setPlayWindow() {
		scoreNow = 0;
				comboNow = 0;
				gemsGainNow = 0;
				maxNotesNow = 0;
		
		playFrame panel = new playFrame();


		//back2.setLocation(957, 200);//Координтаы центры



			    
		panel.startGame();
		
		mainMenuFrame.getContentPane().removeAll();
		mainMenuFrame.getContentPane().add(panel);
		mainMenuFrame.setVisible(true);
	}
	class playFrame extends JPanel {
		
		
		private Image spark = new ImageIcon("src/main/java/icons/spark.png").getImage();
		private JLabel score;
		private JLabel combo;
		public Integer scoreNumber = 0;
		public int allNotes = 0;
		public Integer comboNumber = 0;
		boolean[] isPressed = {false, false, false, false, false, false};
		playFrame panel = this;
		int x[] = {0, 0, 0, 0, 0, 0};
		int y[] = {0, 0, 0, 0, 0, 0};
		public playFrame() {
			this.setLayout(null);
			Font font = new Font("TimesRoman", Font.BOLD, 80);
			
			score = new JLabel ();
			this.add(score);
			score.setFont(font);
			score.setForeground(Color.WHITE);
			score.setText(scoreNumber.toString());
			score.setLocation(850, 0);
			score.setSize(300,100);
			
			
			combo = new JLabel ();
			this.add(combo);
			combo.setFont(font);
			combo.setForeground(Color.WHITE);
			combo.setText("x "+comboNumber.toString());
			combo.setLocation(1500, 0);
			combo.setSize(300,100);
		}
		public void paintComponent(Graphics g) {
			Image backGround = new ImageIcon("src/main/java/playImages/playFrame.png").getImage();
			g.drawImage(backGround, 0,0,this);
			Image gifDance = new ImageIcon("src/main/java/playImages/Paw.gif").getImage();
			g.drawImage(gifDance, 1600,600,this);
			Image gifDance2 = new ImageIcon("src/main/java/playImages/Paw2.gif").getImage();
			g.drawImage(gifDance2, 0,500,this);
			Image[] mass = notation.team.getTeam();
				g.drawImage(mass[0],170 ,200,this);
				g.drawImage(mass[5],1530,200 ,this);
				g.drawImage(mass[1],268 ,552,this);
				g.drawImage(mass[4],1432,552 ,this);
				g.drawImage(mass[2],530,800,this);
				g.drawImage(mass[3],1170,800 ,this);
				for(int i=0;i<6;i++) {
					if(x[i] != 0) g.drawImage(new ImageIcon("src/main/java/icons/CIRCLE.png").getImage(),x[i],y[i]  ,this);
					if(isPressed[i]) g.drawImage(new ImageIcon("src/main/java/icons/spark.png").getImage(),x[i],y[i]  ,this);
				}
				score.setText(scoreNumber.toString());
				combo.setText("x "+comboNumber.toString());
				
				if (comboNumber>comboNow) comboNow = comboNumber;
				//if (scoreNumber>notation.maxScore) notation.maxScore = scoreNumber;
				if (allNotes>maxNotesNow) maxNotesNow = allNotes;
				scoreNow = scoreNumber;
		}
		public void setIcon(int x1, int y1, int number) {
			x[number -1] = x1;
			y[number-1] = y1;
			repaint();
		}
		public void startGame() {
			
			  KeyStroke keyStroke1 = KeyStroke.getKeyStroke(notation.keys[0], 0);
			    Action listener1 = new AbstractAction() {
			        public void actionPerformed(ActionEvent e) {
			           if(x[0]<230 && x[0] != 0 && !isPressed[0] ) {
			        	   if(notation.team.selectedIcons[0] != 0) 
			        		   scoreNumber  += notation.levelDesignation[notation.levels[notation.team.selectedIcons[0]-1]];
			        	   isPressed[0]  = true;
			        	   
			           }
			        }
			    };
			    Integer k1 = notation.keys[0];
			    this.addHotKey(keyStroke1, k1.toString(), listener1);
			    
			    
				  KeyStroke keyStroke6 = KeyStroke.getKeyStroke(notation.keys[5], 0);
				    Action listener6 = new AbstractAction() {
				        public void actionPerformed(ActionEvent e) {
				        	if(x[5]> 1450 && x[5] != 0 && !isPressed[5] ) {
				        		if(notation.team.selectedIcons[5] != 0) 
				        			scoreNumber  += notation.levelDesignation[notation.levels[notation.team.selectedIcons[5]-1]];
					        	isPressed[5]  = true;
					           }
				        }
				    };
				    Integer k6 = notation.keys[5];
				    panel.addHotKey(keyStroke6, k6.toString(), listener6);
				    

				    KeyStroke keyStroke2 = KeyStroke.getKeyStroke(notation.keys[1], 0);
				    Action listener2 = new AbstractAction() {
				        public void actionPerformed(ActionEvent e) {
				        	if(x[1]<318 && x[1] != 0 && !isPressed[1] ) {
				        		if(notation.team.selectedIcons[1] != 0) 
					        	   scoreNumber  += notation.levelDesignation[notation.levels[notation.team.selectedIcons[1]-1]];
					        	   isPressed[1]  = true;
					        	   
					           }
				        }
				    };
				    Integer k2 = notation.keys[1];
				    panel.addHotKey(keyStroke2, k2.toString(), listener2);
				    
				    
				    KeyStroke keyStroke5 = KeyStroke.getKeyStroke(notation.keys[4], 0);
				    Action listener5 = new AbstractAction() {
				        public void actionPerformed(ActionEvent e) {
				        	if(x[4]>1382 && x[4] != 0 && !isPressed[4] ) {
				        		if(notation.team.selectedIcons[4] != 0) 
					        	   scoreNumber  += notation.levelDesignation[notation.levels[notation.team.selectedIcons[4]-1]];
					        	   isPressed[4]  = true;
					        	   
					           }
				        }
				    };
				    Integer k5 = notation.keys[4];
				    panel.addHotKey(keyStroke5, k5.toString(), listener5);
				    
			    
				    KeyStroke keyStroke3 = KeyStroke.getKeyStroke(notation.keys[2], 0);
				    Action listener3 = new AbstractAction() {
				        public void actionPerformed(ActionEvent e) {
				        	if(x[2]<580 && x[2] != 0 && !isPressed[2] ) {
				        		if(notation.team.selectedIcons[2] != 0) 
					        	   scoreNumber  += notation.levelDesignation[notation.levels[notation.team.selectedIcons[2]-1]];
					        	   isPressed[2]  = true;
					        	   
					           }
				        }
				    };
				    Integer k3 = notation.keys[2];
				    panel.addHotKey(keyStroke3, k3.toString(), listener3);
				    
				    
				    KeyStroke keyStroke4 = KeyStroke.getKeyStroke(notation.keys[3], 0);
				    Action listener4 = new AbstractAction() {
				        public void actionPerformed(ActionEvent e) {
				        	if(x[3]>1120 && x[3] != 0 && !isPressed[3] ) {
				        		if(notation.team.selectedIcons[3] != 0) 
					        	   scoreNumber  += notation.levelDesignation[notation.levels[notation.team.selectedIcons[3]-1]];
					        	   isPressed[3]  = true;
					        	   
					           }
				        }
				    };
				    Integer k4 = notation.keys[3];
				    panel.addHotKey(keyStroke4, k4.toString(), listener4);

			    
			new PlayHandler(panel, handler).start();

		}

			private void addHotKey(KeyStroke keyStroke, String inputActionKey, Action listener) {
		    ActionMap actionMap = this.getActionMap();
		    InputMap inputMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		    inputMap.put(keyStroke, inputActionKey);
		    actionMap.put(inputActionKey, listener);
		}

	}
	

	/////////////////////////////////////////////////////////////////////////////ОКНО ОКОНЧАНИЯ КАРТЫ 11///////////////////////////
	public void setResultWindow() {
		
		ResultFrame panel = new ResultFrame();
		notation.playedOnce++;
		int gems = scoreNow/300;
		gemsGainNow = gems;
		if(notation.earnedGEM<gems) notation.earnedGEM=gems;
		
		notation.gems += gems;
		notation.gems += scoreNow/300;
		if(scoreNow > notation.maxScore) {
			notation.maxScore = scoreNow;
			notation.earnedGEM=gemsGainNow;
			notation.maxCombo = comboNow;
			notation.maxNotes = maxNotesNow;
		}
		
		
		
		JButton back = new JButton("BACK");
		Font font = new Font("TimesRoman", Font.BOLD, 80);
		panel.setLayout(null);
		panel.add(back);
		setButtonSetting(back,font);
		back.addActionListener(new Result11BackButtonListener ());
		back.setLocation(0, 900);
		back.setSize(950,130);
		
		JButton restart = new JButton("RESTART");
		panel.add(restart);
		setButtonSetting(restart,font);
		restart.addActionListener(new  Result11RestartButtonListener  ());
		restart.setLocation(975, 900);
		restart.setSize(970,130);
		
		
		JLabel combo = new JLabel();
		panel.add(combo);
		combo.setFont(font);
		combo.setLocation(450, 338);
		combo.setForeground(Color.BLACK);
		combo.setSize(500,100);
		Integer comboN = notation.maxCombo;
		combo.setText(comboN.toString());
		
		JLabel allNotes = new JLabel();
		panel.add(allNotes );
		allNotes.setFont(font);
		allNotes.setLocation(900, 443);
		allNotes.setForeground(Color.BLACK);
		allNotes.setSize(500,100);
		Integer allNotesN = notation.maxNotes;
		allNotes.setText(allNotesN.toString());
		
		JLabel score = new JLabel();
		panel.add(score);
		score.setFont(font);
		score.setLocation(650, 548);
		score.setForeground(Color.BLACK);
		score.setSize(500,100);
		Integer scoreN = notation.maxScore;
		score.setText(scoreN.toString());
		
		
		JLabel earnedGEM = new JLabel();
		panel.add(earnedGEM);
		earnedGEM.setFont(font);
		earnedGEM.setLocation(900,653);
		earnedGEM.setForeground(Color.BLACK);
		earnedGEM.setSize(500,100);
		Integer earnedGEMN = gems;
		earnedGEM.setText(earnedGEMN.toString());
		
		mainMenuFrame.getContentPane().removeAll();
		mainMenuFrame.getContentPane().add(panel);
		mainMenuFrame.setVisible(true);
	}
	class ResultFrame extends JPanel{
		public void paintComponent(Graphics g) {
			Image backGround = new ImageIcon("src/main/java/playImages/resultFrame.png").getImage();
			g.drawImage(backGround, 0,0,this);
			
		}
	}
	class Result11BackButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			handler.changeFrame(2);
		}
	}
	class Result11RestartButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			handler.changeFrame(4);
		}
	}
	
	
	
	////////////////////////////////////////////////////////////////////////////ОКНО ВЫБОРА КОМАНДЫ  7
	public void setTeamSelectWindow() {
		panelTeamSelectFrame = new TeamSelectFrame();

		JButton back = new JButton("BACK");
		Font font = new Font("TimesRoman", Font.BOLD, 80);
		panelTeamSelectFrame.setLayout(null);
		panelTeamSelectFrame.add(back);
		setButtonSetting(back,font);
		back.addActionListener(new TeamSelect7BackButtonListener ());
		back.setLocation(0, 900);
		back.setSize(620,130);

		JButton chikaSelect= new JButton("");
		panelTeamSelectFrame.add(chikaSelect);
		setButtonSetting(chikaSelect,font);
		chikaSelect.addActionListener(new TeamSelect7CHIKAButtonListener ());
		chikaSelect.setLocation(110, 350);
		chikaSelect.setSize(200,200);
		
		JButton rikoSelect= new JButton("");
		panelTeamSelectFrame.add(rikoSelect);
		setButtonSetting(rikoSelect,font);
		rikoSelect.addActionListener(new TeamSelect7RIKOButtonListener());
		rikoSelect.setLocation(410, 350);
		rikoSelect.setSize(200,200);
		
		
		JButton youSelect= new JButton("");
		panelTeamSelectFrame.add(youSelect);
		setButtonSetting(youSelect,font);
		youSelect.addActionListener(new TeamSelect7YOUButtonListener ());
		youSelect.setLocation(710, 350);
		youSelect.setSize(200,200);
		
		
		JButton diaSelect= new JButton("");
		panelTeamSelectFrame.add(diaSelect);
		setButtonSetting(diaSelect,font);
		diaSelect.addActionListener(new TeamSelect7DIAButtonListener ());
		diaSelect.setLocation(1010, 350);
		diaSelect.setSize(200,200);
		
		
		JButton mariSelect= new JButton("");
		panelTeamSelectFrame.add(mariSelect);
		setButtonSetting(mariSelect,font);
		mariSelect.addActionListener(new TeamSelect7MARIButtonListener ());
		mariSelect.setLocation(1310, 350);
		mariSelect.setSize(200,200);
		
		
		JButton kananSelect= new JButton("");
		panelTeamSelectFrame.add(kananSelect);
		setButtonSetting(kananSelect,font);
		kananSelect.addActionListener(new TeamSelect7KANANButtonListener ());
		kananSelect.setLocation(1610, 350);
		kananSelect.setSize(200,200);
		
		
		JButton maruSelect= new JButton("");
		panelTeamSelectFrame.add(maruSelect);
		setButtonSetting(maruSelect,font);
		maruSelect.addActionListener(new TeamSelect7MARUButtonListener ());
		maruSelect.setLocation(110, 600);
		maruSelect.setSize(200,200);
		
		JButton yoshikoSelect= new JButton("");
		panelTeamSelectFrame.add(yoshikoSelect);
		setButtonSetting(yoshikoSelect,font);
		yoshikoSelect.addActionListener(new TeamSelect7YOSHIKOButtonListener ());
		yoshikoSelect.setLocation(410, 600);
		yoshikoSelect.setSize(200,200);
		
		
		JButton rubySelect= new JButton("");
		panelTeamSelectFrame.add(rubySelect);
		setButtonSetting(rubySelect,font);
		rubySelect.addActionListener(new TeamSelect7RUBYButtonListener ());
		rubySelect.setLocation(710, 600);
		rubySelect.setSize(200,200);
		
		panelTeamSelectFrame.teamPower = new JLabel();
		panelTeamSelectFrame.add(panelTeamSelectFrame.teamPower);
		panelTeamSelectFrame.teamPower.setFont(font);
		panelTeamSelectFrame.teamPower.setForeground(Color.BLACK);
		panelTeamSelectFrame.teamPower.setSize(900,100);

		panelTeamSelectFrame.teamPower.setLocation(950, 887);
		
		mainMenuFrame.getContentPane().removeAll();
		mainMenuFrame.getContentPane().add(panelTeamSelectFrame);
		mainMenuFrame.setVisible(true);
	}
	class TeamSelectFrame extends JPanel{
		JLabel teamPower;
		public void paintComponent(Graphics g) {
			Image selectedMember = new ImageIcon("src/main/java/playImages/selected.png").getImage();
			Image backGround = new ImageIcon("src/main/java/playImages/teamSelectFrame.png").getImage();
			g.drawImage(backGround, 0,0,this);			
			
			
			Image[] selected = notation.team.getTeam();
			
			for(int i=0;i<6;i++) {
				g.drawImage(selected[i],100 + i*300 ,30,this);

			}
			
			Image[] members = notation.team.getMembers();
			for(int i=0;i<6;i++) {
				g.drawImage(members[i],100 + i*300 ,350,this);
				for(int j=0;j<6;j++) {
					if(notation.team.selectedIcons[j] == i+1) {
						g.drawImage(selectedMember, 100+ i*300, 350 ,this);
					}
					
				}
			}
			for(int i=0;i<3;i++) {
				g.drawImage(members[i+6],100 + i*300 ,600,this);
				for(int j=0;j<6;j++) {
					if(notation.team.selectedIcons[j] == i+1+6) {
						g.drawImage(selectedMember, 100+ i*300, 600 ,this);
					}
					
				}
			}
			Integer power =0;
			for(int i=0;i<6;i++) {
				int numberMember = notation.team.selectedIcons[i];
				if(numberMember !=0 )
					power += notation.levelDesignation[notation.levels[numberMember-1]-1];
			}
			teamPower.setText("TEAM POWER:" +power.toString());
		}
		
		
	}
	class TeamSelect7BackButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			handler.changeFrame(2);
		}
	}

	class TeamSelect7CHIKAButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			boolean exit1 = false;
			for(int i=0;i<6;i++) 
				if(notation.team.selectedIcons[i] == 1 ) {
					notation.team.selectedIcons[i] = 0;
					exit1 = true;
					break;
				}
			if(!exit1 ) 
				for(int i=0;i<6;i++)
					if(notation.team.selectedIcons[i] == 0) {
						notation.team.selectedIcons[i] = 1;
						break;
					}
			panelTeamSelectFrame.repaint();
		}
	}
	class TeamSelect7RIKOButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			boolean exit1 = false;
			for(int i=0;i<6;i++) 
				if(notation.team.selectedIcons[i] == 2 ) {
					notation.team.selectedIcons[i] = 0;
					exit1 = true;
					break;
				}
			if(!exit1 ) 
				for(int i=0;i<6;i++)
					if(notation.team.selectedIcons[i] == 0) {
						notation.team.selectedIcons[i] = 2;
						break;
					}
			panelTeamSelectFrame.repaint();
		}
	}
	class TeamSelect7YOUButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			boolean exit1 = false;
			for(int i=0;i<6;i++) 
				if(notation.team.selectedIcons[i] == 3 ) {
					notation.team.selectedIcons[i] = 0;
					exit1 = true;
					break;
				}
			if(!exit1 ) 
				for(int i=0;i<6;i++)
					if(notation.team.selectedIcons[i] == 0) {
						notation.team.selectedIcons[i] = 3;
						break;
					}
			panelTeamSelectFrame.repaint();
		}
	}
	
	class TeamSelect7DIAButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			boolean exit1 = false;
			for(int i=0;i<6;i++) 
				if(notation.team.selectedIcons[i] == 4 ) {
					notation.team.selectedIcons[i] = 0;
					exit1 = true;
					break;
				}
			if(!exit1 ) 
				for(int i=0;i<6;i++)
					if(notation.team.selectedIcons[i] == 0) {
						notation.team.selectedIcons[i] = 4;
						break;
					}
			panelTeamSelectFrame.repaint();
		}
	}
	class TeamSelect7MARIButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			boolean exit1 = false;
			for(int i=0;i<6;i++) 
				if(notation.team.selectedIcons[i] == 5 ) {
					notation.team.selectedIcons[i] = 0;
					exit1 = true;
					break;
				}
			if(!exit1 ) 
				for(int i=0;i<6;i++)
					if(notation.team.selectedIcons[i] == 0) {
						notation.team.selectedIcons[i] =5;
						break;
					}
			panelTeamSelectFrame.repaint();
		}
	}
	class TeamSelect7KANANButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			boolean exit1 = false;
			for(int i=0;i<6;i++) 
				if(notation.team.selectedIcons[i] == 6 ) {
					notation.team.selectedIcons[i] = 0;
					exit1 = true;
					break;
				}
			if(!exit1 ) 
				for(int i=0;i<6;i++)
					if(notation.team.selectedIcons[i] == 0) {
						notation.team.selectedIcons[i] = 6;
						break;
					}
			panelTeamSelectFrame.repaint();
		}
	}
	class TeamSelect7MARUButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			boolean exit1 = false;
			for(int i=0;i<6;i++) 
				if(notation.team.selectedIcons[i] == 7 ) {
					notation.team.selectedIcons[i] = 0;
					exit1 = true;
					break;
				}
			if(!exit1 ) 
				for(int i=0;i<6;i++)
					if(notation.team.selectedIcons[i] == 0) {
						notation.team.selectedIcons[i] = 7;
						break;
					}
			panelTeamSelectFrame.repaint();
		}
	}
	class TeamSelect7YOSHIKOButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			boolean exit1 = false;
			for(int i=0;i<6;i++) 
				if(notation.team.selectedIcons[i] == 8 ) {
					notation.team.selectedIcons[i] = 0;
					exit1 = true;
					break;
				}
			if(!exit1 ) 
				for(int i=0;i<6;i++)
					if(notation.team.selectedIcons[i] == 0) {
						notation.team.selectedIcons[i] = 8;
						break;
					}
			panelTeamSelectFrame.repaint();
		}
	}
	class TeamSelect7RUBYButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			boolean exit1 = false;
			for(int i=0;i<6;i++) 
				if(notation.team.selectedIcons[i] == 9 ) {
					notation.team.selectedIcons[i] = 0;
					exit1 = true;
					break;
				}
			if(!exit1 ) 
				for(int i=0;i<6;i++)
					if(notation.team.selectedIcons[i] == 0) {
						notation.team.selectedIcons[i] = 9;
						break;
					}
			panelTeamSelectFrame.repaint();
		}
	}
	////////////////////////////////////////////////////////////////////////////ОКНО ИЗМЕНЕНИЯ НАСТРОЕК 12 //////////////////////////////////////////
	
	
	
	public void setSettingWindow() {
		
		SettingFrame panel = new SettingFrame();
		notation.playedOnce++;
		int gems = scoreNow/300;
		gemsGainNow = gems;
		if(notation.earnedGEM<gems) notation.earnedGEM=gems;
		
		notation.gems += gems;
		notation.gems += scoreNow/300;
		if(scoreNow > notation.maxScore) {
			notation.maxScore = scoreNow;
			notation.earnedGEM=gemsGainNow;
			notation.maxCombo = comboNow;
			notation.maxNotes = maxNotesNow;
		}
		
		
		
		JButton back = new JButton("BACK");
		Font font = new Font("TimesRoman", Font.BOLD, 80);
		panel.setLayout(null);
		panel.add(back);
		setButtonSetting(back,font);
		back.addActionListener(new MainMenuBackButtonListener ());
		back.setLocation(0, 900);
		back.setSize(630,130);
		
		
		JButton set1Button = new JButton("");
		panel.add(set1Button );
		setButtonSetting(set1Button ,font);
		Setting1RestartButton12Listener listner1 = new Setting1RestartButton12Listener  ();
		listner1.panel = panel;
		set1Button .addActionListener(listner1);
		set1Button .setLocation(80,300);
		set1Button .setSize(200,200);
		
		JButton set2Button = new JButton("");
		panel.add(set2Button);
		setButtonSetting(set2Button,font);
		Setting2RestartButton12Listener listner2 = new Setting2RestartButton12Listener  ();
		listner2.panel = panel;
		set2Button.addActionListener(listner2);
		set2Button.setLocation(353,542);
		set2Button.setSize(200,200);
		
		JButton set3Button = new JButton("");
		panel.add(set3Button);
		setButtonSetting(set3Button,font);
		Setting3RestartButton12Listener listner3 = new Setting3RestartButton12Listener  ();
		listner3.panel = panel;
		set3Button.addActionListener(listner3);
		set3Button.setLocation(680,625);
		set3Button.setSize(200,200);
		
		
		JButton set4Button = new JButton("");
		panel.add(set4Button );
		setButtonSetting(set4Button,font);
		Setting4RestartButton12Listener listner4 = new Setting4RestartButton12Listener  ();
		listner4.panel = panel;
		set4Button.addActionListener(listner4);
		set4Button .setLocation(1020,630);
		set4Button.setSize(200,200);
		
		JButton set5Button = new JButton("");
		panel.add(set5Button);
		setButtonSetting(set5Button,font);
		Setting5RestartButton12Listener listner5 = new Setting5RestartButton12Listener  ();
		listner5.panel = panel;
		set5Button.addActionListener(listner5);
		set5Button.setLocation(1367,522);
		set5Button.setSize(200,200);
		
		JButton set6Button = new JButton("");
		panel.add(set6Button );
		setButtonSetting(set6Button ,font);
		Setting6RestartButton12Listener listner6 = new Setting6RestartButton12Listener  ();
		listner6.panel = panel;
		set6Button.addActionListener(listner6);
		set6Button.setLocation(1640, 300);
		set6Button.setSize(200,200);
		
		
		Font font1 = new Font("TimesRoman", Font.BOLD, 100);
		panel.key1 = new JLabel();
		panel.add(panel.key1);
		panel.key1.setFont(font1);
		panel.key1.setLocation(130,300);
		panel.key1.setSize(200,200);
		

		panel.key2 = new JLabel();
		panel.add(panel.key2);
		panel.key2.setFont(font1);
		panel.key2.setLocation(403,542);
		panel.key2.setSize(200,200);

		panel.key3 = new JLabel();
		panel.add(panel.key3);
		panel.key3.setFont(font1);
		panel.key3.setLocation(730,625);
		panel.key3.setSize(200,200);

		panel.key4 = new JLabel();
		panel.add(panel.key4);
		panel.key4.setFont(font1);
		panel.key4.setLocation(1070,630);
		panel.key4.setSize(200,200);
;
		panel.key5 = new JLabel();
		panel.add(panel.key5);
		panel.key5.setFont(font1);
		panel.key5.setLocation(1417,522);
		panel.key5.setSize(200,200);

		panel.key6 = new JLabel();
		panel.add(panel.key6);
		panel.key6.setFont(font1);
		panel.key6.setLocation(1690,300);
		
		panel.key6.setSize(200,200);
		
		mainMenuFrame.getContentPane().removeAll();
		mainMenuFrame.getContentPane().add(panel);
		mainMenuFrame.setVisible(true);
		
	}
	
	
	public void read() throws IOException
	{
        int x = System.in.read();
        char c = (char) x;
        System.out.println("Код символа: " + c + " = " + x);
	}
	
	class SettingFrame extends JPanel{
		JLabel key1;
		JLabel key2;
		JLabel key3;
		JLabel key4;
		JLabel key5;
		JLabel key6;
		public void paintComponent(Graphics g) {
			Image backGround = new ImageIcon("src/main/java/images/settingFrame.png").getImage();
			g.drawImage(backGround, 0,0,this);
			key1.setText(Character.toString ((char) notation.keys[0]));
			
			
			
			key2.setText(Character.toString ((char) notation.keys[1]));
			key3.setText(Character.toString ((char) notation.keys[2]));
			key4.setText(Character.toString ((char) notation.keys[3]));
			key5.setText(Character.toString ((char) notation.keys[4]));
			key6.setText(Character.toString ((char) notation.keys[5]));
		}
	}

	class Setting1RestartButton12Listener implements ActionListener{
		SettingFrame panel;
		public void actionPerformed(ActionEvent e) {

			JTextArea inputText = new JTextArea();
			panel.add(inputText);

			inputText.setSize(100,100);
			inputText.setLocation(280, 300);
			Font font1 = new Font("TimesRoman", Font.BOLD, 100);
			inputText.setFont(font1);
						inputText.addKeyListener(new KeyListener()
						{
						@Override
						public void keyPressed(KeyEvent e)
						{
							boolean isNewKey = true;
							int key =e.getKeyCode();
							for(int i =0;i<6;i++) 
								if(notation.keys[i] == key) {
									isNewKey = false;
									break;
								}
							if(isNewKey)
								notation.keys[0] = key;
							panel.repaint();
						}
						@Override
						public void keyReleased(KeyEvent e)
						{}
						@Override
						public void keyTyped(KeyEvent e)
						{}
						});
		}
	}
	
	
	class Setting2RestartButton12Listener implements ActionListener{
		SettingFrame panel;
		public void actionPerformed(ActionEvent e) {


			JTextArea inputText = new JTextArea();
			panel.add(inputText);

			inputText.setSize(100,100);
			inputText.setLocation(553,542);
			Font font1 = new Font("TimesRoman", Font.BOLD, 100);
			inputText.setFont(font1);
						inputText.addKeyListener(new KeyListener()
						{
						@Override
						public void keyPressed(KeyEvent e)
						{
							boolean isNewKey = true;
							int key =e.getKeyCode();
							for(int i =0;i<6;i++) 
								if(notation.keys[i] == key) {
									isNewKey = false;
									break;
								}
							if(isNewKey)
								notation.keys[1] = key;
							panel.repaint();
						}
						@Override
						public void keyReleased(KeyEvent e)
						{}
						@Override
						public void keyTyped(KeyEvent e)
						{}
						});
		}
	}

	class Setting3RestartButton12Listener implements ActionListener{
		SettingFrame panel;
		public void actionPerformed(ActionEvent e) {

			JTextArea inputText = new JTextArea();
			panel.add(inputText);

			inputText.setSize(100,100);
			inputText.setLocation(880,625);
			Font font1 = new Font("TimesRoman", Font.BOLD, 100);
			inputText.setFont(font1);
						inputText.addKeyListener(new KeyListener()
						{
						@Override
						public void keyPressed(KeyEvent e)
						{
							boolean isNewKey = true;
							int key =e.getKeyCode();
							for(int i =0;i<6;i++) 
								if(notation.keys[i] == key) {
									isNewKey = false;
									break;
								}
							if(isNewKey)
								notation.keys[2] = key;
							panel.repaint();
						}
						@Override
						public void keyReleased(KeyEvent e)
						{}
						@Override
						public void keyTyped(KeyEvent e)
						{}
						});
		}
	}
	class Setting6RestartButton12Listener implements ActionListener{
		SettingFrame panel;
		public void actionPerformed(ActionEvent e) {
			JTextArea inputText = new JTextArea();
			panel.add(inputText);

			inputText.setSize(100,100);
			inputText.setLocation(1540,300);
			Font font1 = new Font("TimesRoman", Font.BOLD, 100);
			inputText.setFont(font1);
						inputText.addKeyListener(new KeyListener()
						{
						@Override
						public void keyPressed(KeyEvent e)
						{
							boolean isNewKey = true;
							int key =e.getKeyCode();
							for(int i =0;i<6;i++) 
								if(notation.keys[i] == key) {
									isNewKey = false;
									break;
								}
							if(isNewKey)
								notation.keys[5] = key;
							panel.repaint();
						}
						@Override
						public void keyReleased(KeyEvent e)
						{}
						@Override
						public void keyTyped(KeyEvent e)
						{}
						});
		}
	}
	class Setting5RestartButton12Listener implements ActionListener{
		
		SettingFrame panel;
		public void actionPerformed(ActionEvent e) {
			JTextArea inputText = new JTextArea();
			panel.add(inputText);

			inputText.setSize(100,100);
			inputText.setLocation(1267,522);
			Font font1 = new Font("TimesRoman", Font.BOLD, 100);
			inputText.setFont(font1);
						inputText.addKeyListener(new KeyListener()
						{
						@Override
						public void keyPressed(KeyEvent e)
						{
							boolean isNewKey = true;
							int key =e.getKeyCode();
							for(int i =0;i<6;i++) 
								if(notation.keys[i] == key) {
									isNewKey = false;
									break;
								}
							if(isNewKey)
								notation.keys[4] = key;
							panel.repaint();
						}
						@Override
						public void keyReleased(KeyEvent e)
						{}
						@Override
						public void keyTyped(KeyEvent e)
						{}
						});
		}
	}
	class Setting4RestartButton12Listener implements ActionListener{
		SettingFrame panel;
		public void actionPerformed(ActionEvent e) {
			JTextArea inputText = new JTextArea();
			panel.add(inputText);

			inputText.setSize(100,100);
			inputText.setLocation(1020,530);
			Font font1 = new Font("TimesRoman", Font.BOLD, 100);
			inputText.setFont(font1);
						inputText.addKeyListener(new KeyListener()
						{
						@Override
						public void keyPressed(KeyEvent e)
						{
							boolean isNewKey = true;
							int key =e.getKeyCode();
							for(int i =0;i<6;i++) 
								if(notation.keys[i] == key) {
									isNewKey = false;
									break;
								}
							if(isNewKey)
								notation.keys[3] = key;
							panel.repaint();
						}
						@Override
						public void keyReleased(KeyEvent e)
						{}
						@Override
						public void keyTyped(KeyEvent e)
						{}
						});
		}
	}
	

}
