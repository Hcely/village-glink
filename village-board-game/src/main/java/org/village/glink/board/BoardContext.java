package org.village.glink.board;

import lombok.Getter;
import org.village.glink.board.instance.BoardInstance;
import org.village.glink.board.util.UnLinkedHashSet;
import org.village.lite.common.util.CollUtil;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * @since 2026/6/24 20:01
 */
public class BoardContext {
    @Getter
    private final long seed;
    @Getter
    private final Random random;
    private long time;
    private final Map<String, UnLinkedHashSet<BoardInstance>> instanceMapByName;
    private final Map<String, BoardInstance> instanceMapById;
    private final Collection<BoardInstance> instances;

    public BoardContext(long seed) {
        this.seed = seed;
        this.random = new Random(seed);
        this.instanceMapByName = new LinkedHashMap<>();
        this.instanceMapById = new LinkedHashMap<>();
        this.instances = CollUtil.unmodifiable(instanceMapById.values());
    }

    public long currentTime() {
        return time;
    }

    public long increaseTime(long t) {
        this.time += t;
        return this.time;
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
