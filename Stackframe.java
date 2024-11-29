import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Stackframe extends JFrame {

	private int stk[] = null;
	private int size = 0;
	private int top = -1;
	private JPanel contentPane;
	private JTextField headingstackds;
	private JTextField sizetxtfld;
	private JTextField pushtxtfld;
	private JTextField poptxtfld;
	private JTextField displtxtfld;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stackframe frame = new Stackframe();
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
	public Stackframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1394, 752);
		//===========================background-image and full-screen logic===============================
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
		//===========================================logic end===============================================
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
 		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		headingstackds = new JTextField();
		headingstackds.setFont(new Font("Tahoma", Font.BOLD, 34));
		headingstackds.setHorizontalAlignment(SwingConstants.CENTER);
		headingstackds.setText("STACK DATA STRUCTURE");
		headingstackds.setBounds(420, 24, 568, 78);
		contentPane.add(headingstackds);
		headingstackds.setColumns(10);
		
		JLabel stcksizelbl = new JLabel(" STACK-SIZE");
		stcksizelbl.setForeground(new Color(255, 255, 128));
		stcksizelbl.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		stcksizelbl.setHorizontalAlignment(SwingConstants.CENTER);
		stcksizelbl.setBounds(268, 164, 205, 64);
		contentPane.add(stcksizelbl);
		
		JButton createbtn = new JButton(" CREATE");
		createbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					size = Integer.parseInt(sizetxtfld.getText());
					stk = new int[size];
					top = -1;
					JOptionPane.showMessageDialog(null, "Stack of size " + size + " created.");
					sizetxtfld.setText(""); // Clear the text field after operation
				}
				catch(NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null, "Please enter a valid size."); 
				}
			}
		});
		createbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		createbtn.setBounds(814, 164, 215, 64);
		contentPane.add(createbtn);
		
		sizetxtfld = new JTextField();
		sizetxtfld.setFont(new Font("Tahoma", Font.BOLD, 16));
		sizetxtfld.setForeground(new Color(0, 0, 0));
		sizetxtfld.setHorizontalAlignment(SwingConstants.CENTER);
		sizetxtfld.setBounds(515, 164, 205, 69);
		contentPane.add(sizetxtfld);
		sizetxtfld.setColumns(10);
		
		JLabel stckpushlbl = new JLabel("PUSH ELEMENT");
		stckpushlbl.setHorizontalAlignment(SwingConstants.CENTER);
		stckpushlbl.setForeground(new Color(255, 255, 128));
		stckpushlbl.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		stckpushlbl.setBounds(268, 294, 205, 64);
		contentPane.add(stckpushlbl);
		
		pushtxtfld = new JTextField();
		pushtxtfld.setHorizontalAlignment(SwingConstants.CENTER);
		pushtxtfld.setForeground(Color.BLACK);
		pushtxtfld.setFont(new Font("Tahoma", Font.BOLD, 16));
		pushtxtfld.setColumns(10);
		pushtxtfld.setBounds(515, 294, 205, 69);
		contentPane.add(pushtxtfld);
		
		JButton btnpush = new JButton("PUSH");
		btnpush.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(top == size-1) {
						JOptionPane.showMessageDialog(contentPane, "Stack is full. Push cann't possible.");
					} else {
						int element = Integer.parseInt(pushtxtfld.getText());
						top++;
						stk[top] = element;
						JOptionPane.showMessageDialog(null, "Element " + element + " pushed onto stack.");
						pushtxtfld.setText("");
					}
				}
				catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please enter a valid element.");
				}
			}
		});
		btnpush.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		btnpush.setBounds(814, 299, 215, 64);
		contentPane.add(btnpush);
		
		JLabel stckpoplbl = new JLabel("POP ELEMENT");
		stckpoplbl.setHorizontalAlignment(SwingConstants.CENTER);
		stckpoplbl.setForeground(new Color(255, 255, 128));
		stckpoplbl.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		stckpoplbl.setBounds(268, 427, 205, 64);
		contentPane.add(stckpoplbl);
		
		poptxtfld = new JTextField();
		poptxtfld.setHorizontalAlignment(SwingConstants.CENTER);
		poptxtfld.setForeground(Color.BLACK);
		poptxtfld.setFont(new Font("Tahoma", Font.BOLD, 16));
		poptxtfld.setColumns(10);
		poptxtfld.setBounds(515, 415, 205, 69);
		contentPane.add(poptxtfld);
		
		JButton btnpop = new JButton(" POP");
		btnpop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					if(top == -1) {
						JOptionPane.showMessageDialog(null, "Pop operation not possible cause stack is EMPTY.");
					} else {
 						JOptionPane.showMessageDialog(null, "Element " + stk[top] + " got popped out.");
 						stk[top] = 0;
						top--;
						poptxtfld.setText("");
 					}
				
			}
		});
		btnpop.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		btnpop.setBounds(814, 415, 215, 64);
		contentPane.add(btnpop);
		
		JLabel displstclbl = new JLabel("STACK-ELEMENTS");
		displstclbl.setHorizontalAlignment(SwingConstants.CENTER);
		displstclbl.setForeground(new Color(255, 255, 128));
		displstclbl.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		displstclbl.setBounds(79, 527, 235, 87);
		contentPane.add(displstclbl);
		
		displtxtfld = new JTextField();
		displtxtfld.setHorizontalAlignment(SwingConstants.CENTER);
		displtxtfld.setForeground(Color.BLACK);
		displtxtfld.setFont(new Font("Tahoma", Font.BOLD, 16));
		displtxtfld.setColumns(10);
		displtxtfld.setBounds(369, 533, 637, 78);
		contentPane.add(displtxtfld);
		
		JButton btndisplay = new JButton(" DISPLAY");
		btndisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(top == -1) {
					JOptionPane.showMessageDialog(null, "Stack is empty.");
				} else {
					StringBuilder s = new StringBuilder();
					for(int i =0;i <= top;i++) {
						s.append(stk[i]).append(" ");
					}
					displtxtfld.setText(s.toString());
 				}
			}
		});
		btndisplay.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		btndisplay.setBounds(1058, 533, 215, 69);
		contentPane.add(btndisplay);
		
		JButton backbtn = new JButton(" BACK");
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				DSAproject dsAproject = new DSAproject();
				dsAproject.setVisible(true);
			}
		});
		backbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		backbtn.setBounds(634, 636, 215, 69);
		contentPane.add(backbtn);
	}
}
