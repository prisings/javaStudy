package thread_Study;



class Sum{
    int num;
    public Sum() { num=0; }
    public void addNum(int n) { num+=n; }
    public int getNum() { return num; }
}
class AdderThread1 extends Sum implements Runnable{
    int start, end;
    public AdderThread1(int s, int e){
        start=s;
        end=e;
    }
    // Runnable 의 run 메서드 구현
    public void run(){
        for(int i=start; i<=end; i++){
            addNum(i);
            System.out.println("start : " + start);
        } 	}  }

class ThreadEx5_RunnJoin{
    public static void main(String[] args)	{
        AdderThread1 at1=new AdderThread1(1, 50);
        AdderThread1 at2=new AdderThread1(51, 100);
        Thread tr1=new Thread(at1);
        Thread tr2=new Thread(at2);
// Runnable 을 구현 한 것만으로는 Thread 클래스의 start 메서드를 호출 할 수 없으므로
// Runnable 의 참조값을 이용하여 Thread 생성
// Thread 클래스의 생성자 중에는 Runnable 인터페이스의 참조값을 인자로 하는 생성자 구현
        tr1.start();
        tr2.start();
        try	{
            tr1.join(); // join() : 해당 스레드가 종료될때까지 쓰레드실행 멈춤
            tr2.join(); // tr1, tr2 가 종료 되어야 42행(출력문) 실행됨.
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("1~100까지의 합: "+(at1.getNum()+at2.getNum()));

    }
// 과제 : 위 예제를 Thread 클래스 를 이용하는 방식으로 변경 하기.
// 		=> sum 클래스는 인터페이스로 	: 화일명 (ThreadInter.java)
}
