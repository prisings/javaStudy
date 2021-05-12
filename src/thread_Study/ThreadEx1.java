package thread_Study;


// Thread 클래스 구현과 실행
// => Thread 클래스 상속
// => Runnable 인터페이스 구현

class ThreadEx1_1 extends Thread {
    public void run() {
        for(int i=0; i < 50; i++) {
            System.out.println("Ti :"+i+"***"+getName()); // 조상인 Thread의 getName()을 호출
        }
    }
}

class ThreadEx1_2 implements Runnable {
    // Runnable 의 run 메서드 구현
    public void run() {
        for(int i=0; i < 50; i++) {
            // Thread.currentThread() - 현재 실행중인 Thread를 반환한다.
            System.out.println("Ri :"+i+"***"+Thread.currentThread().getName());
        }
    }
}

class ThreadEx1 {
    public static void main(String args[]) {
        ThreadEx1_1 t1 = new ThreadEx1_1();

        Runnable r  = new ThreadEx1_2();
        Thread   t2 = new Thread(r);
// Runnable 을 구현 한 것만으로는 Thread 클래스의 start 메서드를 호출 할 수 없으므로
// Runnable 의 참조값을 이용하여 Thread 생성
// Thread 클래스의 생성자 중에는 Runnable 인터페이스의 참조값을 인자로 하는 생성자가 구현
// => 생성자 Thread(Runnable target)

        t1.start();
        t2.start();
// Thread 실행 => start 메서드 호출
// start 호출하면 => run 메서드 실행
// run 메서드를 직접 호출 하는것과의 차이
// 	=> 쓰레드는 자신만의 메모리 공간을 할당 받아 별도의 실행 흐름을 형성함.
		/*t1.run();
		t2.run();*/
    }
}