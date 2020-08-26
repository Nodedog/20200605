
/*
*                   线程等待
*
*
* */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("我是新线程1");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };


        Thread thread2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("我是新线程2");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        //join是等对应线程结束完才会 继续向下执行代码
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        System.out.println("主线程执行完毕");
    }


}
