package ATM;

import java.util.ArrayList;
import java.util.List;

public class Atm {
    private final List<BanknoteCell> cells = new ArrayList<>();
    private final CellManager cellManger = new CellManager();

    public int getBalance() {
        int result = 0;
        for (BanknoteCell banknoteCell : cells) {
            result += banknoteCell.getBalance();
        }
        return result;
    }

    public int getCellCnt() {
        return cells.size();
    }
}
