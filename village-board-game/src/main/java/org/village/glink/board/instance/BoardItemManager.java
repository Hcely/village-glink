package org.village.glink.board.instance;

import org.village.glink.board.util.UnLinkedHashSet;
import org.village.lite.common.util.CollUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yepeijie
 * @date 2026/7/3
 */
public class BoardItemManager {
    private final BoardInstance instance;
    private final Map<String, UnLinkedHashSet<BoardItem>> itemMapByName;
    private final Map<String, BoardItem> itemMapById;
    private final Collection<BoardItem> items;

    public BoardItemManager(BoardInstance instance) {
        this.instance = instance;
        this.itemMapByName = new LinkedHashMap<>();
        this.itemMapById = new LinkedHashMap<>();
        this.items = CollUtil.unmodifiable(itemMapById.values());
    }

    public Collection<BoardItem> items() {
        return items;
    }

    public void add(BoardItem item) {
        final String name = item.getName();
        final String id = item.getId();
        boolean added = itemMapById.put(id, item) == null;
        if (added) {
            item.setParent(this.instance);
            _optSet(name).add(item);
        } else if (!item.isIdentify()) {
            UnLinkedHashSet<BoardItem> set = _optSet(name);
            if (CollUtil.isEmpty(set)) {
                item.setParent(this.instance);
                set.add(item);
            } else {
                BoardItem i = CollUtil.getFirst(set);
                i.addQuantity(item.getQuantity());
            }
        }
    }

    public BoardItem getItemById(String id) {
        return itemMapById.get(id);
    }

    public BoardItem getItemByName(String name) {
        UnLinkedHashSet<BoardItem> set = itemMapByName.get(name);
        return CollUtil.getFirst(set);
    }

    public Collection<BoardItem> getItemsByName(String name) {
        UnLinkedHashSet<BoardItem> set = itemMapByName.get(name);
        return set == null ? Collections.emptyList() : set.unmodifiableColl();
    }

    public BoardItem removeItemById(String id) {
        BoardItem item = itemMapById.remove(id);
        if (item != null) {
            item.setParent(null);
            UnLinkedHashSet<BoardItem> set = itemMapByName.get(item.getName());
            if (set != null) {
                set.remove(item);
            }
        }
        return item;
    }

    public Collection<BoardItem> removeItemByName(String name) {
        UnLinkedHashSet<BoardItem> set = itemMapByName.remove(name);
        if (CollUtil.isEmpty(set)) {
            return Collections.emptyList();
        }
        for (BoardItem item : set) {
            item.setParent(null);
            itemMapById.remove(item.getId());
        }
        return new ArrayList<>(set);
    }


    protected UnLinkedHashSet<BoardItem> _optSet(String name) {
        UnLinkedHashSet<BoardItem> set = itemMapByName.get(name);
        //noinspection Java8MapApi
        if (set == null) {
            set = new UnLinkedHashSet<>();
            itemMapByName.put(name, set);
        }
        return set;
    }

}
