package org.village.glink.board.data.skill;

import org.village.glink.board.BoardType;

/**
 * @author yepeijie
 * @date 2026/7/10
 */
public class BoardSkill extends BoardActiveData {
    public BoardSkill(String name, String label) {
        super(BoardType.SKILL, name, label);
    }
}
