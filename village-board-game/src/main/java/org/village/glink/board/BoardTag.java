package org.village.glink.board;

import lombok.Getter;
import org.village.lite.common.util.ObjUtil;
import org.village.lite.common.util.StrUtil;

/**
 * @since 2026/6/24 20:11
 */
@Getter
public class BoardTag extends BoardObject {
    protected final int hashcode;
    protected final String tag;
    protected final String label;
    protected final BoardObject flag;

    public BoardTag(String tag, String label) {
        this(tag, label, null);
    }

    public BoardTag(String tag, String label, BoardObject flag) {
        this.tag = StrUtil.defaultString(tag);
        this.label = StrUtil.defaultString(label);
        this.hashcode = StrUtil.hashcodeIgnoreCase(tag);
        this.flag = flag;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof BoardTag t && StrUtil.equalsIgnoreCase(tag, t.tag) && ObjUtil.equals(flag, t.flag);
    }

    @Override
    public int hashCode() {
        return hashcode;
    }
}
