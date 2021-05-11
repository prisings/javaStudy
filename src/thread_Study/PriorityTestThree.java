package thread_Study;


class MessageSendingThread3 extends Thread {
    String message;

    public MessageSendingThread3(String str, int prio) {
        message=str;
        setPriority(prio);
    }
    public void run() {
        for(int i=0; i<100; i++) {
            System.out.println(message+"("+getPriority()+")");

            try {
                sleep(1000); // sleep() 메서드 호출되면스레드는 CPU 할당이 불필요한 상황,
                // 그러므로 다른 스레드에게 할당된 CPU 양보
                // 후순위 스레드 기회를 얻게됨
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
// 우선순위 별로 실행됨 -> 선순위 종료후 후순위 실행
class PriorityTestThree {
    public static void main(String[] args) {
        MessageSendingThread3 tr1
                =new MessageSendingThread3("First", Thread.MAX_PRIORITY);
        MessageSendingThread3 tr2
                =new MessageSendingThread3("Second", Thread.NORM_PRIORITY);
        MessageSendingThread3 tr3
                =new MessageSendingThread3("Third", Thread.MIN_PRIORITY);

        tr1.start();
        tr2.start();
        tr3.start();
    }
}
