package thread_Study;

class NewsPaperS {
    String todayNews;
    boolean isTodayNews=false;

    public void setTodayNews(String news) {
        todayNews=news;
        isTodayNews=true;

        synchronized(this) {
            notifyAll();
            // NewsPaperS 클래스의 인스턴스에 대해 적용되며, 모두 Blocked -> Runnable 상태로 깨움
        }
    }

    public String getTodayNews() {
        if(isTodayNews==false) 	{  // 아직 데이터가 도착 하지 않은 상황에서 getTodayNews 안되도록 설정
            try {
                synchronized(this)
                {
                    wait(); // Runnable -> Blocked 상태로
                }
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        return todayNews;
    }
}

class NewsWriterS extends Thread {
    NewsPaperS paper;

    public NewsWriterS(NewsPaperS paper) {
        this.paper=paper;
    }
    public void run() {
        synchronized(this) {
            paper.setTodayNews("자바의 열기가 뜨겁습니다.");
            System.out.println("오늘의 뉴스를 Write : "+Thread.currentThread().getName());
        }
    }
}

class NewsReaderS extends Thread {
    NewsPaperS paper;

    public NewsReaderS(NewsPaperS paper) {
        this.paper=paper;
    }
    public void run() {
        synchronized(this) {
            System.out.println("오늘의 뉴스: "+paper.getTodayNews()+Thread.currentThread().getName());
        }
    }
}

class SyncNewsPaper {
    public static void main(String[] args) {
        NewsPaperS paper=new NewsPaperS();
        NewsReaderS reader1=new NewsReaderS(paper);
        NewsReaderS reader2=new NewsReaderS(paper);
        NewsWriterS writer1=new NewsWriterS(paper);
        NewsWriterS writer2=new NewsWriterS(paper);

        try {

            writer1.start();
            writer2.start();
            reader1.start();
            reader2.start();

            reader1.join();  // 호출한 메서드 (여기서는 Main) 가 마칠때 까지 대기함.
            reader2.join();
            writer1.join();
            writer2.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("오늘의 뉴스를 마침니다.") ;
    }
}
