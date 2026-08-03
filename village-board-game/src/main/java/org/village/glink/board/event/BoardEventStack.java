package org.village.glink.board.event;

import org.village.glink.board.BoardWorld;
import org.village.lite.common.util.collection.StackArray;

/**
 * @author yepeijie
 * @date 2026/7/28
 */
public class BoardEventStack {
    private final BoardWorld world;
    private final StackArray<BoardEvent> eventStack;

    public BoardEventStack(BoardWorld world) {
        this.world = world;
        this.eventStack = new StackArray<>(10, 5);
    }

    public BoardEvent add(BoardEventData data) {
        final int eventIdx = eventStack.size();
        final long eventTime = world.currentTime();
        BoardEvent event = new BoardEvent(world, eventTime, eventIdx, data);
        eventStack.add(event);
        return event;
    }

    public int eventSize() {
        return eventStack.size();
    }
}

