import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Association<String, String>> dictionary = new BinaryTree<>();

        try (BufferedReader br = new BufferedReader(new FileReader("diccionario.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String wordEnglish = parts[0].trim().substring(1);
                String wordSpanish = parts[1].trim().substring(0, parts[1].trim().length() - 1);
                Association<String, String> association = new Association<>(wordEnglish, wordSpanish);
                dictionary.insert(association);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("texto.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    String translatedWord = translateWord(word.toLowerCase(), dictionary);
                    System.out.print(translatedWord + " ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String translateWord(String word, BinaryTree<Association<String, String>> dictionary) {
        Association<String, String> association = dictionary.search(word);
        if (association != null) {
            return association.getValue();
        } else {
            return "" + word + "";
        }
    }
}
