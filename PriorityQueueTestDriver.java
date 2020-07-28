public class PriorityQueueTestDriver {
    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueue<String>(5);
        pq.enqueue(new Node(4, "A"));
        pq.enqueue(new Node(10, "B"));
        pq.enqueue(new Node(3, "C"));
        pq.enqueue(new Node(5, "E"));
        pq.enqueue(new Node(2, "F"));

        // pq.display();
        int size = pq.size();
        for (int i = 0; i < size; i++) {
            Node<String> n = (Node<String>) pq.dequeue();
            n.show();
        }
    }
}
