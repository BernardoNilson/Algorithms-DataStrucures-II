import java.util.HashMap;
import java.util.LinkedHashMap;

public class Compara {

    public static void main(String[] args) {

        In arq = new In("DomCasmurro_utf8.txt");
        String[] words = arq.readAllStrings();
        arq.close();

        // SeparateChainingHashST<String, Integer> dict = new SeparateChainingHashST<>();
        // LinearProbingHashST<String, Integer> dict = new LinearProbingHashST<>();
        // HashMap<String, Integer> dict = new HashMap<>();
        LinkedHashMap<String, Integer> dict = new LinkedHashMap<>();

        long start = System.nanoTime();
        for (String word : words) {
            word = word.toLowerCase();
            if (dict.containsKey(word)) {
                int count = dict.get(word) + 1; // Podia colcar direto no put
                dict.remove(word); // Não precisava deletar
                dict.put(word, count);
            } else {
                dict.put(word, 1);
            }
        }

        long end = System.nanoTime();
        long dur = end - start;
    

        // System.out.println("Palavras:");
        // for (String key : dict.keys()) {
        //     System.out.println("Chave: " + key + " e Frequência: " + dict.get(key));
        // }

        System.out.println("Tempo para executar: " + (double)(dur/1e9));
    }
}
