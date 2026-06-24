package org.village.glink.board;

import lombok.Getter;

/**
 * @since 2026/6/24 20:06
 */
@Getter
public class BoardObject {
    private final String id;
    private final BoardTags tags = new BoardTags();

    public BoardObject(String id) {
        this.id = id;
    }


}
