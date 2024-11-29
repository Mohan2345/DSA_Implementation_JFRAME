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

public class DoublyLinkedListFrame extends JFrame {

	private JPanel contentPane;
	private JTextField hdndlltxtfld;
	private JTextField eleminsrfrnttxtfld;
	private JTextField insrtreartxtfld;
	private JButton insrtrearbtn;
	private JLabel eleminsintmlbl;
	private JTextField insrtintrmedtxtfld;
	private JButton btnInsertintermediate;
	private JLabel elemdltintmlbl;
	private JTextField dltelemintrtxtfld;
	private JButton btnDeleteintermediate;
	private JLabel elemdltintmlbl_1;
	private JTextField dltreartxtfld;
	private JButton deleterearbtn;
	private JLabel elemdltintmlbl_2;
	private JTextField dltfasttxtfld;
	private JButton dltfastbtn;
	private JLabel eleminsfrtlbl_1;
	private JTextField disfronttxtfld;
	private JButton dispforbtn;
	private JLabel eleminsfrtlbl_2;
	private JTextField disbacktxtfld;
	private JButton dispbackbtn;
	private JButton btnback;
	
	private double elem;
    class Node
    {
    	Node preLink;
    	double data;
    	Node nextLink;
    	
    }
    Node first;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoublyLinkedListFrame frame = new DoublyLinkedListFrame();
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
	public DoublyLinkedListFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1213, 752);
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
		
		hdndlltxtfld = new JTextField();
		hdndlltxtfld.setFont(new Font("Tahoma", Font.BOLD, 34));
		hdndlltxtfld.setHorizontalAlignment(SwingConstants.CENTER);
		hdndlltxtfld.setText("DOUBLY-LINKED-LIST");
		hdndlltxtfld.setBounds(389, 23, 477, 58);
		contentPane.add(hdndlltxtfld);
		hdndlltxtfld.setColumns(10);
		
		JLabel eleminsfrtlbl = new JLabel("ELEMENT");
		eleminsfrtlbl.setForeground(new Color(255, 255, 128));
		eleminsfrtlbl.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		eleminsfrtlbl.setHorizontalAlignment(SwingConstants.CENTER);
		eleminsfrtlbl.setBounds(233, 109, 186, 41);
		contentPane.add(eleminsfrtlbl);
		
		eleminsrfrnttxtfld = new JTextField();
		eleminsrfrnttxtfld.setFont(new Font("Tahoma", Font.BOLD, 16));
		eleminsrfrnttxtfld.setForeground(new Color(0, 0, 0));
		eleminsrfrnttxtfld.setHorizontalAlignment(SwingConstants.CENTER);
		eleminsrfrnttxtfld.setBounds(531, 113, 169, 41);
		contentPane.add(eleminsrfrnttxtfld);
		eleminsrfrnttxtfld.setColumns(10);
		
		JButton insrtfrtbtn = new JButton("INSERT-FRONT");
		insrtfrtbtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try
	        {
	        	Node n = new Node();
	            n.data = Double.parseDouble(eleminsrfrnttxtfld.getText().trim());
	            n.preLink = null;
	            n.nextLink = first;

	            if (first != null) {
	               first.preLink = n;
	               }
	               first = n;
	               JOptionPane.showMessageDialog(null, "Element " + n.data+" has been inserted sucessfully!");
	               }
	        catch(NumberFormatException ex)
	        	{
	        		JOptionPane.showMessageDialog(null, "Please enter an element to insert!");
	        	}
			}
		});
		insrtfrtbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		insrtfrtbtn.setBounds(867, 109, 214, 41);
		contentPane.add(insrtfrtbtn);
		
		JLabel eleminsrearlbl = new JLabel("ELEMENT");
		eleminsrearlbl.setHorizontalAlignment(SwingConstants.CENTER);
		eleminsrearlbl.setForeground(new Color(255, 255, 128));
		eleminsrearlbl.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		eleminsrearlbl.setBounds(233, 171, 186, 41);
		contentPane.add(eleminsrearlbl);
		
		insrtreartxtfld = new JTextField();
		insrtreartxtfld.setFont(new Font("Tahoma", Font.BOLD, 16));
		insrtreartxtfld.setHorizontalAlignment(SwingConstants.CENTER);
		insrtreartxtfld.setColumns(10);
		insrtreartxtfld.setBounds(531, 175, 169, 41);
		contentPane.add(insrtreartxtfld);
		
		insrtrearbtn = new JButton("INSERT-REAR");
		insrtrearbtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try
	        {
	            Node n = new Node();
	            n.data = Double.parseDouble(insrtreartxtfld.getText().trim());
	            n.nextLink = null;

	            if (first == null) {
	               n.preLink = null;
	               first = n;
	            } else {
	               Node temp = first;
	               while (temp.nextLink != null) {
	               temp = temp.nextLink;
	            }
	               temp.nextLink = n;
	               n.preLink = temp;
	            }
	                JOptionPane.showMessageDialog(null, "Element " + n.data+" has been inserted sucessfully!");

	        	}
	        	catch(NumberFormatException ex)
	        	{
	                JOptionPane.showMessageDialog(null, "Please enter an element to insert!");

	        	}

			}
		});
		insrtrearbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		insrtrearbtn.setBounds(867, 171, 214, 41);
		contentPane.add(insrtrearbtn);
		
		eleminsintmlbl = new JLabel("ELEMENT");
		eleminsintmlbl.setHorizontalAlignment(SwingConstants.CENTER);
		eleminsintmlbl.setForeground(new Color(255, 255, 128));
		eleminsintmlbl.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		eleminsintmlbl.setBounds(233, 236, 186, 41);
		contentPane.add(eleminsintmlbl);
		
		insrtintrmedtxtfld = new JTextField();
		insrtintrmedtxtfld.setFont(new Font("Tahoma", Font.PLAIN, 16));
		insrtintrmedtxtfld.setHorizontalAlignment(SwingConstants.CENTER);
		insrtintrmedtxtfld.setColumns(10);
		insrtintrmedtxtfld.setBounds(531, 240, 169, 41);
		contentPane.add(insrtintrmedtxtfld);
		
		btnInsertintermediate = new JButton("INSERT-INTERMEDIATE");
		btnInsertintermediate.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
	        try {
	            double data = Double.parseDouble(insrtintrmedtxtfld.getText().trim());
	            String positionInput = JOptionPane.showInputDialog("Enter position to insert (1-based):");
	            if (positionInput == null) {
	                return; // User cancelled the input
	            }
	            int position = Integer.parseInt(positionInput);

	            if (position < 1) {
	                JOptionPane.showMessageDialog(null, "Invalid position. Position must be 1 or greater.");
	                return;
	            }

	            Node n = new Node();
	            n.data = data;

	            if (position == 1 || first == null) {
	                n.nextLink = first;
	                if (first != null) {
	                    first.preLink = n;
	                }
	                first = n;
	            } else {
	                Node temp = first;
	                int count = 1;
	                while (temp.nextLink != null && count < position - 1) {
	                    temp = temp.nextLink;
	                    count++;
	                }
	                n.nextLink = temp.nextLink;
	                if (temp.nextLink != null) {
	                    temp.nextLink.preLink = n;
	                }
	                temp.nextLink = n;
	                n.preLink = temp;
	            }
	            JOptionPane.showMessageDialog(null, "Element " + n.data + " has been inserted successfully at position " + position + "!");
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(null, "Please enter valid numbers for element and position!");
	        }
	    }

	});
		btnInsertintermediate.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		btnInsertintermediate.setBounds(867, 236, 291, 41);
		contentPane.add(btnInsertintermediate);
		
		elemdltintmlbl = new JLabel("DELETED ELEMENT");
		elemdltintmlbl.setHorizontalAlignment(SwingConstants.CENTER);
		elemdltintmlbl.setForeground(new Color(255, 255, 128));
		elemdltintmlbl.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		elemdltintmlbl.setBounds(233, 302, 277, 41);
		contentPane.add(elemdltintmlbl);
		
		dltelemintrtxtfld = new JTextField();
		dltelemintrtxtfld.setFont(new Font("Tahoma", Font.BOLD, 16));
		dltelemintrtxtfld.setHorizontalAlignment(SwingConstants.CENTER);
		dltelemintrtxtfld.setColumns(10);
		dltelemintrtxtfld.setBounds(531, 306, 169, 41);
		contentPane.add(dltelemintrtxtfld);
		
		btnDeleteintermediate = new JButton("DELETE-INTERMEDIATE");
		btnDeleteintermediate.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int position = Integer.parseInt(JOptionPane.showInputDialog("Enter position to delete (1-based):"));
            if (first == null) {
                JOptionPane.showMessageDialog(null, "List is empty!");
                return;
            }

            if (position == 1) {
            	dltelemintrtxtfld.setText(String.valueOf(first.data));
                first = first.nextLink;
                if (first != null) {
                    first.preLink = null;
                }
            } else {
                Node temp = first;
                int count = 1;
                while (temp != null && count < position) {
                temp = temp.nextLink;
                count++;
            }

            if (temp != null) {
               dltelemintrtxtfld.setText(String.valueOf(temp.data));
               JOptionPane.showMessageDialog(null, "Element " + temp.data + " Deleted successfully!");
	           		if (temp.preLink != null) {
	           			temp.preLink.nextLink = temp.nextLink;
	           			}
	           		if (temp.nextLink != null) {
	           			temp.nextLink.preLink = temp.preLink;
	           			}
             } else {
                   JOptionPane.showMessageDialog(null, "Invalid Position!");
             }
          }
 		}
	});
		btnDeleteintermediate.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		btnDeleteintermediate.setBounds(867, 302, 291, 41);
		contentPane.add(btnDeleteintermediate);
		
		elemdltintmlbl_1 = new JLabel("DELETED ELEMENT");
		elemdltintmlbl_1.setHorizontalAlignment(SwingConstants.CENTER);
		elemdltintmlbl_1.setForeground(new Color(255, 255, 128));
		elemdltintmlbl_1.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		elemdltintmlbl_1.setBounds(233, 372, 277, 41);
		contentPane.add(elemdltintmlbl_1);
		
		dltreartxtfld = new JTextField();
		dltreartxtfld.setFont(new Font("Tahoma", Font.BOLD, 16));
		dltreartxtfld.setHorizontalAlignment(SwingConstants.CENTER);
		dltreartxtfld.setColumns(10);
		dltreartxtfld.setBounds(531, 372, 169, 41);
		contentPane.add(dltreartxtfld);
		
		deleterearbtn = new JButton("DELETE-REAR");
		deleterearbtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (first != null) {
	            Node temp = first;
	            while (temp.nextLink != null) {
	            temp = temp.nextLink;
	      }
	            dltreartxtfld.setText(String.valueOf(temp.data));
	            JOptionPane.showMessageDialog(null, "Element " + temp.data + " Deleted successfully!");
	            	if (temp.preLink != null) {
	                 temp.preLink.nextLink = null;
	            	} else {
	                 first = null; // Single element case
	            	}
	      } else {
	          JOptionPane.showMessageDialog(null, "List is empty!");
	      }

		}
	});
		deleterearbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		deleterearbtn.setBounds(867, 368, 291, 41);
		contentPane.add(deleterearbtn);
		
		elemdltintmlbl_2 = new JLabel("DELETED ELEMENT");
		elemdltintmlbl_2.setHorizontalAlignment(SwingConstants.CENTER);
		elemdltintmlbl_2.setForeground(new Color(255, 255, 128));
		elemdltintmlbl_2.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		elemdltintmlbl_2.setBounds(229, 438, 277, 41);
		contentPane.add(elemdltintmlbl_2);
		
		dltfasttxtfld = new JTextField();
		dltfasttxtfld.setHorizontalAlignment(SwingConstants.CENTER);
		dltfasttxtfld.setFont(new Font("Tahoma", Font.BOLD, 16));
		dltfasttxtfld.setColumns(10);
		dltfasttxtfld.setBounds(531, 442, 169, 41);
		contentPane.add(dltfasttxtfld);
		
		dltfastbtn = new JButton("DELETE-FRONT");
		dltfastbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (first != null) {
					dltfasttxtfld.setText(String.valueOf(first.data));
					JOptionPane.showMessageDialog(null, "Element " + first.data + " Deleted successfully!");	                first = first.nextLink;
	                if (first != null) {
	                    first.preLink = null;
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "List is empty!");
	            }

			}
		});
		dltfastbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		dltfastbtn.setBounds(867, 438, 291, 41);
		contentPane.add(dltfastbtn);
		
		eleminsfrtlbl_1 = new JLabel("ELEMENTS");
		eleminsfrtlbl_1.setHorizontalAlignment(SwingConstants.CENTER);
		eleminsfrtlbl_1.setForeground(new Color(255, 255, 128));
		eleminsfrtlbl_1.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		eleminsfrtlbl_1.setBounds(161, 527, 186, 54);
		contentPane.add(eleminsfrtlbl_1);
		
		disfronttxtfld = new JTextField();
		disfronttxtfld.setFont(new Font("Tahoma", Font.BOLD, 16));
		disfronttxtfld.setColumns(10);
		disfronttxtfld.setBounds(404, 530, 422, 58);
		contentPane.add(disfronttxtfld);
		
		dispforbtn = new JButton("DISPLAY FORWARD");
		dispforbtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Node temp = first;
	        StringBuilder s = new StringBuilder();
	        while (temp != null) {
	           s.append(temp.data).append(" ");
	           temp = temp.nextLink;
	        }
	          disfronttxtfld.setText(s.toString());

			}
		});
		dispforbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		dispforbtn.setBounds(850, 525, 339, 58);
		contentPane.add(dispforbtn);
		
		eleminsfrtlbl_2 = new JLabel("ELEMENTS");
		eleminsfrtlbl_2.setHorizontalAlignment(SwingConstants.CENTER);
		eleminsfrtlbl_2.setForeground(new Color(255, 255, 128));
		eleminsfrtlbl_2.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		eleminsfrtlbl_2.setBounds(171, 591, 186, 54);
		contentPane.add(eleminsfrtlbl_2);
		
		disbacktxtfld = new JTextField();
		disbacktxtfld.setFont(new Font("Tahoma", Font.BOLD, 16));
		disbacktxtfld.setColumns(10);
		disbacktxtfld.setBounds(404, 599, 422, 58);
		contentPane.add(disbacktxtfld);
		
		dispbackbtn = new JButton("DISPLAY BACKWARD");
		dispbackbtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Node temp = first;
	        while (temp != null && temp.nextLink != null) {
	          temp = temp.nextLink; // Go to last node
	        }
	          StringBuilder s = new StringBuilder();
	          while (temp != null) {
	          s.append(temp.data).append(" ");
	          temp = temp.preLink;
	        }
	          disbacktxtfld.setText(s.toString());
			}
		});
		dispbackbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		dispbackbtn.setBounds(850, 594, 339, 58);
		contentPane.add(dispbackbtn);
		
		btnback = new JButton("BACK");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				DSAproject dsAproject = new DSAproject();
				dsAproject.setVisible(true);
			}
		});
		btnback.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		btnback.setBounds(545, 664, 151, 41);
		contentPane.add(btnback);
	}
}
