package org.village.glink.board.instance;

import lombok.Getter;
import org.village.glink.board.BoardContext;
import org.village.glink.board.BoardObject;
import org.village.glink.board.BoardType;
import org.village.glink.board.data.BoardData;
import org.village.glink.board.data.BoardDataManager;

import java.util.Collection;

/**
 * @since 2026/6/24 21:30
 */
public class BoardInstance extends BoardObject {
    @Getter
    protected final BoardContext context;
    @Getter
    protected BoardInstance parent;
    @Getter
    protected final String id;
    @Getter
    protected final long createTime;

    protected final BoardDataManager dataMgr;

    public BoardInstance(BoardContext context,
                         BoardType type,
                         String id,
                         String name,
                         String label) {
        super(type, name, label);
        this.context = context;
        this.id = id;
        this.dataMgr = new BoardDataManager(this);
        this.createTime = context.currentTime();
    }

    public boolean containsData(BoardType type, String name) {
        return dataMgr.contains(type, name);
    }

    public <D extends BoardData> D getData(BoardType type, String name) {
        return dataMgr.get(type, name);
    }

    public <D extends BoardData> D removeData(BoardType type, String name) {
        return dataMgr.remove(type, name);
    }

    public <D extends BoardData> boolean addData(D data) {
        return dataMgr.add(data);
    }

    public <D extends BoardData> Collection<D> allData(BoardType type) {
        return dataMgr.all(type);
    }

    protected void setParent(BoardInstance parent) {
        this.parent = parent;
    }

    @Override
    public int hashCode() {//NOSONAR
        return id.hashCode();
    }
}
