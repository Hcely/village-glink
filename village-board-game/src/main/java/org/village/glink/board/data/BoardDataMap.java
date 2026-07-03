package org.village.glink.board.data;

import org.village.glink.board.instance.BoardInstance;
import org.village.lite.common.util.CollUtil;
import org.village.lite.common.util.StrUtil;
import org.village.lite.common.util.collection.ReferenceMap;

import java.util.Collection;
import java.util.Map;

/**
 * @author yepeijie
 * @date 2026/6/29
 */
public class BoardDataMap<D extends BoardData> {
    protected final BoardInstance instance;
    protected final Map<String, D> dataMap;
    protected final Collection<D> unDataColl;

    BoardDataMap(BoardInstance instance) {
        this.instance = instance;
        this.dataMap = ReferenceMap.newIgnoredCaseMap();
        this.unDataColl = CollUtil.unmodifiable(dataMap.values());
    }

    public boolean add(D data) {
        final String name = data.getName();
        if (!dataMap.containsKey(name)) {
            //noinspection unchecked
            D e = (D) data.copy();
            e.setInstance(instance);
            dataMap.put(name, e);
            return true;
        }
        return false;
    }

    public boolean contains(String name) {
        return StrUtil.isNotEmpty(name) && dataMap.containsKey(name);
    }

    public D get(String name) {
        return dataMap.get(name);
    }

    public Collection<D> all() {
        return unDataColl;
    }

    public D remove(String name) {
        return dataMap.remove(name);
    }
}
