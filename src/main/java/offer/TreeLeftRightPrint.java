package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 请实现一个函数按照之字形顺序打印二叉树.
 即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印。
 其他行以此类推。
 */

public class TreeLeftRightPrint {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();

            // Stack<Integer> stack = new Stack<>();
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                // stack.add(node.val);
                list.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            // while(!stack.isEmpty()){
            //     list.add(stack.pop());
            // }
            List<Integer> list1 = new ArrayList<>();

            if(level%2 != 0){
                for(int i=list.size()-1;i>=0;i--){
                    list1.add(list.get(i));
                }
                result.add(list1);
            }else{
                result.add(list);
            }
            System.out.println(list1);
            result.add(list1);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}