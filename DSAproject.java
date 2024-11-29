import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class DSAproject extends JFrame {

	private JPanel contentPane;
	private JTextField txtDataStructure;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DSAproject frame = new DSAproject();
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
	 

    
	public DSAproject() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1405, 882);
		
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
    contentPane.setLayout(null); // Use absolute layout for placing components

    setExtendedState(JFrame.MAXIMIZED_BOTH); // Make the frame full screen
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		JButton btnNewButton = new JButton("ARRAY");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Arrayframe arr = new Arrayframe();
				arr.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton.setBounds(396, 225, 328, 68);
		contentPane.add(btnNewButton);
		
		JButton btnStack = new JButton(" STACK");
		btnStack.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnStack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Stackframe sf = new Stackframe();
				sf.setVisible(true);
			}
		});
		btnStack.setBounds(856, 225, 337, 68);
		contentPane.add(btnStack);
		
		JButton btnQueue = new JButton(" QUEUE");
		btnQueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Queueframe qfr = new Queueframe();
 				qfr.setVisible(true);
			}
		});
		btnQueue.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnQueue.setBounds(396, 409, 328, 68);
		contentPane.add(btnQueue);
		
		JButton btnSinglyLinkedList = new JButton(" SINGLY LINKED LIST");
		btnSinglyLinkedList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 setVisible(false);
				 SinglyllFrame sll = new SinglyllFrame();
				 sll.setVisible(true);
			}
		});
		btnSinglyLinkedList.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnSinglyLinkedList.setBounds(396, 589, 328, 68);
		contentPane.add(btnSinglyLinkedList);
		
		JButton btnCircularQueue = new JButton("CIRCULAR QUEUE");
		btnCircularQueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Circularque cqu = new Circularque();
  				cqu.setVisible(true);
			}
		});
		btnCircularQueue.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnCircularQueue.setBounds(856, 409, 337, 68);
		contentPane.add(btnCircularQueue);
		
		JButton btnDoublyLinkedList = new JButton(" DOUBLY LINKED LIST");
		btnDoublyLinkedList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				DoublyLinkedListFrame dlf = new DoublyLinkedListFrame();
  				dlf.setVisible(true);
			}
		});
		btnDoublyLinkedList.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnDoublyLinkedList.setBounds(856, 589, 337, 68);
		contentPane.add(btnDoublyLinkedList);
		
		txtDataStructure = new JTextField();
		txtDataStructure.setForeground(new Color(128, 0, 255));
		txtDataStructure.setHorizontalAlignment(SwingConstants.CENTER);
		txtDataStructure.setFont(new Font("Tahoma", Font.BOLD, 28));
		txtDataStructure.setText("DATA STRUCTURE");
		txtDataStructure.setBounds(586, 42, 450, 68);
		contentPane.add(txtDataStructure);
		txtDataStructure.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("CLOSE APPLICATION");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton_1.setBounds(586, 693, 428, 62);
		contentPane.add(btnNewButton_1);
	}
}
