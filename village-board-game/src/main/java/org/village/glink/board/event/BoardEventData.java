package org.village.glink.board.event;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author yepeijie
 * @date 2026/7/20
 */
public class BoardEventData {
    protected final String name;
    protected final BoardEventAction action;
    protected final Set<String> flags;

    public BoardEventData(String name, BoardEventAction action) {
        this.name = name;
        this.action = action;
        this.flags = new LinkedHashSet<>();
    }
}
