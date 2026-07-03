package org.village.glink.board;

import lombok.Getter;
import org.village.glink.board.instance.BoardInstance;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * @since 2026/6/24 20:01
 */
public class BoardContext {
    @Getter
    private final long seed;
    @Getter
    private final Random random;
    private long time;
    private final Map<String, BoardInstance> instances;



    public BoardContext(long seed) {
        this.seed = seed;
        this.random = new Random(seed);
        this.instances = new LinkedHashMap<>();
    }

    public long currentTime() {
        return time;
    }

    public long increaseTime(long t) {
        this.time += t;
        return this.time;
    }
}
