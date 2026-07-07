package org.village.glink.board.data;

import lombok.Getter;
import org.village.glink.board.BoardType;
import org.village.lite.common.util.num.NumUtil;

import java.math.BigDecimal;

/**
 * @author yepeijie
 * @date 2026/6/29
 */
@Getter
public class BoardAttribute extends BoardData {
    protected BigDecimal value;

    public BoardAttribute(String name, String label) {
        this(name, label, BigDecimal.ZERO);
    }

    public BoardAttribute(String name, String label, Number value) {
        super(BoardType.ATTRIBUTE, name, label);
        this.value = NumUtil.of(value);
    }
}
