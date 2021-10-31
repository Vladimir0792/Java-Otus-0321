package homework;


import java.util.ArrayDeque;
import java.util.Deque;

/*public class CustomerReverseOrder {


    //todo: 2. надо реализовать методы этого класса
    //надо подобрать подходящую структуру данных, тогда решение будет в "две строчки"
    private final ArrayList<Customer> arr = new ArrayList<>();
    public void add(Customer customer) {
        arr.add(customer);
    }

    public Customer take() {

        return (Customer) arr.clone();
        // это "заглушка, чтобы скомилировать"
    }
}*/

public class CustomerReverseOrder {


    //todo: 2. надо реализовать методы этого класса
    //надо подобрать подходящую структуру данных, тогда решение будет в "две строчки"
    private final Deque<Customer> stck = new ArrayDeque<>();

    public void add (Customer customer){
        stck.push(customer);
    }

    public Customer take(){
        return stck.pop();
    }
}
