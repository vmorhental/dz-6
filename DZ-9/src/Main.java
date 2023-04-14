import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] words = new String[]{"tes tes", "pya", "mama", "yes", "rere"};
        System.out.println(finalMethod(words));

    }
    // 1 - here we describe how we define even chars
    public static boolean hasEvenChars(String word) {
        for (int i = 0; i < word.length(); i++) {
            int count = 0;
            if (word.charAt(i) == ' ') continue;
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(i) == word.charAt(j)) {
                    count++;
                }
            }
            if (count % 2 != 0) {
                return false;
            }
        }
        return true;
    }
    // 2 here we create list of words with even chars using method 1
    public static ArrayList<String> findEvenCharsStrings (String[] words, int limit){
        ArrayList<String> result = new ArrayList<String>();
        int size = words.length;
        for (int i=0; i< size; i++){
            if (result.size() >= limit) break;
            if (hasEvenChars(words[i])){
                result.add(words[i]);
            }
        }
        return result;
    }

    // 3 here we look at list of words with even chars and separate them into unique chars Set
    public static Set<Character> findUniqueChars (ArrayList<String>result){
        Set<Character> uniqueCharsSet = new HashSet<>();
        for (String s:result){
            char [] chars = s.toCharArray();
            for (char c:chars){
                if (c == ' ') continue;
                uniqueCharsSet.add(c);
            }
        }
        return uniqueCharsSet;

    }
    // 4 here we use all predefined methods in one place at first part we just print list of words and in
    // second we return Set of chars that are unique
    public static Set<Character> finalMethod (String[] words){
        ArrayList<String> test = findEvenCharsStrings(words,2);
        System.out.println(test);

        Set<Character> finalCharsSet = findUniqueChars(test);
        return finalCharsSet;
    }
}