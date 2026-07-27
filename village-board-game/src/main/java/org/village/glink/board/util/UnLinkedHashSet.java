package org.village.glink.board.util;

import org.village.lite.common.util.CollUtil;

import java.io.Serial;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author yepeijie
 * @date 2026/7/22
 */
public class UnLinkedHashSet<E> extends LinkedHashSet<E> {
    @Serial
    private static final long serialVersionUID = 4398948989420396971L;
    private transient Set<E> unmodifiable;



    public Set<E> unmodifiableColl() {
        Set<E> coll = unmodifiable;
        if (coll == null) {
            coll = CollUtil.unmodifiable(this);
            unmodifiable = coll;
        }
        return coll;
    }
}
