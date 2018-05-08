package strategy;

import com.sun.org.apache.regexp.internal.RE;
import entity.HandPoker;
import entity.Poker;
import enums.PokerType;

import java.util.List;

/**
 * @Author HeGang [www.coder520.com]
 * @Date 2018/5/8 2:06
 * @Description 四条（Four of a Kind，亦称“铁支”、“四张”或“炸弹”）：有四张同一点数的牌。
 */
public class FourBoomHandler implements TexasHandler {


    private static class LazyHolder {
        private static final FourBoomHandler INSTANCE = new FourBoomHandler();
    }

    private FourBoomHandler() {

    }

    public static final FourBoomHandler getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static final PokerType POKER_TYPE = PokerType.FOUR_OF_A_KIND;

    @Override
    public PokerType handle(HandPoker handPoker) {

        //牌已排序
        //前4个相同或者后4个相同则可判定为 "四张"

        List<Poker> pokerList = handPoker.getPokerList();

        int preValueForTop4 = pokerList.get(0).getCard().getPoint();
        int preValueForLast4 = pokerList.get(1).getCard().getPoint();

        int top4result = 1, last4result = 1;

        for (int i = 1; i < pokerList.size(); i++) {

            if (i != (pokerList.size() - 1)) {
                top4result = preValueForTop4 ^ pokerList.get(i).getCard().getPoint();
            }
            if (i != 1) {
                last4result = preValueForLast4 ^ pokerList.get(i).getCard().getPoint();
            }
        }

        return (top4result == 0 || last4result == 0) ? POKER_TYPE : null;
    }

    @Override
    public int compare(HandPoker handPoker, HandPoker handPokerTarget) {
        //先比较相同4张牌的大小，如果相同比较 剩下一张牌的大小


        Poker[] f = getDifferentPoker(handPoker);
        Poker[] t = getDifferentPoker(handPokerTarget);

        //比较炸弹
        int boomResult = f[0].compareTo(t[0]);
        if (boomResult == 0) {
            //炸弹一样，比较剩下的牌
            return f[1].compareTo(t[1]);
        }

        return boomResult;
    }

    /**
     * 获取相同的牌，和不同那一张
     *
     * @param handPoker [0] 炸弹，[1] 不同那一张
     * @return
     */
    private Poker[] getDifferentPoker(HandPoker handPoker) {

        Poker[] pokers = new Poker[2];

        List<Poker> pokerList = handPoker.getPokerList();

        int preValueForTop4 = pokerList.get(0).getCard().getPoint();
        int preValueForLast4 = pokerList.get(1).getCard().getPoint();

        int top4result = 1, last4result = 1;

        int size = handPoker.getPokerList().size();

        for (int i = 1; i < size; i++) {
            if (i != (pokerList.size() - 1)) {
                top4result = preValueForTop4 ^ pokerList.get(i).getCard().getPoint();
            }
            if (i != 1) {
                last4result = preValueForLast4 ^ pokerList.get(i).getCard().getPoint();
            }
        }

        //前四张相同
        if (top4result == 0) {
            pokers[0] = pokerList.get(0);
            pokers[1] = pokerList.get(5);
        }
        //后四张相同
        if (last4result == 0) {
            pokers[0] = pokerList.get(1);
            pokers[1] = pokerList.get(0);
        }

        return pokers;
    }
}
