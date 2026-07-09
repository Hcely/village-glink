package org.village.glink.board.instance;

import lombok.Getter;
import org.village.lite.common.util.ObjUtil;

/**
 * @author yepeijie
 * @date 2026/7/8
 */
public class ItemQuantity {
    private PriorityQuantityNode head;
    @Getter
    private long basicQuantity = 0;
    @Getter
    private long quantity;

    public PriorityQuantityNode priorityNode() {
        return head;
    }

    public long getPriorityQuantity() {
        return quantity - basicQuantity;
    }

    public boolean add(long v) {
        if (v > 0) {
            basicQuantity += v;
            _add(v);
            return true;
        } else if (v < 0) {
            if (quantity + v < 0) {
                return false;
            }
            for (PriorityQuantityNode node = head; node != null && v < 0; node = node.next) {
                v = node._add(v);
            }
            if (v < 0) {
                basicQuantity += v;
                _add(v);
            }
        }
        return true;
    }

    public boolean add(long v, long priority) {
        return add(v, priority, null);
    }

    public boolean add(long v, long priority, Object flag) {
        if (v > 0) {
            PriorityQuantityNode prev = null;
            PriorityQuantityNode node = head;
            for (; node != null; prev = node, node = node.next) {
                if (node.priority == priority && ObjUtil.equals(node.flag, flag)) {
                    node._add(v);
                    return true;
                } else if (node.priority > priority) {
                    break;
                }
            }
            final PriorityQuantityNode newNode = new PriorityQuantityNode(this, priority, flag);
            _addNode(newNode, prev, node);
            newNode._add(v);
            return true;
        } else {
            return add(v);
        }
    }

    private void _addNode(PriorityQuantityNode newNode,
                          PriorityQuantityNode prev,
                          PriorityQuantityNode next) {
        newNode.next = next;
        newNode.prev = prev;
        if (prev != null) {
            prev.next = newNode;
        } else {
            head = newNode;
        }
        if (next != null) {
            next.prev = newNode;
        }
    }

    private void _removeNode(PriorityQuantityNode node) {
        final PriorityQuantityNode prev = node.prev;
        final PriorityQuantityNode next = node.next;
        if (prev != null) {
            prev.next = next;
        } else {
            head = next;
        }
        if (next != null) {
            next.prev = prev;
        }
    }

    private void _add(long v) {
        quantity += v;
    }

    public static class PriorityQuantityNode {
        protected final ItemQuantity parent;
        @Getter
        protected final long priority;
        @Getter
        protected final Object flag;
        @Getter
        protected long quantity;
        @Getter
        private PriorityQuantityNode prev;
        @Getter
        private PriorityQuantityNode next;

        private PriorityQuantityNode(ItemQuantity parent,
                                     long priority,
                                     Object flag) {
            this.parent = parent;
            this.priority = priority;
            this.flag = flag;
            this.quantity = 0;
        }

        public boolean add(long v) {
            if (v < 0 && quantity + v < 0) {
                return false;
            }
            _add(v);
            return true;
        }

        public void remove() {
            final long v = quantity;
            if (v != 0) {
                parent._add(-v);
                quantity = 0;
            }
            parent._removeNode(this);
        }

        private long _add(long v) {
            if (v > 0) {
                parent._add(v);
                quantity += v;
                return 0;
            } else if (v < 0) {
                long sub = Math.min(quantity, -v);
                parent._add(-sub);
                quantity -= sub;
                if (quantity <= 0) {
                    remove();
                }
                return v + sub;
            }
            return 0;
        }
    }
}
