/*Evelyn Totman.
 * ArrayStack: Implements Stack ADT using array.
 * ArrayStack is implemented with an initial size given by the user or 2 if none is given.
 */

import java.util.EmptyStackException;

public class ArrayStack<E>{
    private E[] stack;
    private int capacity;
    private int topIndex;
    private int size;

    public ArrayStack(int initialCap){
        this.capacity = initialCap;
        topIndex = -1;
        size = 0;
        this.stack = (E[])(new Object[initialCap]);
    }

    public ArrayStack(){
        this(2);
    }

    public int getCapacity() {
        return capacity;
    }

    public int getTopIndex() {
        return topIndex;
    }

    public E[] getStack() {
        return stack;
    }

    /**
     * stackPush : pushes item to top of stack. If stack is full reallocates stack to larger stack.
     * @param item - item to be pushed to stack
     */
    public void stackPush(E item){
        if(capacity == size){
            reallocate();
        }
        topIndex++;
        stack[topIndex] = item;
        size++;
    }

    /**
     * stackPop - Removes top item of stack and returns its data.
     * @return E - data of removed item
     * @throws EmptyStackException - If there is no items in stack throws EmptyStackException
     */
    public E stackPop() throws EmptyStackException {
        if(size == 0){
            throw new EmptyStackException();
        }
        E data = stack[topIndex];
        topIndex--;
        size--;
        return data;
    }

    /**
     * stackEmpty - checks if the stack is empty
     * @return - returns true if empty
     */
    public boolean stackEmpty(){
        if(size == 0){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * stackPeek - returns data of the top item of the stack
     * @return - returns data of top of stack. If stack is empty returns null.
     */
    public E stackPeek(){
        if(size == 0){
            return null;
        }
        else{
            return stack[topIndex];
        }
    }

    /**
     * reallocate - Creates stack of size * 2 and reallocates data of old stack to new stack.
     */
    public void reallocate(){
        int newCap = capacity * 2;
        E[] resized = (E[])(new Object[newCap]);
        for(int i = 0; i < capacity; i++){
            resized[i] = stack[i];
        }
        topIndex = capacity;
        capacity = newCap;
        stack = resized;
    }

    /**
     * @return - returns size of stack.
     */
    public int size(){
        return size;
    }
}
