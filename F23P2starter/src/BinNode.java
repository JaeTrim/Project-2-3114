
public interface BinNode {
    
    public BinNode insert(Seminar sem, BinNode flyNode, int x, int y, int xEnd, int yEnd, int level);
    
    public void print(int level);
    
    public BinNode delete(Seminar sem, int level, int x, int y, int xEnd, int yEnd, BinNode fly);
    
    public int search(int searchX, int searchY, int w, int nodeX, int nodeY, int xEnd, int yEnd, int level, int numNodes, BinNode fly);
}
