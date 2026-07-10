package org.village.glink.board.instance;

import org.village.glink.board.BoardObject;
import org.village.lite.common.util.CollUtil;
import org.village.lite.common.util.StrUtil;
import org.village.lite.common.util.collection.ReferenceMap;

import java.util.Collection;
import java.util.Map;

/**
 * @author yepeijie
 * @date 2026/7/10
 */
public class BoardObjectManager<D extends BoardObject> {
    protected final BoardInstance instance;
    protected final Map<String, D> map;
    protected final Collection<D> coll;

    public BoardObjectManager(BoardInstance instance) {
        this.instance = instance;
        this.map = ReferenceMap.newIgnoredCaseMap();
        this.coll = CollUtil.unmodifiable(map.values());
    }

    public boolean contains(String name) {
        return StrUtil.isNotEmpty(name) && map.containsKey(name);
    }

    public D get(String name) {
        return map.get(name);
    }

    public Collection<D> all() {
        return coll;
    }
}
