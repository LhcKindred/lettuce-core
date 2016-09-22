package com.lambdaworks.redis;

/**
 * Value object for a slice of data (offset/count).
 *
 * @author Mark Paluch
 * @since 4.2
 */
public class Limit {

    private static final Limit UNLIMITED = new Limit(null, null);

    private final Long offset;
    private final Long count;

    protected Limit(Long offset, Long count) {
        this.offset = offset;
        this.count = count;
    }

    /**
     *
     * @return an unlimited limit.
     */
    public static Limit unlimited() {
        return UNLIMITED;
    }

    /**
     * Creates a {@link Limit} given {@code offset} and {@code count}.
     *
     * @param offset
     * @param count
     * @return the {@link Limit}
     */
    public static Limit create(long offset, long count) {
        return new Limit(offset, count);
    }

    /**
     * @return the offset or {@literal -1} if unlimited.
     */
    public long getOffset() {

        if (offset != null) {
            return offset;
        }

        return -1;
    }

    /**
     * @return the count or {@literal -1} if unlimited.
     */
    public long getCount() {

        if (count != null) {
            return count;
        }

        return -1;
    }

    /**
     *
     * @return {@literal true} if the {@link Limit} contains a limitation.
     */
    public boolean isLimited() {
        return offset != null && count != null;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        if (isLimited()) {
            return sb.append(" [offset=").append(getOffset()).append(", count=").append(getCount()).append("]").toString();
        }

        return sb.append(" [unlimited]").toString();
    }
}
