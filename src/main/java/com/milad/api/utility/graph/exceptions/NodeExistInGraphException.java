package com.milad.api.utility.graph.exceptions;

public class NodeExistInGraphException
  extends Exception
{
  public NodeExistInGraphException() {}
  
  public NodeExistInGraphException(String message)
  {
    super(message);
  }
}
