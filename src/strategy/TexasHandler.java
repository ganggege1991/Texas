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


}
