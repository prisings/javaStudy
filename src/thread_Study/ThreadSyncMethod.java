package thread_Study;


class Calculator {
    int opCnt=0 ;
    int mytot = 10000 ;
    int youtot = 10000 ;

    public int add(int n1, int n2) {
        opCnt++;  // 동기화 필요
        mytot += (n1+n2) ;  // you 가 my 에게 입금
        youtot -= (n1+n2) ;
        System.out.println("my 에게 입금: mytot= "+mytot+ "youtot= "+youtot);
        return n1+n2;
    }
    public int min(int n1, int n2) {
        opCnt++; // 동기화 필요
        mytot -= (n1+n2) ;  // my 가 출금 you 에게 입금
        youtot += (n1+n2) ;
        System.out.println("my 가 출금: mytot= "+mytot+ "youtot= "+youtot);
        return n1-n2;
    }
    public void showOpCnt() {
        System.out.println("총 연산 횟수: "+opCnt);
    }
}

class AddThread extends Thread {
    Calculator cal;

    public AddThread(Calculator cal) { this.cal=cal; }

    public void run() {
        System.out.println("1+2="+cal.add(10, 20));
        System.out.println("2+4="+cal.add(20, 40));
    }
}

class MinThread extends Thread {
    Calculator cal;

    public MinThread(Calculator cal) { this.cal=cal; }

    public void run() {
        System.out.println("2-1="+cal.min(20, 10));
        System.out.println("4-2="+cal.min(40, 20));
    }
}

class ThreadSyncMethod {
    public static void main(String[] args) {
        Calculator cal=new Calculator();
        AddThread at=new AddThread(cal);
        MinThread mt=new MinThread(cal);

        AddThread at1=new AddThread(cal);
        MinThread mt2=new MinThread(cal);
        AddThread at2=new AddThread(cal);

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
