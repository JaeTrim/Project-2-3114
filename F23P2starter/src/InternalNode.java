public class InternalNode implements BinNode {

    private BinNode left;
    private BinNode right;

    public InternalNode(BinNode fly) {
        left = fly;
        right = fly;
    }

    public BinNode left() {
        return left;
    }

    public BinNode setLeft(BinNode temp) {
        left = temp;
        return left;
    }

    public BinNode setRight(BinNode temp) {
        right = temp;
        return right;
    }

    public BinNode right() {
        return right;
    }

    public BinNode insert(
        Seminar sem,
        BinNode flyNode,
        int x,
        int y,
        int xEnd,
        int yEnd,
        int level) {
        int decision = level % 2;
        if (decision == 0) {
            int split = 0;
            if ((xEnd - x) % 2 == 0)
            {
                split = x + (((xEnd - x) / 2) - 1);
            }
            else {
                split = x + ((xEnd - x) / 2);
            }
            if (sem.x() > split) {
                setRight(right.insert(sem, flyNode, split + 1, y,
                    xEnd, yEnd, level + 1));
                return this;
            }
            else {
                setLeft(left.insert(sem, flyNode, x, y, split,
                    yEnd, level + 1));
                return this;
            }
        }
        else {
            int split = 0;
            if ((yEnd - y) % 2 == 0)
            {
                split = y + (((yEnd - y) / 2) - 1);
            }
            else {
                split = y + ((yEnd - y) / 2);
            }
            if (sem.y() > split) {
                setRight(right.insert(sem, flyNode, x, split + 1,
                    xEnd, yEnd, level + 1));
                return this;

            }
            else {
                setLeft(left.insert(sem, flyNode, x, y, xEnd, split, level + 1));
                return this;
            }
        }
    }


    public void print(int level) {
        for (int i = 0; i < level; i++)
        {
            System.out.print("  ");
        }
        System.out.println("I");
        left.print(level + 1);
        right.print(level + 1);
    }


    public BinNode delete(Seminar sem, int level, int x,
        int y,
        int xEnd,
        int yEnd, BinNode fly) {
        int decision = level % 2;
        if (decision == 0) {
            int split = 0;
            if ((xEnd - x) % 2 == 0)
            {
                split = x + (((xEnd - x) / 2) - 1);
            }
            else {
                split = x + ((xEnd - x) / 2);
            }
            if (sem.x() > split)
            {
                setRight(right.delete(sem, level + 1, split + 1, y, xEnd, yEnd, fly));
            }
            else
            {
                setLeft(left.delete(sem, level + 1, x, y, split, yEnd, fly));
            }
            if (left == fly && right == fly)
            {
                return fly;
            }
            else if (left != fly && right == fly && left instanceof LeafNode)
            {
                return left;
            }
            else if (left == fly && right != fly && right instanceof LeafNode)
            {
                return right;
            }
        }
        else {
            int split = 0;
            if ((yEnd - y) % 2 == 0)
            {
                split = y + (((yEnd - y) / 2) - 1);
            }
            else {
                split = y + ((yEnd - y) / 2);
            }
            if (sem.y() > split)
            {
                setRight(right.delete(sem, level + 1, x, split + 1, xEnd, yEnd, fly));
            }
            else
            {
                setLeft(left.delete(sem, level + 1, x, y, xEnd, split, fly));
            }
        }
        if (left == fly && right == fly)
        {
            return fly;
        }
        else if (left != fly && right == fly && left instanceof LeafNode)
        {
            return left;
        }
        else if (left == fly && right != fly && right instanceof LeafNode)
        {
            return right;
        }
        return this;
    }
    
    public int search(int searchX, int searchY, int radius, int nodeX, int nodeY, int xEnd, int yEnd, int level, int numNodes, BinNode fly)
    {
        int decision = level % 2;
        int boundaryX = searchX - radius;
        int boundaryY = searchY - radius;
        int w = 2 * radius + 1;
        if (decision == 0)
        {
            int split = 0;
            if ((xEnd - nodeX) % 2 == 0)
            {
                split = nodeX + (((xEnd - nodeX) / 2) - 1);
            }
            else {
                split = nodeX + ((xEnd - nodeX) / 2);
            }
            if ((boundaryX <= split) && ((boundaryX + w) <= split + 1))
            {
                return left.search(searchX, searchY, radius, nodeX, nodeY, split, yEnd, level + 1, numNodes + 1, fly);
            }
            else if ((boundaryX > split) && ((boundaryX + w) > split + 1))
            {
                return right.search(searchX, searchY, radius, split + 1, nodeY, xEnd, yEnd, level + 1, numNodes + 1, fly);
            }
            else
            {
                int currNum = numNodes;
                currNum = left.search(searchX, searchY, radius, nodeX, nodeY, split, yEnd, level + 1, currNum + 1, fly);
                currNum = right.search(searchX, searchY, radius, split + 1, nodeY, xEnd, yEnd, level + 1, currNum + 1, fly);
                return currNum;
            } 
        }
        else 
        {
            int split = 0;
            if ((yEnd - nodeY) % 2 == 0)
            {
                split = nodeY + (((yEnd - nodeY) / 2) - 1);
            }
            else {
                split = nodeY + ((yEnd - nodeY) / 2);
            }
            if ((boundaryY <= split) && ((boundaryY + w) <= split + 1))
            {
                return left.search(searchX, searchY, radius, nodeX, nodeY, xEnd, split, level + 1, numNodes + 1, fly);
            }
            else if ((boundaryY > split) && ((boundaryY + w) > split + 1))
            {
                return right.search(searchX, searchY, radius, nodeX, split + 1, xEnd, yEnd, level + 1, numNodes + 1, fly);
            }
            else
            {
                int currNum = numNodes;
                currNum = left.search(searchX, searchY, radius, nodeX, nodeY, xEnd, split, level + 1, currNum + 1, fly);
                currNum = right.search(searchX, searchY, radius, nodeX, split + 1, xEnd, yEnd, level + 1, currNum + 1, fly);
                return currNum;
            } 
        }
    }
}