package craneSim;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.reflect.*;

public class CraneSim {

	public static void main(String[] args){
				
		BlockWorld blockWorld = new BlockWorld();
		Crane crane = new Crane(blockWorld);
		CraneView craneView = new CraneView(crane, blockWorld);
		
		JFrame f = new JFrame("Crane Simulation");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(650, 450);
		f.setContentPane(craneView);
		f.setVisible(true);
	}
	
}
