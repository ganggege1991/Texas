package enums;

/**
 * Created by HeGang 16:21 2018/5/7.
 * 花色
 */
public enum ColorEnums {

    /**
     * 黑桃
     */
    Spade(1),
    /**
     * 红桃
     */
    Heart(2),
    /**
     * 方片
     */
    Club(3),
    /**
     * 梅花
     */
    Diamond(4);

    private int value;

    ColorEnums(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
