package com.milad.api.utility.graph.exceptions;

public class CycleEdgeException
  extends Exception
{
  public CycleEdgeException() {}
  
  public CycleEdgeException(String message)
  {
    super(message);
  }
}
