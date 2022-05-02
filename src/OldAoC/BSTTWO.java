public class BSTTWO {
    static Node head;
    static class Node{
        Node left = null;
        Node right = null;
        int data;

        public Node(int data){
            this.data = data;

        }
    }

    public static Node addNode(Node ptr, int data){
        if(ptr == null){
            return new Node(data);
        }
        if(data < ptr.data){
            ptr.left = addNode(ptr.left, data);
        }
        else{
            ptr.right = addNode(ptr.right, data);
        }
        return ptr;
    }

    public static boolean search(Node ptr, int data){
        boolean found = false;
        if(ptr == null) return false;
        if(ptr.data == data) return true;
        if(data > ptr.data) found = search(ptr.right, data);
        else if(data < ptr.data) found = search(ptr.left, data);

        return found;
    }

    public static Node delete(Node ptr, int data){
        if(ptr == null) return ptr;

        if(data < ptr.data)  ptr.left = delete(ptr.left, data);
        else if(data > ptr.data)  ptr.right = delete(ptr.right, data);
        else{
            if(ptr.left == null) return ptr.right;
            else if(ptr.right == null) return ptr.left;

            ptr.data = inOrder(ptr.right);
            ptr.right = delete(ptr.right, ptr.data);
        }
        return ptr;
    }

    public static int inOrder(Node ptr){
        int minimum = ptr.data;
        while(ptr.left != null){
            minimum = ptr.left.data;
            ptr = ptr.left;
        }
        return minimum;
    }

    public static void print(Node ptr){
        if(ptr == null) return;
        System.out.print("(");
        print(ptr.left);
        System.out.print(ptr.data);
        print(ptr.right);
        System.out.print(")");
    }

    public static void main(String[] args) {
        while(true){
            char command = StdIn.readString().charAt(0);
            if(command != 'p') {
                int num = Integer.parseInt(StdIn.readString());
                if(command == 'i'){
                    if(search(head,num)) System.out.println("not inserted");
                    else{
                        head = addNode(head, num);
                        System.out.println("inserted");
                    }
                }
                if(command == 's'){
                    if(search(head, num)){
                        System.out.println("present");
                    } else System.out.println("absent");
                }
                if(command == 'd'){
                    if(search(head,num)){
                        head = delete(head, num);
                        System.out.println("deleted");
                    }
                    else System.out.println("absent");
                }
            }
            if(command == 'p') {
                if(head == null) System.out.println("()");
                else {
                    print(head);
                    System.out.println();
                }
            }
        }
    }
}
