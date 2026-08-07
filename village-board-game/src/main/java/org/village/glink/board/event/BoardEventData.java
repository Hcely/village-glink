package org.village.glink.board.event;

import org.village.glink.board.instance.BoardInstance;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yepeijie
 * @date 2026/7/20
 */
public class BoardEventData {
    protected final String name;
    protected final BoardInstance srcInstance;
    protected final Map<String, BoardInstance> subSrcInstances;
    protected final Map<String, BoardInstance> dstInstances;
    protected final BoardEventAction action;
    protected final Set<String> flags;

    public BoardEventData(String name,
                          BoardInstance srcInstance,
                          BoardEventAction action) {
        this.name = name;
        this.srcInstance = srcInstance;
        this.subSrcInstances = new LinkedHashMap<>();
        this.dstInstances = new LinkedHashMap<>();
        this.action = action;
        this.flags = new LinkedHashSet<>();
    }
}
