/*
*
*
*                   线程的状态
*
*NEW
* RUNNABLE
*  BLOCKED
* WAITING
* TIMED_WAITING
*  TERMINATED
*
* */
public class Test2 {
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10_0000; i++) {
                    
                }
            }
        };
        System.out.println("线程启动中" + thread.getState());

        thread.start();

        while (thread.isAlive()){
            System.out.println("线程正在运行" + thread.getState());
        }

        System.out.println("线程结束后" + thread.getState());
    }
}
