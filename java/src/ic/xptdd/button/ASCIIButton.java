package ic.xptdd.button;

import java.util.ArrayList;
import java.util.List;

public class ASCIIButton {

    private final static String EMPTY_STRING = "";
    private final static String SPACE = " ";
    private final static String NEWLINE = "\n";

    private final static String EMPTY_CELL = SPACE + SPACE;
    private final static String WHOLE_CELL = "*" + SPACE;

    private final int rows;
    private final int columns;
    private final String text;

    public static void main(String[] args) {
        System.out.println(String.join(NEWLINE, new ASCIIButton(10, 10, "hello").build()));
    }

    public ASCIIButton(int rows, int columns, String text) {
        this.rows = rows;
        this.columns = columns;
        this.text = text;
    }

    public List<String> build() {
        int halfRows = getOffsetInRows(rows);

        List<String> button = new ArrayList();
        button.add(buildWholeRow(columns));
        button.addAll(buildEmptyRows(halfRows - fixIfEven(rows), columns));
        button.add(buildRowWithText(columns, this.text));
        button.addAll(buildEmptyRows(halfRows, columns));
        button.add(buildWholeRow(columns));

        return button;
    }

    private String buildWholeRow(int columns) {
        String row = EMPTY_STRING;
        for (int j = 0; j < columns; j++) {
            row += WHOLE_CELL;
        }
        return row;
    }

    private List<String> buildEmptyRows(int rows, int columns) {
        List<String> emptyRows = new ArrayList();
        for (int i = 0; i < rows; i++) {
            emptyRows.add(buildEmptyRow(columns));
        }
        return emptyRows;
    }

    private String buildEmptyRow(int columns) {
        return buildRowWithText(columns, EMPTY_STRING);
    }

    private String buildRowWithText(int columns, String text) {
        int offsetInChars = getOffsetInChars(columns, text);

        String rowWithText = EMPTY_STRING;
        rowWithText += buildLeftOffset(offsetInChars - fixIfOdd(text.length()));
        rowWithText += text;
        rowWithText += buildRightOffset(offsetInChars);

        return rowWithText;
    }

    private int getOffsetInRows(int rows) {
        int rowsWithoutBorders = rows - 2;
        return rowsWithoutBorders / 2;
    }

    private int getOffsetInChars(int columns, String text) {
        int columnsWithoutBorders = columns - 2;
        float halfColumns = columnsWithoutBorders / 2.0f;
        int charsInHalfColumns = (int) (halfColumns * EMPTY_CELL.length());
        int textLength = text.length();
        int halfText = textLength / 2;
        return charsInHalfColumns - halfText;
    }

    private String buildLeftOffset(int chars) {
        return WHOLE_CELL + buildOffset(chars);
    }

    private String buildRightOffset(int chars) {
        return buildOffset(chars) + WHOLE_CELL;
    }

    private String buildOffset(int chars) {
        String offset = EMPTY_STRING;
        for (int j = 0; j < chars; j++) {
            offset += SPACE;
        }
        return offset;
    }

    private int fixIfEven(int quantity) {
        return quantity % 2 == 0 ? 1 : 0;
    }

    private int fixIfOdd(int quantity) {
        return quantity % 2 == 0 ? 0 : 1;
    }
}
