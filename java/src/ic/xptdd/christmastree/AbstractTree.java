package ic.xptdd.christmastree;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTree implements Tree {

    @Override
    public List<String> build() throws HeightTooSmallException {
        int canopyHeight = getCanopyHeight();
        int miniumAllowedCanopyHeight = getMinimumAllowedCanopyHeight();

        if (canopyHeight < miniumAllowedCanopyHeight) {
            throw new HeightTooSmallException();
        }

        return buildTree();
    }

    private List<String> buildTree() {
        List<String> tree = new ArrayList();
        tree.addAll(buildCanopy());
        tree.addAll(buildBase());
        tree.addAll(buildTrunk());
        return tree;
    }

    public List<String> buildBase() {
        List<String> base = new ArrayList();
        for (int i = 0; i < getBaseHeight(); i++) {
            base.add(buildBaseRow());
        }
        return base;
    }

    public List<String> buildTrunk() {
        List<String> trunk = new ArrayList();
        for (int i = 0; i < getTrunkHeight(); i++) {
            trunk.add(buildTrunkRow());
        }
        return trunk;
    }

    @Override
    public int getCanopyHeight() {
        return getHeight() - getBaseHeight() - getTrunkHeight();
    }
}
