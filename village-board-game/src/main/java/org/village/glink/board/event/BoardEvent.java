package org.village.glink.board.event;

import org.village.glink.board.BoardWorld;

/**
 * @author yepeijie
 * @date 2026/7/20
 */
public class BoardEvent {
    protected final BoardWorld context;
    protected final long eventTime;
    protected final int eventIdx;
    protected final BoardEventData data;

    public BoardEvent(BoardWorld context,
                      long eventTime,
                      int eventIdx,
                      BoardEventData data) {
        this.context = context;
        this.eventTime = eventTime;
        this.eventIdx = eventIdx;
        this.data = data;
    }
}
