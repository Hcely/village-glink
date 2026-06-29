package org.village.glink.board.instance;

import lombok.Getter;
import org.village.glink.board.BoardContext;
import org.village.glink.board.BoardObject;
import org.village.glink.board.data.BoardAttributes;
import org.village.glink.board.data.BoardTag;
import org.village.glink.board.data.BoardTags;

/**
 * @since 2026/6/24 21:30
 */
public class BoardInstance extends BoardObject {
    @Getter
    private final String id;
    @Getter
    private long createTime;

    private final BoardAttributes attributes;

    private final BoardTags tags;

    public BoardInstance(BoardContext context, String id) {
        super(context);
        this.id = id;
        this.attributes = new BoardAttributes(this);
        this.tags = new BoardTags(this);
        this.createTime = context.currentTime();
    }

    @Override
    public BoardInstance copy() {
        BoardInstance object = (BoardInstance) super.copy();
        object.createTime = context.currentTime();
        return object;
    }

    public void addTag(BoardTag tag) {
        this.tags.add(tag);
    }
}
