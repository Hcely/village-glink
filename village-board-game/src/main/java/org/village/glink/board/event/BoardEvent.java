package org.village.glink.board.event;

import lombok.Getter;
import org.village.glink.board.BoardWorld;

/**
 * @author yepeijie
 * @date 2026/7/20
 */
@Getter
public class BoardEvent {
    protected final BoardWorld world;
    protected final long eventTime;
    protected final BoardEvent parent;
    protected final BoardEventData data;

    public BoardEvent(BoardWorld world,
                      long eventTime,
                      BoardEvent parent,
                      BoardEventData data) {
        this.world = world;
        this.eventTime = eventTime;
        this.parent = parent;
        this.data = data;
    }
}
