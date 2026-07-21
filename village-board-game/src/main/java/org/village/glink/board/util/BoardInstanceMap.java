package org.village.glink.board.util;

import org.village.glink.board.instance.BoardInstance;
import org.village.lite.common.util.CollUtil;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author yepeijie
 * @date 2026/7/21
 */
public class BoardInstanceMap<I extends BoardInstance> {
    private final Map<String, Set<I>> instanceMapByName;
    private final Map<String, I> instanceMapById;
    private final Collection<I> coll;

    public BoardInstanceMap() {
        this.instanceMapByName = new LinkedHashMap<>();
        this.instanceMapById = new LinkedHashMap<>();
        this.coll = CollUtil.unmodifiable(instanceMapById.values());
    }

    public void add(I instance) {
        
    }
}
