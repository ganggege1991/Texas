import entity.HandPoker;
import entity.Poker;
import enums.ColorEnums;
import enums.PokerEnums;
import enums.PokerType;

import javax.sound.midi.Soundbank;
import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 *
 * 入口
 * @author hegang
 * @date 2018/09/05
 */
public class Main {

    public static void main(String[] args) {


        System.out.println("同花顺测试");
        straightFlushTest();

        System.out.println("四条测试");
        fourBoomTest();

        System.out.println("四条VS同花顺 测试");
        fourBoomVSstraightFlushTest();
    }

    /**
     * 四条VS同花顺 测试
     */
    public static void fourBoomVSstraightFlushTest() {
        List<Poker> poker1 = new ArrayList<>(HandPoker.SIZE);

        poker1.add(new Poker(ColorEnums.Spade, PokerEnums.Card_A));
        poker1.add(new Poker(ColorEnums.Diamond, PokerEnums.Card_A));
        poker1.add(new Poker(ColorEnums.Club, PokerEnums.Card_A));
        poker1.add(new Poker(ColorEnums.Heart, PokerEnums.Card_A));
        poker1.add(new Poker(ColorEnums.Spade, PokerEnums.Card_6));

        HandPoker handPoker1 = new HandPoker(poker1);


        List<Poker> poker2 = new ArrayList<>(HandPoker.SIZE);
        poker2.add(new Poker(ColorEnums.Spade, PokerEnums.Card_3));
        poker2.add(new Poker(ColorEnums.Spade, PokerEnums.Card_4));
        poker2.add(new Poker(ColorEnums.Spade, PokerEnums.Card_5));
        poker2.add(new Poker(ColorEnums.Spade, PokerEnums.Card_2));
        poker2.add(new Poker(ColorEnums.Spade, PokerEnums.Card_6));
        HandPoker handPoker2 = new HandPoker(poker2);

        printResult(handPoker1, handPoker2);

    }

    /**
     * 四条测试
     * 如果没有实现牌型则抛出 "未知的牌型"
     * <p>
     * 第一组数据 [A,A,A,A,6]  [K,K,K,K,6]
     * 第二组数据 [A,A,A,A,6]  [A,A,A,A,6]
     */
    public static void fourBoomTest() {

        List<Poker> poker1 = new ArrayList<>(HandPoker.SIZE);

        poker1.add(new Poker(ColorEnums.Spade, PokerEnums.Card_A));
        poker1.add(new Poker(ColorEnums.Diamond, PokerEnums.Card_A));
        poker1.add(new Poker(ColorEnums.Club, PokerEnums.Card_A));
        poker1.add(new Poker(ColorEnums.Heart, PokerEnums.Card_A));
        poker1.add(new Poker(ColorEnums.Spade, PokerEnums.Card_6));

        HandPoker handPoker1 = new HandPoker(poker1);

        List<Poker> poker2 = new ArrayList<>(HandPoker.SIZE);

        poker2.add(new Poker(ColorEnums.Spade, PokerEnums.Card_K));
        poker2.add(new Poker(ColorEnums.Diamond, PokerEnums.Card_K));
        poker2.add(new Poker(ColorEnums.Club, PokerEnums.Card_K));
        poker2.add(new Poker(ColorEnums.Heart, PokerEnums.Card_K));
        poker2.add(new Poker(ColorEnums.Spade, PokerEnums.Card_6));

        HandPoker handPoker2 = new HandPoker(poker2);
        //第一组数据 比较结果
        printResult(handPoker1, handPoker2);

        List<Poker> poker3 = new ArrayList<>(HandPoker.SIZE);
        poker3.add(new Poker(ColorEnums.Heart, PokerEnums.Card_A));
        poker3.add(new Poker(ColorEnums.Spade, PokerEnums.Card_A));
        poker3.add(new Poker(ColorEnums.Diamond, PokerEnums.Card_A));
        poker3.add(new Poker(ColorEnums.Club, PokerEnums.Card_A));
        poker3.add(new Poker(ColorEnums.Spade, PokerEnums.Card_6));
        HandPoker handPoker3 = new HandPoker(poker3);

        List<Poker> poker4 = new ArrayList<>(HandPoker.SIZE);
        poker4.add(new Poker(ColorEnums.Heart, PokerEnums.Card_A));
        poker4.add(new Poker(ColorEnums.Diamond, PokerEnums.Card_A));
        poker4.add(new Poker(ColorEnums.Spade, PokerEnums.Card_A));
        poker4.add(new Poker(ColorEnums.Club, PokerEnums.Card_A));
        poker4.add(new Poker(ColorEnums.Spade, PokerEnums.Card_6));
        HandPoker handPoker4 = new HandPoker(poker4);
        //第二组数据 比较结果
        printResult(handPoker3, handPoker4);


    }


    /**
     * 同花顺 测试
     * 如果没有实现牌型则抛出 "未知的牌型"
     * <p>
     * 第一组数据 [3,4,5,2,6]  [7,3,4,5,6]
     * 第二组数据 [3,4,5,2,6]  [3,4,5,2,6]
     * 第三组数据 [A,4,5,2,3]  [3,4,5,2,6]
     */
    public static void straightFlushTest() {


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
        //第一组数据 比较结果
        printResult(handPoker1, handPoker2);


        List<Poker> poker3 = new ArrayList<>(HandPoker.SIZE);
        poker3.add(new Poker(ColorEnums.Spade, PokerEnums.Card_3));
        poker3.add(new Poker(ColorEnums.Spade, PokerEnums.Card_4));
        poker3.add(new Poker(ColorEnums.Spade, PokerEnums.Card_5));
        poker3.add(new Poker(ColorEnums.Spade, PokerEnums.Card_2));
        poker3.add(new Poker(ColorEnums.Spade, PokerEnums.Card_6));
        HandPoker handPoker3 = new HandPoker(poker3);

        List<Poker> poker4 = new ArrayList<>(HandPoker.SIZE);
        poker4.add(new Poker(ColorEnums.Spade, PokerEnums.Card_3));
        poker4.add(new Poker(ColorEnums.Spade, PokerEnums.Card_4));
        poker4.add(new Poker(ColorEnums.Spade, PokerEnums.Card_5));
        poker4.add(new Poker(ColorEnums.Spade, PokerEnums.Card_2));
        poker4.add(new Poker(ColorEnums.Spade, PokerEnums.Card_6));
        HandPoker handPoker4 = new HandPoker(poker4);
        //第二组数据 比较结果
        printResult(handPoker3, handPoker4);


        List<Poker> poker5 = new ArrayList<>(HandPoker.SIZE);
        poker5.add(new Poker(ColorEnums.Spade, PokerEnums.Card_A));
        poker5.add(new Poker(ColorEnums.Spade, PokerEnums.Card_4));
        poker5.add(new Poker(ColorEnums.Spade, PokerEnums.Card_5));
        poker5.add(new Poker(ColorEnums.Spade, PokerEnums.Card_2));
        poker5.add(new Poker(ColorEnums.Spade, PokerEnums.Card_3));
        HandPoker handPoker5 = new HandPoker(poker5);

        List<Poker> poker6 = new ArrayList<>(HandPoker.SIZE);
        poker6.add(new Poker(ColorEnums.Spade, PokerEnums.Card_3));
        poker6.add(new Poker(ColorEnums.Spade, PokerEnums.Card_4));
        poker6.add(new Poker(ColorEnums.Spade, PokerEnums.Card_5));
        poker6.add(new Poker(ColorEnums.Spade, PokerEnums.Card_2));
        poker6.add(new Poker(ColorEnums.Spade, PokerEnums.Card_6));
        HandPoker handPoker6 = new HandPoker(poker6);
        //第二组数据 比较结果
        printResult(handPoker5, handPoker6);

    }

    private static void printResult(HandPoker handPoker, HandPoker handPokerTarget) {

        int result = handPoker.compareTo(handPokerTarget);
        switch (result) {
            case -1:
                System.out.println(handPokerTarget.toString() + " 赢了 " + handPoker.toString() + " 输了");
                break;

            case 1:
                System.out.println(handPoker.toString() + " 赢了 " + handPokerTarget.toString() + " 输了");
                break;
            default:
                System.out.println(handPoker.toString() + "," + handPokerTarget.toString() + " 打平");
        }


    }
}
