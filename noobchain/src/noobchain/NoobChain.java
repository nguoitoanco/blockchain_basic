package noobchain;

import java.util.ArrayList;

public class NoobChain {
    public static ArrayList<Block> blockChains = new ArrayList<Block>();
    public static int difficulty = 1;

    public static void main(String[] args) {
        System.out.println(new String(new char[difficulty]));
        blockChains.add(new Block("Hi im the first block", "0"));
        System.out.println("Trying to Mine block 1... ");
        blockChains.get(0).mineBlock(difficulty);

        blockChains.add(new Block("Yo im the second block",blockChains.get(blockChains.size()-1).getHash()));
        System.out.println("Trying to Mine block 2... ");
        blockChains.get(1).mineBlock(difficulty);

        blockChains.add(new Block("Hey im the third block",blockChains.get(blockChains.size()-1).getHash()));
        System.out.println("Trying to Mine block 3... ");
        blockChains.get(2).mineBlock(difficulty);

        System.out.println("\nBlockchain is Valid: " + isChainValid());

//        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
//        System.out.println("\nThe block chain: ");
//        System.out.println(blockchainJson);

    }

    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;

        //loop through blockchain to check hashes:
        for(int i=1; i < blockChains.size(); i++) {
            currentBlock = blockChains.get(i);
            previousBlock = blockChains.get(i-1);
            //compare registered hash and calculated hash:
            if(!currentBlock.getHash().equals(currentBlock.calculateHash()) ){
                System.out.println("Current Hashes not equal");
                return false;
            }
            //compare previous hash and registered previous hash
            if(!previousBlock.getHash().equals(currentBlock.getPreviousHash()) ) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
        }
        return true;
    }
}
