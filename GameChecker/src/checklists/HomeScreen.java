package checklists;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

public class HomeScreen extends JFrame {
	
	private MyPanel contentPane;
	private BufferedImage img;
	
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
		// add background image
		try {
            img = ImageIO.read(new File("C:\\Users\\Sung Min\\Desktop\\GameChecker\\Game_Checklist\\GameChecker\\src\\images\\home-image.jpg"));
        } catch(IOException e) {
            e.printStackTrace();
        }
		
		// add a panel
		contentPane= new MyPanel();
        add(contentPane);
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 200);
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
		
		JLabel lblNewLabel = new JLabel("Choose Level...", SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(160, 38, 169, 14);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(0,0,0,100));
		lblNewLabel.setOpaque(true);
		contentPane.add(lblNewLabel);
	}
	
	private class MyPanel extends JPanel{
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }
    }

}
