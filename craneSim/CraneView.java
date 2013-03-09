package craneSim;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JComponent;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.util.*;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.geom.AffineTransform;

public class CraneView extends JComponent{

    private Crane crane;
    private BlockWorld blocks;
	
    CraneView(Crane c, BlockWorld b){
		
		super();
		crane = c;
		blocks = b;

		/* grab some mice to listen */
		MouseMotionListener hungryRat = new MouseMotionListener(){
		
			public void mouseDragged(MouseEvent e){
		
				/* get location of mouse */
				Point2D mousePoint = new Point2D.Double(e.getX(), e.getY());
				
				crane.notify(mousePoint);
				repaint();
			}			
			
			public void mouseMoved(MouseEvent e){
				
			}
		};
		addMouseMotionListener(hungryRat);
		
		MouseListener boredRat = new MouseListener(){
			
			public void mousePressed(MouseEvent e){
			    crane.notifyPress(e.getX());
			}
			
			public void mouseEntered(MouseEvent e){
				
			}
			
			public void mouseExited(MouseEvent e){
				
			}
			
			public void mouseReleased(MouseEvent e){
				
			}
			
			public void mouseClicked(MouseEvent e){
			
			    Point2D mouseCoordinates = new Point2D.Double(e.getX(), e.getY());
			    if(crane.inMagnet(mouseCoordinates)){

				if(crane.holdingBlock()){
				    crane.removeBlock();
				    repaint();
				    return;
				}
				
				crane.grabBlock();
				repaint();
			    }
				    
			}
				
		};
		addMouseListener(boredRat);
	}
	
		
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		AffineTransform savedAt = g2.getTransform();
		blocks.drawStuff(g2);

		g2.setTransform(savedAt);
		crane.drawStuff(g2);
		
	}
	
}
