package org.village.glink.board.event;

import org.village.glink.board.BoardWorld;
import org.village.lite.common.util.collection.StackArray;

/**
 * @author yepeijie
 * @date 2026/7/28
 */
public class BoardEventStack {
    protected static final int MAX_SIZE = 1024;
    private final BoardWorld world;
    private final StackArray<BoardEvent> events;

    public BoardEventStack(BoardWorld world) {
        this.world = world;
        this.events = new StackArray<>(5, 5);
    }

    public BoardEvent add(BoardEventData data) {
        final int eventSize = events.size();
        if (eventSize >= MAX_SIZE) {
            throw new StackOverflowError();
        }
        final long eventTime = world.currentTime();
        final BoardEvent parent = events.last();
        BoardEvent event = new BoardEvent(world, eventTime, parent, data);
        events.add(event);
        return event;
    }

    public int size() {
        return events.size();
    }

    public BoardEvent last() {
        return events.last();
    }

    public BoardEvent poll() {
        return events.poll();
    }

    public BoardEvent get(int index) {
        return events.get(index);
    }
}

