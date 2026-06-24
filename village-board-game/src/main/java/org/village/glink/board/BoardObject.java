package org.village.glink.board;

import lombok.Getter;
import lombok.SneakyThrows;
import org.village.lite.common.Copyable;

/**
 * @since 2026/6/24 20:06
 */

public class BoardObject implements Cloneable, Copyable {
    @Getter
    private long createTime = System.currentTimeMillis();

    @Override
    @SneakyThrows
    public Object copy() {
        BoardObject object = (BoardObject) super.clone();
        object.createTime = System.currentTimeMillis();
        return object;
    }
}
