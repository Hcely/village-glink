package org.village.glink.board;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

/**
 * @since 2026/6/24 20:01
 */
public class BoardContext {
    @Getter
    private final long seed;
    @Getter
    private final Random random;
    @Setter
    private long time;

    private

    public BoardContext(long seed) {
        this.seed = seed;
        this.random = new Random(seed);
    }

    public long currentTime() {
        return time;
    }

    public void increaseTime(long time) {
        this.time += time;
    }
}
