public class Main {
	public static void main(String[] args) {
		DynamicArray<String> arr = new DynamicArray<>(1);
		System.out.println(arr.toString());
		arr.add("1");
		arr.add("2");
		arr.add("3");
		arr.add("4");
		arr.add("5");
		arr.add(null);
		System.out.println(arr.toString());
		System.out.println(arr.indexOf("2"));
	
		System.out.println(arr.remove("5"));
		System.out.println(arr.toString());
	
		System.out.println(arr.remove("1"));
		System.out.println(arr.toString());

		System.out.println(arr.indexOf("2"));
		System.out.println(arr.get(2));
		arr.set(2, "19");
		System.out.println(arr.toString());

		arr.remove(null);
		System.out.println(arr.toString());
	}
}


@SuppressWarnings("unchecked")
class DynamicArray <T> {

	private T[] arr;
	private int len;	// actual length of the array, that is shown to the user
	private int capacity;	// actual capacity of the array, including empty space if there


	DynamicArray() {
		this(16);
	}

	DynamicArray(int capacity) {
		if(capacity<0)	throw new IllegalArgumentException("Illegal Capacity:"+capacity);
		this.capacity = capacity;
		arr = (T[]) new Object[this.capacity];
	}

	public T get(int index) {
		if (index >= len || index < 0) throw new IndexOutOfBoundsException("Index: "+index+", Length: "+len);
    	return arr[index];
	}

	public void set(int index, T val) {
		if (index >= len || index < 0) throw new IndexOutOfBoundsException("Index: "+index+", Length: "+len);
			arr[index] = val;
	}

	public void add(T val) {
		if(len+1>capacity) {
			// Resizing....
			if(capacity == 0) {
				capacity = 1;
			} else {
				capacity *= 2;
			}
			T[] newArr = (T[]) new Object[capacity];
			for(int i=0; i<len; i++) {
				newArr[i] = arr[i];
			}
			arr = newArr;
		} 
		arr[len] = val;
		len++;
	} 

	public boolean remove(Object obj) {
		int index = indexOf(obj);
		if(index == -1)	return false;
		return removeAt(index);
	}

	public boolean removeAt(int index) {
		if(len <= index || index < 0)	throw new IndexOutOfBoundsException("Index: "+index+", Length: "+len);
		arr[index] = null;
		for(int i=index+1; i<len; i++) {
			arr[i-1] = arr[i];
			// swapping values to readjust the array.
			// and setting the last val position as null
			if(i==len-1)	arr[i] = null;
		}
		len--;
		return true;
	}

	public int size() {
		return len;
	}

	public boolean isEmpty() {
		if(len==0)
			return true;
		else
			return false;
	}

	public int indexOf(Object obj) {
		for(int i=0; i<len; i++) {
			if(obj == null && arr[i] == null)
				return i;
			else if(obj != null && arr[i].equals(obj))
				return i;
		}
		return -1;
	}

	public void clear() {
		for(int i=0; i<len; i++)
			arr[i] = null;
		len = 0;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("[");
		for(int i=0; i<len; i++) {
			str.append(String.valueOf(arr[i]));
			if(i<len-1)	str.append(",");
		}
		str.append("]");
		return str.toString();
	}


}


