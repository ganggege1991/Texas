package enums;

/**
 * Created by HeGang 16:59 2018/5/7.
 *
 * @author 何刚
 */
public enum PokerEnums {

    /**
     * 2
     */
    Card_2(2, "2"),
    /**
     * 3
     */
    Card_3(3, "3"),
    /**
     * 4
     */
    Card_4(4, "4"),
    /**
     * 5
     */
    Card_5(5, "5"),
    /**
     * 6
     */
    Card_6(6, "6"),
    /**
     * 7
     */
    Card_7(7, "7"),
    /**
     * 8
     */
    Card_8(8, "8"),
    /**
     * 9
     */
    Card_9(9, "9"),
    /**
     * 10
     */
    Card_10(10, "10"),
    /**
     * J
     */
    Card_J(11, "J"),
    /**
     * Q
     */
    Card_Q(12, "Q"),
    /**
     * K
     */
    Card_K(13, "K"),
    /**
     * A
     */
    Card_A(14, "A"),;

    private int point;

    private String num;

    PokerEnums(int point, String num) {
        this.point = point;
        this.num = num;
    }

    public int getPoint() {
        return point;
    }

    public String getNum() {
        return num;
    }
}
