package ATM;

import java.util.ArrayList;
import java.util.List;

public class atm implements Staff, User {
    private final List<BankCell> cell =new ArrayList<>();
    private final BankManager bankManager = new BankManager();

    public  int getBalance(){
        int result = 0;
        for(BankCell bankCell : cell){
            result += bankCell.getBalance();
        }
        return result;
    }
    public int getCellCount(){
        return cell.size();
    }
    @Override
    public void put(Object[] banknotes){
        final var countCell = bankManager.tryPutcell(Nominal[])banknotes);
        bankManager.putCell(countCell);
    }

    @Override
    public  Object[] get(int sum){
        final var countCell = bankManager.tryCell(sum);
    }

    @Override
    public  void  putCell(BanknoteCell cells){
        cell.add(cells);
        cell.sort((var c1, var c2) -> (c2.getNominal().getCost() - c1.getNominal().get.Cost()));
        bankManager.setCell(cell);
    }
}
