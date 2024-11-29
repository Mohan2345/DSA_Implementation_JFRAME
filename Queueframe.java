import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Queueframe extends JFrame {

	private JPanel contentPane;
	private JTextField queuehdfld;
	private JTextField quesztxtfld;
	private JTextField elmttxtfld;
	private JTextField dltelmnttxtfld;
	private JTextField dispqtxtfld;
	
	private int front = -1;
	private int rear = -1;
	private int size = 0;
	private int que[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Queueframe frame = new Queueframe();
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
	public Queueframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1246, 759);
		Image backgroundImage = null;
		try {
            URL imageURL = new URL("https://wallpaperaccess.com/full/2195701.jpg"); // Replace with your image URL
            backgroundImage = Toolkit.getDefaultToolkit().getImage(imageURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
		Image finalBackgroundImage = backgroundImage;
		contentPane = new JPanel() {
			protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            if (finalBackgroundImage != null) {
	                g.drawImage(finalBackgroundImage, 0, 0, getWidth(), getHeight(), this); // Draw background image
	            }
	        }
	    };

	    setExtendedState(JFrame.MAXIMIZED_BOTH); // Make the frame full screen
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		queuehdfld = new JTextField();
		queuehdfld.setBounds(505, 27, 568, 78);
		queuehdfld.setText("QUEUE DATA STRUCTURE");
		queuehdfld.setHorizontalAlignment(SwingConstants.CENTER);
		queuehdfld.setFont(new Font("Tahoma", Font.BOLD, 34));
		queuehdfld.setColumns(10);
		contentPane.add(queuehdfld);
		
		JLabel quesizelbl = new JLabel("QUEUE-SIZE");
		quesizelbl.setBounds(397, 166, 205, 64);
		quesizelbl.setHorizontalAlignment(SwingConstants.CENTER);
		quesizelbl.setForeground(new Color(255, 255, 128));
		quesizelbl.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		contentPane.add(quesizelbl);
		
		quesztxtfld = new JTextField();
		quesztxtfld.setBounds(663, 166, 205, 69);
		quesztxtfld.setHorizontalAlignment(SwingConstants.CENTER);
		quesztxtfld.setForeground(Color.BLACK);
		quesztxtfld.setFont(new Font("Tahoma", Font.BOLD, 16));
		quesztxtfld.setColumns(10);
		contentPane.add(quesztxtfld);
		
		JButton createbtn = new JButton(" CREATE");
		createbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					size = Integer.parseInt(quesztxtfld.getText().trim());
					if(size <= 0) {
						JOptionPane.showMessageDialog(null, "Size must be greater than zero.", "Error", JOptionPane.ERROR_MESSAGE); 
						return;
					}
					que = new int[size];
					front = -1;
					rear = -1;
					JOptionPane.showMessageDialog(null, "Queue of size " + size + " created."); 
					quesztxtfld.setText(""); // Clear the text field after operation
				} catch (NumberFormatException ex) { 
					JOptionPane.showMessageDialog(contentPane, "Please enter a valid size.");
				}
			}
		});
		createbtn.setBounds(925, 164, 215, 69);
		createbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		contentPane.add(createbtn);
		
		JLabel elemntlbl = new JLabel("ELEMENT");
		elemntlbl.setBounds(411, 290, 205, 64);
		elemntlbl.setHorizontalAlignment(SwingConstants.CENTER);
		elemntlbl.setForeground(new Color(255, 255, 128));
		elemntlbl.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		contentPane.add(elemntlbl);
		
		elmttxtfld = new JTextField();
		elmttxtfld.setBounds(663, 290, 205, 69);
		elmttxtfld.setHorizontalAlignment(SwingConstants.CENTER);
		elmttxtfld.setForeground(Color.BLACK);
		elmttxtfld.setFont(new Font("Tahoma", Font.BOLD, 16));
		elmttxtfld.setColumns(10);
		contentPane.add(elmttxtfld);
		
		JButton insrtbtn = new JButton("INSERT");
		insrtbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try { 
				int element = Integer.parseInt(elmttxtfld.getText()); 
				if (rear == size - 1) { 
					JOptionPane.showMessageDialog(contentPane, "Queue is full. Cannot insert."); 
				} else { 
				    if (front == -1) front = 0; 
				    que[++rear] = element; 
				    JOptionPane.showMessageDialog(contentPane, "Element " + element + " inserted into queue."); 
				    elmttxtfld.setText(""); 
				    } 
				} catch (NumberFormatException ex) { 
					JOptionPane.showMessageDialog(contentPane, "Please enter a valid element."); 
				}
			}
		});
		insrtbtn.setBounds(925, 288, 215, 69);
		insrtbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		contentPane.add(insrtbtn);
		
		JLabel dltelmntlbl = new JLabel("ELEMENT-DELETED");
		dltelmntlbl.setBounds(361, 417, 233, 69);
		dltelmntlbl.setHorizontalAlignment(SwingConstants.CENTER);
		dltelmntlbl.setForeground(new Color(255, 255, 128));
		dltelmntlbl.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		contentPane.add(dltelmntlbl);
		
		dltelmnttxtfld = new JTextField();
		dltelmnttxtfld.setBounds(663, 419, 205, 69);
		dltelmnttxtfld.setHorizontalAlignment(SwingConstants.CENTER);
		dltelmnttxtfld.setForeground(Color.BLACK);
		dltelmnttxtfld.setFont(new Font("Tahoma", Font.BOLD, 16));
		dltelmnttxtfld.setColumns(10);
		contentPane.add(dltelmnttxtfld);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (front == -1 || front > rear) { 
					JOptionPane.showMessageDialog(null, "Queue is empty. Cannot delete."); 
					} else { 
						int deletedElement = que[front++]; 
						dltelmnttxtfld.setText(String.valueOf(deletedElement)); 
						JOptionPane.showMessageDialog(contentPane, "Element " + deletedElement + " deleted from queue."); 
						dltelmnttxtfld.setText(""); 
					}
			}
		});
		btnDelete.setBounds(925, 417, 215, 69);
		btnDelete.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		contentPane.add(btnDelete);
		
		JLabel displbl = new JLabel("QUEUE-ELEMENTS");
		displbl.setBounds(74, 526, 233, 75);
		displbl.setHorizontalAlignment(SwingConstants.CENTER);
		displbl.setForeground(new Color(255, 255, 128));
		displbl.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		contentPane.add(displbl);
		
		dispqtxtfld = new JTextField();
		dispqtxtfld.setBounds(342, 526, 637, 78);
		dispqtxtfld.setHorizontalAlignment(SwingConstants.CENTER);
		dispqtxtfld.setForeground(Color.BLACK);
		dispqtxtfld.setFont(new Font("Tahoma", Font.BOLD, 16));
		dispqtxtfld.setColumns(10);
		contentPane.add(dispqtxtfld);
		
		JButton displaybtn = new JButton("DISPLAY");
		displaybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if (front == -1) { 
				JOptionPane.showMessageDialog(null, "Queue is empty."); 
			} else { 
				StringBuilder sb = new StringBuilder(); 
				for (int i = front; i <= rear; i++) { 
					sb.append(que[i]).append(" "); 
				} 
			dispqtxtfld.setText(sb.toString()); }
			}
		});
		displaybtn.setBounds(1038, 526, 215, 75);
		displaybtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		contentPane.add(displaybtn);
		
		JButton backbtn = new JButton(" BACK");
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				DSAproject dsAproject = new DSAproject();
				dsAproject.setVisible(true);
			}
		});
		backbtn.setBounds(537, 626, 215, 69);
		backbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		contentPane.add(backbtn);
	}
}
