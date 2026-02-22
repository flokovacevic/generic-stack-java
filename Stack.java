/**
 * A simple generic stack
 *
 * We use an Object array internally because Java won't let us write
 * new T[size] directly. So we create an Object[] and cast to T when
 * reading values back out. That's safe because we only ever put T values in.
 *
 * @param <T> the type of things this stack holds
 *
 * @author Florian Kovacevic
 * @version 2026-02-22
 */
public class Stack<T> {
    private Object[] elements;
    private int top; // how many elements are currently in the stack

    /**
     * Creates a stack with a default capacity of 10.
     */
    public Stack() {
        elements = new Object[10];
        top = 0;
    }

    /**
     * Use this if you want a stack with a specific size.
     *
     * @param size the maximum number of elements the stack can hold
     */
    public Stack(int size) {
        elements = new Object[size];
        top = 0;
    }

    /**
     * Pushes a new element onto the top of the stack.
     *
     * @param item the element to push
     * @throws StackFullException if the stack has no room left
     */
    public void push(T item) throws StackFullException {
        if(top == elements.length){
            throw new StackFullException();
        }
        elements[top] = item;
        top++;
    }

    /**
     * Removes and returns the element on top of the stack.
     *
     * @return the element that was on top
     * @throws StackEmptyException if the stack is empty
     */
    public T pop() throws StackEmptyException {
        if (top == 0) {
            throw new StackEmptyException();
        }
        top--;
        T item = (T) elements[top];
        elements[top] = null;
        return item;
    }

    /**
     * Returns the element on top of the stack without removing it.
     *
     * @return the element that is currently on top
     * @throws StackEmptyException if the stack is empty
     */
    public T peek() throws StackEmptyException {
        if (top == 0) {
            throw new StackEmptyException();
        }
        return (T) elements[top - 1];
    }

    /**
     * Returns all elements of the stack as a semicolon-separated string.
     * The first element in the string is the bottom of the stack and the
     * last is the top — the order in which elements were pushed.
     *
     * @return a string like, or an empty string if the stack is empty
     */
    public String list() {
        String list = "";
        for (int i = 0; i < top; i++) {
            if (i > 0) list += "; ";
            list += elements[i];
        }
        return list;
    }

    /**
     * Returns if the stack currently holds no elements.
     *
     * @return whether the stack is empty
     */
    public boolean isEmpty() {
        return top == 0;
    }

    /**
     * Returns if the stack has no room for more elements.
     *
     * @return whether the stack is full
     */
    public boolean isFull() {
        return top == elements.length;
    }
}
