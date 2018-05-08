package enums;

/**
 * Created by HeGang 16:21 2018/5/7.
 * 花色
 */
public enum ColorEnums {

    /**
     * 黑桃
     */
    Spade(1, "♠"),
    /**
     * 红桃
     */
    Heart(2, "♥"),
    /**
     * 方片
     */
    Diamond(3, "♦"),
    /**
     * 梅花
     */
    Club(4, "♣");

    private int value;
    private String graph;

    ColorEnums(int value, String graph) {
        this.value = value;
        this.graph = graph;
    }

    public String getGraph() {
        return graph;
    }

    public int getValue() {
        return value;
    }
}
