
import java.io.BufferedReader;          //reads text from the input stream
import java.io.IOException;		//to throw a failure in Input & Output operations
import java.util.Arrays;		//provides static methods to dynamically create and access Java arrays
import java.io.File;					
import java.io.FileReader;      		  

public class Project1 {
    //Method for accessing Integer Arrays outside of their for loop
	//and for printing
	public static void printArray(int arr[]){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
   
    //Method for splittng the Integer array into two arrays:
    //inputValues[] and targetValues[]
	public static void splitArray(int arr[], int ZeroIndex) {
	int[] inputValues = new int[ZeroIndex];
	int[] targetValues = new int[(arr.length) - (inputValues.length)];
	for(int i = 0; i < arr.length; i++) {
	    if(i < inputValues.length)
	     inputValues[i] = arr[i];
	    else
	     targetValues[i - inputValues.length] = arr[i];
            }
	System.out.println("Input Values:");
	printArray(inputValues);
	Arrays.sort(inputValues);
	System.out.println("The sorted array of the input values:");
	printArray(inputValues);
		

		System.out.println("Target Values:");
		printArray(targetValues);
		
		findElements(inputValues, targetValues);
	}
	//Method for finding the three elements
	public static void findElements(int[] inputValues, int[] targetValues) {
		int a, sum, start, end, tempSum;
	for(int i = 1; i < targetValues.length; i++) {
	     a = targetValues[i];     //reduced to two elements
	  for(int j = 0; j < inputValues.length; j++) {
		  sum = a - inputValues[j];
		   start = j + 1;
		   end = inputValues.length - 1;
		   tempSum = inputValues[start] + inputValues[end];
		   while(start < end) {
			 if(tempSum == sum) {
				 System.out.print("Found 3 elements: " + inputValues[start] + " " + inputValues[end] + " " + inputValues[j] + " ");
				 System.out.print("Of sum, " + targetValues[i]);
				 System.out.println();
				 return;
			 }
			 else if(tempSum < sum)
				 start++;
			 else
				 end--;
		   }
	    }
	  }
	System.out.println("Target Values:");
	printArray(targetValues);
	}
	//main method	
	public static void main(String args[])throws IOException {
	//Read file with fileReader using BufferedReader
	//Providing the file path of the file input1.txt to read texts from
	File file = new File("/Users/sammanakabir/Desktop/comp482/Project1/src/input1.txt");
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
	  System.out.println("ZeroIndex: " + ZeroIndex);
	     
	  splitArray(IntArray, ZeroIndex);
      }
	 	  
}

	
 
	
