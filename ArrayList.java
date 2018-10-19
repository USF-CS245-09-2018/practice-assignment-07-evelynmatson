import java.util.Arrays;

public class ArrayList implements List {

    private int size;
    private Object[] arr;

    public ArrayList() {
        this.size = 0;
        this.arr = new Object[4];
    }

    @Override
    public void add(Object obj) {
        if (this.arr.length == this.size) {
            this.grow_array();
        }

        this.arr[this.size] = obj;
        this.size++;
    }

    @Override
    public void add(int pos, Object obj) {
        // Make sure the pos isnt too big
        if (pos > this.size) {
            throw new IndexOutOfBoundsException("The ArrayList is smaller than the pos passed as an argument.");
        // Grow the array if needed
        } else if (this.arr.length == this.size) {
            this.grow_array();
        }

        // Move things out of the way
        for (int i = this.size-1; i >= pos; i--) {      // Iterate from i = end of array to i = pos to insert
            this.arr[i+1] = this.get(i);
        }

        this.arr[pos] = obj;
        this.size++;
    }

    @Override
    public Object get(int pos) {
        if (size() <= pos) {
            throw new IndexOutOfBoundsException("Invalid index.");
        } else {
            return arr[pos];
        }
    }

    @Override
    public Object remove(int pos) {
        // Make sure the position is valid
        if (pos >= size()) {
            throw new IndexOutOfBoundsException("Invaild pos.");
        }
        Object toReturn = this.get(pos);

        for (int i = pos; i < size-1; i++) {      // Iterate from pos to size-1
            this.arr[i] = this.get(i+1);
        }

        size--;
        return toReturn;
    }

    @Override
    public int size() {
        return this.size;
    }

    private void grow_array() {
        Object[] newArr = new Object[this.arr.length * 2];
        for (int i=0; i < this.arr.length; i++) {
            newArr[i] = arr[i];
        }

        this.arr = newArr;
    }


    public static void main(String[] args) {
        ArrayList myArrayList = new ArrayList();
        System.out.println("\tStart: " + Arrays.toString(myArrayList.arr));

        System.out.println("Adding 5...");
        myArrayList.add(5);
        System.out.println("Adding 43...");
        myArrayList.add(43);
        System.out.println("Adding 12...");
        myArrayList.add(12);
        System.out.println("Adding 92...");
        myArrayList.add(92);
        System.out.println("\t" + Arrays.toString(myArrayList.arr) + ", size = " + myArrayList.size);

        System.out.println("Adding 16...");
        myArrayList.add(16);
        System.out.println("\t" + Arrays.toString(myArrayList.arr) + ", size = " + myArrayList.size);

        System.out.println("Removing pos = 0...");
        System.out.println(myArrayList.remove(0));
        System.out.println("\t" + Arrays.toString(myArrayList.arr) + ", size = " + myArrayList.size);

    }

}
