package com.java.spec.tiennv.thread;

import javax.swing.JApplet;
import javax.swing.JLabel;

public class FlashingText extends JApplet implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel jlabel = new JLabel("Hello World", JLabel.CENTER);

	public FlashingText() {
		add(jlabel);
	}
	
	@Override
	public void run() {
		try {
			
			while (true) {
				if (jlabel.getText() == null) {
					jlabel.setText("Hello World");
				} else {
					jlabel.setText(null);
				}
				Thread.sleep(2000);
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main (String[] args) {
		
	}

}
