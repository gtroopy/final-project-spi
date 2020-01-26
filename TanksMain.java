import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class TanksMain extends JPanel implements ActionListener, MouseMotionListener, KeyListener, MouseListener {
	private JFrame frame = new JFrame("Tanks");
	private JButton how = new JButton("How to Play");
	private JButton start = new JButton("Start Single-Player Game");
	private JLabel howto = new JLabel("Use your mouse to aim and the left and right arrows to move.");
	private JButton back = new JButton("Back to Main Menu");
	private boolean go=false;
	private Tank p1 = new Tank(Color.RED, 1, 650, 680);
	private Timer t = new Timer(16, this);
	private boolean right=false;
	private boolean left=false;
	private int mouseX;
	private int mouseY;
	private boolean shootTime=false;
	private int counter;
	private boolean planeOn=true;
	private Bomber b=new Bomber(0, (int) ((75 - 50 + 1) * Math.random() + 50), .01);
	private boolean bombTime=false;
	private int score=0;
	
	public TanksMain() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container canvas = frame.getContentPane();
		this.setPreferredSize(new Dimension(1400, 800));
		
		start.addActionListener(this);
		how.addActionListener(this);
		back.addActionListener(this);
		this.add(how);
		this.add(start);
		frame.addKeyListener(this);
		frame.addMouseListener(this);
		
		canvas.add(this);
		frame.pack();
		
		this.setOpaque(true);
		
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
	public void paintComponent(Graphics g) {
		Color one=new Color(64, 56, 34);
		if(go==true) {
			g.setColor(one);
			g.fillRect(0, 700, 1400, 100);
			p1.drawTank(g);
			if(shootTime) {
				p1.drawShot(g, mouseX, mouseY);
				b.setWasHit(p1.checkHit(b));
				if(b.getWasHit())
					score+=10;
			}
			if(planeOn==true) {
				b.drawPlane(g);
				if(Math.random()<.001) {
					bombTime=true;
				}
				if(bombTime) {
					b.drawBomb(g);
					if((b.getBombX()>=p1.getX()&&b.getBombX()<=p1.getX()+94)&&(b.getBombY()+12>=680&&b.getBombY()<=750)) {
						go=false;
						t.stop();
				}
				if(b.getX()>getWidth()) {
					b=new Bomber(0, (int) ((75 - 50 + 1) * Math.random() + 50), .01);
					bombTime=false;
				}
			}
			}
		}
		
		repaint();
	}
	
	public static void main(String[] args) {
		new TanksMain();
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source.equals(how)) {
			how.setVisible(false);
			start.setVisible(false);
			this.add(howto);
			howto.setVisible(true);
			this.add(back);
			back.setVisible(true);
		}
		else if(source.equals(back)) {
			start.setVisible(true);
			how.setVisible(true);
			howto.setVisible(false);
			back.setVisible(false);
		}
		else if(source.equals(start)) {
			t.start();
			start.setVisible(false);
			how.setVisible(false);
			howto.setVisible(false);
			go=true;
			frame.setFocusable(true);
		}
		else if(source.equals(t)) {
			score++;
			counter++;
			if(left) {
				p1.moveLeft();
			}
			if(right) {
				p1.moveRight();
			}
			if(counter%5==0)
				shootTime=false;
			b.movePlane();
			frame.setTitle("Score: " + score);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		mouseX=e.getX();
		mouseY=e.getY();
		shootTime=true;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		int source = e.getKeyCode();
		if(source == KeyEvent.VK_LEFT)
			left=true;
		if(source == KeyEvent.VK_RIGHT)
			right=true;
		
	}

	public void keyReleased(KeyEvent e) {
		int source = e.getKeyCode();
		if(source == KeyEvent.VK_LEFT)
			left=false;
		if(source == KeyEvent.VK_RIGHT)
			right=false;
		
	}
}
