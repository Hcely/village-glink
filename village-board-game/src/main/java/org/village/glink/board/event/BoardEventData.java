package org.village.glink.board.event;

import org.village.glink.board.instance.BoardInstance;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author yepeijie
 * @date 2026/7/20
 */
public class BoardEventData {
    protected final String name;
    protected final BoardInstance srcInstance;
    protected final BoardInstance dstInstance;
    protected final BoardEventAction action;
    protected final Set<String> flags;

    public BoardEventData(String name,
                          BoardInstance srcInstance,
                          BoardInstance dstInstance,
                          BoardEventAction action) {
        this.name = name;
        this.srcInstance = srcInstance;
        this.dstInstance = dstInstance;
        this.action = action;
        this.flags = new LinkedHashSet<>();
    }
}
