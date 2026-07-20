package org.village.glink.board.data;

import org.village.glink.board.BoardType;
import org.village.glink.board.instance.BoardInstance;
import org.village.lite.common.util.CollUtil;
import org.village.lite.common.util.StrUtil;
import org.village.lite.common.util.collection.ReferenceMap;

import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

/**
 * @author yepeijie
 * @date 2026/7/3
 */
@SuppressWarnings("unchecked")
public class BoardDataManager {
    protected final BoardInstance instance;
    protected final Map<BoardType, BoardDataMap> mgrMap;

    public BoardDataManager(BoardInstance instance) {
        this.instance = instance;
        this.mgrMap = new EnumMap<>(BoardType.class);
    }

    public boolean contains(BoardType type, String name) {
        BoardDataMap m = this.mgrMap.get(type);
        return m != null && m.contains(name);
    }

    public <D extends BoardData> D get(BoardType type, String name) {
        BoardDataMap m = this.mgrMap.get(type);
        return m != null ? (D) m.get(name) : null;
    }

    public <D extends BoardData> D remove(BoardType type, String name) {
        BoardDataMap m = this.mgrMap.get(type);
        return m != null ? (D) m.remove(name) : null;
    }

    public <D extends BoardData> boolean add(D data) {
        if (data == null) {
            return false;
        } else {
            return mgrMap.computeIfAbsent(data.getType(), k -> new BoardDataMap(instance))
                    .add(data);
        }
    }


    public <D extends BoardData> Collection<D> all(BoardType type) {
        BoardDataMap m = this.mgrMap.get(type);
        return m != null ? (Collection<D>) m.all() : CollUtil.emptyList();
    }

    protected static class BoardDataMap {
        protected final BoardInstance instance;
        protected final Map<String, BoardData> map;
        protected final Collection<BoardData> coll;

        public BoardDataMap(BoardInstance instance) {
            this.instance = instance;
            this.map = ReferenceMap.newIgnoredCaseMap();
            this.coll = CollUtil.unmodifiable(map.values());
        }

        public boolean contains(String name) {
            return StrUtil.isNotEmpty(name) && map.containsKey(name);
        }

        public BoardData get(String name) {
            return map.get(name);
        }

        public Collection<BoardData> all() {
            return coll;
        }

        public boolean add(BoardData data) {
            final String name = data.getName();
            if (map.containsKey(name)) {
                return false;
            } else {
                BoardData e = data.copy();
                e.setInstance(instance);
                map.put(name, e);
                return true;
            }
        }

        public BoardData remove(String name) {
            return map.remove(name);
        }
    }
}
