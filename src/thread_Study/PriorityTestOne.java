package thread_Study;



class MessageSendingThread extends Thread {
    String message;
    int priority;

    public MessageSendingThread(String str) {
        message=str;
    }
    public void run() {
        for(int i=0; i<100; i++)
            System.out.println(message+"("+getPriority()+")");
    }
}
// 우선순위 동일한 스레드들이 CPU 할당시간을 나눠가며 실행
class PriorityTestOne {
    public static void main(String[] args) {
        MessageSendingThread tr1=new MessageSendingThread("First");
        MessageSendingThread tr2=new MessageSendingThread("Second");
        MessageSendingThread tr3=new MessageSendingThread("Third");
        tr1.start();
        tr2.start();
        tr3.start();
    }
}
