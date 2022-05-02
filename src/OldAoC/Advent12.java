import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Advent12 {
    public static int sum = 0;
    public static ArrayList<String> count = new ArrayList<>();
    public static int smallsum = 0;
    public static ArrayList<ArrayList<Integer>> path = new ArrayList<>();
    static class Graph{
        static int verticies;
        ArrayList<ArrayList<Integer>> graph;
        static ArrayList<Boolean> big = new ArrayList<>();

        Graph(int verticies){
            this.verticies = verticies;
            graph = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < this.verticies; i++){
                graph.add(new ArrayList<Integer>());
                big.add(Character.isUpperCase(count.get(i).charAt(0)));
            }
        }

        void addEdge(int a, int b){
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        void print(){
            for(int i = 0; i < this.verticies; i++){
                System.out.print("Node " + count.get(i) + ":");
                for(int x : graph.get(i)) System.out.print(" -> " + count.get(x) + " " + big.get(x));
                System.out.println();
            }
        }
    }

    public static ArrayList<String[]> create() throws Exception { //create an ArrayList of all inputs[], removing '-'
        File file = new File("C:\\Users\\Dylan\\IdeaProjects\\NOINT\\src\\day12.txt");
        Scanner sc = new Scanner(file);
        ArrayList<String[]> input = new ArrayList<>();
        while(sc.hasNextLine()) {
            String[] insert = new String[2];
            String line = sc.nextLine().replaceAll("[-]", " ");
            Scanner b = new Scanner(line);
            for(int i = 0; i < 2; i++){
                insert[i] = b.next();
                if(!count.contains(insert[i])) count.add(insert[i]);
            }
            input.add(insert);
        }
        return input;
    }

    public static int dfs(ArrayList<ArrayList<Integer>> graph, int current, int end, int count1, ArrayList<Integer> visited, ArrayList<ArrayList<Integer>> path,int smallbig){
        count1 = 0;
        if(current == count.indexOf("start") && !visited.contains(count.indexOf("start"))){ // if current is start and hasnt been used
            visited.add(current); //add start
            for(int i = 0; i < graph.get(current).size(); i++){ //add all neighbors of start
                if(graph.get(current).get(i) == smallbig) smallsum++;
                count1 += dfs(graph,graph.get(current).get(i),end,count1,new ArrayList<>(visited), path, smallbig); //add to count for each neighbor
            }
        }
        else if(current == end){ //if current hits end, return 1 to add to count
            boolean add = false;
            for(ArrayList<Integer> temp : path) {
                if (temp.equals(visited)) {
                    add = true;
                }
            }
            if(!add){
                count1++;
                path.add(visited);
            }
            System.out.println();
        }
        else{ //if current is not end
            visited.add(current); //add self
            for(int i = 0; i < graph.get(current).size(); i++) { // for each neighbor of current
                if(graph.get(current).get(i) == smallbig && smallsum < 2){
                    smallsum++;
                    count1 += dfs(graph, graph.get(current).get(i), end, count1, new ArrayList<>(visited),path, smallbig);
                }
                else if(Graph.big.get(graph.get(current).get(i)) || !visited.contains(graph.get(current).get(i))) { //if neighbor isnt in visited or is large
                    count1 += dfs(graph, graph.get(current).get(i), end, count1, new ArrayList<>(visited),path, smallbig); //add to count based on if neighbors hit end
                }
            }
        }
        return count1;
    }

    public static void main(String[] args) throws Exception{
        ArrayList<String[]> input = create();
        Graph g = new Graph(count.size());

        for(int i = 0; i < input.size(); i++){
            g.addEdge(count.indexOf(input.get(i)[0]), count.indexOf(input.get(i)[1]));
        }

        g.print();
        int start = count.indexOf("start");
        int end = count.indexOf("end");

        System.out.println("Start: " + start + " End: " + end);
        int total = 0;
        for(int i = 0; i < g.graph.size(); i++) {
            smallsum = 0;
            if(i != end && i != start && !Graph.big.get(i)) {
                System.out.println("NEXT");
                total += (dfs(g.graph, start, end, 0, new ArrayList<Integer>(), path, i));
            }
        }
        for(ArrayList<Integer> i : path){
            for(int j = 0; j < i.size(); j++){
                System.out.print(count.get(i.get(j)) + " ");
            }
            System.out.println();
        }
        System.out.println(total);
    }
}
