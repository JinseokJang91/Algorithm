package com.study.algo.baekjoon.gold;

import java.io.*;
import java.util.*;

public class Graph_1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
        // V : 정점의 개수
        // E : 간선의 개수
        // K : 시작 정점의 번호
        // 시작 정점으로부터, 모든 다른 정점으로의 "최단 경로" 구하기 => 다익스트라 알고리즘

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        int[] dist = new int[V + 1]; // 정점(Node) 별 최단경로 수 삽입을 위한 배열
        int inf = Integer.MAX_VALUE; // 경로 미존재 CASE
        Arrays.fill(dist,inf);

        List<List<Node>> paths = new ArrayList<>(); // 정점(Node) 별 간선 및 가중치 정보 삽입을 위한 List
        for(int i = 0; i < V + 1; i++) {
            paths.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            Node node = new Node(v, w);
            paths.get(u).add(node);
        }

        dijkstra(K, dist, paths);

        for(int i = 1; i < V + 1; i++) {
            result.append(dist[i] == inf ? "INF" : dist[i]).append("\n");
        }

        bw.write(result.toString());

        br.close();
        bw.close();
    }

    private static void dijkstra(int k, int[] dist, List<List<Node>> paths) {
        System.out.println("=========== k : " + k);
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(k, 0)); // 시작 정점(Node)과 그 가중치 비용 0 초기값 추가
        dist[k] = 0; // 시작 정점(Node)의 최단 경로의 수 0 세팅 (N => N 이동 비용은 0원이기 때문)

        while(!queue.isEmpty()) {
            System.out.println(">>>>> queue : " + queue.peek().toString());
            Node node = queue.poll();
            int nodeNum = node.next;
            System.out.println("nodeNum = " + nodeNum);
            int nodeCost = node.cost;
            System.out.println("nodeCost = " + nodeCost);

            // 정점(Node)에 저장된 가중치 비용보다 계산 비용이 더 높으면 PASS (최단 경로 구하는 것이므로)
            if(dist[nodeNum] < nodeCost) {
                continue;
            }

            // 이동 가능한 정점(Node) 탐색
            for(int i = 0; i < paths.get(nodeNum).size(); i++) {
                Node nextNode = paths.get(nodeNum).get(i);
                int nextNodeNum = nextNode.next;
                System.out.println("nextNodeNum = " + nextNodeNum);
                int nextNodeCost = nextNode.cost + nodeCost;
                System.out.println("nextNodeCost = " + nextNode.cost + "+" + nodeCost);

                // 정점(Node)에 저장된 가중치 비용보다 계산 비용이 더 작으면 변경
                if(dist[nextNodeNum] > nextNodeCost) {
                    System.out.println("dist[nextNodeNum] > nextNodeCost : " + dist[nextNodeNum]  + " > " + nextNodeCost);
                    dist[nextNodeNum] = nextNodeCost;
                    queue.add(new Node(nextNodeNum, nextNodeCost));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int next; // 다음 목적지 정점(Node)
        int cost; // 가중치 비용

        public Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "next=" + next +
                    ", cost=" + cost +
                    '}';
        }
    }
}