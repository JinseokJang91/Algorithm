package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class Tree_1991 {
    static Node startNode;
    static StringBuilder result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 전위 순회 : 루트(부모) - 왼쪽 자식 - 오른쪽 자식
        // 중위 순회 : 왼쪽 자식 - 루트(부모) - 오른쪽 자식
        // 후위 순회 : 왼쪽 자식 - 오른쪽 자식 - 루트(부모)
        result = new StringBuilder();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String root = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            if("A".equals(root)) {
                startNode = new Node(root, null, null);
            }
            makeTree(startNode, root, left, right);
        }

        preOrder(startNode);    // 전위순회
        result.append("\n");
        inOrder(startNode);     // 중위순회
        result.append("\n");
        postOrder(startNode);   // 후위순회

        bw.write(result.toString());

        br.close();
        bw.close();
    }

    private static void makeTree(Node node, String root, String left, String right) {
//        System.out.println("node = " + node);
//        System.out.println("root = " + root);
//        System.out.println("left = " + left);
//        System.out.println("right = " + right);
        // 입력된 root 값이
        if(root.equals(node.rootName)) {
            node.leftNode = ".".equals(left) ? null : new Node(left, null, null);
            node.rightNode = ".".equals(right) ? null : new Node(right, null, null);
        } else {
            if(node.leftNode != null) {
                makeTree(node.leftNode, root, left, right);
            }

            if(node.rightNode != null) {
                makeTree(node.rightNode, root, left, right);
            }
        }
    }

    private static void preOrder(Node node) {
        if(node == null) {
            return; // 방문한 노드가 null 이면 종료
        }
        // 루트 > 왼쪽 자식 > 오른쪽 자식
        result.append(node.rootName);
        preOrder(node.leftNode);
        preOrder(node.rightNode);
    }

    private static void inOrder(Node node) {
        if(node == null) {
            return; // 방문한 노드가 null 이면 종료
        }

        inOrder(node.leftNode);
        result.append(node.rootName);
        inOrder(node.rightNode);
    }

    private static void postOrder(Node node) {
        if(node == null) {
            return; // 방문한 노드가 null 이면 종료
        }

        postOrder(node.leftNode);
        postOrder(node.rightNode);
        result.append(node.rootName);
    }

    static class Node {
        private String rootName;
        private Node leftNode;
        private Node rightNode;

        public Node(String rootName, Node leftNode, Node rightNode) {
            this.rootName = rootName;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "rootName='" + rootName + '\'' +
                    ", leftNode=" + leftNode +
                    ", rightNode=" + rightNode +
                    '}';
        }
    }
}
