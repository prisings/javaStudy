package thread_Study;


class ShowThread extends Thread  {
    String threadName;
    public ShowThread(String name)	{
        threadName=name;
    }
    public void run()	{
        // Thread run 메서드 오버라이딩
        // 생성된 Thread 의 main 메서드 가 run 메서드
        for(int i=0; i<10; i++)	{
            System.out.println("*** "+threadName+" 만들기 ***");
            try	{
                sleep(1000);
                // (1/1000) * 1000 => 1 초간 멈춤
                // Thread 클래스에 정의된 static 메서드
            }catch(InterruptedException e) {
                e.printStackTrace();
            } // catch
        } // for
    } // run
} // ShowThread

class ThreadEx3_Instances {
    public static void main(String[] args) {
        ShowThread st1=new ShowThread("짜장면");
        ShowThread st2=new ShowThread("짬뽕");
        st1.start();
        st2.start();
        // start 호출하면 run() 실행
        // run 메서드를 직접 호출 하는것과의 차이
        // => 쓰레드는 자신만의 메모리 공간을 할당 받아 별도의 실행 흐름을 형성함.
        System.out.println("*** Main Thread 정보출력 ***" );
        System.out.println(" 쓰레드 이름 :  " + Thread.currentThread().getName());
        System.out.println(" getPriority() :  " + Thread.currentThread().getPriority());
        System.out.println(" MAX_PRIORITY :  " + Thread.MAX_PRIORITY);
        System.out.println(" NORM_PRIORITY :  " + Thread.NORM_PRIORITY);
        System.out.println(" MIN_PRIORITY :  " + Thread.MIN_PRIORITY);
        // main 메서드 도  main쓰레드 => 다른 쓰레드와 마찬가지로 자신만의 실행 흐름을 이어감
        // main 이 종료 되어도 남은 쓰레드는 실행됨
        // 모든 쓰레드가 종료 되어야 프로그램은 종료됨.
    }
}
