
import java.io.BufferedReader;      //reads text from the input stream
import java.io.IOException;			//to throw a failure in Input & Output operations
import java.util.Arrays;
import java.io.File;
import java.io.FileReader;         

//Main method 
public class Project1 {
	//Method for accessing Integer Arrays outside of their for loop
	//and for printing
	public static void printArray(int arr[]){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
	public static void main(String args[])throws IOException {
	//Read file with fileReader using BufferedReader
	//Providing the file path of the file input1.txt to read texts from
		File file = new File("/Users/sammanakabir/Desktop/comp482/Project1/src/input1.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String input;	
		StringBuilder holder = new StringBuilder();
		while((input = reader.readLine())!= null) {
		//input = reader.readLine() ;
		 holder.append(input);   //placing the input from the file to the String holder
		 System.out.println(input);
		 holder.append(" ");     //placing space between string 
		}
		 System.out.println(holder);
	     String string = holder.toString();
	
	     
	     String[] ArrayStr = string.split(" "); 
	     int[] IntArray = new int[ArrayStr.length];
	     System.out.println("The converted Int Array is below:");
	     for(int i = 0; i < ArrayStr.length; i++) {
	      (IntArray[i]) = Integer.parseInt(ArrayStr[i]);
	        System.out.print(IntArray[i] + " ");
	        }
	     System.out.println();
	     System.out.println("After int array, the Sorted array using built in sort");
	     Arrays.sort(IntArray);
	    //	     for (int i = 0; i < IntArray.length; i++) {
//	         System.out.print(IntArray[ i ] + " ");
//			}
	     System.out.println();
	     Array(IntArray) ;
	  	}
	}