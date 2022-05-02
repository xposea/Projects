import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Advent8 {
    public static ArrayList<String[]> input = new ArrayList<>();
    public static ArrayList<ArrayList> output = new ArrayList<>();
    public static int total = 0;
    public static void create() throws Exception {
        File file = new File("C:\\Users\\Dylan\\IdeaProjects\\NOINT\\src\\day8.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String[] inputs = new String[10];
            for (int i = 0; i < 10; i++) {
                inputs[i] = sc.next();
            }
            sc.next();
            for (int i = 0; i < 4; i++) {
                ArrayList<Character> outputs = new ArrayList<>();
                String temp = sc.next();
                for(int j = 0; j < temp.length(); j++){
                    outputs.add(temp.charAt(j));
                }
                output.add(outputs);
            }
            input.add(inputs);
        }
    }

    public static char brute(int current){
        ArrayList<Character> temp1 = new ArrayList<>();
        ArrayList<Character> temp2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Character> letters = new ArrayList<>();
            if (input.get(current)[i].length() == 2) {
                for (int j = 0; j < input.get(current)[i].length(); j++) {
                    letters.add(input.get(current)[i].charAt(j));
                }
                temp1 = letters;
            }
            else if (input.get(current)[i].length() == 3) {
                for (int j = 0; j < input.get(current)[i].length(); j++) {
                    letters.add(input.get(current)[i].charAt(j));
                }
                temp2 = letters;
            }
        }
        for (int i = 0; i < temp2.size(); i++) {
            if (!temp1.contains(temp2.get(i))) {
                return temp2.get(i);
            }
        }
        return 'z';
    }

    public static void brute2(int current, char temp,char[] official){
        ArrayList<Character> tester = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (input.get(current)[i].length() == 4) {
                for (int j = 0; j < input.get(current)[i].length(); j++) {
                    tester.add(input.get(current)[i].charAt(j));
                }
            }
        }
        boolean dIsPresent = false;
        for(int i = 0; i < tester.size(); i++){
            if(tester.contains(temp)){
                official[3] = temp;
                dIsPresent = true;
            }
        }
        if(dIsPresent == false){
            official[6] = temp;
        }
    }
    public static char[] count(int current){
        int[] letters = new int[7];
        char[] official = new char[7];
        char[] temp = new char[7];
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < input.get(current)[i].length(); j++) {
                if(input.get(current)[i].charAt(j) == 'a'){
                    letters[0] += 1;
                    temp[0] = input.get(current)[i].charAt(j);
                }
                else if(input.get(current)[i].charAt(j) == 'b'){
                    letters[1] += 1;
                    temp[1] = input.get(current)[i].charAt(j);
                }
                else if(input.get(current)[i].charAt(j) == 'c'){
                    letters[2] += 1;
                    temp[2] = input.get(current)[i].charAt(j);
                }
                else if(input.get(current)[i].charAt(j) == 'd'){
                    letters[3] += 1;
                    temp[3] = input.get(current)[i].charAt(j);
                }
                else if(input.get(current)[i].charAt(j) == 'e'){
                    letters[4] += 1;
                    temp[4] = input.get(current)[i].charAt(j);
                }
                else if(input.get(current)[i].charAt(j) == 'f'){
                    letters[5] += 1;
                    temp[5] = input.get(current)[i].charAt(j);
                }
                else if(input.get(current)[i].charAt(j) == 'g'){
                    letters[6] += 1;
                    temp[6] = input.get(current)[i].charAt(j);
                }
            }
        }
        for(int i = 0; i < 7; i++){
            official[0] = brute(current);
            if(letters[i] == 4){
                official[4] = temp[i];
            }
            if(letters[i] == 6){
                official[1] = temp[i];
            }
            if(letters[i] == 9){
                official[5] = temp[i];
            }
            if(letters[i] == 8 && temp[i] != official[0]){
                official[2] = temp[i];
            }
            if(letters[i] == 7) {
                brute2(current, temp[i], official);
            }
        }
        for(int i = 0; i < 7; i++){
            System.out.println(official[i]);
        }
        return official;
    }

    public static ArrayList[] setNum(char[] official){
        ArrayList[] nums = new ArrayList[10];
        int count = 0;
        for(int i = 0; i < 10; i++){
            ArrayList<Character> chars= new ArrayList<>();
            if(i == 0){
                chars.add(official[0]); chars.add(official[1]); chars.add(official[2]); chars.add(official[4]); chars.add(official[5]); chars.add(official[6]);
            }
            else if(i == 1){
                chars.add(official[2]); chars.add(official[5]);
            }
            else if(i == 2){
                chars.add(official[0]); chars.add(official[2]); chars.add(official[3]); chars.add(official[4]); chars.add(official[6]);
            }
            else if(i == 3){
                chars.add(official[0]); chars.add(official[2]); chars.add(official[3]); chars.add(official[5]); chars.add(official[6]);
            }
            else if(i == 4){
                chars.add(official[1]); chars.add(official[2]); chars.add(official[3]); chars.add(official[5]);
            }
            else if(i == 5){
                chars.add(official[0]); chars.add(official[1]); chars.add(official[3]); chars.add(official[5]); chars.add(official[6]);
            }
            else if(i == 6){
                chars.add(official[0]); chars.add(official[1]); chars.add(official[3]); chars.add(official[4]); chars.add(official[5]); chars.add(official[6]);
            }
            else if(i == 7){
                chars.add(official[2]); chars.add(official[5]); chars.add(official[0]);
            }
            else if(i == 8){
                for(int j = 0; j < 7; j++){
                    chars.add(official[j]);
                }
            }
            else if(i == 9){
                chars.add(official[0]); chars.add(official[1]); chars.add(official[2]); chars.add(official[3]); chars.add(official[5]); chars.add(official[6]);
            }
            nums[count] = chars;
            count++;
        }
        return nums;
    }

    public static void decode(ArrayList[] nums, int current){
        for(int i = current*4; i < current*4 + 4; i++){
            int count = 0;
            int smallsum = 0;
            for(int j = 0; j < 4; j++) {
                ArrayList<Character> temp = output.get(i);
                if(temp.size() == 2){
                    smallsum += Math.pow(10,3-j) * 1;
                }
                else if(temp.size() == 5 && temp.containsAll(nums[2])){
                    smallsum += Math.pow(10,3-j) * 2;
                }
                else if(temp.size() == 5 && temp.containsAll(nums[3])){
                    smallsum += Math.pow(10,3-j) * 3;
                }
                else if(temp.size() == 4){
                    smallsum += Math.pow(10,3-j) * 4;
                }
                else if(temp.size() == 5 && temp.containsAll(nums[5])){
                    smallsum += Math.pow(10,3-j) *5;
                }
                else if(temp.size() == 6 && temp.containsAll(nums[6])){
                    smallsum += Math.pow(10,3-j) * 6;
                }
                else if(temp.size() == 3){
                    smallsum += Math.pow(10,3-j) * 7;
                }
                else if(temp.size() == 7 && temp.containsAll(nums[8])){
                    smallsum += Math.pow(10,3-j) * 8;
                }
                else if(temp.size() == 6 && temp.containsAll(nums[9])){
                    smallsum += Math.pow(10,3-j) * 9;
                }
                System.out.println(smallsum);
                i++;
            }
            total += smallsum;
        }
        System.out.println(total);
    }

    public static void main(String[] args) throws Exception{
        create();
        for(int i = 0; i < output.size()/4; i++) {
            char[] official = count(i);
            ArrayList[] nums = setNum(official);
            decode(nums, i);
        }
    }
}