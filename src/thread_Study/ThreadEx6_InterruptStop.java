package thread_Study;



class PrintThread2 extends Thread {
    public void run() {
        //how1
        try {
            while(true) {
                System.out.println("실행 중1");
                Thread.sleep(1);
            }
        } catch(InterruptedException e) {
        }

        //how2
		/*while(true) {
			System.out.println("실행 중2");
			if(Thread.interrupted()) {  // Thread의 interrupt() 값 반환
				break;
			}
		}*/
//	main 에서 강제종료 	thread.interrupt();
        System.out.println("자원 정리");
        System.out.println("실행 종료");
    }
}

public class ThreadEx6_InterruptStop {
    public static void main(String[] args)  {
        Thread thread = new PrintThread2();
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("Main_interrupt() 호출");
        thread.interrupt(); // Thread.interrupted() 를 true 로
    }
}


////////////////////////////////////////////////////////
//***  InterruptedException
//
//말 그대로 Thread가 중단되었을 때 발생하는 예외.
//즉, wait()메소드나 sleep() 메소드를 사용해 Thread가 대기 상태로 들어갔다가
//깨어나지 못 할때 발생하는 예외 또한,
//interrupt()메소드를 사용해 Thread를 중단시킬 때도  발생함.


