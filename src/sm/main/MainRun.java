package sm.main;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;

public class MainRun {
	public static void main(String[] args) {

		 MainFrame f = new MainFrame();
//		 Dimension ds=Toolkit.getDefaultToolkit().getScreenSize();
//		 f.setLocation((ds.width-400)/2,(ds.height-360)/2);
		 f.setResizable(false);
		 f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
