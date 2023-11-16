package lab_9.task_2;

public class Magazine extends ABook{
    private String name;

    public Magazine(String title, int pageNumber, int year, String author, double price, String name) {
        super(title, pageNumber, year, author, price);
        this.name = name;
    }
    public boolean isMagazine(ABook book){
        return (book instanceof Magazine) ? true : false;
    }

    @Override
    public String typeOfBook() {
        return "Magazine";
    }

    public boolean sameName(String title) {
        return typeOfBook().equals("Magazine") && name.equals(title);
    }

    public boolean sameYear(int year) {
        return typeOfBook().equals("Magazine") && this.year==year;
    }

    @Override
    public void add(Chapter c) {

    }

    @Override
    public String toString() {
        return "Magazine{" +
                "name='" + name + '\'' +
                '}';
    }
}
