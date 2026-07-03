package org.village.glink.board.data;

import lombok.Getter;
import lombok.SneakyThrows;
import org.village.glink.board.BoardObject;
import org.village.glink.board.instance.BoardInstance;
import org.village.lite.common.Copyable;
import org.village.lite.common.util.ClassUtil;
import org.village.lite.common.util.StrUtil;

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
    protected final int hashcode;

    public BoardData(String name, String label) {
        super(name, label);
        this.hashcode = StrUtil.hashcodeIgnoreCase(this.name);
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

    @Override
    public boolean equals(Object obj) {// NOSONAR
        if (obj == null) {
            return false;
        }
        Class<?> objType = obj.getClass();
        return ClassUtil.isAssignable(this.getClass(), objType) && eq(((BoardData) obj));
    }

    public boolean eq(BoardData d) {
        return eq(d.name);
    }

    public boolean eq(String name) {
        return StrUtil.equalsIgnoreCase(this.name, name);
    }

    @Override
    public int hashCode() {
        return hashcode;
    }


}
