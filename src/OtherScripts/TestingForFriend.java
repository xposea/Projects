package OtherScripts;

public class TestingForFriend {
    public static void main(String[] args) {
        StdOut.println("Paste input to be revised: ");
        String[] lines = StdIn.readAllLines();
        for(String line : lines){
            StdOut.println(line.replaceAll("[;:,.()]", ""));
        }
    }
}
