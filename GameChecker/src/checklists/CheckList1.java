package checklists;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class CheckList1  {

	private JFrame frame;
	private JLabel lblClock;
	private JCheckBox[] ckboxes = new JCheckBox[8];
	/**
	 * Launch the application.
	 */
	public static void checkList() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckList1 window = new CheckList1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws InterruptedException 
	 */
	public CheckList1() {
		initialize();
		showTime();
		scheduledReset();
	}
	
	/*
	 * showTime(): show the current time.
	 * */
	public void showTime() {
		new Thread() {
			public void run() {
				// loop forever
				while(true) 
	            {
					// get current time. 
	                Calendar cal = new GregorianCalendar();
	                int hour = cal.get(Calendar.HOUR_OF_DAY);
	                int min = cal.get(Calendar.MINUTE);
	                int sec = cal.get(Calendar.SECOND);
	                
	                // format the string in military time
	                String time = String.format("%02d",hour) + ":" + String.format("%02d",min) + ":" + String.format("%02d",sec);
	                
	                // show the current time
	                lblClock.setText(time);
	        
	            } //end while
			} //run
		}.start();
	}// showTime
	
	/*
	 * scheduledReset(): Reset checkboxes every 6 seconds. 
	 * */
	public void scheduledReset() {
		new Thread() {
			public void run() {
				try {
					// pause for 6 seconds
					Thread.sleep((long) (0.1*60*1000));
					// reset checkboxes
					resetCheckboxes();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}//run
		}.start();
	}//scheduledReset
	
	
	/*
	 * resetCheckboxes(): reset all checkboxes
	 * */
	public void resetCheckboxes() {
		for(int i = 0; i < ckboxes.length ; i++) {
			ckboxes[i].setSelected(false);
		}
		scheduledReset();
	}// resetCheckboxes
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 479, 463);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Level 1 -10 Daily Missions");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(40, 27, 347, 52);
		frame.getContentPane().add(lblNewLabel);
		
		
		ckboxes[0] = new JCheckBox("Complete Basic Tutorial");
		ckboxes[0].setBounds(46, 114, 144, 23);
		frame.getContentPane().add(ckboxes[0]);
		
		ckboxes[1] = new JCheckBox("Talk to all the NPCs in the village");
		ckboxes[1].setBounds(46, 163, 209, 23);
		frame.getContentPane().add(ckboxes[1]);
		
		ckboxes[2] = new JCheckBox("Complete the weapon NPC's quest");
		ckboxes[2].setBounds(46, 211, 209, 23);
		frame.getContentPane().add(ckboxes[2]);
		
		ckboxes[3] = new JCheckBox("Complete the potion NPC's quest");
		ckboxes[3].setBounds(46, 260, 209, 23);
		frame.getContentPane().add(ckboxes[3]);
		
		ckboxes[4] = new JCheckBox("Kill 100 squirrels ");
		ckboxes[4].setBounds(257, 114, 165, 23);
		frame.getContentPane().add(ckboxes[4]);
		
		ckboxes[5] = new JCheckBox("Kill 100 slimes");
		ckboxes[5].setBounds(257, 163, 99, 23);
		frame.getContentPane().add(ckboxes[5]);
		
		ckboxes[6] = new JCheckBox("Learn how to ride a horse");
		ckboxes[6].setBounds(257, 211, 153, 23);
		frame.getContentPane().add(ckboxes[6]);
		
		ckboxes[7] = new JCheckBox("Enter the scorpion dungeon \r\nand 50 shells");
		ckboxes[7].setHorizontalAlignment(SwingConstants.LEFT);
		ckboxes[7].setVerticalAlignment(SwingConstants.TOP);
		ckboxes[7].setBounds(257, 260, 153, 77);
		frame.getContentPane().add(ckboxes[7]);
		
		JButton btnNewButton = new JButton("Go Back Home");
		btnNewButton.setBounds(267, 344, 131, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Create new Home page and open
				HomeScreen newHome = new HomeScreen();
				newHome.setVisible(true);
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		lblClock = new JLabel("clock");
		lblClock.setBounds(40, 348, 49, 14);
		frame.getContentPane().add(lblClock);
		
		
	}
}
