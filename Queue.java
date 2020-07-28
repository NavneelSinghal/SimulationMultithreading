// This class implements the Queue
public class Queue<V> implements QueueInterface<V> {
    private NodeBase<V>[] queue;
    private int capacity, currentSize, front, rear;

    public Queue(int capacity) {
        //@SuppressWarnings("unchecked")
        this.capacity = capacity;
        queue = new Node[this.capacity];
        currentSize = 0;
        front = 0;
        rear = 0;
    }

    public int size() {
        return currentSize;
    }

    public int capacity() {
        return queue.length;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == capacity;
    }

    public void enqueue(Node<V> node) {
        if (currentSize == capacity) {
        } else {
            this.queue[rear] = node;
            rear = (rear + 1) % capacity;
            currentSize++;
        }
    }

    public NodeBase<V> dequeue() {
        if (isEmpty()) {
            System.out.println("The queue is empty");
            return null;
        } else {
            NodeBase<V> a = queue[front];
            queue[front] = null;
            front = (front + 1) % capacity;
            currentSize--;
            return a;
        }
    }
}
