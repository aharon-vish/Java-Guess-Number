import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.TextArea;
import java.awt.font.ShapeGraphicAttribute;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DrawPanel extends JPanel  //get array of "color" and print them 
{
                                       
	int CorX;
	int CorY;
	int CorydrawString=20;;
	private int [] PosGusses;
	private String [] numberFromUser;
	private int [][] ColorPos;
	private int NumberOfTryGusse;
	
    public DrawPanel(int [] _PosGusses, String _numberFromUser[],int [][] ColorPos,int NumberOfTryGusse )                      
    {
    	 super();
    	 this.NumberOfTryGusse=NumberOfTryGusse;
    	 this.ColorPos=ColorPos;
    	numberFromUser=_numberFromUser;
    	PosGusses=_PosGusses;
    }

    public void paintComponent(Graphics g)  
    {
   
        super.paintComponent(g); 

   for (int i = 0; i <= NumberOfTryGusse; i++) {     //  iterate on two dimensional array if NumberOfTryGusse=0 so one row if NumberOfTryGusse=1 make tow ....
	   for(int j=0;j<4;j++)
       {
    	   if(ColorPos[i][j]==1)     // make  red circle
    	   {
           g.setColor(Color.red);
           g.fillOval(CorX,CorY, 25, 25); 
           CorX=CorX+35;
    	   }
    	   if(ColorPos[i][j]==2)   // make green circle
    	   {
               g.setColor(Color.green);
               g.fillOval(CorX,CorY, 25,25);
               CorX=CorX+35;
    	   }
     
      }  
       
	   
	    g.setFont(new Font("TimesRoman", Font.PLAIN, 20));    
	    g.setColor(Color.blue);
	    g.drawString("Number Of Gusses: "+(i+1) +" , "+ "User Gusse: "+numberFromUser[i],getWidth()-350,CorydrawString);// drow the guess and the num of try
	   
       CorY=CorY+30;        //row down
       CorydrawString=CorydrawString+30;
       CorX=0;   //make for new row strat at 0
}

	
}
}
