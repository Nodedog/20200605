
/*
*
*           多线程不安全
*
* */
public class Test3 {
    static class Counter{
        public int count = 0;

        //加上synchronized 关键字给方法加锁
        //进入increase方法加锁,执行完increase方法自动解锁
        synchronized public void increase(){
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread thread1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    counter.increase();
                }
            }
        };
        thread1.start();


        Thread thread2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    counter.increase();
                }
            }
        };

        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(counter.count);
    }
}
