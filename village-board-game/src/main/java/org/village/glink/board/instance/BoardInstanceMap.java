package org.village.glink.board.instance;

import org.village.glink.board.util.UnLinkedHashSet;
import org.village.lite.common.util.CollUtil;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yepeijie
 * @date 2026/7/21
 */
public class BoardInstanceMap {
    private final Map<String, UnLinkedHashSet<BoardInstance>> instanceMapByName;
    private final Map<String, BoardInstance> instanceMapById;
    private final Collection<BoardInstance> instances;

    public BoardInstanceMap() {
        this.instanceMapByName = new LinkedHashMap<>();
        this.instanceMapById = new LinkedHashMap<>();
        this.instances = CollUtil.unmodifiable(instanceMapById.values());
    }

    public void add(BoardInstance instance) {
        if (!instance.isIdentify()) {
            return;
        }
        final String name = instance.getName();
        final String id = instance.getId();
        boolean added = instanceMapById.put(id, instance) == null;
        if (added) {
            _optSet(name).add(instance);
        }
    }

    protected UnLinkedHashSet<BoardInstance> _optSet(String name) {
        UnLinkedHashSet<BoardInstance> set = instanceMapByName.get(name);
        if (set == null) {
            set = new UnLinkedHashSet<>();
            instanceMapByName.put(name, set);
        }
        return set;
    }
}
