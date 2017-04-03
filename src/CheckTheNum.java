import java.util.Arrays;

import javax.swing.JOptionPane;


public class CheckTheNum {  /// 2-Right position green color , 1-Right number red color 
	
                                // create an array of "color" in right location



public int [] CompareDigits(int [] RndNum,int []NumUser) {
	int z=0;//counter of the right guess
	 int []  Correct_Guesses = new int [4];
	 for (int i = 0; i < RndNum.length; i++) {
		for (int j =0; j < NumUser.length; j++) {
			
			
			if(RndNum[i]==NumUser[j])
			{
				if(i==j)  //green color
				{
					Correct_Guesses[z]=2;
				z++;
				}
				else {
					Correct_Guesses[z]=1; //red color 
					z++;
					}

				}

			}
		}
// showMessageDialog - only use for debug
		/*JOptionPane.showMessageDialog(
				null,
				Integer.toString(Correct_Guesses[0])
						+ Integer.toString(Correct_Guesses[1])
						+ Integer.toString(Correct_Guesses[2])
						+ Integer.toString(Correct_Guesses[3]));*/
		return Correct_Guesses;
	}


}
