package LaiOffer.Class4_BinaryTree_BinarySearchTree;

/**
 * Binary Tree Question 4:
 * Let's assume if we tweak the L child with R child of an arbitrary node in a binary tree,
 * then the "structure" of the tree are not changed.
 * Then how can we determine whether two binary trees' structures are identical.
 */
public class BinaryTree_TweakIdentical {

    /**
     * Solution:
     * If two binary trees are tweak identical, then they are same or symmetric.
     * Check both situations, if one is true then they are tweak identical.
     *
     * Since the last step is like checking
     * return
     * (isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right))
     * || // Identical or Symmetric
     * (isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left))
     *
     * if tree is balanced:
     * Time Complexity = O(4^log2n) = O(2^2log2n) = O(2^log2(n^2)) = O(n^2)
     * Space Complexity = O(log n)
     *
     * if tree is not balanced (like a linked list):
     * Time Complexity = O(n)
     * Space Complexity = O(n)
     */

}
