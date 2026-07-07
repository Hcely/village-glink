package org.village.glink.board;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yepeijie
 * @date 2026/7/3
 */
@Getter
@AllArgsConstructor
public enum BoardType {
    TAG(Group.DATA),
    ATTRIBUTE(Group.DATA),
    STATE(Group.DATA),
    SKILL(Group.DATA),
    PERK(Group.DATA),
    //
    ITEM(Group.INSTANCE),
    CHARACTER(Group.INSTANCE),
    ;
    private final Group group;

    public boolean isData() {
        return group == Group.DATA;
    }

    public boolean isInstance() {
        return group == Group.INSTANCE;
    }

    enum Group {
        DATA,
        INSTANCE
    }
}
