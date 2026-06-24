package org.village.glink.board;

import lombok.Getter;

/**
 * @since 2026/6/24 21:30
 */
public class BoardInstance extends BoardObject {
    @Getter
    private final String id;
    private final BoardTags tags = new BoardTags();

    public BoardInstance(String id) {
        this.id = id;
    }

    public void addTag(BoardTag tag) {
        
    }

}
