package Revision;

import java.util.*;

public class AlienDictionary {
    public String findOrder(String[] words) {
        int n = words.length;
        HashMap<Character, HashSet<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();
        //Initialise graph and indegree maps
        for(String word: words){
            for(int i = 0; i < word.length(); i++){
                //put in placeholder for this character in graph and indegree hashMaps
                if(!graph.containsKey(word.charAt(i))){
                    graph.put(word.charAt(i), new HashSet<>());
                }

                if(!indegree.containsKey(word.charAt(i))){
                    //set indegree to 0 initially
                    indegree.put(word.charAt(i), 0);
                }
            }
        }

        //populate graph and indegree maps by comparing 2 words
        for(int i = 0; i < words.length - 1; i++){
            String a = words[i];
            String b = words[i + 1];

            //invalid condition -> a = abcs and b = abc, then b must be before a , or else invalid
            if(a.length() > b.length() && a.startsWith(b)){
                return "";
            }

            int ptr = 0;
            //compare a and b now; first non-similar character between a and b forms an edge from a to b
            while (ptr < a.length() && ptr < b.length()){
                if(a.charAt(ptr) != b.charAt(ptr)){
                    //add the edge only if not stored previously(prevents, extra indegree addition to incoming char)
                    if(!graph.get(a.charAt(ptr)).contains(b.charAt(ptr))){
                        //form the edge from a to b and break
                        graph.get(a.charAt(ptr)).add(b.charAt(ptr));
                        //increment indegree
                        indegree.put(b.charAt(ptr), indegree.get(b.charAt(ptr)) + 1);
                    }
                    //keep the above if statement inside the previous if is also necessary since this ensures loop is broken when first non-similar character is seen
                    break;
                }
                ptr++;
            }
        }

        //add 0 indegree chars to queue
        Queue<Character> q = new LinkedList<>();
        for(Map.Entry<Character, Integer> entry: indegree.entrySet()){
            if(entry.getValue() == 0){
                q.add(entry.getKey());
            }
        }

        //now perform topological sort and populate StringBuilder with the order
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            Character curr = q.poll();
            sb.append(curr);
            for(Character nei: graph.get(curr)){
                indegree.put(nei, indegree.get(nei) - 1);
                if(indegree.get(nei) == 0){
                    q.add(nei);
                }
            }
        }

        //if topological sort length is smaller than indegree length, it is invalid
        if(sb.length() < indegree.size()){
            return "";
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        AlienDictionary alienDictionary = new AlienDictionary();

        String res = alienDictionary.findOrder(new String[]{"cc", "ccac", "bd", "bacc", "d", "dda", "a", "aca", "abdaa"});
        System.out.println(res);
    }
}
