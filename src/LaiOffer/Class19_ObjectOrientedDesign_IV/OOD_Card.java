package LaiOffer.Class19_ObjectOrientedDesign_IV;

public class OOD_Card {

    /**
     * I. Design a generic deck of cards
     *
     * Step 1. Figure out what classes we need to define and their relationships.
     * Assumption: standard 52-card set
     *
     * 牌 Card, 牌堆 Deck
     * Card: 1) Value 2) Suit
     * Deck: 1) List<Card>
     *
     * Step 2. Functionalities of main classes and their public interfaces.
     *
     * Card
     *  -    value() 牌面
     *  -    suit() 花色
     * Deck
     *  -    shuffle() 洗牌
     *  -    dealHand() 发牌
     *
     * II. How to extend the Card design to support BlackJack?
     * BlackJack score rules:
     *  -   1~10 scores its face value
     *  -   J, Q, and K score 10
     *  -   A scores either 1 or 11
     *
     * BlackJackHand extends Hand
     *  -   score: choose the best among all possible values
     *  -   isBlackJack: boolean
     *
     * III. How to simulate the BlackJack game?
     * 棋牌游戏类OOD
     *  - 对游戏道具和游戏状态的描述
     *  - 游戏规则和游戏流程
     *
     * game status s1 --> rules + actions --> s2 -> check end -> continue...
     *
     * 1. Understand the rules
     * 2. Capture game status
     * 3. Model game procedure
     *
     * How to describe the current game status
     *  -   Hand[]
     *  -   Deck
     *
     * Hand h1, Hand h2, Shuffled Deck
     * {}       {}       {c1, c2, ... c52}
     * deal cards （发牌）
     * {c1, c2} {c3, c4} {c5, c6, ... c52}
     * apply rules: if there is blackjack, declare winner
     * action: h1/h2 decides if continue, and if so call "addCard"
     * h1,              h2,                 Deck
     * {c1, c2, c5}     {c3, c4, c6}        {c7, c8, ...}
     *
     * apply rule: check if h1/h2 busted
     * action... -> translate to class methods
     * ...
     * apply rules to check/compare scores -> a class method
     */

}
