package ic.xptdd.christmastree;

import java.util.List;

public interface Tree {

    public final static String EMPTY_STRING = "";
    public final static String SPACE = " ";
    public final static String NEWLINE = "\n";

    public List<String> build() throws HeightTooSmallException;

    public List<String> buildCanopy();

    public String buildBaseRow();

    public String buildTrunkRow();

    public int getMinimumAllowedCanopyHeight();

    public int getWidth();
    
    public int getHeight();

    public int getCanopyHeight();

    public int getBaseHeight();

    public int getTrunkHeight();
}
