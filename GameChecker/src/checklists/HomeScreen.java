package checklists;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class HomeScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeScreen frame = new HomeScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomeScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Level 1-10");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckList1 lvl1_10list = new CheckList1();
				lvl1_10list.checkList();
				setVisible(false);
				
			}
		});
		btnNewButton.setBounds(67, 93, 113, 23);
		contentPane.add(btnNewButton);
		
		JButton btnLevel_1 = new JButton("Level 11-20");
		btnLevel_1.setBounds(190, 93, 113, 23);
		contentPane.add(btnLevel_1);
		
		JButton btnLevel = new JButton("Level 21-30");
		btnLevel.setBounds(313, 93, 113, 23);
		contentPane.add(btnLevel);
		
		JLabel lblNewLabel = new JLabel("Choose Level...");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(47, 38, 109, 14);
		contentPane.add(lblNewLabel);
	}

}
