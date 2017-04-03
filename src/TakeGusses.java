import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import javax.swing.*;
 
    public class TakeGusses extends JPanel  {
    public JTextField text;
    public String s ; 
 
    public TakeGusses() {       // create a new text field an add to frame
       
    	Font font1 = new Font("SansSerif", Font.BOLD, 20);
        JPanel panel = new JPanel();
        
        text=new JTextField("Enter 4 Digit Number  (need to be different digits)",30);
        text.setFont(font1);
        text.setHorizontalAlignment(JTextField.CENTER);
        panel.add(text);
        
text.addFocusListener(new FocusListener() {
	
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override                                  //clear the text field 
	public void focusGained(FocusEvent e) {
		text.setText("");
		s=text.getText();
		
	}
});

     
        

        add(panel);
    }  
    
    
public String UserGuess() {     // return the user guess to main prog
	s=text.getText();
	return s;
}    
    
public int []  CheckString_() {    //chek if that string is valid
int [] UserNum={0,0,0,0};
String UserGs=text.getText();
String [] parts = UserGs.split("");   //split the string guess to array 
int Temp; //debug use

		if((UserGs.length())==4)		// if 4 digit  return null
		{
			if(isNumeric(UserGs))   // if only Numeric digit  return null
			{
			    for (int i=0; i < UserGs.length(); i++) {      // convert to int return null
			    	UserNum[i] = Integer.parseInt(parts[i]);
			    }
			     if(UserNum[0]!=0)  // check if the first digit is zero return null
			     {
			    	 for (int i = 0; i < UserNum.length; i++) {    //// check for different digit return null
						for (int j =i+ 1; j < UserNum.length; j++) {  

							if(UserNum[i]==UserNum[j])
							{
								JOptionPane.showMessageDialog(null, "Please try again . 4 number digit (need to be different digits) ");
								Arrays.fill(UserNum, 0);
								text.setText("");
								return UserNum =null;
								
							}
							
						}
					}
			     }
			  
			     
			     else {
						JOptionPane.showMessageDialog(null, "Please try again . 4 number digit (first digit != 0) ");
						Arrays.fill(UserNum, 0);
						text.setText("");
						return UserNum =null;
				}
			    
			}
			else {
				JOptionPane.showMessageDialog(null, "Please try again . 4 number digit (only digit) ");
				Arrays.fill(UserNum, 0);
				text.setText("");
				return UserNum =null;
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Please try again . 4 number digit (only 4 digit number) ");
			Arrays.fill(UserNum, 0);
			text.setText("");
			return UserNum =null;
		}
    text.setText("");   //clear text field 
	return UserNum;       // return the array of guess
	
}

public boolean isNumeric(String str)   // check if numeric 
{
  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
}

}