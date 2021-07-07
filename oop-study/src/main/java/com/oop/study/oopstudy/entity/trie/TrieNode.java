package com.oop.study.oopstudy.entity.trie;

import java.util.Stack;

public class TrieNode {
    private TrieNode[] childes;
    private char data;
    private boolean isLast;

    public TrieNode(char data) {
        this.childes = new TrieNode[26];
        this.data = data;
        this.isLast = false;
    }

    public void addChildes(String word, int i) {
        if (word.length() <= i) {
            this.isLast = true;
            return;
        }

        char target = word.charAt(i++);
        int curIndex = target - 'a';

        if (this.childes[curIndex] != null) {
            this.childes[curIndex].addChildes(word, i);
            return;
        }

        TrieNode node = new TrieNode(target);
        this.childes[curIndex] = node;
        node.addChildes(word, i);
    }

    public void searchDepthFirst() {
        Stack<TrieNode> stack = new Stack<>();
        stack.push(this);

        while (!stack.isEmpty()) {
            TrieNode next = stack.pop();
            System.out.println("Data: " + next.data);
            System.out.println("Is Last?: " + next.isLast);

            for (TrieNode tmp : next.childes) {
                stack.push(tmp);
            }
        }
    }
}
