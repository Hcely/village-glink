package org.village.glink.board.event;

import org.village.glink.board.BoardContext;

/**
 * @author yepeijie
 * @date 2026/7/20
 */
public class BoardEvent {
    protected final BoardContext context;
    protected final long eventTime;
    protected final BoardEvent parent;
    protected final BoardEventData data;

    public BoardEvent(BoardContext context,
                      long eventTime,
                      BoardEvent parent,
                      BoardEventData data) {
        this.context = context;
        this.eventTime = eventTime;
        this.parent = parent;
        this.data = data;
    }
}
