
import java.util.*;
import java.lang.*;
import java.io.*;

public class Largest {

	public String[] findLargest(String[] arrayOfString) {
		
		// words present in the array
		ArrayList<String> wordsPresent = new ArrayList<String>();

		// used ArrayList because we don't know how many unique words are there, also there are many functions that makes it easy

		// corresponding number of times that word is present
		ArrayList<Integer> timesPresent = new ArrayList<Integer>();
		

		for (String str : arrayOfString) {

			if(wordsPresent.contains(str)){

				// if word is present, find it's index number where it is present
				int index = wordsPresent.indexOf(str);
				
				// get the no. of times it is present
				int no = timesPresent.get(index);
				
				// update the no. 
				timesPresent.set(index, ++no);
			}
			else{

				// else add the word and 1.
				wordsPresent.add(str);
				timesPresent.add(1);
			}
		}

		// sort on basis of timesPresent but reflect in wordsPresent.

		int size = timesPresent.size();
		for (int i = 0 ; i < size - 1; i++ ) {
			for(int j = i + 1; j < size; j++){

				int next = timesPresent.get(j);
				int current = timesPresent.get(i);

				if(next > current){
					String nextWord = wordsPresent.get(j);
					String currentWord = wordsPresent.get(i);
					
					wordsPresent.set(j, currentWord);
					wordsPresent.set(i, nextWord);

					timesPresent.set(j, current);
					timesPresent.set(i, next);
				}
			}
		}


		// remove the remaining elements
		for(int i = 5; i<size; i++)
			wordsPresent.remove(i);

		String[] largest5 = wordsPresent.toArray(new String[0]);


		return largest5;

	}

	public static void main(String[] args) {

		Largest l = new Largest();
		String[] str = {"Pune", "Pune", "Pune", "Delhi", "Delhi", "Bangalore", "Bangalore", "Bangalore", "Bangalore", "Bangalore", "Hyderabad", "Patna", "Jaipur", "Jaipur", "Jaipur"};
		String[] soln = l.findLargest(str);
 
		System.out.println("Given String array:");
		for (String str1 : str) {
			System.out.print(str1 + " ");
		}

		System.out.println("");
		System.out.println("");

		System.out.println("Five Most Repeated Words in Sorted Order:");
		for (String str1 : soln) {
			System.out.print(str1 + " ");
		}
	}
}