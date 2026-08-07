package org.village.glink.board.data.info;

import lombok.Getter;
import org.village.glink.board.BoardType;
import org.village.glink.board.data.BoardData;

/**
 * @since 2026/6/24 20:11
 */
@Getter
public class BoardTag extends BoardData {
    public BoardTag(String name, String label) {
        super(BoardType.TAG, name, label);
    }
}
