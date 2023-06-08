package ru.koltunov.vitalii.graph;
/*
add_vertex(vertex) -- добавление вершины
add_edge(a, b) -- добавление ребра из a в b
dfs() -- выводящий на экран все вершины в порядке обхода
bfs() -- выводящий на экран все вершины в порядке обхода
 */


import java.util.*;

public class Tree {



    private TreeVertex root;
    private List<TreeVertex> vertices = new ArrayList<>();
    private Set<TreeVertex> visited = new HashSet<>();
    private Deque<TreeVertex> queue = new ArrayDeque<>();

    public void add_vertex(TreeVertex treeVertex) {
        vertices.add(treeVertex);
    }

    public void add_edge(TreeVertex from, TreeVertex to) {
        from.add_edge(to);
    }

    /* start from root

     */
    public void dfs() {
        visited.clear();
        dfs(root);
    }

    public void bfs() {
        visited.clear();
        bfs(root);
    }
    public void bfs(TreeVertex u) {
        queue.offer(u);
        while (!queue.isEmpty()) {
            TreeVertex k = queue.poll();
            System.out.println(k.data);
            visited.add(k);
            for (TreeVertex t: k.edges) {
                if (!visited.contains(t)) {
                    queue.offer(t);
                }
            }
        }
    }

    private void dfs(TreeVertex u) {
        System.out.println(u.data);
        visited.add(u);
        for (TreeVertex tv : u.edges) {
            if (!visited.contains(tv)) {
                dfs(tv);
            }
        }
    }
}

class TreeVertex {
    public int data;
    public List<TreeVertex> edges = new ArrayList<>();

    public TreeVertex(int data) {
        this.data = data;
    }

    public void add_edge(TreeVertex to) {
        edges.add(to);
    }
}
