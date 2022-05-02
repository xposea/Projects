import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Advent10 {
    public static void main(String[] args) throws Exception{
        File file = new File("C:\\Users\\Dylan\\IdeaProjects\\NOINT\\src\\day10.txt");
        Scanner sc = new Scanner(file);
        int points = 0;
        ArrayList<Long> middle = new ArrayList<>();
        boolean corrupt = false;
        long incomplete = 0;
        while(sc.hasNextLine()){
            Stack<Character> balance = new Stack<>();
            String line = sc.nextLine();
            char[] input = line.toCharArray();
            for(int i = 0; i < input.length; i++){
                if(input[i] == '(' || input[i] == '[' || input[i] == '{' || input[i] == '<'){
                    balance.push(input[i]);
                }
                else if((input[i] == ')' && balance.peek() == '(') || (input[i] == ']' && balance.peek() == '[')  || (input[i] == '}' && balance.peek() == '{')  || (input[i] == '>' && balance.peek() == '<')){
                    balance.pop();
                }
                else{
                    if(input[i] == ')'){
                        points += 3;
                        corrupt = true;
                        break;
                    }
                    else if(input[i] == ']'){
                        points += 57;
                        corrupt = true;
                        break;
                    }
                    else if(input[i] == '}'){
                        points += 1197;
                        corrupt = true;
                        break;
                    }
                    else if(input[i] == '>'){
                        points += 25137;
                        corrupt = true;
                        break;
                    }
                }
            }
            if(corrupt == false) {
                while (!balance.empty()) {
                    System.out.println(balance);
                    if (balance.peek() == '(') {
                        incomplete *= 5;
                        incomplete += 1;
                        balance.pop();
                    } else if (balance.peek() == '[') {
                        incomplete *= 5;
                        incomplete += 2;
                        balance.pop();
                    } else if (balance.peek() == '{') {
                        incomplete *= 5;
                        incomplete += 3;
                        balance.pop();
                    } else if (balance.peek() == '<') {
                        incomplete *= 5;
                        incomplete += 4;
                        balance.pop();
                    }
                }
                middle.add(incomplete);
            }
            incomplete = 0;
            corrupt = false;
        }
        Collections.sort(middle);
        System.out.println(middle);
        System.out.println(middle.get((middle.size())/2));
    }
}
