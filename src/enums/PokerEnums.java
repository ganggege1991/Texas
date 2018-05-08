package enums;

/**
 * Created by HeGang 16:59 2018/5/7.
 */
public enum PokerEnums {


    Card_2(2, "2"),
    Card_3(3, "3"),
    Card_4(4, "4"),
    Card_5(5, "5"),
    Card_6(6, "6"),
    Card_7(7, "7"),
    Card_8(8, "8"),
    Card_9(9, "9"),
    Card_10(10, "10"),
    Card_J(11, "J"),
    Card_Q(12, "Q"),
    Card_K(13, "K"),
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
