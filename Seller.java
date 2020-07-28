import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Seller<V> extends SellerBase<V> {
    int sleept;
    public Seller(int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty,
        PriorityQueue<V> catalog, Queue<V> inventory) {
        this.lock = lock;
        this.full = full;
        this.empty = empty;
        this.setSleepTime(sleepTime);
        this.catalog = catalog; // check if correct
        this.inventory = inventory;
        this.sleept = sleepTime;
    }

    public void sell() throws InterruptedException {
        try {
            lock.lock();
            while (catalog.isFull()) {
                full.await();
            }
            if (!inventory.isEmpty())
                catalog.enqueue((Node<V>) inventory.dequeue());

            empty.signalAll();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
