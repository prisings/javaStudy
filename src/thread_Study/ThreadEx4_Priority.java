package thread_Study;


class ShowThreadp extends Thread  {
    String threadName;
    public ShowThreadp(String name, int p)	{
        threadName=name;
        setPriority(p);  // 우선순위 변경
    }
    public void run()	{
        for(int i=0; i<50; i++)	{
            System.out.println("**"+threadName+"("+getPriority()+")");
        } // for
    } // run
} // ShowThread
class ThreadEx4_Priority {
    public static void main(String[] args) {
        ShowThreadp st1=new ShowThreadp("1 쓰레드" ,Thread.MAX_PRIORITY );
        ShowThreadp st2=new ShowThreadp("2 쓰레드" ,Thread.NORM_PRIORITY);
        ShowThreadp st3=new ShowThreadp("3 쓰레드" ,Thread.MIN_PRIORITY);
        st1.start();
        st2.start();
        st3.start();
        System.out.println("*** Main Thread 정보출력 ***" );
        System.out.println(" 쓰레드 이름 :  " + Thread.currentThread().getName());
        System.out.println(" getPriority() :  " + Thread.currentThread().getPriority());
        System.out.println(" MAX_PRIORITY :  " + Thread.MAX_PRIORITY);
        System.out.println(" NORM_PRIORITY :  " + Thread.NORM_PRIORITY);
        System.out.println(" MIN_PRIORITY :  " + Thread.MIN_PRIORITY);
    }
}
