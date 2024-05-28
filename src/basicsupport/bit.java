package basicsupport;

public enum bit {
    one(1), zero(0);
    public final int value;

    private bit(int value) {
        this.value = value;
    }
}
