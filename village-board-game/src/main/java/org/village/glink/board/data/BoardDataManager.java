package org.village.glink.board.data;

import org.village.glink.board.BoardType;
import org.village.glink.board.instance.BoardInstance;
import org.village.lite.common.util.CollUtil;
import org.village.lite.common.util.StrUtil;
import org.village.lite.common.util.collection.ReferenceMap;

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
    private final Map<BoardType, BoardDataMap> mgrMap;

    public BoardDataManager(BoardInstance instance) {
        this.instance = instance;
        this.mgrMap = new HashMap<>();
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

    private static class BoardDataMap {
        protected final BoardInstance instance;
        protected final Map<String, BoardData> dataMap;
        protected final Collection<BoardData> unDataColl;

        BoardDataMap(BoardInstance instance) {
            this.instance = instance;
            this.dataMap = ReferenceMap.newIgnoredCaseMap();
            this.unDataColl = CollUtil.unmodifiable(dataMap.values());
        }

        public boolean add(BoardData data) {
            final String name = data.getName();
            if (!dataMap.containsKey(name)) {
                BoardData e = data.copy();
                e.setInstance(instance);
                dataMap.put(name, e);
                return true;
            }
            return false;
        }

        public boolean contains(String name) {
            return StrUtil.isNotEmpty(name) && dataMap.containsKey(name);
        }

        public BoardData get(String name) {
            return dataMap.get(name);
        }

        public Collection<BoardData> all() {
            return unDataColl;
        }

        public BoardData remove(String name) {
            return dataMap.remove(name);
        }
    }
}
