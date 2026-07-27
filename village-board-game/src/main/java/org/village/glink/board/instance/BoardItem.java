package org.village.glink.board.instance;

import lombok.Getter;
import org.village.glink.board.BoardContext;
import org.village.glink.board.BoardType;

/**
 * @author yepeijie
 * @date 2026/7/3
 */
public class BoardItem extends BoardInstance {
    @Getter
    protected final ItemQuantity quantity;

    public BoardItem(BoardContext context,
                     String name,
                     String label) {
        super(context, BoardType.ITEM, false, null, name, label);
        this.quantity = new ItemQuantity();
    }

    public BoardItem(BoardContext context,
                     String id,
                     String name,
                     String label) {
        super(context, BoardType.ITEM, true, id, name, label);
        this.quantity = null;
    }
}
