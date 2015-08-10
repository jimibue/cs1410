package assign7;


/**
 * This class builds and has methods to create dynamic arrays that hold strings.
 * @author James Yeates
 *
 */
public class DynamicArray2 {

	private String[] data;   // the backing array
	private int count;       // the number of elements in the dynamic array
	
	/**
	 * Creates an empty dynamic array with room to grow.
	 */
	public DynamicArray2() {
		data = new String[8];
		count = 0;
	}
	
	/**
	 * Returns the number of elements in the dynamic array.
	 * 
	 * @return the number of elements
	 */
	public int size() {
		return count;
	}
	
	/**
	 * Adds a string at the end of the Dynamic Array.  If the Array is not big enough
	 * a new array twice the original size is made with original values copied into it
	 * @param s the String to be added
	 */
	public void add(String s) {
		
		//if array is full make a new array twice the size and copy values into it
		if( count == data.length){
			
			String []tempData = new String [count*2];
			for(int i =0; i< data.length; i++){
				tempData[i]= data[i];
			}
			
			data = tempData;
			data[count]=s;
			
		}
		data[count] = s;
		count++;
	}
	
	/**
	 * Inserts a string at the specified index creates a new array if needed
	 * @param i integer- the index at which to insert the String
	 * @param s String to be inserted
	 */
	public void add(int i, String s) {	
		//Throw an Exception if invalid index is given
		if( i < 0 || i > count )//? should this be count + 1
			throw new IndexOutOfBoundsException();
		
		//create new array if needed
		if( count ==data.length){
			
			String []tempData = new String [count*2];
			for(int j =0; j< data.length; j++){
				tempData[j]= data[j];
			}
			data = tempData;
		}
		//move items in array one over from index i
		for(int k = count-1; k >= i; k--){
			
			data[k+1] = data[k];
			
		}
		data[i]= s;
		count++;
	}
	
	/**
	 * this method removes an element from an array and moves the element the right
	 * one unit to the left to fill in the gap.
	 * @param i the index at which to remove the element
	 */
	public void remove(int i) {	
		//Throw an Exception if invalid index is given
		if( i < 0 || i >= count)//? should this be count + 1
			throw new IndexOutOfBoundsException();
		//shift items from index i one to the left
		for( int k = i; k< count-1; k++)
			data[k] = data[k+1];
		//System.out.println(count);
		data[count-1] = null;
		count--;
	}
	
	/**
	 * This returns the element at the given index
	 * @param i the index
	 * @return  String at index 'i'
	 */
	public String get(int i) {
		if( i < 0 || i >= count)
			throw new IndexOutOfBoundsException();
		return data[i];
		
	}
	
	/**
	 * 
	 * replaces the element at index i 
	 * @param i integer- the index at which to replace
	 * @param s String- the element to replace
	 */
	public void set(int i, String s) {
		//Throw an Exception if invalid index is given
		if( i < 0 || i >= count )
			throw new IndexOutOfBoundsException();
		data[i] = s;
	}
	
	/**
	 * Returns a formatted string version of this dynamic array.
	 * 
	 * @return the formatted string
	 */
	public String toString() {
		String result = "[";
		if(size() > 0) 
			result += get(0);
		
		for(int i = 1; i < size(); i++) 
			result += ", " + get(i);
		
		return result + "]";
	}
	
	/**
	 * Returns the length of the array, used to see if array is growing as specified.
	 * @return the length of the array
	 */
	public int getDataLength(){
		return data.length;
	}
}
