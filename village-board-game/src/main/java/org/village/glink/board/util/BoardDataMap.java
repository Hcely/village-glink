package org.village.glink.board.util;

import org.village.glink.board.data.BoardData;
import org.village.glink.board.instance.BoardInstance;
import org.village.lite.common.util.CollUtil;
import org.village.lite.common.util.StrUtil;
import org.village.lite.common.util.collection.ReferenceMap;

import java.util.Collection;
import java.util.Map;

@SuppressWarnings("unchecked")
public class BoardDataMap<D extends BoardData> {
    protected final BoardInstance instance;
    protected final Map<String, D> map;
    protected final Collection<D> coll;

    public BoardDataMap(BoardInstance instance) {
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

    public boolean add(D data) {
        final String name = data.getName();
        if (map.containsKey(name)) {
            return false;
        } else {
            D e = (D) data.copy();
            e.setInstance(instance);
            map.put(name, e);
            return true;
        }
    }

    public BoardData remove(String name) {
        return map.remove(name);
    }
}