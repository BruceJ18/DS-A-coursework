package DSA.datastructures.tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {
    private class Node {
        private char letter;
        private HashMap<Character, Node> letterStorage = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char letter) {
            this.letter = letter;
        }

        @Override
        public String toString() {
            return "value=" + letter;
        }

        public boolean hasLetter(char letter) {
            return letterStorage.containsKey(letter);
        }

        public void addLetterNode(char letter) {
            letterStorage.put(letter, new Node(letter));
        }

        public void removeLetterNode(char letter) {
            letterStorage.remove(letter);
        }

        public Node[] getLetterNodes() {
            return letterStorage.values().toArray(new Node[0]);
        }

        public Node getSubLetterNode(char letter) {
            return letterStorage.get(letter);
        }

        public boolean hasSubLetterNodes() {
            return !letterStorage.isEmpty();
        }
    }

    private Node root = new Node(' ');

    public void insert(String word) {
        var current = root;
        for (char letter: word.toCharArray()) {
            if (!current.hasLetter(letter))
                current.addLetterNode(letter);
            current = current.getSubLetterNode(letter);
        }
        current.isEndOfWord = true;
    }

    public boolean contains(String word) {
        if (word == null)
            return false;

        var current = root;
        for (char letter: word.toCharArray()) {
            if (!current.hasLetter(letter))
                return false;
            current = current.getSubLetterNode(letter);
        }
        return current.isEndOfWord;
    }

    public void traverse() {
        traverse(root);
    }


    private void traverse(Node root) {
        System.out.println(root.letter);

        for (var letterNode: root.getLetterNodes())
            traverse(letterNode);
    }

    public void remove(String word) {
        if (word == null) return;
        remove(word, root, 0);
    }

    private void remove(String word, Node root, int index) {
        if (index == word.length()) {
            root.isEndOfWord = false;
            return;
        }

        var letter = word.charAt(index);
        var letterNode = root.getSubLetterNode(letter);
        if (letterNode == null)
            return;

        remove(word, letterNode, index + 1);

        if (!letterNode.hasSubLetterNodes() && !letterNode.isEndOfWord)
            letterNode.removeLetterNode(letter);
    }

    public List<String> findWords(String prefix) {
        List<String> autocompleteList = new ArrayList<>();
        var lastLetterNode = findLastNodeOf(prefix);
        findWords(lastLetterNode, prefix, autocompleteList);
        return autocompleteList;
    }

    private void findWords(Node root, String prefix, List<String> autocompleteList) {
        if (root == null) return;

        if (root.isEndOfWord)
            autocompleteList.add(prefix);

        for (var letterNode : root.getLetterNodes())
            findWords(letterNode, prefix + letterNode.letter, autocompleteList);
    }

    private Node findLastNodeOf(String prefix) {
        if (prefix == null) return null;

        var current = root;
        for (var letter: prefix.toCharArray()) {
            var letterNode = current.getSubLetterNode(letter);
            if (letterNode == null) return null;
            current = letterNode;
        }
        return current;
    }





}
