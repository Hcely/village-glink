package org.village.glink.board;

import lombok.Getter;
import lombok.SneakyThrows;
import org.village.lite.common.Copyable;
import org.village.lite.common.util.StrUtil;

/**
 * @since 2026/6/24 20:06
 */

@Getter
public class BoardObject implements Cloneable, Copyable {//NOSONAR
    protected final String name;
    protected final String label;

    public BoardObject(String name, String label) {
        this.name = StrUtil.defaultIfEmpty(name);
        this.label = StrUtil.defaultIfEmpty(label, this.name);
    }

    @Override
    @SneakyThrows
    public BoardObject copy() {
        return (BoardObject) super.clone();
    }
}
