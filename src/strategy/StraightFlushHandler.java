package strategy;

import entity.HandPoker;
import entity.Poker;
import enums.ColorEnums;
import enums.PokerEnums;
import enums.PokerType;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HeGang [www.coder520.com]
 * @Date 2018/5/7 21:28
 * @Description 同花顺策略  同一花色的顺序排
 */
public class StraightFlushHandler implements TexasHandler {


    private static final PokerType POKER_TYPE = PokerType.STRAIGHT_FLUSH;

    private static class LazyHolder {
        private static final StraightFlushHandler INSTANCE = new StraightFlushHandler();
    }

    private StraightFlushHandler() {

    }

    public static final StraightFlushHandler getInstance() {
        return LazyHolder.INSTANCE;
    }

    /**
     * 最小的牌型
     */
    private static List<Poker> minimum = new ArrayList<Poker>() {
        //花色没关系
        {
            add(new Poker(ColorEnums.Spade, PokerEnums.Card_2));
            add(new Poker(ColorEnums.Spade, PokerEnums.Card_3));
            add(new Poker(ColorEnums.Spade, PokerEnums.Card_4));
            add(new Poker(ColorEnums.Spade, PokerEnums.Card_5));
            add(new Poker(ColorEnums.Spade, PokerEnums.Card_A));
        }
    };


    @Override
    public PokerType handle(HandPoker handPoker) {
        /**
         * 可以处理返回牌型
         */
        if (canHandle(handPoker)) {
            return POKER_TYPE;
        } else {
            //否则返回null
            return null;
        }
    }

    @Override
    public int compare(HandPoker handPoker, HandPoker handPokerTarget) {


        boolean flagO = isMinimum(handPoker.getPokerList());
        boolean flagT = isMinimum(handPokerTarget.getPokerList());

        if (flagO && flagT) {
            return 0;
        }

        if (flagO) {
            return -1;
        }

        if (flagT) {
            return 1;
        }

        return Integer.valueOf(handPoker.getTotalPoint()).compareTo(Integer.valueOf(handPokerTarget.getTotalPoint()));
    }


    /**
     * 判断是否可以处理
     *
     * @param handPoker
     * @return
     */
    private boolean canHandle(HandPoker handPoker) {


        List<Poker> pokerList = handPoker.getPokerList();

        ColorEnums pre = pokerList.get(0).getColor();

        int preValue = pre.getValue();

        int result;

        for (int i = 1; i < pokerList.size(); i++) {
            int currValue = pokerList.get(i).getColor().getValue();
            result = preValue ^ currValue;
            //有一个不同
            if (result != 0) {
                return false;
            }
        }

        //是否最小牌型
        if (isMinimum(pokerList)) {
            //设置为最小牌型
            return true;
        }

        //是否连续
        return isContinuous(pokerList);
    }


    /**
     * 是否最小牌型
     *
     * @param pokerList
     * @return
     */
    private boolean isMinimum(List<Poker> pokerList) {

        for (int i = 0; i < HandPoker.SIZE; i++) {

            if (pokerList.get(i).equals(minimum.get(i))) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    /**
     * 已排序的List，直接判断是否为连续
     *
     * @param pokerList
     * @return
     */
    private boolean isContinuous(List<Poker> pokerList) {


        int prePoint = pokerList.get(0).getCard().getPoint();
        for (int i = 1; i < pokerList.size(); i++) {
            int currPoint = pokerList.get(i).getCard().getPoint();
            //不等于1 则不连续
            if (currPoint - prePoint != 1) {
                return false;
            }
            prePoint = currPoint;

        }

        return true;
    }


}
