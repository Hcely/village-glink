package org.village.glink.board.data;

import org.village.glink.board.BoardType;
import org.village.glink.board.instance.BoardInstance;
import org.village.glink.board.util.BoardDataMap;
import org.village.lite.common.util.CollUtil;

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
    protected final Map<BoardType, BoardDataMap<BoardData>> mgrMap;

    public BoardDataManager(BoardInstance instance) {
        this.instance = instance;
        this.mgrMap = new EnumMap<>(BoardType.class);
    }

    public boolean contains(BoardType type, String name) {
        BoardDataMap<BoardData> m = this.mgrMap.get(type);
        return m != null && m.contains(name);
    }

    public <D extends BoardData> D get(BoardType type, String name) {
        BoardDataMap<BoardData> m = this.mgrMap.get(type);
        return m != null ? (D) m.get(name) : null;
    }

    public <D extends BoardData> D remove(BoardType type, String name) {
        BoardDataMap<BoardData> m = this.mgrMap.get(type);
        return m != null ? (D) m.remove(name) : null;
    }

    public <D extends BoardData> boolean add(D data) {
        if (data == null) {
            return false;
        } else {
            return mgrMap.computeIfAbsent(data.getType(), k -> new BoardDataMap<>(instance))
                    .add(data);
        }
    }


    public <D extends BoardData> Collection<D> all(BoardType type) {
        BoardDataMap<BoardData> m = this.mgrMap.get(type);
        return m != null ? (Collection<D>) m.all() : CollUtil.emptyList();
    }
}
