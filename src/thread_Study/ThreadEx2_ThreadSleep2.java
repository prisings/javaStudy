package thread_Study;



import java.util.*;

class Count extends Thread{
    private String name;
    private int sleepTime;
    public Count(String name) {
        this.name = name;
        sleepTime = new Random().nextInt(1000);
    }
    // 객체가 해야되는 일을 run 메소드 안에 나열해줌.
    @Override
    public void run() {
        System.out.println(name+"_토끼가 출발!");
        System.out.println(name+" 쓰레드 이름 : "
                + Thread.currentThread().getName());

        for(int i=100; i>0; i--){
            System.out.println("나는 토끼 "+name+" Count : "+i);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } // for
    }
}

public class ThreadEx2_ThreadSleep2 {
    public static void main(String[] args) {
        Count c1 = new Count("Read");
        Count c2 = new Count("Blue");
        c1.start();
        c2.start();
        System.out.println("Main-거북이도 출발 하자");
        for(int i=100; i>0; i--){
            System.out.println("나는 거북이 : "+i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } // for
        System.out.println("*** Main Thread 정보출력 ***" );
        System.out.println(" getState() :  " + Thread.currentThread().getState());
        System.out.println(" 쓰레드 이름 :  " + Thread.currentThread().getName());
        System.out.println(" getPriority() :  " + Thread.currentThread().getPriority());
    } // main
} // class

