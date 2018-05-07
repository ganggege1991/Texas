import entity.HandPoker;
import entity.Poker;
import enums.ColorEnums;
import enums.PokerEnums;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        List<Poker> poker1 = new ArrayList<>(HandPoker.SIZE);
        poker1.add(new Poker(ColorEnums.Spade, PokerEnums.Card_3));
        poker1.add(new Poker(ColorEnums.Spade, PokerEnums.Card_4));
        poker1.add(new Poker(ColorEnums.Spade, PokerEnums.Card_5));
        poker1.add(new Poker(ColorEnums.Spade, PokerEnums.Card_2));
        poker1.add(new Poker(ColorEnums.Spade, PokerEnums.Card_6));
        HandPoker handPoker1 = new HandPoker(poker1);


        List<Poker> poker2 = new ArrayList<>(HandPoker.SIZE);
        poker2.add(new Poker(ColorEnums.Spade, PokerEnums.Card_7));
        poker2.add(new Poker(ColorEnums.Spade, PokerEnums.Card_3));
        poker2.add(new Poker(ColorEnums.Spade, PokerEnums.Card_4));
        poker2.add(new Poker(ColorEnums.Spade, PokerEnums.Card_5));
        poker2.add(new Poker(ColorEnums.Spade, PokerEnums.Card_6));
        HandPoker handPoker2 = new HandPoker(poker2);


        //比较 同花顺比较
        System.out.println(handPoker1.compareTo(handPoker2));

    }
}
