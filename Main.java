/** 
 * Erick Guerra 23208
 * gue23208@uvg.edu.gt
 * Hoja-de-trabajo-7
 * Lenguaje: Java
 * Utilizacion de arboles para traducir una oracion
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        BinaryTree<Association<String, String>> dictionary = new BinaryTree<>();

        List<Association<String, String>> associations = loadDictionary("diccionario.txt");
        
        for (Association<String, String> association : associations) {
            dictionary.insert(association);
        }

        System.out.println("Arbol ordenado por la palabra en inglés:");
        for (Association<String, String> association : associations) {
            System.out.println("(" + association.getKey() + ", " + association.getValue() + ")");
        }

        System.out.println("\nOración:");
        translateSentence("texto.txt", dictionary);
    }

    
    /** 
     * @param filename
     * @return List<Association<String, String>>
     */
    private static List<Association<String, String>> loadDictionary(String filename) {
        List<Association<String, String>> associations = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String wordEnglish = parts[0].trim().substring(1);
                String wordSpanish = parts[1].trim().substring(0, parts[1].trim().length() - 1);
                Association<String, String> association = new Association<>(wordEnglish, wordSpanish);
                associations.add(association);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(associations, (a1, a2) -> a1.getKey().compareTo(a2.getKey()));
        return associations;
    }

    
    /** 
     * @param dictionary
     */
    private static void translateSentence(String filename, BinaryTree<Association<String, String>> dictionary) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
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

    
    /** 
     * @param dictionary
     * @return String
     */
    private static String translateWord(String word, BinaryTree<Association<String, String>> dictionary) {
        Association<String, String> association = dictionary.search(word);
        if (association != null) {
            return association.getValue();
        } else {
            return "" + word + "";
        }
    }
}
