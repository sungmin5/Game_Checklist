package checklists;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

public class CheckList1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	 */
	public CheckList1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 469, 651);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Level 1 -10 Daily Missions");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(40, 27, 347, 52);
		frame.getContentPane().add(lblNewLabel);
		
		JCheckBox ckbox_basicTutorial = new JCheckBox("Complete Basic Tutorial");
		ckbox_basicTutorial.setBounds(46, 114, 144, 23);
		frame.getContentPane().add(ckbox_basicTutorial);
		
		JCheckBox ckbox_discoverVillage = new JCheckBox("Talk to all the NPCs in the village");
		ckbox_discoverVillage.setBounds(46, 163, 209, 23);
		frame.getContentPane().add(ckbox_discoverVillage);
		
		JCheckBox ckbox_weaponNPCreq = new JCheckBox("Complete the weapon NPC's quest");
		ckbox_weaponNPCreq.setBounds(46, 211, 209, 23);
		frame.getContentPane().add(ckbox_weaponNPCreq);
		
		JCheckBox ckbox_potionNPCreq = new JCheckBox("Complete the potion NPC's quest");
		ckbox_potionNPCreq.setBounds(46, 260, 209, 23);
		frame.getContentPane().add(ckbox_potionNPCreq);
		
		JCheckBox ckbox_killSqrls = new JCheckBox("Kill 100 squirrels ");
		ckbox_killSqrls.setBounds(257, 114, 165, 23);
		frame.getContentPane().add(ckbox_killSqrls);
		
		JCheckBox ckbox_killSlimes = new JCheckBox("Kill 100 slimes");
		ckbox_killSlimes.setBounds(257, 163, 99, 23);
		frame.getContentPane().add(ckbox_killSlimes);
		
		JCheckBox ckbox_rideHorse = new JCheckBox("Learn how to ride a horse");
		ckbox_rideHorse.setBounds(257, 211, 153, 23);
		frame.getContentPane().add(ckbox_rideHorse);
		
		JCheckBox ckbox_scorpionDngnQuest = new JCheckBox("Enter the scorpion dungeon \r\nand 50 shells");
		ckbox_scorpionDngnQuest.setHorizontalAlignment(SwingConstants.LEFT);
		ckbox_scorpionDngnQuest.setVerticalAlignment(SwingConstants.TOP);
		ckbox_scorpionDngnQuest.setBounds(257, 260, 153, 77);
		frame.getContentPane().add(ckbox_scorpionDngnQuest);
	}
}
