package org.village.glink.board.data;

import lombok.Getter;
import org.village.glink.board.BoardContext;
import org.village.glink.board.BoardObject;
import org.village.glink.board.instance.BoardInstance;
import org.village.lite.common.util.ClassUtil;
import org.village.lite.common.util.StrUtil;

/**
 * @author yepeijie
 * @date 2026/6/29
 */
public class BoardData extends BoardObject {
    @Getter
    protected BoardInstance instance;
    protected final String name;
    protected final String label;
    protected final int hashcode;

    public BoardData(BoardContext context, String name, String label) {
        super(context);
        this.name = StrUtil.defaultIfEmpty(name);
        this.label = StrUtil.defaultIfEmpty(label, this.name);
        this.hashcode = StrUtil.hashcodeIgnoreCase(this.name);
    }

    protected void setInstance(BoardInstance instance) {
        this.instance = instance;
    }

    @Override
    public BoardData copy() {
        BoardData data = (BoardData) super.copy();
        data.setInstance(null);
        return data;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Class<?> objType = obj.getClass();
        return ClassUtil.isAssignable(this.getClass(), objType) && eq(((BoardData) obj).name);
    }

    public boolean eq(String name) {
        return StrUtil.equalsIgnoreCase(this.name, name);
    }

    @Override
    public int hashCode() {
        return hashcode;
    }
}
