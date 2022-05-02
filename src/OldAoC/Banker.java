public class Banker {
    static int bankNumber = 0;
    static BankAccount head;
    static class BankAccount{
        int balance;
        int number = 0;
        BankAccount next;
        BankAccount(int balance){
            this.balance = balance;
            number = bankNumber;
            bankNumber++;
        }
    }

    public static void addAccount(int balance){
        if(head == null) head = new BankAccount(balance);
        else{
            BankAccount ptr = head;
            while(ptr.next != null) ptr = ptr.next;
            ptr.next = new BankAccount(balance);
        }

    }

    public static BankAccount find(int number){
        if(head != null) {
            BankAccount ptr = head;
            while(ptr.next != null && ptr.number != number) ptr = ptr.next;
            if(ptr.number == number) return ptr;
            else return null;
        }
        return null;
    }

    public static void deposit(int amount, int number){
        if(find(number) != null) {
            find(number).balance += amount;
        }
    }

    public static void checkBalance(int number){
        if(find(number) != null) {
            System.out.println(find(number).balance);
        }
    }

    public static void withdraw(int amount, int number){
        if(find(number) != null) {
            find(number).balance -= amount;
        }
    }

    public static void transfer(int from, int to, int amount){
        if(find(from) != null && find(to) != null) {
            find(from).balance -= amount;
            find(to).balance += amount;
        }
    }

    public static void main(String[] args) {
        addAccount(5000);
        withdraw(300, 0);
        deposit(500,0);
        checkBalance(0);
        addAccount(3000);
        transfer(0,1,300);
        checkBalance(0);
        checkBalance(1);
    }
}
