import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	
	//frame width/height
	int width = 900;
	int height = 600;
	
	long timer = 0; //animation timer ------
	long time = 10; // actual wave/level timer
	long newTime = 0;
	
	boolean lose = false;
	
	Font timerFont = new Font("Courier", Font.BOLD, 40);

	int z = 0;

	int level = 0;
	
	int score = 0;
	
	Music shot = new Music("RLGRR.wav", false);
	Music blud = new Music("RLBLUD.wav", false);
	Music backgroundMusic = new Music("Luigi's Mansion theme song.wav", false);
	
	
	
	//Add your object declaration and instantiations here
	Background b = new Background("luigiMansion.gif");
	Ghost ghostA = new Ghost("ghost - Pixel.png");
	Ghost ghostB = new Ghost("ghost - Pixel.png");
	Ghost ghostC = new Ghost("ghost - Pixel.png");
	Ghost ghostD = new Ghost("ghost - Pixel.png");
	Ghost ghostE = new Ghost("ghost - Pixel.png");
	GhostDead corpse = new GhostDead ("ghostDead.png");
	Luigi luigi = new Luigi ("newLuigi.png");
	EndLuigi endLuigi = new EndLuigi ("LUIGIGIF.gif.gif");
	Table table = new Table ("table - Pixel (1).png");
	Balloons balloons = new Balloons ("balloon.png");
	Stats stats = new Stats("statsBackground.png");
	GhostStats sGhost1 = new GhostStats ("ghost - Pixel.png");
	GhostStats sGhost2 = new GhostStats ("ghost - Pixel.png");
	GhostStats sGhost3 = new GhostStats ("ghost - Pixel.png");
	GhostStats sGhost4 = new GhostStats ("ghost - Pixel.png");
	GhostStats sGhost5 = new GhostStats ("ghost - Pixel.png");
	PlayAgain playAgain = new PlayAgain ("newPlayAgain.png");
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		//Call the paint method of your objects here
		b.paint(g);
		ghostA.paint(g);
		ghostB.paint(g);
		ghostC.paint(g);
		ghostD.paint(g);
		ghostE.paint(g);
		balloons.paint(g);
		table.paint(g);
		stats.paint(g);
		sGhost1.paint(g);
		sGhost2.paint(g);
		sGhost3.paint(g);
		sGhost4.paint(g);
		sGhost5.paint(g);
		luigi.paint(g);
		corpse.paint(g);
		playAgain.paint(g);
		
		
		timer += 20;
		if(timer%1000 == 0) {
			time--;
		}

		g.setColor(Color.white);
		g.setFont(timerFont);
		g.drawString(""+time,820,35);
		
		g.setColor(Color.white);
		g.drawString("Score: "+ score, 10, 35);
		g.drawString("Level: "+ level, 600,35);
		
		if(time == 0 && level<6 || lose) {
			time =0;
			timer = 0;
				endLuigi.paint(g);
				g.drawString("You Lost! ", 380, 200);
				g.drawString("Score: " + score, 370,300);
				sGhost1.x = -100;
				sGhost2.x = -100;
				sGhost3.x = -100;
				sGhost4.x = -1000;
				sGhost5.x = -100;
				ghostA.x = -100;
				ghostB.x = -100;
				ghostC.x = -100;
				ghostD.x = -100;
				ghostE.x = -100;
				playAgain.x = 330;
				luigi.x = -300;
				corpse.x = -100;
		}else if(level == 7&&score>0){	
				endLuigi.paint(g);
				g.drawString("You Won! ",380,200);
				g.drawString("Score: " + score, 370,300);
				sGhost1.x = -100;
				sGhost2.x = -100;
				sGhost3.x = -100;
				sGhost4.x = -1000;
				sGhost5.x = -100;
				ghostA.x = -100;
				ghostB.x = -100;
				ghostC.x = -100;
				ghostD.x = -100;
				ghostE.x = -100;
				playAgain.x = 330;
				luigi.x = -300;
				corpse.x = -100;
		}else if(level == 7 &&score<0){
			endLuigi.paint(g);
			g.drawString("You Lost! ", 380, 200);
			g.drawString("Score: " + score, 370,300);
			sGhost1.x = -100;
			sGhost2.x = -100;
			sGhost3.x = -100;
			sGhost4.x = -1000;
			sGhost5.x = -100;
			ghostA.x = -100;
			ghostB.x = -100;
			ghostC.x = -100;
			ghostD.x = -100;
			ghostE.x = -100;
			playAgain.x = 330;
			luigi.x = -300;
			corpse.x = -100;
		}else {
		
		}
			
		

		if(sGhost1.x == -100 && sGhost2.x == -100 && sGhost3.x == -100 && sGhost4.x == -100) {
			sGhost1.x = 300 +30;
			sGhost2.x = 350+30;
			sGhost3.x = 400+30;
			sGhost4.x = 450+30;
			sGhost5.x = 500+30;

			ghostA.x = (int)(Math.random()*(500-100)+100);
			ghostA.y = (int)(Math.random()*(500-100)+100);
			ghostB.x = (int)(Math.random()*(500-100)+100);
			ghostC.y = (int)(Math.random()*(500-100)+100);	ghostB.x = (int)(Math.random()*(500-100)+100);
			ghostD.y = (int)(Math.random()*(500-100)+100);	ghostC.x = (int)(Math.random()*(500-100)+100);
			ghostE.y = (int)(Math.random()*(500-100)+100);	ghostD.x = (int)(Math.random()*(500-100)+100);
			ghostE.x = (int)(Math.random()*(500-100)+100);
			level++;
			z=0;
			time=10;
			time = time-level;
		}
			
		
	//each wave has 5 ghosts
	//decrease time each wave
		//write different if statements for each level
		
	
	
		
		
	}
	
	public static void main(String[] arg) {
		Frame f = new Frame();
		
	}
	
	public Frame() {
		JFrame f = new JFrame("Duck Hunt");
		f.setSize(new Dimension(width, height));
		f.setBackground(Color.blue);
		f.add(this);
		f.setResizable(false);
 		f.addMouseListener(this);
		f.addKeyListener(this);
		//cursor imge outside of the src folder
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("crosshair.png").getImage(),
				new Point(0,0), "custom cursor"));
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		backgroundMusic.play();
	
		sGhost1.x = 300 +30;
		sGhost2.x = 350+30;
		sGhost3.x = 400+30;
		sGhost4.x = 450+30;
		sGhost5.x = 500+30;

	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent m) {
		// TODO Auto-generated method stub
		System.out.println(m.getX()+":"+m.getY());
		
		
		//perform a Rectangle collision for the two objects
		//
		Rectangle a = new Rectangle(m.getX(),m.getY(),50,50);
		
		//represent the 2nd object as a Rectangle
		Rectangle b = new Rectangle(ghostA.x, ghostA.y,ghostA.width,ghostA.height); //x,y,width,height
		Rectangle c = new Rectangle(ghostB.x, ghostB.y,ghostB.width,ghostB.height);
		Rectangle d = new Rectangle(ghostC.x, ghostC.y,ghostC.width,ghostC.height);
		Rectangle e = new Rectangle(ghostD.x, ghostD.y,ghostD.width,ghostD.height);
		Rectangle f = new Rectangle(ghostE.x, ghostE.y,ghostE.width,ghostE.height);
		Rectangle stat = new Rectangle(stats.x, stats.y, stats.width,stats.height);
		Rectangle pA = new Rectangle (playAgain.x, playAgain.y, playAgain.width, playAgain.height);
		Rectangle endBalloon = new Rectangle (balloons.x+30, balloons.y+40, balloons.width, balloons.height);
		//print the valeus of the Rectangle to confirm they're all sensical vlaues!
		System.out.println("mouse: " +a);
		System.out.println("mouse: " +b);
		System.out.println("mouse: " +c);
		System.out.println("mouse: " +d);
		System.out.println("mouse: " +e);
		System.out.println("mouse: " +f);

		//intersection with stats bar
		
		//use built-in intersect method of a rectangle
		if(a.intersects(endBalloon)) {
			lose = true;
		}
		if(a.intersects(pA)) {
			sGhost1.x = 300 +30;
			sGhost2.x = 350+30;
			sGhost3.x = 400+30;
			sGhost4.x = 450+30;
			sGhost5.x = 500+30;
			ghostA.x = (int)(Math.random()*(500-100)+100);
			ghostA.y = (int)(Math.random()*(500-100)+100);
			ghostB.x = (int)(Math.random()*(500-100)+100);
			ghostC.y = (int)(Math.random()*(500-100)+100);	ghostB.x = (int)(Math.random()*(500-100)+100);
			ghostD.y = (int)(Math.random()*(500-100)+100);	ghostC.x = (int)(Math.random()*(500-100)+100);
			ghostE.y = (int)(Math.random()*(500-100)+100);	ghostD.x = (int)(Math.random()*(500-100)+100);
			ghostE.x = (int)(Math.random()*(500-100)+100);
			balloons.x = 100;
			balloons.y = 300;
			z=0;
			time=10;
			playAgain.x = -500;
			level = 0;
			score = 1000;
			lose = false;
			
			//reset stat ghosts
			//reset all ghosts
			//score = 0
			//reset timer = 60
			//reset level
		}
		
		if(a.intersects(b)) {
			System.out.println("COLLISION!!");
				corpse.x= ghostA.x + 60;
				corpse.y = ghostA.y;
				luigi.x = ghostA.x;
				luigi.y = 500;
				score +=1000;
				ghostA.x = -100; //teleport the ghost to
				blud.play();
		}
		else if(a.intersects(c)) {
			System.out.println("COLLISION!!");
				corpse.x= ghostB.x + 60;
				corpse.y = ghostB.y;
				luigi.x = ghostB.x;
				luigi.y = 500;
				score +=1000;
				ghostB.x = -100; //teleport the ghost to
				blud.play();
		}
		else if(a.intersects(d)) {
			System.out.println("COLLISION!!");
				corpse.x= ghostC.x + 60;
				corpse.y = ghostC.y;
				luigi.x = ghostC.x;
				luigi.y = 500;
				score +=1000;
				ghostC.x = -100; //teleport the ghost to
				blud.play();
		}
		else if(a.intersects(e)) {
			System.out.println("COLLISION!!");
				corpse.x = ghostD.x + 60;
				corpse.y = ghostD.y;
				luigi.x = ghostD.x;
				luigi.y = 500;
				score +=1000;
				ghostD.x = -100; //teleport the ghost to
				blud.play();
		}
		else if(a.intersects(f)) {
			System.out.println("COLLISION!!");
				corpse.x= ghostE.x + 60;
				corpse.y = ghostE.y;
				luigi.x = ghostE.x;
				luigi.y = 500;
				score +=1000;
				ghostE.x = -100; //teleport the ghost to
				blud.play();
		}else {
			shot.play();
			score -= 1000;
		}
		
		if((a.intersects(b)||a.intersects(c)||a.intersects(d)||a.intersects(e)||a.intersects(f))&&z==4) {
			sGhost1.x =-100;
			
		}
		else if((a.intersects(b)||a.intersects(c)||a.intersects(d)||a.intersects(e)||a.intersects(f))&&z==3) {
			sGhost2.x =-100;
			z++;
		}
		else if((a.intersects(b)||a.intersects(c)||a.intersects(d)||a.intersects(e)||a.intersects(f))&&z==2) {
			sGhost3.x =-100;
			z++;
		}
		else if((a.intersects(b)||a.intersects(c)||a.intersects(d)||a.intersects(e)||a.intersects(f))&&z==1) {
			sGhost4.x =-100;
			z++;
			System.out.print("shot1");
		}
		else if((a.intersects(b)||a.intersects(c)||a.intersects(d)||a.intersects(e)||a.intersects(f))&&z==0) {
			sGhost5.x =-100;
			z++;
			System.out.print("shot1");
		}
	
		
	
	
		
		
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
