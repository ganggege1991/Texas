package strategy;

import entity.HandPoker;
import enums.PokerType;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HeGang [www.coder520.com]
 * @Date 2018/5/8 0:55
 * @Description TODO
 */
public class HandlerManager {

    public static List<TexasHandler> handlerList = new ArrayList<>();

    static {
        handlerList.add(StraightFlushHandler.getInstance());
        handlerList.add(FourBoomHandler.getInstance());
    }

    public static TexasHandler handlePoker(HandPoker handPoker) {

        PokerType pokerType = null;

        for (TexasHandler th : handlerList) {
            pokerType = th.handle(handPoker);
            if (pokerType != null) {
                handPoker.setPokerType(pokerType);
                return th;
            }
        }

        return null;
    }
}
