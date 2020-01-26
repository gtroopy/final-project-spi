import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Bomber {
	private int locX;
	private int bombX;
	private int locY;
	private int bombY;
	private double speed;
	private boolean loadDropped=false;
	private boolean wasHit=false;
	
	public Bomber(int x, int y, double s) {
		locX=x;
		locY=y;
		bombY=locY;
		bombX=locX;
		speed=s;
	}
	public void drawPlane(Graphics g) {
		if(wasHit==false) {
			g.setColor(Color.DARK_GRAY);
			if(locX+100>0)
				g.fillRect(locX, locY, 100, 40);
		}
		
	}
	public void drawBomb(Graphics g) {
		if(wasHit==false) {
			loadDropped=true;
			g.setColor(Color.BLACK);
			g.fillOval(bombX+50, bombY, 6, 12);
			speed+=.005;
			bombY+=speed;
		}
	}
	public void movePlane() {
		if(wasHit==false) {
			locX+=4;
			if(loadDropped==false)
				bombX+=4;
		}
		else {
			locX=-100;
			bombX=locX;
			loadDropped=false;
			wasHit=false;
		}
	}
	public int getX() {
		return locX;
	}
	public int getY() {
		return locY;
	}
	public void setX(int x) {
		locX=x;
		bombX=locX;
	}
	public void setY(int y) {
		locY=y;
		bombY=locY;
	}
	public void setLoadDropped(boolean b) {
		loadDropped=b;
	}
	public void setWasHit(boolean s) {
		wasHit=s;
	}
	public boolean getWasHit() {
		return wasHit;
	}
	public int getBombX() {
		return bombX;
	}
	public int getBombY() {
		return bombY;
	}
}