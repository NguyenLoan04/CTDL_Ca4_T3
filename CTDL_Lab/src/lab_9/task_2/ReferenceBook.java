package lab_9.task_2;

import java.util.ArrayList;
import java.util.List;

public class ReferenceBook extends ABook{
    private String field;
    private List<Chapter> chapters;

    public ReferenceBook(String title, int pageNumber, int year, String author, double price, String field) {
        super(title, pageNumber, year, author, price);
        this.field = field;
        this.chapters = new ArrayList<>();
    }
    public void add(Chapter chapter){
        chapters.add(chapter);
    }
    public boolean isReBook(ABook book){
        return (book instanceof ReferenceBook) ? true : false;
    }

    public boolean moreChapter(ReferenceBook max) {
        return chapters.size()> max.chapters.size();
    }

    @Override
    public String typeOfBook() {
        return "ReferenceBook";
    }

    @Override
    public boolean sameName(String title) {
        return false;
    }

    @Override
    public boolean sameYear(int year) {
        return false;
    }

    @Override
    public String toString() {
        return "ReferenceBook{" +
                "field='" + field + '\'' +
                ", chapters=" + chapters.toString() +
                '}';
    }
}
