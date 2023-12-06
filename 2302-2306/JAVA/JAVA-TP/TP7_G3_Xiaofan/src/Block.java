import java.util.LinkedList;
import java.util.Queue;

class Block {
    //the main use of Queue is to implement a messaging system or task scheduling system
    //FIFO
    private final Queue<Transaction> transactions = new LinkedList<>();

    //return to queue "transactions"
    public Queue<Transaction> getTransactions() {
        return transactions;
    }

    //adds the parameter transaction to the queue transactions
    //returns a boolean value → whether the operation was successful or not.
    //In the add(), if the num of the queue = 10, the pay() is executed for each transaction.
    public boolean add(Transaction transaction) {
        boolean added = transactions.offer(transaction);
        if (transactions.size() == 10) {
            transactions.forEach(Transaction::pay);
        }
        return added;
    }

    //Returns a string → contain information about all the transactions
    public String toString() {
        String transactionString = "\nTransaction history:\n";
        for (Transaction transaction : transactions) {
            transactionString += transaction.toString() + "\n";
        }
        return transactionString;
    }
}
