class Transaction {
    //originWallet : type Wallet, correspondant au numéro du portefeuille émetteur dela transaction, ne pouvant être modifié (getter)
    private final Wallet originWallet;
    //destinationWallet : type Wallet, correspondant au numéro du portefeuille destinataire de la transaction, ne pouvant être modifié (getter)
    private final Wallet destinationWallet;
    //isepCoins : type entier, correspondant au montant de la transaction, ne pouvant être modifié (getter)
    private final int isepCoins;
    //payed : type booléen, indique si la transaction a été réalisée ou non (getter)
    private boolean payed;

    //Initialise the "originWallet", "destinationWallet" and "isepCoins"
    //Set "payed" status of the transaction to unpaid.
    public Transaction(Wallet originWallet, Wallet destinationWallet, int isepCoins) {
        this.originWallet = originWallet;
        this.destinationWallet = destinationWallet;
        this.isepCoins = isepCoins;
        this.payed = false;
    }
    public boolean isPayed() {
        return this.payed;
    }

    //pay() is used to implement payment for transactions
    //Before a transaction is paid:
    //check that the transaction has been paid
    //check that the originWallet
    //check destinationWallet information
    //check that the originWallet has enough isepcoins
    public boolean pay() {
        if (this.payed || this.originWallet.equals(this.isepCoins) || this.originWallet.getIsepCoins() < this.isepCoins) {
            return false;
        }

        this.originWallet.setIsepCoins(this.originWallet.getIsepCoins() - this.isepCoins);
        this.destinationWallet.setIsepCoins(this.destinationWallet.getIsepCoins() + this.isepCoins);
        this.payed = true;
        return true;
    }

    //Show transaction information
    public String toString() {
        return "-- the originWallet = " + this.originWallet.getOwner() + ", the destinationWallet = " + this.destinationWallet.getOwner() + ", isepCoins = " + this.isepCoins + ", payed → " + this.payed + " --";
    }
}




/*
    public Wallet getOriginWallet() {
        return this.originWallet;
    }

    public Wallet getDestinationWallet() {
        return this.destinationWallet;
    }

    public int getIsepCoins() {
        return this.isepCoins;
    }
*/
