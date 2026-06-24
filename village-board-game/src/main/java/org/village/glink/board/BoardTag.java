package org.village.glink.board;

/**
 * @since 2026/6/24 20:11
 */
public class BoardTag extends BoardObject {
    private final String tag;
    private final String label;

    public BoardTag(String tag, String label) {
        this.tag = tag;
        this.label = label;
    }
}
