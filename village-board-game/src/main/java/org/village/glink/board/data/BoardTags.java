package org.village.glink.board.data;

import org.village.glink.board.instance.BoardInstance;
import org.village.lite.common.util.CollUtil;
import org.village.lite.common.util.collection.ReferenceMap;

import java.util.Collection;
import java.util.Map;

/**
 * @since 2026/6/24 20:55
 */
public class BoardTags implements BoardDataMap<BoardTag> {
    protected final BoardInstance instance;
    protected final Map<String, BoardTag> tagMap;
    protected final Collection<BoardTag> unTagList;

    public BoardTags(BoardInstance instance) {
        this.instance = instance;
        this.tagMap = ReferenceMap.newIgnoredCaseMap();
        this.unTagList = CollUtil.unmodifiable(tagMap.values());
    }

    @Override
    public boolean add(BoardTag data) {
        if (!tagMap.containsKey(data.name)) {
            BoardTag e = (BoardTag) data.copy();
            e.setInstance(instance);
            tagMap.put(data.name, e);
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(String name) {
        return tagMap.containsKey(name);
    }

    @Override
    public BoardTag get(String name) {
        return tagMap.get(name);
    }

    @Override
    public Collection<BoardTag> all() {
        return unTagList;
    }

    @Override
    public BoardTag remove(String name) {
        return tagMap.remove(name);
    }
}
