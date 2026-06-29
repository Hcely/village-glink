package org.village.glink.board;

import lombok.SneakyThrows;
import org.village.lite.common.Copyable;

/**
 * @since 2026/6/24 20:06
 */

public class BoardObject implements Cloneable, Copyable {//NOSONAR
    protected final BoardContext context;

    public BoardObject(BoardContext context) {
        this.context = context;
    }


    @Override
    @SneakyThrows
    public BoardObject copy() {
        return (BoardObject) super.clone();
    }
}
