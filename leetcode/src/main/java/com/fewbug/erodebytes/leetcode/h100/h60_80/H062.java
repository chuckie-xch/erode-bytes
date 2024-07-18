package com.fewbug.erodebytes.leetcode.h100.h60_80;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/17 21:56
 **/
public class H062 {

    public class Trie {

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null || word.length() == 0) {
                return;
            }
            TrieNode tail = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if (tail.tns[index] == null) {
                    tail.tns[index] = new TrieNode();
                }
                tail = tail.tns[index];
            }
            tail.end = true;
        }

        public boolean search(String word) {
            if (word == null || word.length() == 0) {
                return true;
            }
            TrieNode tail = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if (tail.tns[index] == null) {
                    return false;
                }
                tail = tail.tns[index];
            }
            return tail.end;
        }

        public boolean startsWith(String prefix) {
            if (prefix == null || prefix.length() == 0) {
                return true;
            }
            TrieNode tail = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                int index = c - 'a';
                if (tail.tns[index] == null) {
                    return false;
                }
                tail = tail.tns[index];
            }
            return true;
        }
    }

    public class TrieNode {
        boolean end;
        TrieNode[] tns = new TrieNode[26];
    }
}
