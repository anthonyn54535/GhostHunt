import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Ghost{
	private Image img; 	
	private AffineTransform tx;
	int width, height;
	int x, y;						//position of the object
	int vx, vy;						//movement variables
	double scaleWidth = .3;		 //change to scale image
	double scaleHeight = .3; //change to scale image

	public Ghost(String filename) {
		img = getImage("/imgs/"+filename); //load the image for Tree

		//alter these
		width = 50;
		height = 50;
		x = (int)(Math.random()*(500-100)+100);
		y = (int)(Math.random()*(500-100)+100);
		vx = (int)(Math.random()*(10)+2);
		vy = (int)(Math.random()*(10)+2);
		
		
		
		tx = AffineTransform.getTranslateInstance(0, 0);
		init(x, y); 				//initialize the location of the image
									//use your variables
	}
	
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(0, 0);
	}
	
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		
		x+=vx;
		y+=vy;
		//make ghost bounce
		if(x>=800) {
			vx*=-1;
		}
		if(x<=0) {
			vx*=-1;
		}
		if(y<=0) {
			vy*=-1;
		}
		if(y>=500) {
			vy*=-1;
		}
		
		
		
		init(x,y);
		g2.drawImage(img, tx, null);

	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(scaleWidth, scaleHeight);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Ghost.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
