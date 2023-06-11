package dictionary;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class SaveableDictionary {

    private HashMap<String, String> dictionary;
    private String file;

    public SaveableDictionary() {
        this.dictionary = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        this.dictionary = new HashMap<>();
        this.file = file;
    }

    public void add(String words, String translation) {
        if (!(this.dictionary.keySet().contains(words)) &&
            !(this.dictionary.values().contains(words))) {
            this.dictionary.put(words, translation);
        }
    }

    public String translate(String word) {
        if (!(this.dictionary.keySet().contains(word)) &&
            !(this.dictionary.values().contains(word))) {
                return null;
        }

        if (!(this.dictionary.get(word) == null)) {
            return this.dictionary.get(word);
        } 
        
        return searchValues(word);
    }

    public String searchValues(String word) {
        String translation = "";
        for (Entry<String, String> w : this.dictionary.entrySet()) {
            if (w.getValue().equals(word)) {
                translation = w.getKey();
                break;
            }
        }
        return translation;           
    }

    public void delete(String word) {
        if (!(this.dictionary.keySet().contains(word)) &&
            !(this.dictionary.values().contains(word))) {
                return;
        }

        if(this.dictionary.remove(word) == null) {
            this.dictionary.remove(searchValues(word));
        }
    }

    public boolean load() {
        try (Scanner scanner = new Scanner(Paths.get(this.file))) {
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                String[] wordAndTranslation = row.split(":");
                String word = wordAndTranslation[0];
                String translation = wordAndTranslation[1];
                add(word, translation);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean save() {
        try {
            PrintWriter writer = new PrintWriter(this.file);
            for (Entry<String, String> entry : this.dictionary.entrySet()) {
                writer.println(entry.getKey() + ":" + entry.getValue());
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
