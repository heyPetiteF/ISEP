import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class Wallet {
    //owner : type texte, ne pouvant être modifié, correspondant au nom du propriétaire du portefeuille (getter)
    private final String owner;
    // token : type entier, ne pouvant être modifié, correspondant au numéro du portefeuille, définit aléatoirement à la création du portefeuille (getter)
    private final int token;
    //isepCoins : type entier, correspondant au solde du portefeuille, initialisé à 0 à la création du portefeuille (getter et setter)
    private int isepCoins;

    public Wallet(String owner) {
        this.owner = owner;
        this.token = generateToken();
    }

    public String getOwner() {
        return this.owner;
    }

    public int getToken() {
        return this.token;
    }

    public int getIsepCoins() {
        return this.isepCoins;
    }

    public void setIsepCoins(int isepCoins) {
        this.isepCoins = isepCoins;
    }

    //Open source code
    //Generate a random number as a "key" and hash it using the SHA-256 hash function until the hash value starts with "00"
    //then return the key.
    private int generateToken() {
        MessageDigest md;
        Random random = new Random();
        int token = random.nextInt(Integer.MAX_VALUE);

        try {
            md = MessageDigest.getInstance("SHA-256");

            while (!isValidToken(md.digest(String.valueOf(token).getBytes()))) {
                token = random.nextInt(Integer.MAX_VALUE);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return token;
    }

    private boolean isValidToken(byte[] hash) {
        String hexHash = bytesToHex(hash);

        return hexHash.substring(0, 2).equals("00");
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

}

