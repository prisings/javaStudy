package thread_Study;


// ThreadEx5_RunnJoin
// => Thread 클래스 를 이용하는 방식으로 변경 하기.

interface Sum11{
    void addNum(int n);
    int getNum();
}

class AdderThread11 extends Thread implements Sum11{
    int start, end, num;
    public AdderThread11(int s, int e){
        start = s;
        end = e;
        num = 0;
    }
    public void run(){
        for(int i=start; i<=end ; i++){
            addNum(i);
            System.out.println("start : " + start);
        }
    }

    @Override
    public void addNum(int n) { num+=n;}

    @Override
    public int getNum() {return num;}
}

public class ThreadEx5_ThreadJoin {
    public static void main(String[] args) {
        AdderThread11 at1 = new AdderThread11(1,50);
        AdderThread11 at2 = new AdderThread11(51,100);

        at1.start();
        at2.start();
        try{
            at1.join(); //join():해당 쓰레드가 종료될 때 까지 쓰레드 실행 멈춤.
            at2.join(); //tr1, tr2가 종료되어야 출력문 실행.
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("1~100까지의 합 : "+(at1.getNum()+at2.getNum()));
    }
}

