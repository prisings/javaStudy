package thread_Study;



class ThreadA1 extends Thread {
    private WorkObject workObject;

    public ThreadA1(WorkObject workObject) {
        this.workObject = workObject;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++) {
            workObject.methodA();
            System.out.print(" ai : " +i) ;
            System.out.println() ;
        }
    }
}

class ThreadB1 extends Thread {
    private WorkObject workObject;

    public ThreadB1(WorkObject workObject) {
        this.workObject = workObject;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++) {
            System.out.print(" bi : " +i) ;
            System.out.println() ;
            workObject.methodB();
        }
    }
}
class WorkObject {
    public synchronized void methodA() {
        System.out.print("ThreadA의 methodA() 작업 실행");
        notify(); // 작업을 마친 후 Blocked 를 깨우고
        try {
            wait(); // 자신은 wait 로
        } catch (InterruptedException e) {
        }
    }

    public synchronized void methodB() {
        System.out.print("ThreadB의 methodB() 작업 실행");
        notify();
        try {
            wait();
        } catch (InterruptedException e) {
        }
    }
}

public class WaitNotifyExample {
    public static void main(String[] args) {
        WorkObject sharedObject = new WorkObject();

        ThreadA1 threadA = new ThreadA1(sharedObject);
        ThreadB1 threadB = new ThreadB1(sharedObject);

        threadA.start();
        threadB.start();

    }
}

