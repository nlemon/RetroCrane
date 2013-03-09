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

public class BlockView extends JComponent{
    
    private BlockWorld blocks;

    BlockView(){
	
	super();
	blocks = new BlockWorld();

    }

    public void paintComponent(Graphics g){

	super.paintComponent(g);
	Graphics2D g2 = (Graphics2D) g;
	blocks.drawStuff(g2);
    }
}