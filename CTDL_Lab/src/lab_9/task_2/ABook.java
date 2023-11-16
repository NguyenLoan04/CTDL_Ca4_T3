package lab_9.task_2;

public abstract class ABook {
    protected String title;
    protected int pageNumber;
    protected int year;
    protected String author;
    protected double price;

    public ABook(String title, int pageNumber, int year, String author, double price) {
        this.title = title;
        this.pageNumber = pageNumber;
        this.year = year;
        this.author = author;
        this.price = price;
    }
    public boolean isMagazine(){
        return (this instanceof Magazine) ? true : false;
    }
    public boolean isReBook(){
        return (this instanceof ReferenceBook) ? true : false;
    }
    public abstract String typeOfBook();
    public boolean is10ysMaga(int now){
        if(isMagazine()){
            if(now-year==10) return true;
        }
        return false;
    }
    public boolean isSame(ABook other){
       return this.getClass()== other.getClass() && this.author.equals(other.author);
    }


    public abstract boolean sameName(String title);

    public abstract boolean sameYear(int year);
    public abstract void add(Chapter c);
}
