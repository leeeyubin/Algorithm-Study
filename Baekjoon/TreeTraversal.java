import java.util.*;
class Node{
    char data;
    Node left, right;
    public Node(char data){
        this.data = data;
    }
}
class Tree{
    Node root;
    public void Add(char data, char leftData, char rightData){
        if(root == null){
            if(data != '.')
                root = new Node(data);
            if(leftData != '.')
                root.left = new Node(leftData);
            if(rightData  != '.')
                root.right = new Node(rightData);
        }
        else
            Search(root, data, leftData, rightData);
    }
    public void Search(Node root, char data, char leftData, char rightData){
        if(root == null)
            return;
        else if(root.data == data){
            if(leftData != '.')
                root.left = new Node(leftData);
            if(rightData != '.')
                root.right = new Node(rightData);
        }
        else {
            Search(root.left, data, leftData, rightData);
            Search(root.right, data, leftData, rightData);
        }
    }
    public void preOrder(Node root){
        System.out.print(root.data);
        if(root.left != null)
            preOrder(root.left);
        if(root.right != null)
            preOrder(root.right);
    }
    public void inOrder(Node root){
        if(root.left != null)
            inOrder(root.left);
        System.out.print(root.data);
        if(root.right != null)
            inOrder(root.right);
    }
    public void postOrder(Node root){
        if(root.left != null)
            postOrder(root.left);
        if(root.right != null)
            postOrder(root.right);
        System.out.print(root.data);
    }
}
public class TreeTraversal {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int n = scanner.nextInt();

       Tree tree = new Tree();
       for(int i = 0; i< n; i++){
           tree.Add(scanner.next().charAt(0), scanner.next().charAt(0), scanner.next().charAt(0));
       }
       tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);

        scanner.close();
    }
}
