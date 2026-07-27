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
public class BoardInstanceMap<I extends BoardInstance> {
    private final BoardInstance instance;
    private final Map<String, UnLinkedHashSet<I>> instanceMapByName;
    private final Map<String, I> instanceMapById;
    private final Collection<I> coll;

    public BoardInstanceMap(BoardInstance instance) {
        this.instance = instance;
        this.instanceMapByName = new LinkedHashMap<>();
        this.instanceMapById = new LinkedHashMap<>();
        this.coll = CollUtil.unmodifiable(instanceMapById.values());
    }

    public void add(I instance) {
        final String name = instance.getName();
        final String id = instance.getId();
        boolean added = instanceMapById.put(id, instance) == null;
        if (added) {
            instance.setParent(this.instance);
            _optSet(name).add(instance);
        } else if (!instance.isIdentify()) {
            UnLinkedHashSet<I> set = _optSet(name);
            if (CollUtil.isEmpty(set)) {
                instance.setParent(this.instance);
                set.add(instance);
            } else if (instance instanceof BoardItem item) {
                BoardItem i = (BoardItem) set.getFirst();

            }
        }
    }

    protected UnLinkedHashSet<I> _getSet(String name) {
        return instanceMapByName.get(name);
    }

    protected UnLinkedHashSet<I> _optSet(String name) {
        UnLinkedHashSet<I> set = instanceMapByName.get(name);
        if (set == null) {
            set = new UnLinkedHashSet<>();
            instanceMapByName.put(name, set);
        }
        return set;
    }
}
