package Daily.Nov2023;

import java.util.ArrayDeque;
import java.util.Queue;

public class 填充每个节点的下一个右侧节点指针II117 {
    public Node connect(Node root) {
        if(root==null)return null;
        //节点队列
        Queue<Node> queue=new ArrayDeque<Node>();
        queue.offer(root);
        //遍历队列，同时存储左右孩子节点
        while(!queue.isEmpty()){
            int n=queue.size();
            //当前层次的末尾
            Node last=null;
            for (int i = 1; i <= n; i++) {
                Node t=queue.poll();
                if(t.left!=null)
                    queue.offer(t.left);
                if(t.right!=null)
                    queue.offer(t.right);
                //两两节点之间建立层次间联系
                if(i!=1)
                    last.next=t;
                //遍历链表，给后面建立联系
                last=t;
            }
        }
        return root;
    }
}
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