package com.williamtrindade.LC1123LowestCommonAncestorOfDeepestLeaves;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    // Variáveis de estado para rastrear a resposta durante a recursão
    int maxDepth = 0;
    TreeNode lca = null;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return lca;
    }

    private int dfs(TreeNode node, int currentDepth) {
        // Se bater no fundo, retorna a profundidade atual
        if (node == null) {
            return currentDepth;
        }

        // 1. Desce explorando os dois lados até o talo
        int leftDepth = dfs(node.left, currentDepth + 1);
        int rightDepth = dfs(node.right, currentDepth + 1);

        // 2. O coração da lógica:
        // Se as duas ramificações empataram E atingiram uma profundidade inédita
        if (leftDepth == rightDepth && leftDepth >= maxDepth) {
            maxDepth = leftDepth;
            lca = node; // Atualizamos o nosso ancestral
        }

        // 3. Retorna sempre a maior profundidade encontrada neste galho
        return Math.max(leftDepth, rightDepth);
    }
}