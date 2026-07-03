package org.village.glink.board.data;

import org.village.glink.board.instance.BoardInstance;
import org.village.lite.common.util.CollUtil;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yepeijie
 * @date 2026/7/3
 */
@SuppressWarnings("unchecked")
public class BoardDataManager {
    private final BoardInstance instance;
    private final Map<Class<?>, BoardDataMap<?>> mgrMap;

    public BoardDataManager(BoardInstance instance) {
        this.instance = instance;
        this.mgrMap = new HashMap<>();
    }

    public <D extends BoardData> BoardDataMap<D> map(Class<D> type) {
        return (BoardDataMap<D>) this.mgrMap.computeIfAbsent(type, k -> new BoardDataMap<>(instance));
    }

    public <D extends BoardData> boolean contains(Class<D> type, String name) {
        BoardDataMap<D> m = (BoardDataMap<D>) this.mgrMap.get(type);
        return m != null && m.contains(name);
    }

    public <D extends BoardData> D get(Class<D> type, String name) {
        BoardDataMap<D> m = (BoardDataMap<D>) this.mgrMap.get(type);
        return m != null ? m.get(name) : null;
    }

    public <D extends BoardData> D remove(Class<D> type, String name) {
        BoardDataMap<D> m = (BoardDataMap<D>) this.mgrMap.get(type);
        return m != null ? m.remove(name) : null;
    }

    public <D extends BoardData> boolean add(D data) {
        if (data == null) {
            return false;
        } else {
            return map((Class<D>) data.getClass()).add(data);
        }
    }

    public <D extends BoardData> Collection<D> all(Class<D> type) {
        BoardDataMap<D> m = (BoardDataMap<D>) this.mgrMap.get(type);
        return m != null ? m.all() : CollUtil.emptyList();
    }
}
