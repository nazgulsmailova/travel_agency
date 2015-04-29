package com.epam.smailova.travel.transfer;

import com.epam.smailova.travel.model.Account;

public class TransferAction {
    private long transactionAmount;
    public TransferAction(long amount) {
        if (amount > 0) {
            this.transactionAmount = amount;
        } else {
            throw new IllegalArgumentException();
        }
    }
    public boolean transferIntoAccount(Account from, Account to) {

        double demand = from.getAmount() - transactionAmount;

        if (demand >= 0) {
            from.setAmount((long) demand);
            to.addAmount(transactionAmount);
            return true;
        } else {
            return false;
        }
    }
    public double getTransactionAmount () {
        return transactionAmount;
    }

}

