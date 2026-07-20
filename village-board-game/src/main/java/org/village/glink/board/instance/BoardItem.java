package org.village.glink.board.instance;

import org.village.glink.board.BoardContext;
import org.village.glink.board.BoardType;

/**
 * @author yepeijie
 * @date 2026/7/3
 */
public class BoardItem extends BoardInstance {
    protected final boolean overlay;
    protected final ItemQuantity quantity;

    public BoardItem(BoardContext context,
                     String name,
                     String label) {
        super(context, BoardType.ITEM, "", name, label);
        this.overlay = true;
        this.quantity = new ItemQuantity();
    }

    public BoardItem(BoardContext context,
                     String id,
                     String name,
                     String label) {
        super(context, BoardType.ITEM, id, name, label);
        this.overlay = false;
        this.quantity = null;
    }
}
