import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Arrayframe extends JFrame {

	private int size;
    private int arr[]=null;
    private int elem;
    private int pos;
	private JPanel contentPane;
	private JTextField headingarraydstxt;
	private JTextField sizeofarrfld;
	private JTextField elemttxtfld;
	private JTextField posninsrttxtfld;
	private JTextField delposntxtfld;
	private JTextField disparrtxtfld;

    //private ArrayList<Integer> arrayList = new ArrayList<>(); // We are using ArrayList for dynamic array functionality

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Arrayframe frame = new Arrayframe();
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
	public Arrayframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1410, 739);
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
		
		headingarraydstxt = new JTextField();
		headingarraydstxt.setFont(new Font("Tahoma", Font.BOLD, 28));
		headingarraydstxt.setHorizontalAlignment(SwingConstants.CENTER);
		headingarraydstxt.setText("ARRAY DATA STRUCTURE");
		headingarraydstxt.setBounds(458, 40, 494, 66);
		contentPane.add(headingarraydstxt);
		headingarraydstxt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("SIZE");
		lblNewLabel.setForeground(new Color(255, 255, 128));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(458, 180, 112, 59);
		contentPane.add(lblNewLabel);
		
		sizeofarrfld = new JTextField();
		sizeofarrfld.setFont(new Font("Tahoma", Font.BOLD, 16));
		sizeofarrfld.setBounds(606, 180, 119, 59);
		contentPane.add(sizeofarrfld);
		sizeofarrfld.setColumns(10);
		
		JButton crtarrbtn = new JButton(" CREATE");
		crtarrbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int inputSize = Integer.parseInt(sizeofarrfld.getText().trim());
	        		
	        		if(inputSize<=0)
	        		{
	        			JOptionPane.showMessageDialog(null,"Array size must be greater than zero(0)");
	        			return;
	        		}
	        		
	        		int arr[] = new int[inputSize];
	        		Arrayframe.this.size=inputSize;
	        		Arrayframe.this.arr=arr;
	    			JOptionPane.showMessageDialog(null,"Array of size " + inputSize +" has been created !");

 				}
				catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid size!");
 				}
 			}
		});
		crtarrbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		crtarrbtn.setBounds(788, 178, 128, 55);
		contentPane.add(crtarrbtn);
		
		JLabel lblElement = new JLabel(" ELEMENT");
		lblElement.setForeground(new Color(255, 255, 128));
		lblElement.setHorizontalAlignment(SwingConstants.CENTER);
		lblElement.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblElement.setBounds(355, 280, 112, 59);
		contentPane.add(lblElement);
		
		elemttxtfld = new JTextField();
		elemttxtfld.setFont(new Font("Tahoma", Font.BOLD, 16));
		elemttxtfld.setColumns(10);
		elemttxtfld.setBounds(506, 284, 119, 59);
		contentPane.add(elemttxtfld);
		
		JLabel lblPosition = new JLabel(" POSITION");
		lblPosition.setForeground(new Color(255, 255, 128));
		lblPosition.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosition.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblPosition.setBounds(660, 284, 128, 59);
		contentPane.add(lblPosition);
		
		posninsrttxtfld = new JTextField();
		posninsrttxtfld.setFont(new Font("Tahoma", Font.BOLD, 16));
		posninsrttxtfld.setColumns(10);
		posninsrttxtfld.setBounds(798, 284, 119, 59);
		contentPane.add(posninsrttxtfld);
		
		JButton insrtarrbtn = new JButton(" INSERT");
		insrtarrbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					elem=Integer.parseInt(elemttxtfld.getText().trim());
		        	pos=Integer.parseInt(posninsrttxtfld.getText().trim());
		        	if(pos>=0 && pos<=arr.length-1)
		        	{
		        		arr[pos]=elem;
		        		JOptionPane.showMessageDialog(null,"Element " + elem + " has been inserted successfully!");
		        	}
		        	else
		        	{
		        		JOptionPane.showMessageDialog(null, "Enter a valid position to insert!");
		        	}

				} 
				catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please enter valid numbers!");
				}
			}
		});
		insrtarrbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		insrtarrbtn.setBounds(990, 284, 128, 55);
		contentPane.add(insrtarrbtn);
		
		JLabel lblPosition_1 = new JLabel(" POSITION");
		lblPosition_1.setForeground(new Color(255, 255, 128));
		lblPosition_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosition_1.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblPosition_1.setBounds(355, 410, 128, 59);
		contentPane.add(lblPosition_1);
		
		delposntxtfld = new JTextField();
		delposntxtfld.setFont(new Font("Tahoma", Font.BOLD, 16));
		delposntxtfld.setColumns(10);
		delposntxtfld.setBounds(506, 410, 119, 59);
		contentPane.add(delposntxtfld);
		
		JButton dltarrbtn = new JButton(" DELETE");
		dltarrbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(size>0)
	        		{
	        			pos=Integer.parseInt(delposntxtfld.getText().trim());
	            		if(pos>=0 && pos<=arr.length-1)
	            		{
	            			JOptionPane.showMessageDialog(null, "Element " + arr[pos] + " has been deleted successfully!");
	            			arr[pos] = 0;
	            		}
	            		else
	            		{
	            			JOptionPane.showMessageDialog(null, "Please enter a valid position to delete");
	            		}
	        		}
	        		
	        			JOptionPane.showMessageDialog(null, "Please create an array first!");
	        		
 
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid position!");
                }
			}
		});
		dltarrbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		dltarrbtn.setBounds(672, 410, 128, 59);
		contentPane.add(dltarrbtn);
		
		disparrtxtfld = new JTextField();
		disparrtxtfld.setFont(new Font("Tahoma", Font.BOLD, 16));
		disparrtxtfld.setColumns(10);
		disparrtxtfld.setBounds(365, 512, 618, 103);
		contentPane.add(disparrtxtfld);
		
		JButton disparrbtn = new JButton(" DISPLAY");
		disparrbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(size > 0) {
						StringBuilder s = new StringBuilder();
						for(int i =0;i < arr.length;i++) {
							s.append(arr[i]+", ");
						}
						disparrtxtfld.setText(s.toString());
 					} else {
 						JOptionPane.showMessageDialog(null, "OOPS! Array is empty.");
 					}
				}
				catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "OOPS! Create an array first!");
				}
 			}
		});
		disparrbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		disparrbtn.setBounds(1054, 512, 168, 96);
		contentPane.add(disparrbtn);
		
		JButton btnBack = new JButton(" BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 setVisible(false);
				DSAproject dsAproject = new DSAproject();
				dsAproject.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		btnBack.setBounds(640, 625, 128, 55);
		contentPane.add(btnBack);
	}
}
