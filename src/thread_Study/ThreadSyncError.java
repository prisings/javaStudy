package thread_Study;


class Increment {
    int num=0;
    //	public void increment(){ num++; }
    public synchronized void increment(){ num++; }
    public int getNum() { return num; }
}
// 동기화 되어있지 않은 상태 에서는 실행 시마다 틀린 다른 값이 나옴.
// increment()의 num++ 이 완료되지 않은 상태에서 다른 쓰레드가 사용하게됨.
class IncThread extends Thread {
    Increment inc;
    public IncThread(Increment inc) {
        this.inc=inc;  	}
    public void run() {
        for(int i=0; i<10000; i++)
            for(int j=0; j<10000; j++)
                inc.increment();  	}}
class ThreadSyncError {
    public static void main(String[] args) {
        Increment inc=new Increment();
        IncThread it1=new IncThread(inc);
        IncThread it2=new IncThread(inc);
        IncThread it3=new IncThread(inc);
        it1.start();
        it2.start();
        it3.start();
        try {
            it1.join();
            it2.join();
            it3.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(inc.getNum());  // 300000000 , 100000000 , 예측불가
    }
}