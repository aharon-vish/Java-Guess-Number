import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.lang.reflect.Array;
import java.security.AllPermission;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.plaf.ColorUIResource;
public class MasterMind{
	
          
	public static void main(String[] args) {
	    

		RandomNumber Rnd=new RandomNumber(); //make a rnd number for guess
		JFrame application = new JFrame();		// new frame window
	    TakeGusses UserGuess=new TakeGusses();  // new text filed for user guesses 
	  
	    
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();  // size of a screen
	    double height = screenSize.getHeight();
	    double width = screenSize.getWidth();
	    
	    
	    CheckTheNum  CheckUserVsRnd =new CheckTheNum();    // obj that check the number 
		JPanel panel=new JPanel();      // create new panel with text filed  
		
		int [][] SaveGussesCircle= new int [25][4];   //save all the color circle
		
		


		panel.setLayout(null);

		JButton CheckButton=new JButton("Check Number");  //new button
		
	    application.add(CheckButton);

	    
	    int [] RandNum =Rnd.GetRandNum();   // get the number for guesses in to array 
         	    
	    
	    Dimension size = CheckButton.getPreferredSize(); // size button
	    int ButWidth =((((int) width/2)/2)-80);
	    int ButHeight =(((int) height)-150);
	    CheckButton.setBounds(ButWidth,ButHeight,
	             size.width, size.height);
	    
		application.setLayout(new BorderLayout() );
	    
	      
	     application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );   //size window
	     application.setSize((int)width/2,(int)height-40); 
	     application.add(panel);
	     
	     application.add(UserGuess,BorderLayout.PAGE_END);   
	     application.setVisible( true );

	     CheckButton.addActionListener(new ActionListener() {  // when the user press on the button it came here
	     int NumberOfTryGusse;  // count the try and the row when we print the circle
	     String [] _UserGuess = new String[25];  // save the string of the guess to print it later 
			@Override
	
			
			
			
			
			public void actionPerformed(ActionEvent e) {

				_UserGuess [NumberOfTryGusse]  = UserGuess.UserGuess();      //on click 
				int [] UserNum = UserGuess.CheckString_();                  // save the user to array
				int [] PositonOfCircle =CheckUserVsRnd.CompareDigits(RandNum,UserNum);   //compare between them and save the answer in array 
				
				for (int i = 0; i < PositonOfCircle.length; i++) {     //save all the tries in two dimensional array [pos][row] 
					SaveGussesCircle[NumberOfTryGusse][i]=PositonOfCircle[i];
				}
				
				
				
				
			if(UserNum!=null)
				{					
					DrawPanel DrowovalGus = new DrawPanel(PositonOfCircle,_UserGuess,SaveGussesCircle,NumberOfTryGusse); //make new panel   
					application.add(DrowovalGus);					
					application.setVisible( true );
					NumberOfTryGusse++;
					if(NumberOfTryGusse==24)   // check if the user try over 25 guesses
					{
						JOptionPane.showMessageDialog(null, "You 've used all your 25 guesses,  Bye Bye ");
						System.exit(0);
					
					}
					
                 if(PositonOfCircle[0]==2&&PositonOfCircle[1]==2&&PositonOfCircle[2]==2&&PositonOfCircle[3]==2) // check if he guess right
                 {
						JOptionPane.showMessageDialog(null, "Congratulations you guessed it, Bye Bye ");
						System.exit(0);
                 }
						
					}
					
				}
				

	
			
		});
	     

	      

	}

}
