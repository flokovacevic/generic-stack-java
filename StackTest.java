/**
 * Test class for the generic Stack.
 *
 * We test an integer stack and a string stack to make sure
 * everything works — pushing, popping, peeking, and the
 * two exceptions when something goes wrong.
 *
 * @author Florian Kovacevic
 * @version 2026-02-22
 */
public class StackTest {
    public static void main(String[] args) {

        System.out.println("=== Testing an Integer stack ===");
        testIntegerStack();

        System.out.println("=== Testing a String stack ===");
        testStringStack();
    }

    public static void testIntegerStack() {

        Stack<Integer> stack = new Stack<>(); // default capacity: 10

        // Peeking on an empty stack should throw
        try {
            stack.peek();
        } catch (StackEmptyException e) {
            System.out.println("Good - peek on empty stack threw: " + e.getMessage());
        }

        // Popping on an empty stack should throw
        try {
            stack.pop();
        } catch (StackEmptyException e) {
            System.out.println("Good - pop on empty stack threw: " + e.getMessage());
        }

        // Push some numbers and check the order
        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);
            System.out.println("Stack after pushing 1, 2, 3: " + stack.list()); // 1; 2; 3;

            System.out.println("Peek (should be 3): " + stack.peek());
            System.out.println("Pop (should be 3): " + stack.pop());
            System.out.println("Pop (should be 2): " + stack.pop());
            System.out.println("Stack now: " + stack.list()); // 1
        } catch (StackFullException | StackEmptyException e){
            System.out.println("Unexpected error: " + e.getMessage());
        }

        // Fill it up completely, then try to push one more
        try {
            for (int i = 0; i < 9; i++) { // 1 element already in, 9 more = full
                stack.push(i);
            }
            System.out.println("Stack full: " + stack.isFull());
            stack.push(999); // this should fail
        } catch (StackFullException e){
            System.out.println("Good - push on full stack threw: " + e.getMessage());
        }

        try {
            while (!stack.isEmpty()){
                stack.pop();
            }
            System.out.println("list() on empty stack: \"" + stack.list() + "\""); // ""
        } catch (StackEmptyException e){
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    public static void testStringStack() {

        Stack<String> stack = new Stack<>(3); // small capacity so it fills up fast

        // Push three words
        try {
            stack.push("Hello");
            stack.push("World");
            stack.push("Java");
            System.out.println("Stack after pushing Hello, World, Java: " + stack.list());

            // One more push should fail — stack is full
            stack.push("Oops!");
        } catch (StackFullException e) {
            System.out.println("Good - push on full stack threw: " + e.getMessage());
        }

        // Pop everything and check Last In, First Out order
        try {
            System.out.println("Peek (should be Java): " + stack.peek());
            System.out.println("Pop: " + stack.pop()); // Java
            System.out.println("Pop: " + stack.pop()); // World
            System.out.println("Pop: " + stack.pop()); // Hello
            System.out.println("Stack empty: " + stack.isEmpty());

            // One more pop should fail now
            stack.pop();
        } catch (StackEmptyException e) {
            System.out.println("Good — pop on empty stack threw: " + e.getMessage());
        }

        // Stack should be reusable after emptying
        try {
            stack.push("Fresh Start!");
            System.out.println("Stack after reuse: " + stack.list()); // Fresh Start!
        } catch (StackFullException e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}
