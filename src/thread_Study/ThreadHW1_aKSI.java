package thread_Study;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadHW1_aKSI {
	public static class ThreadHW1 {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			ReentrantLock lock = new ReentrantLock(true);
			ThreadTest p = new ThreadTest(1, 50, lock);
			ThreadTest p1 = new ThreadTest(51, 100, lock);
			Thread thw1 = new Thread(p, "일번");
			Thread thw2 = new Thread(p1, "이번");

			thw1.start();
			thw2.start();
			while ((thw1.isAlive()) && (thw2.isAlive())) {
				try {
					thw1.join();
					thw2.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			System.out.println("테스트:" + ThreadTest.sum);
		}

	}

	static class ThreadTest implements Runnable {
		private ReentrantLock o;
		private int start;
		private int end;
		private int result;
		public Object key;
		public static int sum;

		public ThreadTest(int start, int end, ReentrantLock i) {
			// TODO Auto-generated constructor stub
			this.start = start;
			this.end = end;
			o = i;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (int i = start; i <= end; i++) {
				result += i;
				try {
					o.lock();
					sum += i;
				} finally {
					o.unlock();
				}
				try {
					Thread.sleep(90);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			System.out.printf("Thread Name=%s , %d~%d : %d\n", Thread.currentThread().getName(), this.start, this.end,
					result);
		}

	}
}