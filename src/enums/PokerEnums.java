package enums;

/**
 * Created by HeGang 16:59 2018/5/7.
 */
public enum PokerEnums {


    Card_2('2'),
    Card_3('3'),
    Card_4('4'),
    Card_5('5'),
    Card_6('6'),
    Card_7('7'),
    Card_8('8'),
    Card_9('9'),
    Card_10('a'),
    Card_J('j'),
    Card_Q('q'),
    Card_K('k'),
    Card_A('a'),;

    private char card;


    PokerEnums(char card) {
        this.card = card;
    }
}
