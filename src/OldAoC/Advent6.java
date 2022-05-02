import java.io.File;
import java.util.Scanner;

public class Advent6 {
    public static long[] create() throws Exception{
        File file = new File("C:\\Users\\Dylan\\IdeaProjects\\NOINT\\src\\day6.txt");
        Scanner sc = new Scanner(file);
        String line = sc.nextLine().replaceAll(","," ");
        sc.close();
        Scanner b = new Scanner(line);
        long[] gens= new long[9];
        for(int i = 0; i < 9; i++){
            gens[i] = 0;
        }
        while(b.hasNextInt()){
            int age = b.nextInt();
            if(age == 1){
                gens[0] += 1;
            }
            if(age == 2){
                gens[1] += 1;
            }
            if(age == 3){
                gens[2] += 1;
            }
            if(age == 4){
                gens[3] += 1;
            }
            if(age == 5){
                gens[4] += 1;
            }
        }
        b.close();
        return gens;
    }

    public static void addDay(long[] gens){
        long temp;
        temp = gens[0];
        for(int i = 1; i < 9; i++){
            gens[i-1] = gens[i];
        }
        gens[8] = temp;
        gens[6] += temp;
    }

    public static void main(String[] args) throws Exception{
        long[] gens= create();
        for(int i = 0; i < 256; i++){
            addDay(gens);
            System.out.println(i);
        }
        long sum = 0;
        for(int i = 0; i < 8; i++){
            sum += gens[i];
        }
        System.out.println(sum);
    }
}

/*import java.io.File;
        import java.util.LinkedList;
        import java.util.Scanner;

public class Advent6 {
    public static LinkedList<Integer> create() throws Exception{
        File file = new File("C:\\Users\\Dylan\\IdeaProjects\\NOINT\\src\\day6.txt");
        Scanner sc = new Scanner(file);
        LinkedList<Integer> fish= new LinkedList<>();
        String line = sc.nextLine().replaceAll(","," ");
        sc.close();
        Scanner b = new Scanner(line);
        while(b.hasNextInt()){
            fish.add(b.nextInt());
        }
        b.close();
        return fish;
    }

    public static LinkedList<Integer> addDay(LinkedList<Integer> fish){
        long birth = 0;
        long fishInitial = fish.size();
        for(int i = 0; i < fishInitial; i++){
            if(fish.get(i) == 0){
                fish.set(i, 6);
                birth += 1;
            }
            else{
                fish.set(i, fish.get(i)-1);
            }
        }
        for(int i = 0; i < birth; i++){
            fish.addLast(8);
        }
        return fish;
    }

    public static void main(String[] args) throws Exception{
        LinkedList<Integer> fish = create();
        for(int i = 0; i < 256; i++){
            fish = addDay(fish);
            System.out.println(i);
        }
        System.out.println(fish.size());
    }
}

close*/