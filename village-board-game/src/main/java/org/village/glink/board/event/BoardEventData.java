package org.village.glink.board.event;

/**
 * @author yepeijie
 * @date 2026/7/20
 */
public class BoardEventData {
    protected final String name;
    protected final BoardEventAction action;

    public BoardEventData(String name, BoardEventAction action) {
        this.name = name;
        this.action = action;
    }
}
