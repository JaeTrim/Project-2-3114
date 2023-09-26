/**
 * 
 */
public class SearchResult {
    
    String output;
    int nodesVisited;
    
    public SearchResult()  
    {        
        output = "";
        nodesVisited = 1;
    }
    
    public int getNodesVisited()
    {
        return nodesVisited;
    }
    
    public String getOutput()
    {
        return output;
    }
    
    public void setNodesVisited(int num)
    {
        nodesVisited = num;
    }
    
    public void setOutput(String str)
    {
        output = str;
    }
}
