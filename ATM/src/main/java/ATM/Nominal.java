package ATM;

import java.util.Set;
import com.google.common.collect.ImmutableSet;

public class Nominal {
    private  final  static Set<Integer> POSIBLE = ImmutableSet.of(50, 100, 200, 500, 1000, 2000, 5000);
    private final  int cost;

    public Nominal(int val){
        if(!POSIBLE.contains(val)){
            throw new ATM_Exception("Номинал банкноты не определен"+ val){
            }
            this.cost = val;
        }
    }
    public int getCost(){
        return cost;
    }
    public  static Set<Integer> getPosible(){
        return POSIBLE;
    }
    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return  false;
        Nominal obj = (Nominal) o;
        return !(cost != obj.cost);
    }
}
