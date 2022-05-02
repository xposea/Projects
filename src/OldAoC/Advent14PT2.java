import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Advent14PT2 {
    static String base;
    static HashMap<Character, Long> charCount = new HashMap<>();
    public static HashMap<String,HashSet<String>> create() throws Exception {
        File file = new File("C:\\Users\\Dylan\\IdeaProjects\\NOINT\\src\\day14.txt");
        Scanner sc = new Scanner(file);
        HashMap<String, HashSet<String>> rules = new HashMap<>();
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            if(!line.equals("")){
                if(line.contains("->")){
                    HashSet<String> insert = new HashSet<>();
                    String[] split = line.split(" -> ");
                    insert.add(new String(new char[]{split[0].charAt(0),split[1].charAt(0)}));
                    insert.add(new String(new char[]{split[1].charAt(0),split[0].charAt(1)}));
                    rules.put(line.split(" -> ")[0],insert);
                    if(!charCount.containsKey(line.split(" -> ")[0].charAt(0))) charCount.put(line.split(" -> ")[0].charAt(0),0L);
                    if(!charCount.containsKey(line.split(" -> ")[0].charAt(1))) charCount.put(line.split(" -> ")[0].charAt(1),0L);
                    if(!charCount.containsKey(line.split(" -> ")[1].charAt(0))) charCount.put(line.split(" -> ")[1].charAt(0),0L);
                } else base = line;
            }
        }
        return rules;
    }

    public static HashMap<String,Long> ruleApply(HashMap<String, Long> countMap, HashMap<String, HashSet<String>> rules, int order){
        if(order == 0) return countMap;
        HashMap<String, Long> newCountMap = new HashMap<>();
        for(String key : countMap.keySet()){
            Long count = countMap.get(key);
            if(count != 0L) {
                for (String added : rules.get(key)) {
                    if(!newCountMap.containsKey(added)) {
                        newCountMap.put(added, count);
                    } else newCountMap.replace(added,newCountMap.get(added) + count);
                }
            }
        }
        return ruleApply(newCountMap, rules,order - 1);
    }

    public static void main(String[] args) throws Exception{
        HashMap<String, HashSet<String>> rules = create();
        HashMap<String, Long> countMap = new HashMap<>();

        for(String key : rules.keySet()){
            if(!countMap.containsKey(key)) countMap.put(key,0L);
            for(String pairs : rules.get(key)){
                if(!countMap.containsKey(pairs)) countMap.put(pairs,0L);
            }
        }
        for(int i = 0; i < base.length() - 1; i++){
            countMap.replace(new String(new char[]{base.charAt(i), base.charAt(i + 1)}), countMap.get(new String(new char[]{base.charAt(i), base.charAt(i + 1)})) + 1);
        }
        countMap = ruleApply(countMap,rules, 40);
        System.out.println(countMap);
        for(String key : countMap.keySet()){
            Long count = countMap.get(key);
            charCount.replace(key.charAt(0),charCount.get(key.charAt(0)) + count); //if(!countMap.containsKey(string)) countMap.put(string,0);
            charCount.replace(key.charAt(1),charCount.get(key.charAt(1)) + count);
        }
        System.out.println(Collections.max(charCount.values())/2 - Collections.min(charCount.values())/2 + 1);
    }
}
