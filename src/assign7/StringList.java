package assign7;

/**
 * StringList class-A StringList is an ordered collection of non-null strings, in which
 * the same string may occur more than once.
 * @author James Yeates
 *
 */
public class StringList {
	
	private DynamicArray2 dynamicArray;
	
      
    /**
     *  Creates an empty StringList object
     */
    public StringList() {
    	
    	dynamicArray = new DynamicArray2();
     }
    
   /**
     * This methods inserts a String at specific index
     * 
     * @param e String to be inserted in the list
     * @param i index to insert string
     */
    public void insert(String e, int i) {
    	if( e == null)
    		throw new IllegalArgumentException();
    	dynamicArray.add(i, e);
    }
    
    /**
     *  indicates whether the list contains e
     * @param e the string to be searched for
     * @return a boolean based on if the given string is in the list
     */
    
    public boolean contains(String e) {
    	if( e == null)
    		throw new IllegalArgumentException();
    	for(int i = 0; i< dynamicArray.size(); i++){
    		if( dynamicArray.get(i).equals(e)){
    			return true;
    		}
    	}
        return false;
    }
    
   /**
     *  removes all occurrences of e from the list
     * @param e the string to be removed
     */
    public void remove(String e) {
    	if( e == null)
    		throw new IllegalArgumentException();
    	
    	for(int i = 0; i< dynamicArray.size(); i++){
    		if( dynamicArray.get(i).equals(e)){
    			dynamicArray.remove(i);
    			i--;
    		}
    	}
    }
    
    /**
     *  Returns the number of strings in the list
     * @return  the number of strings in the list
     */
    public int size() {
  
        return dynamicArray.size();
    }  
    
    /**
	 * Returns the string list as a formatted string.
	 * 
	 * @return the string representation of the list
	 */
    public String toString() {
    	
		String result = "\"";
		if(size() > 0) 
			result += dynamicArray.get(0);
		
		for(int i = 1; i < size(); i++) 
			result += ", " + dynamicArray.get(i);
		
		
		return result + "\"";
	}
    
    
}