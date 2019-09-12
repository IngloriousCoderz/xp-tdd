package ic.xptdd.christmastree;

import java.util.ArrayList;
import java.util.List;

public class ChristmasBallsDecorator extends AbstractTree {

    private final static String AVAILABLE_LIGHTS = "o * ";
    private final static String SPLIT_CANOPY_ROW_REGEX = "[^\\s]+";

    private final Tree tree;

    public ChristmasBallsDecorator(Tree tree) {
        this.tree = tree;
    }

    @Override
    public List<String> buildCanopy() throws HeightTooSmallException {
        return putChristmasBalls(tree.buildCanopy());
    }

    @Override
    public String buildBaseRow() {
        return tree.buildBaseRow();
    }

    @Override
    public String buildTrunkRow() {
        return tree.buildTrunkRow();
    }

    private List<String> putChristmasBalls(List<String> rows) {
        List<String> newRows = new ArrayList();
        for (int i = 0; i < rows.size(); i++) {
            newRows.add(putChristmasBallsOnRow(rows.get(i)));
        }
        return newRows;
    }

    private String putChristmasBallsOnRow(String row) {
        String[] tokens = row.split(SPLIT_CANOPY_ROW_REGEX);

        if (!rowHasRoomForBalls(tokens)) {
            return row;
        }

        String insideCanopy = tokens[1];
        int leftIndex = row.indexOf(insideCanopy);
        int rightIndex = leftIndex + insideCanopy.length() - 1;

        StringBuilder builder = new StringBuilder(row);
        for (int j = leftIndex + 1; j < rightIndex; j++) {
            char randomLight = chooseRandomLight();
            builder.setCharAt(j, randomLight);
        }

        return builder.toString();
    }

    private boolean rowHasRoomForBalls(String[] tokens) {
        return tokens.length == 2;
    }

    private char chooseRandomLight() {
        int index = (int) (Math.random() * AVAILABLE_LIGHTS.length());
        return AVAILABLE_LIGHTS.charAt(index);
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
    public int getBaseHeight() {
        return tree.getBaseHeight();
    }

    @Override
    public int getTrunkHeight() {
        return tree.getTrunkHeight();
    }
}
