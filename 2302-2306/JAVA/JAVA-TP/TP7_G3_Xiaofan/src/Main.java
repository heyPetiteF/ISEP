import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {
    // Wallet (Portefeuille)
    private static Map<Integer, Wallet> wallets = new HashMap<>();
    //Define a static list of wallets and a static list of blockchains
    private static List<Block> blockchain = new ArrayList<>();

    //Initialize owner's name and initialize each with 66 isepcoins
    public static void main(String[] args) {
        String[] ownerName = {"ZHI", "YIN", "NI", "TAI", "MEI"};
        for (String name : ownerName) {
            Wallet wallet = new Wallet(name);
            wallet.setIsepCoins(66);
            wallets.put(wallet.getToken(), wallet);
        }
        Simulate();
        BlockchainStatus();
    }


    //Simulation of 88 random trades
    public static void Simulate() {
        Random random = new Random();
        List<Wallet> walletList = new ArrayList<>(wallets.values());

        //Each time a random originWallet and destinationWallet are selected with a random number of isepCoins
        //then a Transaction object is created and add it to a Block
        for (int i = 0; i < 88; i++) {
            Wallet sender = walletList.get(random.nextInt(walletList.size()));
            Wallet receiver = walletList.get(random.nextInt(walletList.size()));
            int amount = random.nextInt(sender.getIsepCoins() + 1);
            Transaction transaction = new Transaction(sender, receiver, amount);
            Block currentBlock;

            //A block is terminated when the number of transactions in the block reaches 10 or when the blockchain list is empty
            //a new block object is then created and added to the blockchain list.
            if (blockchain.isEmpty() || blockchain.get(blockchain.size() - 1).getTransactions().size() == 10) {
                currentBlock = new Block();
                blockchain.add(currentBlock);
            } else {
                currentBlock = blockchain.get(blockchain.size() - 1);
            }
            currentBlock.add(transaction);
        }

    }

    //The content of the blockchain and the state of the wallet.
    public static void BlockchainStatus() {

        for (Block block : blockchain) {
            System.out.println(block.toString());
        }

        System.out.println("The situation now : ");

        for (Wallet wallet : wallets.values()) {
            System.out.printf("the owner: %s, isepCoins: %d%n", wallet.getOwner(), wallet.getIsepCoins());
        }
    }
}

