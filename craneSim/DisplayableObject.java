package craneSim;

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics2D;
import java.awt.Color;

public class DisplayableObject implements Displayable{

	protected Shape frame;
        protected AffineTransform myTransform = new AffineTransform();
        protected AffineTransform positionInCrane = new AffineTransform();
	protected Point2D anchor;
	protected Color drawMeIn;
	protected int width;
	protected int height;
	protected double angle = 0.0;
        protected boolean onMagnet = false;
        protected boolean isBlock = false;
	
	public Shape getFrame(){
		
		return frame;
	}

    public void setBlock(){
	isBlock = true;
    }

    public boolean isOnMagnet(){
	return onMagnet;
    }

    public void setMagnet(boolean mag){
	onMagnet = mag;
    }

    public int getWidth(){
	return width;
    }

    public int getHeight(){
	return height;
    }

	public AffineTransform getMyTransform(){
		
		return myTransform;
	}
	
	public AffineTransform getPositionInCrane(){
		
		return positionInCrane;
	}
	
	public double getAnchorX(){
		
		return anchor.getX();
	}

	public double getAnchorY(){
		
		return anchor.getY();
	}

	public void drawStuff(Graphics2D g2){
		
		
	}
}
