package assignment4;

public class MyHashTable {
	// Private ArrayListAlt and int made instance variables for access
	// by the rest of the methods in this class to be possible.
	private ArrayListAlt[] hashArray;
	private int size;

	// If an int size is given, the hashArray is initiated using the size given.
	public MyHashTable(int size) {
		this.size = size;
		this.hashArray = new ArrayListAlt[size];
		
		// At each index of the hash array an array is initialized.
		for(int i = 0; i < size; i++) {
			hashArray[i] = new ArrayListAlt();
		}
	}
	
	// If an int size is not given, the hashArray is initiated with a size of 11.
	public MyHashTable() {
		this.size = 11;
		this.hashArray = new ArrayListAlt[11];

		// At each index of the hash array an array is initialized.
		for(int i = 0; i < size; i++) {
			hashArray[i] = new ArrayListAlt();
		}
	}
	
	// Returns the index to where a record would be stored in the hashArray.
    private int hashFunc(int position) {
        return position % size;
    }
	
    // Adds a record to the hashArray at the appropriate index.
    public void add(Record a) {
        int hashIndex = hashFunc(a.getNumber());
        hashArray[hashIndex].add(a);
    }
    
    // Removes a record from the hashArray by finding the appropriate index
    // and checking if that particular array stores that record. 
    public void remove(int number) {
    	int hashIndex = hashFunc(number);
    	if(!hashArray[hashIndex].remove(number)) {
    		System.out.println("No such element");
    	}
    }
    
    // Returns a record from the hashArray based off the number given.
    public String get(int number) {
        int hashIndex = hashFunc(number);
        return hashArray[hashIndex].get(number);
    }
    
    // A method which returns a string which holds all of the contents of the hashArray.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(i).append(": ").append(hashArray[i].toString()).append("\n");
        }
        return sb.toString();
    }
}
