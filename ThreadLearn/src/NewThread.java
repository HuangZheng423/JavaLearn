/**
 * Created by huangzheng on 16-2-27.
 */

/**
 * 线程实现两种方式
 *  1.继承Thread类，重写run方法
 *  2.实现Runnable接口
 * 线程的启动是通过start方法，而不是run方法
 */
public class NewThread {
    public static void main(String args[]){
//        ThreadA ta = new ThreadA();
//        ThreadB tb = new ThreadB();
//        ta.start();
//        Thread t2 = new Thread(tb);
//        t2.start();
        Data d = new Data();
        new ThreadC(d).start();
        new ThreadC(d).start();

    }
}

class ThreadA extends Thread{
    public void  run(){
        for (int i=0;i<1000;i++) {
            System.out.println("A："+i);
        }
    }
}

class ThreadB implements Runnable{
        public void run(){
            for (int i=0;i<1000;i++){
                System.out.println("B:"+i);
            }
        }
}
class ThreadC extends Thread{
    Data d;
    public ThreadC(Data d){
        this.d=d;
    }
    public void run(){
        /*while (true) {
            d.process();
        }*/
    }
}

class Data{
    int i;
        public synchronized void process () {
        System.out.println("Before:" + i);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        i++;
        System.out.println("After:" + i);
    }

}