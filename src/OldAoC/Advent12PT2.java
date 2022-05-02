import java.io.File;
import java.util.*;

public class Advent12PT2 {
    static int totalPaths = 0;
    static class Graph{
        HashMap<String, HashSet<String>> graph = new HashMap<>();
        void addEdge(String a, String b){
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
    }
    public static ArrayList<String[]> create() throws Exception {
        File file = new File("C:\\Users\\Dylan\\IdeaProjects\\NOINT\\src\\day12.txt");
        Scanner sc = new Scanner(file);
        ArrayList<String[]> input = new ArrayList<>();
        while(sc.hasNextLine()) {
            String[] insert = new String[2];
            String line = sc.nextLine().replaceAll("[-]", " ");
            Scanner b = new Scanner(line);
            for(int i = 0; i < 2; i++){
                insert[i] = b.next();
            }
            input.add(insert);
        }
        return input;
    }

    public static void print(Graph g){
        for(String string : g.graph.keySet()){
            System.out.println(string + ": " + g.graph.get(string));
        }
    }

    public static void dfs(Graph g, ArrayList<String> path, String current, String multiple, int multipleUse){
        path.add(current);
        if(current.equals(multiple)) multipleUse++;
        if(current.equals("end")) totalPaths++;
        for(String adj : g.graph.get(current)){
            if(!adj.equals("start")){
                if(Character.isUpperCase(adj.charAt(0)) || !path.contains(adj) || (adj.equals(multiple) && multipleUse < 2)){
                    dfs(g, new ArrayList<>(path), adj, multiple, multipleUse);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        Graph g = new Graph();
        ArrayList<String[]> input = create();
        for(String[] edges : input){
            if(!g.graph.containsKey(edges[0])) g.graph.put(edges[0], new HashSet<>());
            if(!g.graph.containsKey(edges[1])) g.graph.put(edges[1], new HashSet<>());
            g.addEdge(edges[0],edges[1]);
        }
        //print(g);
        totalPaths += 5874;
        for(String multiple : g.graph.keySet()){
            if(!multiple.equals("start") && !multiple.equals("end") && Character.isLowerCase(multiple.charAt(0))){
                dfs(g, new ArrayList<>(), "start", multiple, 0);
                totalPaths -= 5874;
            }
        }
        System.out.println(totalPaths);
    }
}
