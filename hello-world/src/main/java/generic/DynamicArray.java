package generic;

import java.util.Arrays;

/**
 * @author hzk
 */
public class DynamicArray<E> {
    private static final int DEFAULT_CAPACITY = 10;
    public int size;
    private Object[] elementData;

    public DynamicArray() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapacity(int minCapacity){
        int oldCapacity=elementData.length;
        if(oldCapacity>=minCapacity){
            return;
        }
        int newCapacityp=oldCapacity*2;
        if(newCapacityp<minCapacity){
            newCapacityp = minCapacity;
            elementData= Arrays.copyOf(elementData,newCapacityp);
        }
    }
    public void add(E e){
        ensureCapacity(size+1);
        elementData[size++]=e;
    }
    public E get(int index){
        return (E)elementData[index];
    }
    public E set(int index,E element){
        E oldvalue  = get(index);
        elementData[index]=element;
        return oldvalue;
    }

}
