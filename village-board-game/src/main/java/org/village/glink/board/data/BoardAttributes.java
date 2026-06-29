package org.village.glink.board.data;

import org.village.glink.board.instance.BoardInstance;
import org.village.lite.common.util.CollUtil;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yepeijie
 * @date 2026/6/29
 */
public class BoardAttributes implements BoardDataMap<BoardAttribute> {
    protected final BoardInstance instance;
    protected final Map<String, BoardAttribute> attributes;
    protected final Collection<BoardAttribute> unAttributes;

    public BoardAttributes(BoardInstance instance) {
        this.instance = instance;
        this.attributes = new LinkedHashMap<>();
        this.unAttributes = CollUtil.unmodifiable(attributes.values());
    }

    @Override
    public boolean add(BoardAttribute data) {
        if (!unAttributes.contains(data)) {
            BoardAttribute e = (BoardAttribute) data.copy();
            e.setInstance(this.instance);
            attributes.put(e.name, e);
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(String name) {
        return attributes.containsKey(name);
    }

    @Override
    public BoardAttribute get(String name) {
        return attributes.get(name);
    }

    @Override
    public Collection<BoardAttribute> all() {
        return unAttributes;
    }

    @Override
    public BoardAttribute remove(String name) {
        return attributes.remove(name);
    }
}
