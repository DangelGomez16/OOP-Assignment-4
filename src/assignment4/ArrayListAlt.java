package assignment4;
import java.util.ArrayList;

public class ArrayListAlt {
	// An ArrayList is made an instance variable so that it can be accessed in other
	// methods.
	private ArrayList<Record> records;
	
	// Initiates the ArrayList.
	public ArrayListAlt() {
		this.records = new ArrayList<>();
	}
	
	// Adds a new record to the ArrayList.
	public void add(Record r) {
		// Finds whether or not this record number already exists.
		int position = find(r.getNumber());
		
		// If the record number does exist, the value is replaced with the new
		// record value.
		if(position != -1) {
			records.get(position).setValue(r.getValue());
		}
		
		// Otherwise, add a new record to the array. Then, sort the list.
		else {
			records.add(r);
			records.sort((r1, r2) -> Integer.compare(r1.getNumber(), r2.getNumber()));
		}
	}

	// Returns true if a record was removed, false if not.
	public boolean remove(int num) {
		// Finds the position of the record in the array.
		int position = find(num);
		
		// If there is a position, remove it from the array.
		if(position != -1) {
			records.remove(position);
			return true;
		}	
		// Otherwise, return false.
		else {
			return false;
		}
	}
	
	// A method which returns a string which holds the contents of the array.
	@Override
	public String toString() {
		// If the array is empty, return empty string.
	    if (records.isEmpty()) {
	        return "";
	    }
	    
	    // Otherwise, create a string which starts with an open bracket, 
	    // then append the number and value of each record separated by a colon. 
	    StringBuilder sb = new StringBuilder();
	    sb.append("[");
	    for (int i = 0; i < records.size(); i++) {
	        sb.append(records.get(i).toString());
	        if (i < records.size() - 1) {
	            sb.append(", ");
	        }
	    }
	    
	    // End with a closed bracket and return string.
	    sb.append("]");
	    return sb.toString();
	}

	// Finds the index in the array where a number would be.
	private int find(int number) {
		// Goes through the array index by index. If the index number and the given number
		// match, then it returns the index.
		for(int i = 0; i < records.size(); i++) {
			if(records.get(i).getNumber() == number) {
				return i;
			}
		}
		
		// Otherwise, return -1 to indicate failure.
		return -1;
	}
	
	// Returns the record value of a given record number.
	public String get(int number) {
		// Searches for the position of the given number.
		int position = find(number);
		
		// Returns the record value.
		if(position != -1) {
			return records.get(position).getValue();
		}
		
		// Otherwise, return null.
		else {
			return null;
		}
	}
	
	// Returns size of the array.
	public int size() {
		return records.size();
	}
    
}
