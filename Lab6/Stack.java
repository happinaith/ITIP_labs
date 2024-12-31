public class Stack<T> {
    private T[] array;
    private int size;
    private int capacity;
    
    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.array = (T[]) new Object[capacity];
    }

    public void push(T element) {
        if (size == capacity) {
            throw new StackOverflowError("Стек переполнен");
        }
        array[size++] = element;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек пуст");
        }
        T element = array[--size];
        array[size] = null;
        return element;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек пуст");
        }
        return array[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Верхний элемент: " + stack.peek());
        System.out.println("Удален: " + stack.pop());
        System.out.println("Верхний элемент: " + stack.peek());

        stack.push(40);
        System.out.println("Размер стека: " + stack.getSize());
    }
}
