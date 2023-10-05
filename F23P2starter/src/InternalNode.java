
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
            if ((sem.x() > (x + (xEnd - x) / 2))) {
                setRight(right.insert(sem, flyNode, x + ((xEnd - x) / 2), y,
                    xEnd, yEnd, level + 1));
                return this;
            }
            else {
                setLeft(left.insert(sem, flyNode, x, y, x + ((xEnd - x) / 2),
                    yEnd, level + 1));
                return this;
            }
        }
        else {
            if ((sem.y() > (y + (yEnd - y) / 2))) {
                setRight(right.insert(sem, flyNode, x, y + ((yEnd - y) / 2),
                    xEnd, yEnd, level + 1));
                return this;

            }
            else {
                setLeft(left.insert(sem, flyNode, x, y, xEnd, y + (yEnd - y)
                    / 2, level + 1));
                return this;
            }
        }
    }


    public void print() {
        System.out.println("I");
        left.print();
        right.print();
    }


    public BinNode delete(Seminar sem, int level, int x,
        int y,
        int xEnd,
        int yEnd, BinNode fly) {
        int decision = level % 2;
        if (decision == 0) {
            int split = x + ((xEnd - x) / 2);
            if (sem.x() > split)
            {
                setRight(right.delete(sem, level + 1, split, y, xEnd, yEnd, fly));
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
            else
            {
                setLeft(left.delete(sem, level + 1, x, y, split, yEnd, fly));
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
        }
        else {
            int split = y + ((yEnd - y) / 2);
            if (sem.y() > split)
            {
                setRight(right.delete(sem, level + 1, x, split, xEnd, yEnd, fly));
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
            else
            {
                setLeft(left.delete(sem, level + 1, x, y, xEnd, split, fly));
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
        }
    }
    
}