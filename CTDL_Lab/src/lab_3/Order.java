package lab_3;

import java.util.Arrays;
import java.util.Comparator;

public class Order {
    private OrderItem[] items;
    private ByNameAndPrice baseSort;
    //cost
    public double cost(){
        double sum=0;
        for(int i=0;i<items.length;i++){
            sum+=items[i].getProduct().getPrice();
        }
        return sum;
    }
    //using binary search approach
    public boolean contains(Product p){
        return linearBinarySearch(p) ;
    }

    private boolean linearBinarySearch(Product p) {
        Arrays.sort(items, baseSort);
        int low=0;
        int high=items.length-1;
        while (low<high){
            int mid=(low+high)/2;
            OrderItem midOrder=items[mid];
            int v=p.compareTo(midOrder.getProduct());
            if(v==0) return true;
            else if(v>0){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return false;
    }
    // get all products based on the given type using
    //linear search
    public Product[] filter(String type){
        int size=0;
        for (int i=0;i<items.length;i++){
            if(items[i].getProduct().getName().compareTo(type)==0){
                size++;
            }
        }
        Product[] result=new Product[size];
        int index=0;
        for (int i=0;i<items.length;i++){
            for (int j=0;j< result.length;j++){
                if(type.compareTo(items[i].getProduct().getName())==0){
                    index++;
                    break;
                }
                result[i-index]=items[i].getProduct();
            }
        }
        return result;
    }


}
