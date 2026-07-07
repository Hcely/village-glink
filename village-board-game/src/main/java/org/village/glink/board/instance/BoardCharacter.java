package org.village.glink.board.instance;

import org.village.glink.board.BoardContext;
import org.village.glink.board.BoardType;

/**
 * @since 2026/7/7 22:29
 */
public class BoardCharacter extends BoardInstance {
    public BoardCharacter(BoardContext context, String id, String name, String label) {
        super(context, BoardType.CHARACTER, id, name, label);
    }
}
