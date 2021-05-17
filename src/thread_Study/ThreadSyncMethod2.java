package thread_Study;


class Calculator2 {
    int opCnt=0 ;
    int mytot = 10000 ;
    int youtot = 10000 ;

    public int add(int n1, int n2) {
        synchronized(this) {
            opCnt++;  // 동기화 필요
            mytot += (n1+n2) ;  // you 가 my 에게 입금
            youtot -= (n1+n2) ;
            System.out.println("my 에게 입금: mytot= "+mytot+ " , youtot= "+youtot);
        }
        return n1+n2;
    }
    public int min(int n1, int n2) {
        synchronized(this) {
            opCnt++; // 동기화 필요
            mytot -= (n1+n2) ;  // my 가 출금 you 에게 입금
            youtot += (n1+n2) ;
            System.out.println("my 가 출금: mytot= "+mytot+ " , youtot= "+youtot);
        }
        return n1-n2;
    }
    public void showOpCnt() {
        System.out.println("총 연산 횟수: "+opCnt);
    }
}

class AddThread2 extends Thread {
    Calculator2 cal;

    public AddThread2(Calculator2 cal) { this.cal=cal; }

    public void run() {
        System.out.println("10+20="+cal.add(10, 20));
        System.out.println("20+40="+cal.add(20, 40));
    }
}

class MinThread2 extends Thread {
    Calculator2 cal;

    public MinThread2(Calculator2 cal) { this.cal=cal; }

    public void run() {
        System.out.println("30-20="+cal.min(30, 20));
        System.out.println("40-30="+cal.min(40, 30));
    }
}

class ThreadSyncMethod2 {
    public static void main(String[] args) {
        Calculator2 cal=new Calculator2();
        AddThread2 at=new AddThread2(cal);
        MinThread2 mt=new MinThread2(cal);

        AddThread2 at1=new AddThread2(cal);
        AddThread2 at2=new AddThread2(cal);
        MinThread2 mt2=new MinThread2(cal);

        at.start();
        mt.start();
        at1.start();
        mt2.start();
        at2.start();

        try {
            at.join();
            at1.join();
            at2.join();
            mt.join();
            mt2.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        cal.showOpCnt();
    }
}
