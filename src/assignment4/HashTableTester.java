// Daniel A. Gomez
package assignment4;
import java.io.*;
import java.util.Scanner;

public class HashTableTester {

	public static void main(String[] args) {	
		// If args.length is not 1 then that means that the program did not run with a text file
		// to read off of, and so the program is terminated. (This was for debugging).
        if (args.length != 1) {
            System.out.println("Usage: java HashTableTester <data file>");
            return;
        }		
		
		// Tries to handle read the contents of the file given. If it fails, then an exception is 
        // run and the program terminates. (This was necessary so that the scanner would work).
		try {	
			
			// Opens file, scans file into scanner, then initiates the hash table and size for the table.
			File file = new File(args[0]);
			Scanner scanner = new Scanner(file);
			int size = 0;
			MyHashTable table;
			
			// If the file has an integer as the first line, size is set to that integer.
			if(scanner.hasNextInt())
				size = scanner.nextInt();
			
			// The table is then made in the size of the previously received integer. If 
			// for some reason it didn't have an integer, the no argument constructor is used.
			if(size != 0) {
				table = new MyHashTable(size);
			}
			else {
				table = new MyHashTable();
			}
			
			// Goes through the file line by line until there are no more lines. 
			while(scanner.hasNextLine()) {
				
				// A string is given the contents of the current line.
				String line = scanner.nextLine();
				
				// If the line starts with "add", then it will pick apart the string so that
				// we can receive the number and value data needed to add a new record into the
				// hash table.
				if(line.startsWith("add")) {
					String[] parts = line.split(" ")[1].split(":");
					int number = Integer.parseInt(parts[0]);
					String value = parts[1];
					table.add(new Record(number, value));
				}
				
				// Otherwise, if it starts with "remove", we receive the number and remove the 
				// corresponding record from the hash table.
				else if(line.startsWith("remove")) {
					int number = Integer.parseInt(line.split(" ")[1]);
					table.remove(number);
				}
			}
			
			// Prints out the contents of the hash table.
			System.out.println(table);
			
			// Scanner is closed.
	        scanner.close();
		}
		
		// If the try didn't work, terminate program.
		catch(FileNotFoundException e){
            System.out.println("File not found: " + args[0]);
		}
	}
	
	
	
}
