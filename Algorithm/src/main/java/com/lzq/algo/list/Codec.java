package com.lzq.algo.list;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lin
 * @date 2023/09/04
 */
public class Codec {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        b.left = a;
        b.right = c;
        Codec codec = new Codec();
        System.out.println(codec.serialize(b));
    }

    public String serialize(TreeNode root) {
        if (root == null){
            return null;
        }
        List<String> res = new ArrayList<String>();
        String left = serialize(root.left);
        res.add(left);
        String right = serialize(root.right);
        res.add(right);
        return res.toString();
    }



// Decodes your encoded data to tree.

    public TreeNode deserialize(String data) {

        return new TreeNode(1);

    }

}



// Your Codec object will be instantiated and called as such:

// Codec ser = new Codec();

// Codec deser = new Codec();

// String tree = ser.serialize(root);

// TreeNode ans = deser.deserialize(tree);

// return ans;
