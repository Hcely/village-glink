package org.village.glink.board.instance;

import lombok.Getter;
import org.village.glink.board.BoardContext;
import org.village.glink.board.BoardObject;
import org.village.glink.board.data.BoardAttribute;
import org.village.glink.board.data.BoardDataMap;
import org.village.glink.board.data.BoardState;
import org.village.glink.board.data.BoardTag;

/**
 * @since 2026/6/24 21:30
 */
public class BoardInstance extends BoardObject {
    protected final BoardContext context;
    @Getter
    private final String id;
    @Getter
    private long createTime;
    private final BoardDataMap<BoardAttribute> attributes;
    private final BoardDataMap<BoardState> states;
    private final BoardDataMap<BoardTag> tags;

    public BoardInstance(BoardContext context, String id, String name, String label) {
        super(name, label);
        this.context = context;
        this.id = id;
        this.attributes = new BoardDataMap<>(this);
        this.states = new BoardDataMap<>(this);
        this.tags = new BoardDataMap<>(this);
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

    @Override
    public int hashCode() {//NOSONAR
        return id.hashCode();
    }
}
