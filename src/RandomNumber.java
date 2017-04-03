import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


public class RandomNumber {        
	Random randGen= new Random();
	int [] NumberToGuess= new int [4];
	boolean flag=true;
	int i=0;
	public int[] GetRandNum() {
		
	    int[] solutionArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0};   //shuffle the array for random number 

	    shuffleArray(solutionArray);
	    while(solutionArray[0]==0)
	    {
	    	 shuffleArray(solutionArray);
	    }
	    for (int i = 0; i < 4; i++)                    // print the shuffle array on console for debug 
	    {
	      System.out.print(solutionArray[i] + " ");
	    }
	    System.out.println();                                            
	    for (int i = 0; i < NumberToGuess.length; i++) {   //  copy the shuffle array to anther array to guess
	    	NumberToGuess[i]=solutionArray[i];	
		}
	    
	    return NumberToGuess;	
}
		
public void shuffleArray(int[] ar)  //make the shuffle 
{
  Random rnd = new Random();
  for (int i = ar.length - 1; i > 0; i--)
  {
    int index = rnd.nextInt(i + 1);
   
    int a = ar[index];
    ar[index] = ar[i];
    ar[i] = a;
  }
}
	 	

}

