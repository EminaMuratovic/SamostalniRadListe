public class DynamicArrayInt {
	private int[] array;
	private int size;
	private final int DEFAULT_SIZE = 10;

	public DynamicArrayInt() {
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
		array[size] = value;
		size++;
	}
	
	public void add(int value, int index) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("...");
		if (size == array.length)
			resize();
		for(int i = size; i > index; i--)
			array[i] = array[i - 1];
		array[index] = value;
		size++;
	}

	public void remove(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("...");
		for (int i = index; i < size - 1; i++) {
			array[i] = array[i + 1];
		}
		size--;
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