import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;

public class SinglyllFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtSinglylinkedlist;
	private JTextField insrtfrnttxtfld;
	private JTextField insrtreartxtfld;
	private JTextField insrtintrtxtfld;
	private JTextField dltintrmdtxtfld;
	private JTextField dltreartxtfld;
	private JTextField dltfrnttxtfld;
	private JTextField distxtfrntfld;
	private JTextField disbacktxtfld;
	
	class Node {
      double data;
      Node next;

      Node(double data) {
         this.data = data;
         this.next = null;
      }
    }
	Node head;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SinglyllFrame frame = new SinglyllFrame();
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
	public SinglyllFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1213, 766);
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
		
		txtSinglylinkedlist = new JTextField();
		txtSinglylinkedlist.setText("SINGLY-LINKED-LIST");
		txtSinglylinkedlist.setHorizontalAlignment(SwingConstants.CENTER);
		txtSinglylinkedlist.setFont(new Font("Tahoma", Font.BOLD, 34));
		txtSinglylinkedlist.setColumns(10);
		txtSinglylinkedlist.setBounds(371, 10, 477, 58);
		contentPane.add(txtSinglylinkedlist);
		
		JLabel eleminsfrtlbl = new JLabel("ELEMENT");
		eleminsfrtlbl.setHorizontalAlignment(SwingConstants.CENTER);
		eleminsfrtlbl.setForeground(new Color(255, 255, 128));
		eleminsfrtlbl.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		eleminsfrtlbl.setBounds(208, 78, 186, 41);
		contentPane.add(eleminsfrtlbl);
		
		insrtfrnttxtfld = new JTextField();
		insrtfrnttxtfld.setHorizontalAlignment(SwingConstants.CENTER);
		insrtfrnttxtfld.setForeground(Color.BLACK);
		insrtfrnttxtfld.setFont(new Font("Tahoma", Font.BOLD, 16));
		insrtfrnttxtfld.setColumns(10);
		insrtfrnttxtfld.setBounds(489, 78, 169, 41);
		contentPane.add(insrtfrnttxtfld);
		
		JButton insrtfrtbtn = new JButton("INSERT-FRONT");
		insrtfrtbtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
		       double data = Double.parseDouble(insrtfrnttxtfld.getText().trim());
		       Node newNode = new Node(data);
		       newNode.next = head;
		       head = newNode;
		       JOptionPane.showMessageDialog(null, "Inserted at front: " + data);
		       } catch (NumberFormatException ex) {
		         JOptionPane.showMessageDialog(null, "Invalid input!");
		       }
			}
		});
		insrtfrtbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		insrtfrtbtn.setBounds(798, 78, 214, 41);
		contentPane.add(insrtfrtbtn);
		
		JLabel eleminsfrtlbl_1 = new JLabel("ELEMENT");
		eleminsfrtlbl_1.setHorizontalAlignment(SwingConstants.CENTER);
		eleminsfrtlbl_1.setForeground(new Color(255, 255, 128));
		eleminsfrtlbl_1.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		eleminsfrtlbl_1.setBounds(208, 144, 186, 41);
		contentPane.add(eleminsfrtlbl_1);
		
		insrtreartxtfld = new JTextField();
		insrtreartxtfld.setHorizontalAlignment(SwingConstants.CENTER);
		insrtreartxtfld.setForeground(Color.BLACK);
		insrtreartxtfld.setFont(new Font("Tahoma", Font.BOLD, 16));
		insrtreartxtfld.setColumns(10);
		insrtreartxtfld.setBounds(489, 144, 169, 41);
		contentPane.add(insrtreartxtfld);
		
		JButton btnInsertrear = new JButton("INSERT-REAR");
		btnInsertrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { double data = Double.parseDouble(insrtreartxtfld.getText().trim()); 
				Node newNode = new Node(data); 
				if (head == null) 
				{ 
					head = newNode; 
				} 
				else 
				{ 
					Node temp = head; 
					while (temp.next != null) 
					{ 
						temp = temp.next; 
					} 
					temp.next = newNode; 
				} 
				JOptionPane.showMessageDialog(null, "Inserted at rear: " + data); 
				}
				catch (NumberFormatException ex) 
				{ 
					JOptionPane.showMessageDialog(null, "Invalid input!"); 
				}

			}
		});
		btnInsertrear.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		btnInsertrear.setBounds(798, 144, 214, 41);
		contentPane.add(btnInsertrear);
		
		JLabel eleminsfrtlbl_1_1 = new JLabel("ELEMENT");
		eleminsfrtlbl_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		eleminsfrtlbl_1_1.setForeground(new Color(255, 255, 128));
		eleminsfrtlbl_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		eleminsfrtlbl_1_1.setBounds(208, 208, 186, 41);
		contentPane.add(eleminsfrtlbl_1_1);
		
		insrtintrtxtfld = new JTextField();
		insrtintrtxtfld.setHorizontalAlignment(SwingConstants.CENTER);
		insrtintrtxtfld.setForeground(Color.BLACK);
		insrtintrtxtfld.setFont(new Font("Tahoma", Font.BOLD, 16));
		insrtintrtxtfld.setColumns(10);
		insrtintrtxtfld.setBounds(489, 208, 169, 41);
		contentPane.add(insrtintrtxtfld);
		
		JButton btnInsertintermediate = new JButton("INSERT-INTERMEDIATE");
		btnInsertintermediate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try 
			{ 
				double data = Double.parseDouble(insrtintrtxtfld.getText().trim()); 
				int position = Integer.parseInt(JOptionPane.showInputDialog("Enter position:")); 
				Node newNode = new Node(data); 
				if (position == 0) 
				{ 
				    newNode.next = head; 
				    head = newNode; 
					JOptionPane.showMessageDialog(null, "Inserted at position 0: " + data); 
					return; 
					}
					 Node temp = head;
					for (int i = 0; i < position - 1; i++) 
					{ 
					if (temp != null) 
					{ 
					temp = temp.next; 
					} 
					else 
					{ 
					JOptionPane.showMessageDialog(null, "Position out of range!"); 
					return; 
					} 
					} 
					newNode.next = temp.next; 
					temp.next = newNode; 
					JOptionPane.showMessageDialog(null, "Inserted at position " + position + ": " + data); 
				} 
				catch (NumberFormatException ex) 
				{ 
					JOptionPane.showMessageDialog(null, "Invalid input!"); 
				}

			}
		});
		btnInsertintermediate.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		btnInsertintermediate.setBounds(798, 208, 291, 41);
		contentPane.add(btnInsertintermediate);
		
		JLabel elemdltintmlbl = new JLabel("DELETED ELEMENT");
		elemdltintmlbl.setHorizontalAlignment(SwingConstants.CENTER);
		elemdltintmlbl.setForeground(new Color(255, 255, 128));
		elemdltintmlbl.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		elemdltintmlbl.setBounds(208, 275, 277, 41);
		contentPane.add(elemdltintmlbl);
		
		dltintrmdtxtfld = new JTextField();
		dltintrmdtxtfld.setHorizontalAlignment(SwingConstants.CENTER);
		dltintrmdtxtfld.setForeground(Color.BLACK);
		dltintrmdtxtfld.setFont(new Font("Tahoma", Font.BOLD, 16));
		dltintrmdtxtfld.setColumns(10);
		dltintrmdtxtfld.setBounds(489, 275, 169, 41);
		contentPane.add(dltintrmdtxtfld);
		
		JButton btnDeleteintermediate = new JButton("DELETE-INTERMEDIATE");
		btnDeleteintermediate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{ 
					int position = Integer.parseInt(JOptionPane.showInputDialog("Enter position to delete:")); 
					if (head == null) 
					{ 
						JOptionPane.showMessageDialog(null, "List is empty!"); 
						return; 
					} 
					if (position == 0) 
					{ 
						double data = head.data; 
						head = head.next; 
						dltintrmdtxtfld.setText(String.valueOf(data)); 
						JOptionPane.showMessageDialog(null, "Deleted from position 0: " + data); 
						return; 
					} 
					Node temp = head; 
					for (int i = 0; i < position - 1; i++) 
					{ 
						if (temp != null) 
						{ 
							temp = temp.next; 
						} 
						else 
						{ 
							JOptionPane.showMessageDialog(null, "Position out of range!"); 
							return; 
						} 
					} 
					if (temp.next == null) 
					{ 
						JOptionPane.showMessageDialog(null, "Position out of range!"); 
					} 
					else 
					{ 
						double data = temp.next.data; 
						temp.next = temp.next.next; 
						dltintrmdtxtfld.setText(String.valueOf(data)); 
						JOptionPane.showMessageDialog(null, "Deleted from position " + position + ": " + data); 
					} 
				} 
				catch (NumberFormatException ex) 
				{ 
					JOptionPane.showMessageDialog(null, "Invalid input!");
				}
			}

			
		});
		btnDeleteintermediate.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		btnDeleteintermediate.setBounds(798, 275, 291, 41);
		contentPane.add(btnDeleteintermediate);
		
		JLabel elemdltintmlbl_1 = new JLabel("DELETED ELEMENT");
		elemdltintmlbl_1.setHorizontalAlignment(SwingConstants.CENTER);
		elemdltintmlbl_1.setForeground(new Color(255, 255, 128));
		elemdltintmlbl_1.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		elemdltintmlbl_1.setBounds(208, 340, 277, 41);
		contentPane.add(elemdltintmlbl_1);
		
		dltreartxtfld = new JTextField();
		dltreartxtfld.setHorizontalAlignment(SwingConstants.CENTER);
		dltreartxtfld.setForeground(Color.BLACK);
		dltreartxtfld.setFont(new Font("Tahoma", Font.BOLD, 16));
		dltreartxtfld.setColumns(10);
		dltreartxtfld.setBounds(489, 340, 169, 41);
		contentPane.add(dltreartxtfld);
		
		JButton deleterearbtn = new JButton("DELETE-REAR");
		deleterearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{ if (head == null) 
				{ 
					JOptionPane.showMessageDialog(null, "List is empty!"); 
				} 
				else if (head.next == null) 
				{ 
					double data = head.data; 
					head = null; 
					dltreartxtfld.setText(String.valueOf(data)); 
					JOptionPane.showMessageDialog(null, "Deleted from rear: " + data); 
				} 
				else 
				{ 
					Node temp = head; 
					while (temp.next.next != null) 
					{ 
						temp = temp.next; 
					} 
					double data = temp.next.data; 
					temp.next = null; 
					dltreartxtfld.setText(String.valueOf(data)); 
					JOptionPane.showMessageDialog(null, "Deleted from rear: " + data);
				}
				}

			}
		});
		deleterearbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		deleterearbtn.setBounds(798, 340, 291, 41);
		contentPane.add(deleterearbtn);
		
		JLabel elemdltintmlbl_1_1 = new JLabel("DELETED ELEMENT");
		elemdltintmlbl_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		elemdltintmlbl_1_1.setForeground(new Color(255, 255, 128));
		elemdltintmlbl_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		elemdltintmlbl_1_1.setBounds(208, 408, 277, 41);
		contentPane.add(elemdltintmlbl_1_1);
		
		dltfrnttxtfld = new JTextField();
		dltfrnttxtfld.setHorizontalAlignment(SwingConstants.CENTER);
		dltfrnttxtfld.setForeground(Color.BLACK);
		dltfrnttxtfld.setFont(new Font("Tahoma", Font.BOLD, 16));
		dltfrnttxtfld.setColumns(10);
		dltfrnttxtfld.setBounds(489, 408, 169, 41);
		contentPane.add(dltfrnttxtfld);
		
		JButton dltfastbtn = new JButton("DELETE-FRONT");
		dltfastbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (head == null) 
				{ 
					JOptionPane.showMessageDialog(null, "List is empty!"); 
				} 
				else 
				{ 
					double data = head.data; head = head.next; dltfrnttxtfld.setText(String.valueOf(data)); 
					JOptionPane.showMessageDialog(null, "Deleted from front: " + data);
				}

			}
		});
		dltfastbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		dltfastbtn.setBounds(798, 408, 291, 41);
		contentPane.add(dltfastbtn);
		
		JLabel eleminsfrtlbl_1_2 = new JLabel("ELEMENTS");
		eleminsfrtlbl_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		eleminsfrtlbl_1_2.setForeground(new Color(255, 255, 128));
		eleminsfrtlbl_1_2.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		eleminsfrtlbl_1_2.setBounds(102, 500, 186, 54);
		contentPane.add(eleminsfrtlbl_1_2);
		
		distxtfrntfld = new JTextField();
		distxtfrntfld.setFont(new Font("Tahoma", Font.BOLD, 16));
		distxtfrntfld.setColumns(10);
		distxtfrntfld.setBounds(320, 496, 442, 58);
		contentPane.add(distxtfrntfld);
		
		JButton dispforbtn = new JButton("DISPLAY FORWARD");
		dispforbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (head == null) 
				{ 
					distxtfrntfld.setText("List is empty"); 
				} 
				else 
				{ 
					Node temp = head; StringBuilder sb = new StringBuilder(); 
					while (temp != null) 
					{ 
						sb.append(temp.data).append(" -> "); 
						temp = temp.next; 
					} 
					distxtfrntfld.setText(sb.substring(0, sb.length() - 4)); // Remove last " -> "
				}

			}
		});
		dispforbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		dispforbtn.setBounds(784, 496, 339, 58);
		contentPane.add(dispforbtn);
		
		JLabel eleminsfrtlbl_1_2_1 = new JLabel("ELEMENTS");
		eleminsfrtlbl_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		eleminsfrtlbl_1_2_1.setForeground(new Color(255, 255, 128));
		eleminsfrtlbl_1_2_1.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		eleminsfrtlbl_1_2_1.setBounds(102, 580, 186, 54);
		contentPane.add(eleminsfrtlbl_1_2_1);
		
		disbacktxtfld = new JTextField();
		disbacktxtfld.setFont(new Font("Tahoma", Font.BOLD, 16));
		disbacktxtfld.setColumns(10);
		disbacktxtfld.setBounds(320, 580, 442, 58);
		contentPane.add(disbacktxtfld);
		
		JButton btnDisplayReverse = new JButton("DISPLAY BACKWARD");
		btnDisplayReverse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (head == null) 
				{ 
					disbacktxtfld.setText("List is empty"); 
				} 
				else
				{
					Node prev = null, current = head, next; 
					StringBuilder sb = new StringBuilder(); 
					// Reverse the linked list 
					while (current != null) 
					{ 
						next = current.next; 
						current.next = prev; 
						prev = current; 
						current = next; 
					} // Now prev is the head of the reversed list 
					Node temp = prev; 
					while (temp != null) 
					{ 
						sb.append(temp.data).append(" -> "); 
						temp = temp.next; 
					} // Reverse the list again to restore original order 
					current = prev; 
					prev = null; 
					while (current != null) 
					{ 
						next = current.next; 
						current.next = prev; 
						prev = current; 
						current = next; 
					} 
					head = prev; // Restore head to original 
					disbacktxtfld.setText(sb.substring(0, sb.length() - 4));
				}

			}
		});
		btnDisplayReverse.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		btnDisplayReverse.setBounds(784, 576, 339, 58);
		contentPane.add(btnDisplayReverse);
		
		JButton btnback = new JButton("BACK");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				DSAproject dsAproject = new DSAproject();
				dsAproject.setVisible(true);
			}
		});
		btnback.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		btnback.setBounds(507, 662, 151, 41);
		contentPane.add(btnback);
	}

}
