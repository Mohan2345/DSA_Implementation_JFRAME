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

public class Circularque extends JFrame {

	private JPanel contentPane;
	private JTextField cirquetxthding;
	private JTextField cirquesiztxtfld;
	private JTextField sizetxtfld;
	private JTextField dlttxtfld;
	private JTextField disptxtfld;
	
	private int cq[]; 
	private int size; 
	private int front = -1; 
	private int rear = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Circularque frame = new Circularque();
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
	public Circularque() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1304, 758);
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
		
		cirquetxthding = new JTextField();
		cirquetxthding.setBounds(343, 10, 783, 70);
		cirquetxthding.setText("CIRCULAR-QUEUE DATA STRUCTURE");
		cirquetxthding.setHorizontalAlignment(SwingConstants.CENTER);
		cirquetxthding.setFont(new Font("Tahoma", Font.BOLD, 34));
		cirquetxthding.setColumns(10);
		contentPane.add(cirquetxthding);
		
		JLabel cirquelbl = new JLabel("CIRCULAR-QUEUE-SIZE");
		cirquelbl.setHorizontalAlignment(SwingConstants.CENTER);
		cirquelbl.setForeground(new Color(255, 255, 128));
		cirquelbl.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		cirquelbl.setBounds(229, 143, 383, 69);
		contentPane.add(cirquelbl);
		
		cirquesiztxtfld = new JTextField();
		cirquesiztxtfld.setHorizontalAlignment(SwingConstants.CENTER);
		cirquesiztxtfld.setForeground(Color.BLACK);
		cirquesiztxtfld.setFont(new Font("Tahoma", Font.BOLD, 16));
		cirquesiztxtfld.setColumns(10);
		cirquesiztxtfld.setBounds(678, 145, 205, 69);
		contentPane.add(cirquesiztxtfld);
		
		JButton createbtn = new JButton(" CREATE");
		createbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					size = Integer.parseInt(cirquesiztxtfld.getText());
					cq = new int[size];
					front = -1;
					rear = -1;
					JOptionPane.showMessageDialog(null, "Circular queue of size " + size + " created."); 
					cirquesiztxtfld.setText(""); // Clear the text field after operation
				} catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(contentPane, "Please enter a valid size.");
				}
			}
		});
		createbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		createbtn.setBounds(987, 143, 243, 69);
		contentPane.add(createbtn);
		
		JLabel elemntlbl = new JLabel("ELEMENT");
		elemntlbl.setHorizontalAlignment(SwingConstants.CENTER);
		elemntlbl.setForeground(new Color(255, 255, 128));
		elemntlbl.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		elemntlbl.setBounds(214, 270, 383, 69);
		contentPane.add(elemntlbl);
		
		sizetxtfld = new JTextField();
		sizetxtfld.setHorizontalAlignment(SwingConstants.CENTER);
		sizetxtfld.setForeground(Color.BLACK);
		sizetxtfld.setFont(new Font("Tahoma", Font.BOLD, 16));
		sizetxtfld.setColumns(10);
		sizetxtfld.setBounds(678, 272, 205, 69);
		contentPane.add(sizetxtfld);
		
		JButton insrtbtn = new JButton("INSERT");
		insrtbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try { 
			int element = Integer.parseInt(sizetxtfld.getText()); 
			if ((rear + 1) % size == front) { 
				JOptionPane.showMessageDialog(contentPane, "Queue is full. Cannot insert."); 
				} else { 
					if (front == -1) front = 0; // First element 
					rear = (rear + 1) % size; 
					cq[rear] = element; 
					JOptionPane.showMessageDialog(contentPane, "Element " + element + " inserted into queue."); 
					sizetxtfld.setText(""); // Clear the text field after operation } } catch (NumberFormatException ex) { JOptionPane.showMessageDialog(contentPane, "Please enter a valid element."); }
					}
				} catch (NumberFormatException ex) { 
					JOptionPane.showMessageDialog(contentPane, "Please enter a valid element."); 
			  }
			}
		});
		insrtbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		insrtbtn.setBounds(987, 270, 243, 69);
		contentPane.add(insrtbtn);
		
		JLabel dltelmntlbl = new JLabel("ELEMENT-DELETED");
		dltelmntlbl.setHorizontalAlignment(SwingConstants.CENTER);
		dltelmntlbl.setForeground(new Color(255, 255, 128));
		dltelmntlbl.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		dltelmntlbl.setBounds(229, 385, 383, 69);
		contentPane.add(dltelmntlbl);
		
		dlttxtfld = new JTextField();
		dlttxtfld.setHorizontalAlignment(SwingConstants.CENTER);
		dlttxtfld.setForeground(Color.BLACK);
		dlttxtfld.setFont(new Font("Tahoma", Font.BOLD, 16));
		dlttxtfld.setColumns(10);
		dlttxtfld.setBounds(678, 387, 205, 69);
		contentPane.add(dlttxtfld);
		
		JButton dltbtn = new JButton("DELETE");
		dltbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if (front == -1) { 
				JOptionPane.showMessageDialog(contentPane, "Queue is empty. Cannot delete."); 
				} else { 
				int deletedElement = cq[front]; 
				if (front == rear) { 
					front = -1; rear = -1; 
					} else { 
					front = (front + 1) % size; 
					} 
				dlttxtfld.setText(String.valueOf(deletedElement)); 
				JOptionPane.showMessageDialog(contentPane, "Element " + deletedElement + " deleted from queue."); 
				dlttxtfld.setText(""); // Clear the text field after operation }
				}
			}
		});
		dltbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		dltbtn.setBounds(987, 385, 243, 69);
		contentPane.add(dltbtn);
		
		JLabel crdislbl = new JLabel("CIRCULAR-QUEUE-ELEMENTS");
		crdislbl.setHorizontalAlignment(SwingConstants.CENTER);
		crdislbl.setForeground(new Color(255, 255, 128));
		crdislbl.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		crdislbl.setBounds(34, 511, 367, 75);
		contentPane.add(crdislbl);
		
		disptxtfld = new JTextField();
		disptxtfld.setHorizontalAlignment(SwingConstants.CENTER);
		disptxtfld.setForeground(Color.BLACK);
		disptxtfld.setFont(new Font("Tahoma", Font.BOLD, 16));
		disptxtfld.setColumns(10);
		disptxtfld.setBounds(431, 511, 637, 78);
		contentPane.add(disptxtfld);
		
		JButton displaybtn = new JButton("DISPLAY");
		displaybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (front == -1) {
		            JOptionPane.showMessageDialog(contentPane, "Queue is empty. No elements to display.");
		            disptxtfld.setText(""); // Clear the text field
		        } else {
		            StringBuilder queueElements = new StringBuilder();
		            int i = front;
		            while (i != rear) {
		                queueElements.append(cq[i]).append(" ");
		                i = (i + 1) % size; // Move to next element, wrapping around if necessary
		            }
		            queueElements.append(cq[rear]); // Add the last element (rear)
		            disptxtfld.setText(queueElements.toString()); // Display the queue elements in the text field
		        }
			}
		});
		displaybtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		displaybtn.setBounds(1100, 511, 180, 75);
		contentPane.add(displaybtn);
		
		JButton backbtn = new JButton(" BACK");
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				DSAproject dsAproject = new DSAproject();
				dsAproject.setVisible(true);
			}
		});
		backbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		backbtn.setBounds(732, 630, 215, 69);
		contentPane.add(backbtn);
	}

}
