import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Buyer<V> extends BuyerBase<V> {
    int sleept;
    public Buyer(int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty,
        PriorityQueue<V> catalog, int iteration) {
        this.lock = lock;
        this.full = full;
        this.empty = empty;
        this.setSleepTime(sleepTime);
        this.setIteration(iteration);
        this.catalog = catalog; // check if correct
        this.sleept = sleepTime;
    }
    public void buy() throws InterruptedException {
        try {
            lock.lock();
            while (catalog.isEmpty()) {
                empty.await();
            }
            NodeBase<V> n = catalog.dequeue();

            full.signalAll();

            System.out.print("Consumed "); // DO NOT REMOVE (For Automated Testing)
            n.show(); // DO NOT REMOVE (For Automated Testing)

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
