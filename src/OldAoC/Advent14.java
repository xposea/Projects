import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Advent14 {
    static String base;
    static HashMap<Character,Integer> countMap = new HashMap<>();
    public static HashMap<String,Character> create() throws Exception {
        File file = new File("C:\\Users\\Dylan\\IdeaProjects\\NOINT\\src\\day14.txt");
        Scanner sc = new Scanner(file);
        HashMap<String, Character> rules = new HashMap<>();
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            if(!line.equals("")){
                if(line.contains("->")){
                    rules.put(line.split(" -> ")[0],line.split(" -> ")[1].charAt(0));
                    if(!countMap.containsKey(line.split(" -> ")[0].charAt(0))) countMap.put(line.split(" -> ")[0].charAt(0),0);
                    if(!countMap.containsKey(line.split(" -> ")[0].charAt(1))) countMap.put(line.split(" -> ")[0].charAt(1),0);
                    if(!countMap.containsKey(line.split(" -> ")[1].charAt(0))) countMap.put(line.split(" -> ")[1].charAt(0),0);
                } else base = line;
            }
        }
        return rules;
    }

    public static String ruleApply(String input, int order,HashMap<String,Character> rules){
        int counter = 0;
        if(order == 0) return input;
        char[] newInput = new char[input.length()*2 - 1];
        for(int i = 0; i < newInput.length; i++){
            if(i % 2 == 0) newInput[i] = input.charAt(i/2);
            else{
                //System.out.println(new String(new char[]{input.charAt(counter), input.charAt(counter + 1)}));
                newInput[i] = rules.get(new String(new char[]{input.charAt(counter), input.charAt(counter + 1)}));
                counter++;
            }
        }
        newInput = ruleApply(new String(newInput), order - 1, rules).toCharArray();
        return new String(newInput);
    }
    public static void main(String[] args) throws Exception{
        HashMap<String,Character> rules = create();
        String counter = ruleApply(base,40,rules);
        for(Character letter : counter.toCharArray()){
            countMap.replace(letter,countMap.get(letter) + 1);
        }
        //System.out.println(countMap);
        System.out.println(Collections.max(countMap.values()) - Collections.min(countMap.values()));
    }
}
