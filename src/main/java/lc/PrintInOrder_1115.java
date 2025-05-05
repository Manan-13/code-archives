package lc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class PrintInOrder_1115 {
    public static void main(String[] args) {
        Foo foo =new Foo();
        Thread one = new Thread(()->{
            try {
                foo.first(()-> System.out.println("first"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread two = new Thread(()->{
            try {
                foo.second(()-> System.out.println("second"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread three = new Thread(()->{
            try {
                foo.third(()-> System.out.println("third"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        two.start();
        three.start();
        one.start();
    }

}
class Foo {
    int first = 0;
    int second = 0;
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized(this){
            printFirst.run();
            first++;
            notifyAll();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized(this){
            while(first != 1) wait();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            second++;
            notifyAll();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized(this){
            while(second != 1) wait();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }

    }
}