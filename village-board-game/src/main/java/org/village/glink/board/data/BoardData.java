package org.village.glink.board.data;

import lombok.SneakyThrows;
import org.village.glink.board.BoardObject;
import org.village.glink.board.BoardType;
import org.village.lite.common.Copyable;
import org.village.lite.common.util.StrUtil;

/**
 * @author yepeijie
 * @date 2026/6/29
 */
public class BoardData //NOSONAR
        extends BoardObject
        implements Cloneable, Copyable {
    private final int hashcode;

    public BoardData(BoardType type, String name, String label) {
        super(type, name, label);
        this.hashcode = StrUtil.hashcodeIgnoreCase(name);
    }

    @SneakyThrows
    @Override
    public BoardData copy() {
        return (BoardData) super.clone();
    }

    public boolean eq(BoardObject d) {
        return eq(d.getName());
    }

    public boolean eq(String name) {
        return StrUtil.equalsIgnoreCase(this.name, name);
    }

    @Override
    public int hashCode() {
        return hashcode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj instanceof BoardData i && type == i.type && StrUtil.equalsIgnoreCase(name, i.name);
    }
}
