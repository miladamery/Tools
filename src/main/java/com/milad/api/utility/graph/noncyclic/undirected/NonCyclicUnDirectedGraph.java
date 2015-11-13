package com.milad.api.utility.graph.noncyclic.undirected;

import java.util.ArrayList;

import com.milad.api.utility.graph.Graph;
import com.milad.api.utility.graph.Node;
import com.milad.api.utility.graph.exceptions.CycleEdgeException;
import com.milad.api.utility.graph.exceptions.EdgeExistException;

public class NonCyclicUnDirectedGraph<V extends Node>
  extends Graph<V>
{
  public void addEdge(V fNode, V sNode)
    throws EdgeExistException, CycleEdgeException
  {
    if ((containsEdge(fNode, sNode)) || (containsEdge(sNode, fNode))) {
      throw new EdgeExistException("Edge ( " + fNode.getId() + "<--->" + sNode.getId() + " exists!");
    }
    if (fNode.getId() == sNode.getId()) {
      throw new CycleEdgeException("No cycle is allowed for this graph. If you require cycles use Cyclic graph types. exception raised for node : " + fNode.getId());
    }
    if (this.edges.containsKey(fNode.getId()))
    {
      ((ArrayList)this.edges.get(fNode.getId())).add(sNode);
    }
    else
    {
      ArrayList<V> newArrList = new ArrayList();
      newArrList.add(sNode);
      this.edges.put(fNode.getId(), newArrList);
    }
    if (this.edges.containsKey(sNode.getId()))
    {
      ((ArrayList)this.edges.get(sNode.getId())).add(fNode);
    }
    else
    {
      ArrayList<V> newArrList = new ArrayList();
      newArrList.add(fNode);
      this.edges.put(sNode.getId(), newArrList);
    }
  }
}
