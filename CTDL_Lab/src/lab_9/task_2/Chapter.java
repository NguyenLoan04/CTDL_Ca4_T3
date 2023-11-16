package lab_9.task_2;

public class Chapter {
    private String titleC;
    private int pages;

    public Chapter(String titleC, int pages) {
        this.titleC = titleC;
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "titleC='" + titleC + '\'' +
                ", pages=" + pages +
                '}';
    }
}
