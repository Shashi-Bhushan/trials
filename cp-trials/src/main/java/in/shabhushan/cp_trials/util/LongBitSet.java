package in.shabhushan.cp_trials.util;

import java.util.stream.LongStream;

public class LongBitSet {
  private long backingField;

  private LongBitSet(long backingField) {
    this.backingField = backingField;
  }

  public LongBitSet() {
    backingField = 0L;
  }

  public long[] getAllElements() {
    return LongStream.range(0, 64).filter(i -> (backingField & (1L << i)) != 0).toArray();
  }

  public void add(int x) {
    // or sets the bit irrespective of if it's 0 or 1
    backingField = backingField | (1L << x);
  }

  public boolean contains(int x) {
    // and set the bit to 0
    return (backingField & (1L << x)) != 0;
  }

  public void remove(int x) {
    // negate bit, then add
    backingField = backingField & ~(1L << x);
  }

  public LongBitSet intersection(LongBitSet set) {
    return new LongBitSet(this.backingField & set.backingField);
  }

  public LongBitSet union(LongBitSet set) {
    return new LongBitSet(this.backingField | set.backingField);
  }

  public LongBitSet complement() {
    return new LongBitSet(~this.backingField);
  }

  public LongBitSet difference(LongBitSet set) {
    return new LongBitSet(this.backingField & ~(set.backingField));
  }
}
