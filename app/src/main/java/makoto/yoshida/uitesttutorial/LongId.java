package makoto.yoshida.uitesttutorial;


import java.io.Serializable;

public class LongId implements Serializable {
    private long value;

    public LongId(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof LongId)) {
            return false;
        }

        LongId a = (LongId) obj;

        return a.value == value;
    }

    @Override
    public int hashCode() {
        return Long.valueOf(value)
                .hashCode();
    }

    @Override
    public String toString() {
        return Long.toString(value);
    }
}
