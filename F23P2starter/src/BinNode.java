
public interface BinNode {
    
    public BinNode insert(Seminar sem, BinNode flyNode, int x, int y, int xEnd, int yEnd, int level);
    
    public void print();
    
    public BinNode delete(Seminar sem, int level, int x, int y, int xEnd, int yEnd, BinNode fly);
    
}
