package com.milad.api.utility.graph.noncyclic.directed;

import java.util.ArrayList;

import com.milad.api.utility.graph.Graph;
import com.milad.api.utility.graph.Node;
import com.milad.api.utility.graph.exceptions.CycleEdgeException;
import com.milad.api.utility.graph.exceptions.EdgeExistException;

public class NonCyclicDirectedGraph<V extends Node>
  extends Graph<V>
{
  public void addEdge(V fNode, V sNode)
    throws EdgeExistException, CycleEdgeException
  {
    if (containsEdge(fNode, sNode)) {
      throw new EdgeExistException("Edge ( " + fNode.getId() + "--->" + sNode.getId() + "exists!");
    }
    if (fNode.getId() == sNode.getId()) {
      throw new CycleEdgeException("No cycle is allowed for this graph. If you require cycles use Cyclic graph types. exception for node : " + fNode.getId());
    }
    if (this.edges.containsKey(fNode.getId()))
    {
      ((ArrayList)this.edges.get(fNode.getId())).add(sNode);
    }
    else
    {
      ArrayList<V> arr = new ArrayList();
      arr.add(sNode);
      this.edges.put(fNode.getId(), arr);
    }
  }
}
