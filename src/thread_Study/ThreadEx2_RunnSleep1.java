package thread_Study;


// Runnable 연습과 sleep 메서드적용
class Count2 implements Runnable {

    @Override
    public void run() {
        System.out.println("Count_토끼가 출발!_(Runnable)");

        for (int i = 100; i > 0; i--) {
            System.out.println("나는 토끼 Count : " + i);
			/*try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
        }

    }

}

public class ThreadEx2_RunnSleep1 {
    public static void main(String[] args) {

        Thread t = new Thread(new Count2());

        t.start();

        System.out.println("Main-거북이도 출발 하자");
        for(int i=100; i>0; i--){
            System.out.println("나는 거북이 : "+i);
			/*try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
        }
    }

}

