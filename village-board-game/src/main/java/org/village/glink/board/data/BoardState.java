package org.village.glink.board.data;

import org.village.glink.board.BoardType;
import org.village.glink.board.instance.BoardInstance;

/**
 * @author yepeijie
 * @date 2026/7/3
 */
public class BoardState extends BoardData {
    protected final BoardInstance provider;
    protected final Object identifyFlag;

    public BoardState(String name,
                      String label,
                      BoardInstance provider) {
        this(name, label, provider, null);
    }

    public BoardState(String name,
                      String label,
                      BoardInstance provider,
                      Object identifyFlag) {
        super(BoardType.STATE, name, label);
        this.identifyFlag = identifyFlag;
        this.provider = provider;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
