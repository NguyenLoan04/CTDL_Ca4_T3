package lab_3;


public class Product  {
    private String id;
    private String name;
    private double price;
    private String type;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }


    public int compareTo(Product o) {
        int byName= this.getName().compareTo(o.getName());
        if(byName==0) return Double.compare(this.price,o.price);
        return byName;
    }
}
