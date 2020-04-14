package checklists;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class CheckList1  {

	private JFrame frame;
	private JLabel lblClock;
	private JCheckBox[] ckboxes = new JCheckBox[8];
	private Font font_strike_red;
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
	}
	
	/*
	 * showTime(): show the current time.
	 * */
	public void showTime() {
		new Thread() {
			public void run() {
				// loop forever
				
				int secHolder =0;
				while(true) 
	            {
					// get current time. 
	                Calendar cal = new GregorianCalendar();
	                int hour = cal.get(Calendar.HOUR_OF_DAY);
	                int min = cal.get(Calendar.MINUTE);
	                int sec = cal.get(Calendar.SECOND);
	                
	             
	                if(secHolder == 0) {
	                	secHolder = sec;
	                } else if (sec == (secHolder + 5)){
	                	secHolder = sec;
	                	//resetCheckboxes();
	                	saveData();
	                }
	                
	                String day = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.getDefault());
	                
	                // format the string in military time
	                String time = String.format("%02d",hour) + ":" + String.format("%02d",min) + ":" + String.format("%02d",sec) + ":" + day;
	                
	                // show the current time
	                lblClock.setText(time);
	        
	            } //end while
			} //run
		}.start();
	}// showTime
	
	
	/*
	 * resetCheckboxes(): reset all checkboxes
	 * */
	public void resetCheckboxes() {
		for(int i = 0; i < ckboxes.length ; i++) {
			ckboxes[i].setSelected(false);
		}
	}// resetCheckboxes
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//initialize font
		getFont();
		
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
		
		// back home button.
		JButton btnNewButton = new JButton("Go Back Home");
		btnNewButton.setBounds(267, 344, 131, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveData();
				//Create new Home page and open
				HomeScreen newHome = new HomeScreen();
				newHome.setVisible(true);
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		// Show Date and Time
		lblClock = new JLabel("clock");
		lblClock.setBounds(40, 348, 90, 14);
		frame.getContentPane().add(lblClock);
		
		//load saved data
		loadData();
	}
	/*
	 * Iterate through the check boxes and select them if reads true. 
	 * */
	public void loadData() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Sung Min\\Desktop\\GameChecker\\Game_Checklist\\GameChecker\\src\\checklists\\level1.txt"));
			for(int i = 0; i < ckboxes.length ; i++) {
				final int j = i;
				// initialize on click action. 
				ckboxes[j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//Create new Home page and open
						if(ckboxes[j].isSelected()==true) {
							ckboxes[j].setFont(font_strike_red);
							ckboxes[j].setForeground(Color.RED);
						}
						else {
							ckboxes[j].setFont(new Font("helvetica", Font.PLAIN, 12));
							ckboxes[j].setForeground(Color.BLACK);
						}
					}
				});
				// click the check box if the file reads True. 
				if(Boolean.parseBoolean(br.readLine())) {
					ckboxes[j].doClick();
				}
			}
		} catch(Exception e) {}
	}
	/*
	 * Iterate through the checkboxes and save each isSelected value. 
	 * */
	public void saveData() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Sung Min\\Desktop\\GameChecker\\Game_Checklist\\GameChecker\\src\\checklists\\level1.txt"));
			for(int i = 0; i < ckboxes.length ; i++) {
				if(ckboxes[i].isSelected()) {
					bw.write("true");
				}else {
					bw.write("false");
				}
				bw.newLine();
			}
			bw.close();
		} catch(Exception e) {
		}
	}
	public void getFont() {
		// New font with strike
		Font font_strike = new Font("helvetica", Font.PLAIN, 12);
		Map  attributes = font_strike.getAttributes();
		attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
		font_strike_red = new Font(attributes);
	}

}
