package ATM;

import java.util.List;
import  java.util.ArrayList;

public class BankManager {
    private List<BanknoteCell> cells = null;
    void  setCells (List<BanknoteCell> cells){
        this.cells = cells;
    }
}
public int[] tryPutcell(Nominal[] banknotes ){
    if (cells = null){
        throw new ATM_Exception("Отсутствуют банкноты")
    }
    final int[] score = new int[cells.size()];
    for(final var money : banknotes ){
        boolean isPut = false;
        for(int ind = 0; ind < cells.size(); ind++){
            final var cell = cells.get(ind);
            if(!money.equals(cell.getBanknoteNominal())){
                continue;
            }
            final int newCntInCell = score[ind] + 1;
            if (!cell.tryPut(newCntInCell)) {
                continue;
            }
            score[ind] = newCntInCell;
            isPut = true;
            break;
        }
        if (!isPut) {
            throw new ATM_Exception("Отсутствуют банкноты");
        }
    }
    return score;
}

    public void putToCells(int[] cnt) {
        if (cnt.length != cells.size()) {
            throw new ATM_Exception("Не удается вставить банкноту. Ошибка!");
        }
        for (int i = 0; i < cnt.length; i++) {
            final var curCell = cells.get(i);
            final int ammountAdded = cnt[i];
            curCell.put(ammountAdded);
        }
    }

    public int[] tryGetFromCells(int sum) {
        if (cells == null || cells.isEmpty()) {
            throw new ATM_Exception("Отсутствуют банкноты");
        }
        int curSum = sum;
        final int[] result = new int[cells.size()];
        for (int i = 0; i < cells.size(); i++) {
            final var curCell = cells.get(i);
            final int canGetFromCellSum = curCell.tryGetSum(curSum);
            final int canGetFromCellCnt = canGetFromCellSum / curCell.getBanknoteNominal().getCost();
            result[i] = canGetFromCellCnt;
            curSum -= canGetFromCellSum;
            if (curSum == 0) {
                break;
            }
        }
        if (curSum > 0) {
            throw new ATM_Exception("Неккоректная сумма");
        }
        return result;
    }

    public Nominal[] getFromCells(int[] cnt) {
        if (cnt.length != cells.size()) {
            throw new ATM_Exception("Не удается вставить банкноту. Ошибка!");
        }
        final List<Nominal> result = new ArrayList<>();
        for (int i = 0; i < cnt.length; i++) {
            final var curCell = cells.get(i);
            final int cntFromCell = cnt[i];
            final var banknotesFromCell = getFromCell(curCell, cntFromCell);
            result.addAll(banknotesFromCell);
        }
        final Nominal[] resArray = new Nominal[result.size()];
        return result.toArray(resArray);
    }

    private List<Nominal> getFromCell(BanknoteCell cell, int cnt) {
        final List<Nominal> result = new ArrayList<>();
        final int banknoteCost = cell.getBanknoteNominal().getCost();
        cell.getBanknoteNominal(cnt);
        for (int i = 0; i < cnt; i++) {
            try {
                result.add(new Nominal(banknoteCost));
            } catch (Exception e) {
                throw new ATM_Exception("Внутренняя ошибка. Номинал банкноты" +  banknoteCost );
            }
        }
        return result;
    }


}

    }
}
