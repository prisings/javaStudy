package thread_Study;



class NewsPaper {  // 스레드간의 자료 주고 받음
    String todayNews;
    public void setTodayNews(String news){
        todayNews=news;
    }
    public String getTodayNews(){
        return todayNews;
    }
}
class NewsWriter extends Thread {
    NewsPaper paper;

    public NewsWriter(NewsPaper paper){
        this.paper=paper;
    }
    public void run(){
        for(int i=0; i<5; i++) {
            paper.setTodayNews("자바의 열기가 뜨겁습니다.");
            System.out.println("오늘의 뉴스를 Write : "+Thread.currentThread().getName());
        }
    }
}
class NewsReader extends Thread{
    NewsPaper paper;

    public NewsReader(NewsPaper paper){
        this.paper=paper;
    }
    public void run(){
        for(int i=0; i<5; i++)
            System.out.println("오늘의 뉴스: "+paper.getTodayNews()+Thread.currentThread().getName());
    }
}
class NewsPaperStory{
    public static void main(String[] args)	{
        NewsPaper paper=new NewsPaper();
        NewsReader reader1=new NewsReader(paper);
        NewsReader reader2=new NewsReader(paper);
        NewsWriter writer1=new NewsWriter(paper);
        NewsWriter writer2=new NewsWriter(paper);

        writer1.start();
        reader1.start();
        writer2.start();
        reader2.start();

        try	{
            reader1.join();
            writer1.join();
            reader2.join();
            writer2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
