import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Advent13 {
    static ArrayList<String> foldInstructions = new ArrayList<>();
    static int maxX = 1311;
    static int maxY = 895;
    public static ArrayList<ArrayList<Integer>> create() throws Exception {
        File file = new File("C:\\Users\\Dylan\\IdeaProjects\\NOINT\\src\\day13.txt");
        Scanner sc = new Scanner(file);
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            if(line.contains(",")) {
                String[] insert = line.split(",");
                ArrayList<Integer> inserter = new ArrayList<>();
                inserter.add(Integer.parseInt(insert[0])); inserter.add(Integer.parseInt(insert[1]));
                input.add(inserter);
            }
            else if(!line.equals("")) foldInstructions.add(line);
        }
        return input;
    }

    public static void print(char[][] paper){
        for(int i = 0; i < maxY; i++){
            for(int j = 0; j < maxX; j++){
                System.out.print(paper[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static char[][] foldX(char[][] paper, int axis){
        char[][] foldedPaper = new char[maxY][axis];
        for(int i = 0; i < maxY; i++){
            for(int j = 0; j < axis; j++){
                if(paper[i][maxX - j - 1] == '#' || paper[i][j] == '#' ) foldedPaper[i][j] = '#';
            }
        }
        maxX = axis;
        return foldedPaper;
    }

    public static char[][] foldY(char[][] paper, int axis){
        char[][] foldedPaper = new char[axis][maxX];
        for(int i = 0; i < axis; i++){
            for(int j = 0; j < maxX; j++){
                if(paper[maxY - i - 1][j] == '#' || paper[i][j] == '#') foldedPaper[i][j] = '#';
            }
        }
        maxY = axis;
        return foldedPaper;
    }

    public static void main(String[] args) throws Exception{
        ArrayList<ArrayList<Integer>> input = create();
        char[][] paper = new char[maxY][maxX];
        for(int i = 0; i < maxY; i++){
            for(int j = 0; j < maxX; j++){
                ArrayList<Integer> test = new ArrayList<>();
                test.add(j); test.add(i);
                if(input.contains(test)){
                    paper[i][j] = '#';
                }
                else paper[i][j] = '*';
            }
        }

        //print(paper);
        System.out.println();
        //String instructions = foldInstructions.get(0);
        //System.out.println(instructions);
        for(String instructions : foldInstructions){
            if(instructions.contains("x")) paper = foldX(paper,Integer.parseInt(instructions.replaceAll("[^\\d]","")));
            else if(instructions.contains("y")) paper = foldY(paper,Integer.parseInt(instructions.replaceAll("[^\\d]","")));
        }
        int sum = 0;
        for(int i = 0; i < maxY; i++) {
            for (int j = 0; j < maxX; j++) {
                if(paper[i][j] == 1) sum++;
            }
        }
        print(paper);
        System.out.println(sum);
    }
}
