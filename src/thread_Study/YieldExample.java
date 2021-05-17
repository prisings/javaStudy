package thread_Study;


// Thread.yield(); 스레드 양보
class ThreadA extends Thread {
    public boolean stop = false;
    public boolean work = true;

    public void run() {
        while(!stop) {
            if(work) {
                System.out.println("ThreadA 작업 내용");
            } else {
                System.out.println("** ThreadA yield() **");
                Thread.yield();  // running -> runnable
            }
        }
        System.out.println("ThreadA 종료");
    }
}
class ThreadB extends Thread {
    public boolean stop = false;
    public boolean work = true;

    public void run() {
        while(!stop) {
            if(work) {
                System.out.println("ThreadB 작업 내용");
            } else {
                System.out.println("** ThreadB yield() **");
                Thread.yield();
            }
        }
        System.out.println("ThreadB 종료");
    }
}
public class YieldExample {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        threadA.start();
        threadB.start();
        // 처음 1초간은 A,B 번갈아 실행
        try { Thread.sleep(10); } catch (InterruptedException e) {}
        threadA.work = false;
        // 메인 스레드가 threadA.work = false; 변경하면 Thread.yield(); 호출하여 양보-> B 에게로
        try { Thread.sleep(10); } catch (InterruptedException e) {}
        threadA.work = true;
        try { Thread.sleep(10); } catch (InterruptedException e) {}
        threadA.stop = true;
        threadB.stop = true;
    }
}

