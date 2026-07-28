package org.village.glink.board.instance;

import lombok.Getter;
import org.springframework.util.Assert;
import org.village.glink.board.BoardContext;
import org.village.glink.board.BoardObject;
import org.village.glink.board.BoardType;
import org.village.glink.board.data.BoardData;
import org.village.glink.board.data.BoardDataManager;
import org.village.lite.common.util.StrUtil;

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
    protected final boolean identify;
    @Getter
    protected final long createTime;
    private final int hashcode;
    protected final BoardDataManager dataMgr;

    public BoardInstance(BoardContext context,
                         BoardType type,
                         String id,
                         String name,
                         String label) {
        this(context, type, true, id, name, label);
    }

    public BoardInstance(BoardContext context,
                         BoardType type,
                         boolean identify,
                         String id,
                         String name,
                         String label) {
        super(type, name, label);
        this.identify = identify;
        this.context = context;
        if (identify) {
            Assert.hasText(id, "id must not be empty");
            this.id = id;
        } else {
            this.id = type.name() + ":" + name;
        }
        this.dataMgr = new BoardDataManager(this);
        this.createTime = context.currentTime();
        this.hashcode = StrUtil.hashcodeIgnoreCase(this.id);
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

    void setParent(BoardInstance parent) {
        this.parent = parent;
    }

    @Override
    public int hashCode() {
        return hashcode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj instanceof BoardInstance i &&
                type == i.type && StrUtil.equalsIgnoreCase(id, i.id) && StrUtil.equalsIgnoreCase(name, i.name);
    }
}
