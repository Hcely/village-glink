package org.village.glink.board.data;

import lombok.Getter;
import org.village.glink.board.BoardContext;

/**
 * @since 2026/6/24 20:11
 */
@Getter
public class BoardTag extends BoardData {
    public BoardTag(BoardContext context, String name, String label) {
        super(context, name, label);
    }
}
