package concept;

import java.util.LinkedList;
import java.util.Queue;

public class BoundedBlockingQueue<T> {
    Queue<T> queue;
    private final int capacity;

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<>();
    }

    public synchronized void enqueue(T item) throws InterruptedException {
        while (queue.size() == capacity) wait();
        queue.add(item);
        notifyAll();
    }

    public synchronized T dequeue() throws InterruptedException {
        while (queue.isEmpty()) wait();
        T obj =  queue.poll();
        notifyAll();
        return obj;
    }

    public int size() {
        return queue.size();
    }

}

//
//public static void main(String[] args) {
//
//}
