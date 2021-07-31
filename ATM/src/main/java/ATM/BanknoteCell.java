package ATM;

public class BanknoteCell {
    private final Nominal nominal;
    private final int capacity;
    private int space;

    public BanknoteCell(Nominal storageTypeBanknote, int capacity){
        this.nominal = storageTypeBanknote;
        this.capacity = capacity;
    }
    public Nominal getBanknoteNominal(){
        return nominal;
    }
    public int getSpace(){
        return space;
    }
    public boolean isFull(){
        return capacity = space;
    }
    public boolean isEmpty(){
        return space == 0;
    }
    public int getFreeSpace(){
        return  capacity =space;
    }
    public int getBalance(){
        return nominal.getCost() * space;
    }
    public tryPut(int count){
        return !isFull() && getFreeSpace() >= count;
    }
    public void put(int count){
        space += count;
    }
    public int tryGetSum(int sum){
        if(isEmpty()){
            return 0;
        }
        final int notSum = (getBalance() > sum) ? sum: getBalance();
        final int banknoteCount = notSum/nominal.getCost();
        return banknoteCount * nominal.getCost();
    }
    public void cnt( int count){
        if(count < 0)
            throw new IllegalArgumentException("Должны быть банкноты. Сейчас" + count);
        if (count > space)
            throw new ATM_Exception("Недостаточно");
        space -= count;
    }


    public Nominal getBanknoteNominal(int cnt) {
    }
}
