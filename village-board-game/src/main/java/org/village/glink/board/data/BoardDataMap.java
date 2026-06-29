package org.village.glink.board.data;

import java.util.Collection;

/**
 * @author yepeijie
 * @date 2026/6/29
 */
public interface BoardDataMap<D extends BoardData> {
    boolean add(D data);

    boolean contains(String name);

    D get(String name);

    Collection<D> all();

    D remove(String name);
}
