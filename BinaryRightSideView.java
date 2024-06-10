import java.util.*;
class Node{
  int data;
  Node left;
  Node right;
  
  Node(int data){
    this.data=data;
    this.left=null;
    this.right=null;
  }
}

class Main
{ 
  static Node binaryTree(String s[]){
    if(s[0] == "N" || s.length == 0) return null;
    Queue<Node> q = new LinkedList<>();
    Node root = new Node(Integer.parseInt(s[0]));
    q.add(root);
    int i = 1;
    while(!q.isEmpty() && i < s.length){
      Node cur = q.poll();
      String curval = s[i];
      if(!curval.equals("N")){
        cur.left = new Node(Integer.parseInt(curval));
        q.add(cur.left);
      }
      i++;
      if(i >=s.length) break;
      curval = s[i];
      if(!curval.equals("N")){
        cur.right = new Node(Integer.parseInt(curval));
        q.add(cur.right);
      }
      i++;
    }
    return root;
  }
  static void rightView(Node root, List<Integer> L,int level){
    if(root == null) return;
    if(L.size() == level) L.add(root.data);
    if(root.right != null) rightView(root.right, L, level+1);
    if(root.left != null) rightView(root.left, L, level+1);
  }
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    String s[] = sc.nextLine().split(" ");
    Node root = binaryTree(s);
    ArrayList<Integer> L = new ArrayList<>();
    rightView(root, L, 0);
    for(int i : L){
      System.out.print(i + " ");
    }
  }
}
