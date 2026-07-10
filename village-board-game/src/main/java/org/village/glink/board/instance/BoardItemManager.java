package org.village.glink.board.instance;

import org.village.lite.common.util.CollUtil;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yepeijie
 * @date 2026/7/3
 */
public class BoardItemManager {
    private final BoardInstance holder;
    private final Map<String, BoardItem> itemMap;
    private final Collection<BoardItem> itemColl;

    public BoardItemManager(BoardInstance holder) {
        this.holder = holder;
        this.itemMap = new LinkedHashMap<>();
        this.itemColl = CollUtil.unmodifiable(itemMap.values());
    }
}
