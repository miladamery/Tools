package com.milad.api.utility.graph.cyclic.directed;

import java.util.ArrayList;

import com.milad.api.utility.graph.Graph;
import com.milad.api.utility.graph.Node;
import com.milad.api.utility.graph.exceptions.CycleEdgeException;
import com.milad.api.utility.graph.exceptions.EdgeExistException;

public class CyclicDirectedGraph<V extends Node> extends Graph<V> {

	public void addEdge(V fNode, V sNode) throws EdgeExistException, CycleEdgeException {
		if (containsEdge(fNode, sNode)) {
			throw new EdgeExistException("Edge ( " + fNode.getId() + "--->" + sNode.getId() + "exists!");
		}
		if (fNode.getId() == sNode.getId()) {
			if (this.edges.containsKey(fNode.getId())) {
				((ArrayList) this.edges.get(fNode.getId())).add(fNode);
			} else {
				ArrayList<V> arr = new ArrayList<>();
				arr.add(fNode);
				this.edges.put(fNode.getId(), arr);
			}
		} else if (this.edges.containsKey(fNode.getId())) {
			((ArrayList) this.edges.get(fNode.getId())).add(sNode);
		} else {
			ArrayList<V> arr = new ArrayList<>();
			arr.add(sNode);
			this.edges.put(fNode.getId(), arr);
		}
	}
}