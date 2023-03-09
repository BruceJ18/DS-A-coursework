package DSA.datastructures.graph;

import java.util.*;

public class AdjacencyListGraph {
    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private Map<String, Node> mainChain = new HashMap<>();
    private Map<Node, List<Node>> sideChain = new HashMap<>();


    public void addNode(String label) {
        var node = new Node(label);
        mainChain.putIfAbsent(label, node);
        sideChain.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String fromLabel, String toLabel) {
        var fromNode = mainChain.get(fromLabel);
        var toNode = mainChain.get(toLabel);
        if (fromNode == null || toNode == null) {
            throw new IllegalArgumentException();
        }
        sideChain.get(fromNode).add(toNode);
    }

    public void print() {
        for (var vertex : sideChain.keySet()) {
            var adjacentVertices = sideChain.get(vertex);
            if (!adjacentVertices.isEmpty())
                System.out.println(vertex + " is connected to " + adjacentVertices);
        }
    }

    public void removeNode(String label) {
        var node = mainChain.get(label);
        if (node == null)
            return;

        for (var vertex : sideChain.keySet())
            sideChain.get(vertex).remove(node);

        sideChain.remove(node);
        mainChain.remove(label);
    }

    public void removeEdge(String fromLabel, String toLabel) {
        var fromNode = mainChain.get(fromLabel);
        var toNode = mainChain.get(toLabel);
        if (fromNode == null || toNode == null) return;

        sideChain.get(fromNode).remove(toNode);
    }


//    recursive depth first search
    public void traverseDepthFirst(String label) {
        var node = mainChain.get(label);
        if (node == null)
            return;

        traverseDepthFirst(mainChain.get(label), new HashSet<>());
    }

    private void traverseDepthFirst(Node currentNode, Set<Node> visited) {
        System.out.println();
        visited.add(currentNode);

        for (var adjacentNode : sideChain.get(currentNode)) {
            if (!visited.contains(adjacentNode))
                traverseDepthFirst(adjacentNode, visited);
        }
    }

    public void DepthFirst(String label) {
        var root = mainChain.get(label);
        if (root == null)
            return;

        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            var currentNode = stack.pop();

            if (visited.contains(currentNode))
                continue;

            System.out.println(currentNode);
            visited.add(currentNode);

            for (var adjacentNode : sideChain.get(currentNode)) {
                if (!visited.contains(adjacentNode))
                    stack.push(adjacentNode);
            }
        }
    }

    public void breathFirst(String label) {
        var root = mainChain.get(label);
        if (root == null)
            return;

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            var current = queue.remove();

            if (visited.contains(current))
                continue;

            System.out.println(current);
            visited.add(current);

            for (var adjacenctNode : sideChain.get(current)) {
                if (!visited.contains(adjacenctNode))
                    queue.add(adjacenctNode);
            }
        }
    }










}
