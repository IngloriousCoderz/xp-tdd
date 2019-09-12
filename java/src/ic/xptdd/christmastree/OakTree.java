package ic.xptdd.christmastree;

import java.util.ArrayList;
import java.util.List;

public class OakTree extends AbstractTree implements Tree {

    private final static String CANOPY_TOP_LEFT = "/";
    private final static String CANOPY_TOP = "-";
    private final static String CANOPY_TOP_RIGHT = "\\";
    private final static String CANOPY_BOTTOM_LEFT = "\\";
    private final static String CANOPY_BOTTOM = "-";
    private final static String CANOPY_BOTTOM_RIGHT = "/";
    private final static String CANOPY_MIDDLE = "|";
    private final static String BASE = "\\\\//";
    private final static String TRUNK = "||";

    private final static int BASE_HEIGHT = 1;
    private final static int TRUNK_HEIGHT = 2;

    private final int width;
    private final int height;

    public OakTree(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public List<String> buildCanopy() {
        List<String> canopy = new ArrayList();
        canopy.add(buildTop());
        canopy.addAll(buildMiddle());
        canopy.add(buildBottom());
        return canopy;
    }

    private String buildTop() {
        int widthWithoutBorders = width - CANOPY_TOP_LEFT.length() - CANOPY_TOP_RIGHT.length();

        String top = CANOPY_TOP_LEFT;
        for (int j = 0; j < widthWithoutBorders; j++) {
            top += CANOPY_TOP;
        }
        top += CANOPY_TOP_RIGHT;
        return top;
    }

    private List<String> buildMiddle() {
        int canopyHeight = getCanopyHeight();
        int heightWithoutBorders = canopyHeight - 2;

        List<String> middle = new ArrayList();
        for (int i = 0; i < heightWithoutBorders; i++) {
            middle.add(buildMiddleRow());
        }
        return middle;
    }

    private String buildMiddleRow() {
        int widthWithoutBorders = width - 2 * CANOPY_MIDDLE.length();

        String middle = CANOPY_MIDDLE;
        for (int j = 0; j < widthWithoutBorders; j++) {
            middle += SPACE;
        }
        middle += CANOPY_MIDDLE;
        return middle;
    }

    private String buildBottom() {
        int widthWithoutBorders = width - CANOPY_BOTTOM_LEFT.length() - CANOPY_BOTTOM_RIGHT.length();

        String top = CANOPY_BOTTOM_LEFT;
        for (int j = 0; j < widthWithoutBorders; j++) {
            top += CANOPY_BOTTOM;
        }
        top += CANOPY_BOTTOM_RIGHT;
        return top;
    }

    @Override
    public String buildBaseRow() {
        int beforeBase = getBeforeBaseWidth();

        String base = EMPTY_STRING;
        for (int j = 0; j < beforeBase; j++) {
            base += SPACE;
        }
        base += BASE;
        return base;
    }

    @Override
    public String buildTrunkRow() {
        int beforeTrunk = getBeforeTrunkWidth();

        String trunk = EMPTY_STRING;
        for (int j = 0; j < beforeTrunk; j++) {
            trunk += SPACE;
        }
        trunk += TRUNK;
        return trunk;
    }

    private int getBeforeBaseWidth() {
        int halfWidth = width / 2;
        int halfBase = BASE.length() / 2;
        return halfWidth - halfBase;
    }

    private int getBeforeTrunkWidth() {
        int halfWidth = getWidth() / 2;
        int halfTrunk = TRUNK.length() / 2;
        return halfWidth - halfTrunk;
    }

    @Override
    public int getMinimumAllowedCanopyHeight() {
        return 2;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getBaseHeight() {
        return BASE_HEIGHT;
    }

    @Override
    public int getTrunkHeight() {
        return TRUNK_HEIGHT;
    }
}
