package org.village.glink.board.instance;

import lombok.Getter;
import lombok.SneakyThrows;
import org.village.glink.board.BoardContext;
import org.village.glink.board.BoardObject;
import org.village.glink.board.data.BoardData;
import org.village.glink.board.data.BoardDataManager;

import java.util.Collection;

/**
 * @since 2026/6/24 21:30
 */
public class BoardInstance //NOSONAR
        extends BoardObject
        implements Cloneable {
    @Getter
    protected final BoardContext context;
    @Getter
    protected BoardInstance parent;
    @Getter
    private String id;
    @Getter
    protected long createTime;

    //
    protected final BoardDataManager dataMgr;

    public BoardInstance(BoardContext context,
                         String id,
                         String name,
                         String label) {
        super(name, label);
        this.context = context;
        this.id = id;
        this.dataMgr = new BoardDataManager(this);
        this.createTime = context.currentTime();
    }

    @SneakyThrows
    public BoardInstance copy(String id) {
        BoardInstance object = (BoardInstance) super.clone();
        object.id = id;
        object.createTime = context.currentTime();
        return object;
    }

    public <D extends BoardData> boolean containsData(Class<D> type, String name) {
        return dataMgr.contains(type, name);
    }

    public <D extends BoardData> D getData(Class<D> type, String name) {
        return dataMgr.get(type, name);
    }

    public <D extends BoardData> D removeData(Class<D> type, String name) {
        return dataMgr.remove(type, name);
    }

    public <D extends BoardData> boolean addData(D data) {
        return dataMgr.add(data);
    }

    public <D extends BoardData> boolean addData(Class<?> type, D data) {
        return dataMgr.add(type, data);
    }

    public <D extends BoardData> Collection<D> allData(Class<D> type) {
        return dataMgr.all(type);
    }

    @Override
    public int hashCode() {//NOSONAR
        return id.hashCode();
    }
}
