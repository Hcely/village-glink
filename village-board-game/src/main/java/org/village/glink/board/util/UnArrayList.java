package org.village.glink.board.util;

import org.village.lite.common.util.CollUtil;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yepeijie
 * @date 2026/7/22
 */
public class UnArrayList<E> extends ArrayList<E> {

    @Serial
    private static final long serialVersionUID = -9141550179253702712L;

    private transient List<E> unmodifiable;


    public List<E> unmodifiableColl() {
        List<E> coll = unmodifiable;
        if (coll == null) {
            coll = CollUtil.unmodifiable(this);
            unmodifiable = coll;
        }
        return coll;
    }
}
