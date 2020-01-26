import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Tank {
	private Color color;
	private int thex;
	private int they;
	
	public Tank(Color c, int l, int x, int y) {
		color=c;
		they=y;
		thex=x;
	}
	public void drawTank(Graphics g) {
		g.setColor(color);
		g.fillRect(thex, they, 100, 70);
	}
	public void moveRight() {
		thex+=2;
	}
	public void moveLeft() {
		thex-=2;
	}
	public int getX() {
		return thex;
	}
	public void drawShot(Graphics g, int finX, int finY) {
		g.setColor(Color.GREEN);
		g.drawLine(thex+50, they, thex+50, 0);
		
	}
	public boolean checkHit(Bomber omb) {
		if(thex+50>=omb.getX()&&thex+50<=omb.getX()+100)
			return true;
		return false;
	}
}
