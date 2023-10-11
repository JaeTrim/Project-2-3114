/**
 * Search Result Class
 * 
 * @author Jae Trimboli (jaetrim)
 * @author Mohammad Mian (mohammadm21)
 * @version 10-10-2023
 */
public class SearchResult {

    private String output;
    private int nodesVisited;

    /**
     * Constructor for SearchResult
     */
    public SearchResult() {
        output = "";
        nodesVisited = 1;
    }


    /**
     * Returns the nodes visited in a search
     * 
     * @return how many nodesVisited
     */
    public int getNodesVisited() {
        return nodesVisited;
    }


    /**
     * Gets String output
     * 
     * @return output for String
     */
    public String getOutput() {
        return output;
    }


    /**
     * Sets the amount of nodes that were visited
     * 
     * @param num
     *            is new nodes visited
     */
    public void setNodesVisited(int num) {
        nodesVisited = num;
    }


    /**
     * Sets the output for proper printing
     * 
     * @param str
     *            new output
     */
    public void setOutput(String str) {
        output = str;
    }
}
