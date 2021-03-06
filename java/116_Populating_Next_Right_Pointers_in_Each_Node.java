/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        return connect2(root);
    }

    public Node connect1(Node root) {
        if(root==null) return root;
        if(root.left!=null && root.right!=null){
            root.left.next=root.right;
        }
        if(root.left!=null && root.right==null){
            root.left.next=getNext(root.next);
        }
        if(root.right!=null)
            root.right.next=getNext(root.next);
        connect(root.right);
        connect(root.left);
        return root;
    }

    public Node getNext(Node root){
        if(root==null) return null;
        if(root.left!=null) return root.left;
        if(root.right!=null) return root.right;
        if(root.next!=null) return getNext(root.next);
        return null;
    }

    public Node connect2(Node root) {
        if(root==null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                Node curNode = queue.poll();
                if(i < size-1){
                    curNode.next = queue.peek();
                }
                if(curNode.left != null) queue.add(curNode.left);
                if(curNode.right != null) queue.add(curNode.right);
            }
        }
        return root;
    }

}