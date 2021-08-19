package com.yu.ysblog.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

/**
 * @Author yu
 * @DateTime 2021/8/19 20:26
 */
public class T1 {

    static class Node implements Comparable<Node> {
        String name;
        TreeSet<Node> child;
        int height;

        public Node(String name, TreeSet<Node> child, int height) {
            this.name = name;
            this.child = child;
            this.height = height;
        }

        public Node(String name, int height) {
            this.name = name;
            this.child = new TreeSet<>();
            this.height = height;
        }

        @Override
        public int compareTo(Node o) {
            return this.name.compareTo(o.name);
        }


        @Override
        public int hashCode() {
            return Objects.hash(name, child);
        }
    }

    public static void main(String[] args) {
        List<String> paths = Arrays.asList(
                "opt/data/a",
                "opt/sys/b",
                "Tmp/test/oozz",
                "Tmp/test/ooZZ",
                "ABC");

        // 创建根来保存数据
        TreeSet<Node> rootChild = new TreeSet<>();
        Node root = new Node("gen", rootChild, 0);
        for (String path : paths) {
            if (!path.contains("/")) {
                Node child = getChild(root, path);
                if (child == null) {
                    rootChild.add(new Node(path, 0));
                }
            }
            String[] split = path.split("/");
            String name = split[0];
            Node child = getChild(root, name);
            if (child == null) {
                Node currentNode = new Node(name, 0);
                buildTree(currentNode, split, 0);
                rootChild.add(currentNode);
            } else {
                buildTree(child, split, 0);
            }
        }
        printRes(root);
    }

    private static void printRes(Node node) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < node.height; i++) {
            stringBuilder.append("  ");
        }
        if (!node.name.equals("gen")) {
            System.out.println(stringBuilder.toString() + node.name);
        }
        TreeSet<Node> child = node.child;
        for (Node n : child) {
            printRes(n);
        }
    }

    private static void buildTree(Node currentNode, String[] names, int index) {
        if (index >= names.length - 1) {
            return;
        }
        TreeSet<Node> child = currentNode.child;
        String currName = names[index + 1];
        Node child1 = getChild(currentNode, currName);
        if (child1 == null) {
            Node node = new Node(currName, index + 1);
            child.add(node);
            buildTree(node, names, index + 1);
        } else {
            buildTree(child1, names, index + 1);
        }
    }

    private static Node getChild(Node node, String name) {
        TreeSet<Node> child = node.child;
        for (Node n : child) {
            if (n.name.equals(name)) {
                return n;
            }
        }
        return null;
    }
}
