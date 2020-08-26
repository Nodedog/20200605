import java.util.Scanner;

/*
*
* 每个引用对象头部都有一个标记锁 可以看成一个boolean值 初始情况都是false 是未加锁的情况
*
*
*
* */

public class Test4 {
    public static void main(String[] args) {
        //如果只定义一个locker 那么就是两个线程抢谁抢到了等执行完之后才能继续执行另一个线程
        //定义一个locker1 locker2 分别给thread1 thread2加锁两个线程各跑各的 互不影响 不互斥
        //如果locker1 locker2 .getClass的话 那下面两个线程就分别针对locker1 locker2的类对象
        //进行竞争 此处的locker1 locker2的类型都是Object 对应的类对象也一样 那么如果线程1尝试
        // 加锁 就会吧类对象的对象头中的所标记改成true,当线程2去尝试加锁时 发现类对象的所标记已经
        //改成true了所以只能等线程1执行完解锁改成false才能继续执行
        Object locker1 = new Object();
        Object locker2 = new Object();

        Thread thread1 = new Thread(){
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);

                synchronized (locker1.getClass()){
                    //如果一直不输入,就是一直卡在这里阻塞
                    System.out.println("请输入一个整数");

                    int num = scanner.nextInt();
                    System.out.println("num = " + num);
                }
            }
        };
        thread1.start();


        Thread thread2 = new Thread(){
            @Override
            public void run() {
                while (true){
                    synchronized (locker2.getClass()){
                        System.out.println("线程2 获取到锁了");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        thread2.start();
    }

}
