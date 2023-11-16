package lab_9.task_2;

import java.util.*;

public class Library {
    List<ABook> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void add(ABook book) {
        this.books.add(book);
    }

    public double sumPrice() {
        double sum = 0;
        for (int i = 0; i < books.size(); i++) {
            sum += books.get(i).price;
        }
        return sum;
    }

    public ReferenceBook mostChapters() {
        List<ReferenceBook> list = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isReBook())
                list.add((ReferenceBook) books.get(i));
        }
        ReferenceBook max = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).moreChapter(max))
                max = list.get(i);
        }
        return max;
    }

    public boolean containsMagazine(String title) {
//        List<Magazine> list= new ArrayList<>();
//        for (int i=0;i<books.size();i++){
//            if (books.get(i).isMagazine()){
//                list.add((Magazine) books.get(i));
//            }
//        }
//       Magazine re= null;
//        for (Magazine m: list){
//            if(m.sameName(title))
//                re=m;
//        }
//        return re;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).sameName(title)) {
                return true;
            }
        }
        return false;
    }

    public List<Magazine> published(int year) {
        List<Magazine> list = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).sameYear(year))
                list.add((Magazine) books.get(i));
        }
        return list;
    }

    public List<ABook> sortByTitleAndYear() {
        books.sort(new Comparator<ABook>() {
            @Override
            public int compare(ABook o1, ABook o2) {
                if (o1.title.compareTo(o2.title) == 0) {
                    return o2.year - o1.year;
                }
                return o1.title.compareTo(o2.title);
            }
        });
        return books;
    }

    public Map<Integer, Integer> thongke() {
        Map<Integer, Integer> re = new HashMap<>();
        for (ABook book : books) {
            re.put(book.year, re.getOrDefault(book.year, 0) + 1);
        }
        return re;
    }

    public static void main(String[] args) {
        Library test = new Library();
        Chapter c1=new Chapter("def", 4);
        Chapter c2=new Chapter("ghi", 4);
        Chapter c3=new Chapter("abc", 4);
        Chapter c4=new Chapter("pdf", 4);
        Chapter c5=new Chapter("qwd", 4);
        ABook b1 = new ReferenceBook("L", 20, 2004, "NBL", 110.0, "abc");
        b1.add(c1);
        b1.add(c2);
        ABook b2 = new ReferenceBook("T", 24, 2003, "DMT", 80.0, "abc");
        b2.add(c3);
        b2.add(c4);
        b2.add(c5);
        ABook m1 = new Magazine("L", 20, 2004, "NBL", 120.0, "tt");
        ABook m2 = new Magazine("T", 24, 2003, "DMT", 200.0, "mm");
        test.add(b1);
        test.add(b2);
        test.add(m1);
        test.add(m2);
        System.out.println(test.sumPrice());
        System.out.println(test.mostChapters());
        System.out.println(test.containsMagazine("tt"));
        System.out.println(test.published(2004));
        System.out.println(test.sortByTitleAndYear());
        System.out.println(test.thongke());
    }
}
