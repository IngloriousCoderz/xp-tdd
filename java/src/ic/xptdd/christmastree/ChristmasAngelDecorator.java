package ic.xptdd.christmastree;

import static ic.xptdd.christmastree.Tree.EMPTY_STRING;
import static ic.xptdd.christmastree.Tree.SPACE;

import java.util.ArrayList;
import java.util.List;

public class ChristmasAngelDecorator extends AbstractTree {

    private final static String ANGEL = "qp";
    private final static int ANGEL_HEIGHT = 1;

    private final Tree tree;

    public ChristmasAngelDecorator(Tree tree) {
        this.tree = tree;
    }

    @Override
    public List<String> buildCanopy() {
        List<String> result = new ArrayList();
        result.add(buildAngel());
        result.addAll(tree.buildCanopy());
        return result;
    }

    private String buildAngel() {
        int beforeAngel = getBeforeAngelWidth();

        String angelRow = EMPTY_STRING;
        for (int j = 0; j < beforeAngel; j++) {
            angelRow += SPACE;
        }
        angelRow += ANGEL;
        return angelRow;
    }

    @Override
    public String buildBaseRow() {
        return tree.buildBaseRow();
    }

    @Override
    public String buildTrunkRow() {
        return tree.buildTrunkRow();
    }

    private int getBeforeAngelWidth() {
        int halfWidth = getWidth() / 2;
        int halfAngelWidth = getAngelWidth() / 2;
        return halfWidth - halfAngelWidth;
    }

    private int getAngelWidth() {
        return ANGEL.length();
    }

    @Override
    public int getMinimumAllowedCanopyHeight() {
        return tree.getMinimumAllowedCanopyHeight();
    }

    @Override
    public int getWidth() {
        return tree.getWidth();
    }

    @Override
    public int getHeight() {
        return tree.getHeight();
    }

    @Override
    public int getCanopyHeight() {
        return tree.getCanopyHeight() + ANGEL_HEIGHT;
    }

    @Override
    public int getBaseHeight() {
        return tree.getBaseHeight();
    }

    @Override
    public int getTrunkHeight() {
        return tree.getTrunkHeight();
    }

}
