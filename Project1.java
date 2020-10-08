
import java.io.BufferedReader;          //reads text from the input stream
import java.io.IOException;		//to throw a failure in Input & Output operations
import java.util.Arrays;		//provides static methods to dynamically create and access Java arrays
import java.io.File;					
import java.io.FileReader;      		  

public class Project1 {
    public class Project1 {
	static void SumChecker(int[] targetValues, int[] inputValues){
	  for(int i = 0; i < targetValues.length; i++)
	  {
		int j = 0, k = 1, f = inputValues.length - 1, sum = 0;
		while(targetValues[i] != sum && j < inputValues.length - 2)
		{
	      sum = inputValues[j] + inputValues[k] + inputValues[f];
		  if(sum == targetValues[i])
		  {
		   System.out.println(sum + " YES"); 
		  }
		  else if(sum < targetValues[i] && k < f - 1)
		  {
		    k++;
		  }
		  else if(sum > targetValues[i] && f > k + 1)
		  {
		    f--; 
		  }
		  else
		  {
			j++;
			k = j + 1;
			f = inputValues.length - 1;
		  } 
		}
		if(targetValues[i] != sum)
		{
		  System.out.println(targetValues[i] + " NO");
		}
	  }
	}
	//main method	
	public static void main(String args[])throws IOException {
	//Read file with fileReader using BufferedReader
	//Providing the file path of the file input1.txt to read texts from
	//File file = new File("/Users/sammanakabir/Desktop/comp482/Project1/src/input1.txt");
	File file = new File("input1.txt");
	BufferedReader reader = new BufferedReader(new FileReader(file));
	String input;
		
	//building a string for storing the input from the file
	StringBuilder holder = new StringBuilder();
		
	while((input = reader.readLine())!= null) {
	  holder.append(input);   				           //placing the input from the file to the String holder
	  System.out.println("Reading: " + input);
	  holder.append(" ");   					   //placing space between string 
	}
	System.out.println("Holder: " + holder);  
	String string = holder.toString();  
	
	String[] ArrayStr = string.split(" "); 		                   //Using space to split
	int[] IntArray = new int[ArrayStr.length];	               	   //Initialization of IntArray[]
	     
	System.out.println("The converted Int Array is below:");
	for(int i = 0; i < ArrayStr.length; i++) {
	   (IntArray[i]) = Integer.parseInt(ArrayStr[i]);
	    // System.out.print(IntArray[i] + " ");
	 }
	 printArray(IntArray);
	 System.out.println();
	     
	 //finding the ZeroIndex of the Integer array
	 int ZeroIndex = 0;
	 for(int i = 0; i < IntArray.length; i++) {
	    if(IntArray[i] == 0) {
	       ZeroIndex = i;	
	    }
	  }
	  //Splitting the Integer Array to inputValues[] and targetValues[]
 	int[] inputValues = new int[ZeroIndex];
	int[] targetValues = new int[(IntArray.length) - (inputValues.length)];
	for(int i = 0; i < IntArray.length; i++)
	{
	  if(i < inputValues.length)
	  {
		inputValues[i] = IntArray[i];
	  }
	  else
	  {
		targetValues[i - inputValues.length] = IntArray[i];
	  }
	}
	
	Arrays.sort(inputValues);							
    SumChecker(targetValues, inputValues);	    	  //Calling the function 
	}
	 
      }
	 	  
}

	
 
	
