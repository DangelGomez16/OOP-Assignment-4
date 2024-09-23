package assignment4;

public class Record {
	// Private int and string instance variables made to be accessed
	// by all the methods of the class.
	private int number;
	private String value;
	
	// Initiates a record using the given number and value.
	public Record(int number, String value) {
		this.number = number;
		this.value = value;
	}
	
	// Returns number of record.
	public int getNumber() {
		return this.number;
	}
	
	// Returns value or record.
	public String getValue() {
		return this.value;
	}
	
	// Set the value of the record.
	public void setValue(String value) {
		this.value = value;
	}
	
	// Set the number of the record.
	public void setNumber(int number) {
		this.number = number;
	}
	
	// Return a string as number:value.
    @Override
    public String toString() {
        return number + ":" + value;
    }
}
