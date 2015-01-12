
public class SortedDynamicArrayInt {
	private int[] array;
	private int size;
	private final int DEFAULT_SIZE = 10;
	
	public SortedDynamicArrayInt() {
		size = 0;
		array = new int[DEFAULT_SIZE];
	}
	
	public boolean contains(int value) {
		for(int i = 0; i < size; i++) {
			if(array[i] == value)
				return true;
		}
		return false;
	}
	
	public void add(int value) {
		if (size == array.length)
			resize();
		int i = 0;
		while(array[i] < value){
			i++;
		}
		for(i = size; i > array[i]; i--) {
			array[i] = array[i - 1];
		}
		array[i] = value;
		size++;
	}
	
	private void resize() {
		int[] temp = new int[size * 2];
		for (int i = 0; i < size; i++) {
			temp[i] = array[i];
		}
		array = temp;
	}

	public int getSize() {
		return size;
	}

	public String toString() {
		String str = "";
		str += "[ ";
		for (int i = 0; i < size; i++) {
			str += array[i];
			if (i != size - 1)
				str += ", ";
		}
		str += " ]";
		return str;

	}

}
