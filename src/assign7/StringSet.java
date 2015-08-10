package assign7;


/**
 *  StringSet is a collection of non-null strings, with no duplicates
 * @author James Yeates
 *
 */

public class StringSet {
    
	DynamicArray2 dynamicArray;
    
    public StringSet() {
    	dynamicArray = new DynamicArray2();
    }
    
    /**
     * adds e to the set if there is not already an element in the set equal
     * to e
     * @param e String to be added if not already in the set
     */
   
    public void insert(String e) {
    	if(e == null){
    		throw new IllegalArgumentException();
    	}
    	
    	//check to see if e is in the set
    	if(!contains(e))
    		dynamicArray.add(e);
    }
    
  /**
   * Checks to see if e is in the set
   * @param the String to be checked
   * @return the boolean result if e is in the list
   */
    public boolean contains(String e) {

    	if(e == null){
    		throw new IllegalArgumentException();
    	}
    	
		for(int i = 0; i < dynamicArray.size(); i++)
			if(dynamicArray.get(i).equals(e))
				return true;
        return false;
    }
    
  /**
   * Removes the given string from the set
   * @param e the String to be removed
   */
    public void remove(String e) {
    	if(e == null){
    		throw new IllegalArgumentException();
    	}
    	for(int i = 0; i < dynamicArray.size(); i++)
    		if(dynamicArray.get(i).equals(e))
    			dynamicArray.remove(i);
    }
    
    /**
     * Returns the number of strings in the set
     * @return the number of strings in the set
     */
    public int size() {

        return dynamicArray.size();
    }  
    
    /**
     * Creates a string representation of the set
     * @return a string representation if the set
     */
    public String toString() {
    	String result = "{";
		if(size() > 0) 
			result += dynamicArray.get(0);
		
		for(int i = 1; i < size(); i++) 
			result += ", " + dynamicArray.get(i);
		
		return result + "}";
    }
}