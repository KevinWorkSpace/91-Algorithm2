package Basic.Tree.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<TreeNode> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) list.add(node);
            else {
                queue.add(node.left);
                queue.add(node.right);
                list.add(node);
            }
        }
        StringBuffer buffer = new StringBuffer("[");
        for (int i=0; i<list.size(); i++) {
            TreeNode node = list.get(i);
            if (node != null) {
                buffer.append(node.val);
            }
            else buffer.append("null");
            if (i != list.size() - 1) {
                buffer.append(",");
            }
        }
        buffer.append("]");
        return buffer.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        String[] vals = data.substring(1, data.length()-1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            if (!vals[i+1].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i+1]));
                queue.add(node.right);
            }
            i += 2;
        }
        return root;
    }

    public static void main(String[] args) {
//        TreeNode n1 = new TreeNode(1);
//        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(3);
//        TreeNode n4 = new TreeNode(4);
//        TreeNode n5 = new TreeNode(5);
//        n1.left = n2;
//        n1.right = n3;
//        n3.left = n4;
//        n3.right = n5;
        Codec codec = new Codec();
        String s = codec.serialize(null);
        codec.deserialize(s);
    }
}
