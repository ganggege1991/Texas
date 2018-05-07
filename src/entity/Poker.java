package entity;

import com.sun.istack.internal.NotNull;
import enums.ColorEnums;

/**
 * Created by HeGang 16:20 2018/5/7.
 * 牌
 */
public class Poker implements Comparable<Poker> {

    /**
     * 花色
     */
    private ColorEnums color;

    private char card;

    public Poker(@NotNull ColorEnums color, @NotNull char card) {
        this.color = color;
        this.card = card;
    }

    public ColorEnums getColor() {
        return color;
    }

    public void setColor(ColorEnums color) {
        this.color = color;
    }

    public char getCard() {
        return card;
    }

    public void setCard(char card) {
        this.card = card;
    }


    @Override
    public int compareTo(Poker o) {

        return 0;
    }
}
