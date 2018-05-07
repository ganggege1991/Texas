package entity;

import com.sun.istack.internal.NotNull;
import enums.PokerType;
import strategy.HandlerManager;

import java.util.Collections;
import java.util.List;

/**
 * @Author HeGang [www.coder520.com]
 * @Date 2018/5/7 21:30
 * @Description 手牌
 */
public class HandPoker implements Comparable<HandPoker> {


    public static final int SIZE = 5;

    private List<Poker> pokerList;

    private PokerType pokerType;

    /**
     * 总积分
     */
    private int totalPoint;

    public HandPoker(@NotNull List<Poker> pokerList) {
        if (pokerList.size() != SIZE) {
            throw new RuntimeException("手牌数量错误");
        }
        this.pokerList = pokerList;
        //排序
        Collections.sort(pokerList);
        //牌型积分
        initTotalPoint();
        //处理
        HandlerManager.handlePoker(this);
    }

    public List<Poker> getPokerList() {
        return pokerList;
    }

    private void initTotalPoint() {

        pokerList.forEach(poker -> {
            this.totalPoint += poker.getCard().getPoint();
        });
    }

    public void setPokerList(List<Poker> pokerList) {
        this.pokerList = pokerList;
    }


    public PokerType getPokerType() {
        return pokerType;
    }

    public void setPokerType(PokerType pokerType) {
        this.pokerType = pokerType;
    }

    public int getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(int totalPoint) {
        this.totalPoint = totalPoint;
    }

    @Override
    public int compareTo(HandPoker o) {

        if (o == this) {
            return 0;
        }

        int typeResult = this.pokerType.compareTo(o.getPokerType());
        if (typeResult == 0) {
            //牌型相同比点数
            return Integer.valueOf(this.totalPoint).compareTo(Integer.valueOf(o.totalPoint));
        }
        //否则比类型
        return typeResult;
    }


}
