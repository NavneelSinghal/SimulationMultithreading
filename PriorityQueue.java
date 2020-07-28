// Naive priority queue
public class PriorityQueue<V> implements QueueInterface<V> {
    private NodeBase<V>[] queue; // sorted in decreasing order of priority
    private int capacity, currentSize;

    public PriorityQueue(int capacity) {
        //@SuppressWarnings("unchecked");
        this.capacity = capacity;
        queue = new Node[this.capacity]; // initialise queue with size equal to capacity
        currentSize = 0;
    }

    public int capacity() {
        return queue.length;
    }

    public int size() {
        return currentSize; // return the size of the queue
    }

    public boolean isEmpty() {
        return currentSize == 0; // if 0 return true else false
    }

    public boolean isFull() {
        return currentSize == capacity; // if capacity then true else false
    }

    public void enqueue(Node<V> node) {
        if (this.isFull()) {
        } else {
            boolean less = false;
            for (int i = 0; i < currentSize; i++) {
                if (node.getPriority() > queue[i].getPriority()) {
                    for (int j = currentSize; j > i; j--) {
                        queue[j] = queue[j - 1];
                    }
                    queue[i] = node;
                    less = true;
                    currentSize++;
                    break;
                }
            }
            if (less == false) {
                queue[currentSize] = node;
                currentSize++;
            }
        }
    }

    // In case of priority queue, the dequeue() should
    // always remove the element with minimum priority value
    public NodeBase<V> dequeue() {
        if (this.isEmpty()) {
            System.out.println("The priority queue is empty");
            return null;
        } else {
            NodeBase<V> answer = queue[currentSize - 1];
            queue[currentSize - 1] = null;
            currentSize--;
            return answer;
        }
    }

    public void display() {
        if (this.isEmpty()) {
            System.out.println("Queue is empty");
        }
        for (int i = 0; i < currentSize; i++) {
            queue[i + 1].show();
        }
    }
}
