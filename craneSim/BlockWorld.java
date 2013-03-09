package craneSim;

import java.util.*;
import java.awt.Rectangle;
import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.RectangularShape;
import java.awt.geom.Rectangle2D;
import java.awt.Shape;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.AffineTransform;

public class BlockWorld implements Displayable{

    private static int ground = 380;
    private Block block1;
    private Block block2;
    private Block block3;
    private Block block4;
    private Block block5;
    private Block block6;
    private Block block7;
    private Block block8;
    private Block block9;
    private Vector<DisplayableObject> blocks;

    class Block extends DisplayableObject{

	Block(int x, int y, int w, int h){	

	    super();
	    frame = new Rectangle2D.Double(x, y, w, h);
	    width = w;
	    height = h;
	    myTransform = new AffineTransform();	
	}	

	public void drawStuff(Graphics2D g2){
	   
	    if(onMagnet){
		return;
	    }

	    g2.transform(myTransform);
	    positionInCrane.concatenate(g2.getTransform());
	    	    
	    g2.setColor(Color.RED);
	    g2.fillRect(0, 0, width, height);	   
	    g2.setColor(Color.BLACK);
	    g2.drawRect(0, 0, width, height);
	}

    }

    BlockWorld(){
	
	super();
	block1 = new Block(300, 350, 90, 30);
	block2 = new Block(300, 290, 30, 60);
	block3 = new Block(360, 290, 30, 60);
	block4 = new Block(300, 260, 90, 30);
	block5 = new Block(390, 300, 120, 20);
	block6 = new Block(390, 320, 30, 60);
	block7 = new Block(480, 320, 30, 60);
	block8 = new Block(420, 280, 40, 20);
	block9 = new Block(430, 340, 40, 60);

	blocks = new Vector<DisplayableObject>(9);

	blocks.add(block1);
	blocks.add(block2);
	blocks.add(block3);
	blocks.add(block4);
	blocks.add(block5);
	blocks.add(block6);
	blocks.add(block7);
	blocks.add(block8);
	blocks.add(block9);
    }

    public void drawStuff(Graphics2D g2){

	g2.setColor(Color.BLACK);
	g2.fillRect(0, 0, 650, 450);
	g2.setColor(Color.BLACK);
	g2.drawRect(0, 0, 650, 450);

	for(int i = 0; i < blocks.size(); i++){

	    if(blocks.get(i).isOnMagnet()) continue;
	    Shape curShape = blocks.get(i).getFrame();
	    Rectangle2D boundingBox = (Rectangle2D)curShape;

	    g2.setColor(Color.WHITE);
	    g2.fillRect((int)boundingBox.getX(), (int)boundingBox.getY(),
	                (int)boundingBox.getWidth(), (int)boundingBox.getHeight());
	   
	    g2.setColor(Color.BLUE);
	    g2.drawRect((int)boundingBox.getX(), (int)boundingBox.getY(),
	       	        (int)boundingBox.getWidth(), (int)boundingBox.getHeight());

	}

	g2.setColor(Color.GRAY);
	g2.fillRect(0, 380, 650, 70);
	g2.setColor(Color.BLACK);
	g2.drawRect(0, 380, 650, 70);

    }

    public Vector<DisplayableObject> getBlocks(){
	return blocks;
    }

    public void blockWorldAdd(Rectangle2D newFrame, boolean successfulRemoval){

	for(int i = 0; i < blocks.size(); i++){
	    
	    if(blocks.get(i).isOnMagnet()){
		blocks.get(i).setMagnet(false);
		if(successfulRemoval){

		    Rectangle2D blockFrame = (Rectangle2D)blocks.get(i).getFrame();
		    double translateX = newFrame.getX() - blockFrame.getX();
		    double translateY = newFrame.getY() - blockFrame.getY();		    
		    blocks.get(i).getMyTransform().translate(translateX, translateY);		    
		    blockFrame.setRect(newFrame.getX(), ground - blocks.get(i).getHeight(), blocks.get(i).getWidth(), blocks.get(i).getHeight());

		}
		break;
	    }
	}
    }

    public void blockWorldRemove(int i){

	blocks.get(i).setMagnet(true);
    }
}