package org.village.glink.board;

import lombok.Getter;
import org.village.lite.common.util.StrUtil;

/**
 * @since 2026/6/24 20:06
 */

@Getter
public class BoardObject {
    protected final BoardType type;
    protected final String name;
    protected final String label;
    private final int hashcode;

    public BoardObject(BoardType type, String name, String label) {
        this.type = type;
        this.name = StrUtil.defaultIfEmpty(name);
        this.label = StrUtil.defaultIfEmpty(label, this.name);
        this.hashcode = StrUtil.hashcodeIgnoreCase(this.name);
    }

    @Override
    public int hashCode() {
        return hashcode;
    }
}
