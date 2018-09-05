package strategy;

import entity.HandPoker;
import enums.PokerType;

/**
 * @Author HeGang [www.coder520.com]
 * @Date 2018/5/7 21:28
 * @Description TODO
 */
public interface TexasHandler {


    /**
     * 处理设置
     *
     * @param handPoker
     * @return
     */
    PokerType handle(HandPoker handPoker);

    /**
     * 比较两个牌型
     * @param handPoker
     * @param handPokerTarget
     * @return
     */
    int compare(HandPoker handPoker,HandPoker handPokerTarget);


}
