package org.village.glink.board.instance;

import org.jetbrains.annotations.NotNull;

/**
 * @author yepeijie
 * @date 2026/7/8
 */
public class ItemQuantity {
    private int baseQuantity = 0;
    private ExpiredQuantity header;

    public void increase(int v) {

    }

    public void increase(int v, long expiredTime) {

    }


    protected static class ExpiredQuantity implements Comparable<ExpiredQuantity> {
        protected final ItemQuantity q;
        protected final long expiredTime;
        protected int quantity = 0;
        protected ExpiredQuantity next;

        public ExpiredQuantity(ItemQuantity q, long expiredTime) {
            this.q = q;
            this.expiredTime = expiredTime;
        }

        @Override
        public int compareTo(@NotNull ItemQuantity.ExpiredQuantity o) {
            return Long.compare(o.expiredTime, expiredTime);
        }
    }
}
