package com.milad.api.utility.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.milad.api.utility.graph.exceptions.CycleEdgeException;
import com.milad.api.utility.graph.exceptions.EdgeExistException;
import com.milad.api.utility.graph.exceptions.NodeDoesNotExistInGraphException;
import com.milad.api.utility.graph.exceptions.NodeExistInGraphException;

/**
 * This class implements undirected Graph representation by adjacency list and
 * simple operations on it Methods like adding a new node, adding a new edge,
 * checking if a node or edge is in graph, getting all nodes in "array list"
 * form, getting all edges in "array list" form This class assumes that nodes
 * extend Node abstract class which defines an id for graph nodes(vertices).
 *
 * @author Milad
 * @param <V>
 */
public abstract class Graph<V extends Node> {

    protected HashMap<Long, ArrayList<V>> edges;
    protected HashMap<Long, V> nodes;
    protected int size = 0;

    public Graph() {
        edges = new HashMap<>();
        nodes = new HashMap<>();
    }

    public Graph(Graph g) {
    }

    /**
     * Add a new node in graph if node with same id exist in graph
     * NodeExistInGraphException happens
     *
     * @param gNode
     * @return V node
     * @throws Graph.Exceptions.NodeExistInGraphException
     */
    public boolean addNode(V gNode) throws NodeExistInGraphException {
        if (this.containsNode(gNode)) {
            throw new NodeExistInGraphException("Node with id " + gNode.getId() + " exist in this graph!");
        }
        V n = nodes.put(gNode.getId(), gNode);
        size++;
        return n == null;
    }

    /**
     * Adds appropriate links in adjacency list to define edge since graph is
     * undirected in both nodes links of adjacency will be created
     *
     * @param fNode
     * @param sNode
     * @throws Graph.Exceptions.EdgeExistException
     */
    public abstract void addEdge(V fNode, V sNode) throws EdgeExistException, CycleEdgeException;

    /**
     * Check if node exists in graph
     *
     * @param node
     * @return
     */
    public boolean containsNode(V node) {

        return nodes.containsKey(node.getId());
    }

    /**
     * Check if there is a link between fnode and snode or in other word check
     * if there is an edge between those two.
     *
     * @param fNode
     * @param sNode
     * @return
     */
    public boolean containsEdge(V fNode, V sNode) {
        if (!this.containsNode(fNode) || !this.containsNode(sNode)) {
            return false;
        }
        boolean edgeExists = false;
        ArrayList<V> arrList = edges.get(fNode.getId());
        if (arrList != null) {
            for (Iterator<V> i = arrList.iterator(); i.hasNext();) {
                if (i.next().getId() == sNode.getId()) {
                    edgeExists = true;
                    break;
                }
            }
        }
        return edgeExists;
    }

    /**
     * returns node object if node is in graph if node does not exist in graph
     * throws NodeDoesNotExistInGraphException
     *
     * @param id
     * @return V
     * @throws NodeDoesNotExistInGraphException
     */
    public V getNode(int id) throws NodeDoesNotExistInGraphException {

        if (this.nodes.containsKey(id)) {
            return this.nodes.get(id);
        } else {
            throw new NodeDoesNotExistInGraphException("Input node(vertice) with id " + id + " does not exist in graph!");
        }
    }

    /**
     * returns an array containing all nodes
     *
     * @return ArrayList
     */
    public ArrayList<V> getAllNodes() {

        ArrayList<V> newArrList = new ArrayList<>();
        this.nodes.values().stream().forEach((verts) -> {
            newArrList.add(verts);
        });
        return newArrList;
    }

    /**
     * calculates node degree
     *
     * @param node
     * @return Integer
     * @throws NodeDoesNotExistInGraphException
     */
    public int degree(V node) throws NodeDoesNotExistInGraphException {
        this.checkNodeExistenceForException(node);
        ArrayList<V> arr = this.edges.get(node.getId());
        if (arr == null) {
            return 0;
        } else {
            return this.edges.get(node.getId()).size();
        }
    }

    /**
     * returns ones node other adjacent nodes
     *
     * @param node
     * @return ArrayList
     * @throws NodeDoesNotExistInGraphException
     */
    public ArrayList<V> nodeAdjacents(V node) throws NodeDoesNotExistInGraphException {
        this.checkNodeExistenceForException(node);
        ArrayList<V> arrList = this.edges.get(node.getId());
        return arrList;
    }

    /**
     * returns graph adjacency list in hash map form this can be used for edge
     * related operations consider we put this method to get rid of edge
     * calculation inside graph class
     *
     * @return HashMap
     */
    public HashMap<V, ArrayList<V>> getEdges() {
        HashMap<V, ArrayList<V>> adjList = new HashMap<>();
        this.edges.entrySet().stream().forEach((entry) -> {
            adjList.put(this.nodes.get(entry.getKey()), entry.getValue());
        });
        return adjList;
    }

    /**
     * @return graph size
     */
    public int getSize() {
        return size;
    }

    /**
     * method for not repeating same code for checking node existence
     *
     * @param node
     * @throws NodeDoesNotExistInGraphException
     */
    private void checkNodeExistenceForException(V node) throws NodeDoesNotExistInGraphException {
        if (!containsNode(node)) {
            throw new NodeDoesNotExistInGraphException("Node with id " + node.getId() + " does not exist in this graph!");
        }
    }

}
