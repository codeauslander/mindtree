package ShotClass;

import java.util.*;

public class C10_SimpleTextQueries {
    public static void textQueries(List<String> sentences, List<String> queries) {
        String[] responses = new String[queries.size()];
        for (int outerIndex = 0; outerIndex < sentences.size(); outerIndex++) {
            String sentence = sentences.get(outerIndex);
            for (int innerIndex = 0; innerIndex < queries.size(); innerIndex++) {
                String[] words = queries.get(innerIndex).split(" ");
                int counter = 0;
                for (int i = 0; i < words.length; i++) {
                    if (sentence.contains(words[i])) {
                        counter++;
                    }
                }
                if (counter == words.length) {
                    // System.out.println(queries.get(innerIndex) + " | " + sentence + " | " + response);
                    if(responses[innerIndex] == null){
                        responses[innerIndex] = "";
                    }
                    responses[innerIndex] += outerIndex + " ";
                }
            }
        }
        for(int index = 0; index < responses.length; index++){
            if(responses[index] == null){
                responses[index] = "-1";
            }
            System.out.println(responses[index]);
        }
    }
}
