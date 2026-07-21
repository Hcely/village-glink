package org.village.glink.board.instance;

import java.util.Map;

/**
 * @author yepeijie
 * @date 2026/7/3
 */
public class BoardItemManager {
    protected final BoardInstance instance;
    protected Map<String, BoardItem> items;

    public BoardItemManager(BoardInstance instance) {
        this.instance = instance;

    }

}
