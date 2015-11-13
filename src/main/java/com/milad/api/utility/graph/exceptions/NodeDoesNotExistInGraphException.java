package com.milad.api.utility.graph.exceptions;

public class NodeDoesNotExistInGraphException
  extends Exception
{
  public NodeDoesNotExistInGraphException() {}
  
  public NodeDoesNotExistInGraphException(String message)
  {
    super(message);
  }
}
