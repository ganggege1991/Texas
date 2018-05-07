package strategy;

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
    private static final PokerType POKER_TYPE = PokerType.FOUR_OF_A_KIND;

    @Override
    public PokerType handle(HandPoker handPoker) {

        //牌已排序
        //取前4个比较相同或者后4个相同则可判定为 "四张"

        List<Poker> pokerList = handPoker.getPokerList();

        int preValueForTop4 = pokerList.get(0).getCard().getPoint(), preValueForLast4 = pokerList.get(1).getCard().getPoint();
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

        //TODO
        return 0;
    }
}
