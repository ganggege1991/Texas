package entity;

import com.sun.istack.internal.NotNull;
import enums.ColorEnums;
import enums.PokerEnums;

/**
 * Created by HeGang 16:20 2018/5/7.
 * 牌
 */
public class Poker implements Comparable<Poker> {

    /**
     * 花色
     */
    private ColorEnums color;

    private PokerEnums card;

    public Poker(@NotNull ColorEnums color, @NotNull PokerEnums card) {
        this.color = color;
        this.card = card;
    }

    public ColorEnums getColor() {
        return color;
    }

    public void setColor(ColorEnums color) {
        this.color = color;
    }

    public PokerEnums getCard() {
        return card;
    }

    public void setCard(PokerEnums card) {
        this.card = card;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Poker)) return false;

        Poker poker = (Poker) o;

        return card == poker.card;
    }

    @Override
    public int hashCode() {
        return card.hashCode();
    }

    @Override
    public int compareTo(Poker o) {
        if (this == o) {
            return 0;
        }
        //比点数，花色无关
        return Integer.valueOf(this.getCard().getPoint()).compareTo(Integer.valueOf(o.getCard().getPoint()));

    }
}
