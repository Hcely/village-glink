package org.village.glink.board.data;

import lombok.Getter;
import lombok.SneakyThrows;
import org.village.glink.board.BoardObject;
import org.village.glink.board.BoardType;
import org.village.glink.board.instance.BoardInstance;
import org.village.lite.common.Copyable;
import org.village.lite.common.util.ClassUtil;

/**
 * @author yepeijie
 * @date 2026/6/29
 */
public class BoardData //NOSONAR
        extends BoardObject
        implements Cloneable, Copyable {
    @Getter
    protected BoardInstance instance;
    protected long createTime;

    public BoardData(BoardType type, String name, String label) {
        super(type, name, label);
    }

    protected void setInstance(BoardInstance instance) {
        this.instance = instance;
        this.createTime = instance.getContext().currentTime();
    }

    @SneakyThrows
    @Override
    public BoardData copy() {
        BoardData data = (BoardData) super.clone();
        data.instance = null;
        return data;
    }
}
