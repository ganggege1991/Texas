package enums;

/**
 * @Author HeGang [www.coder520.com]
 * @Date 2018/5/7 22:08
 * <strong>注意枚举的compareTo 比较是比较的顺序，越靠后越大 例如：STRAIGHT_FLUSH > FOUR_OF_A_KIND</strong>
 * @Description 牌型枚举
 */
public enum PokerType {


    /**
     * 四条
     */
    FOUR_OF_A_KIND("四条"),
    /**
     * 同花顺
     */
    STRAIGHT_FLUSH("同花顺");

    private String name;

    PokerType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
