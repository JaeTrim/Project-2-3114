/**
 * 
 */
public class SearchResult {
    
    StringBuilder output;
    int nodesVisited;
    
    public SearchResult()  
    {        
        output = new StringBuilder();
        nodesVisited = 1;
    }
    
    public int getNodesVisited()
    {
        return nodesVisited;
    }
    
    public StringBuilder getOutput()
    {
        return output;
    }
    
    public void setNodesVisited(int num)
    {
        nodesVisited = num;
    }
    
    public void setOutput(StringBuilder str)
    {
        output = str;
    }
}
