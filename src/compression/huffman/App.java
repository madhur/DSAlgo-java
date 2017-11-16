package compression.huffman;

public class App {

    public static void main(String[] args) {
        String text = "My name is Joiiii";

        int[] charFrequencies = new int[256];

        for(char c: text.toCharArray()) {
            ++charFrequencies[c];
        }

        HuffmanCode code = new HuffmanCode();
        HuffmanTree huffmanTree = code.buildCode(charFrequencies);
        code.printCodes(huffmanTree,  new StringBuilder());
    }
}
