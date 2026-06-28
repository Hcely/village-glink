package org.village.glink.board;

import org.village.lite.common.util.CollUtil;
import org.village.lite.common.util.collection.DynamicArray;
import org.village.lite.common.util.collection.ReferenceMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @since 2026/6/24 20:55
 */
public class BoardTags {
    protected final List<BoardTag> tagList = new ArrayList<>();
    protected final Collection<BoardTag> unTagList = CollUtil.unmodifiableList(tagList);
    protected final Map<String, DynamicArray<BoardTag>> tagMap = ReferenceMap.newIgnoredCaseMap();

    public void addTag(BoardTag tag) {
        DynamicArray<BoardTag> list = tagMap.get(tag.tag);
        if (CollUtil.isEmpty(list)) {
            list = new DynamicArray<>(1, 1);
            tagMap.put(tag.tag, list);
        }
        if (!list.contains(tag)) {
            list.add(tag);
            tagList.add(tag);
        }
    }

    public boolean containsTag(String tag) {
        return tagMap.containsKey(tag);
    }

    public BoardTag getTag(String tag) {
        DynamicArray<BoardTag> list = tagMap.get(tag);
        return CollUtil.getFirst(list);
    }

    public Collection<BoardTag> getTags(String tag) {
        DynamicArray<BoardTag> list = tagMap.get(tag);
        if (list == null) {
            return CollUtil.emptyList();
        } else {
            return list.unmodifiableArray();
        }
    }

    public Collection<BoardTag> allTags() {
        return unTagList;
    }
}
