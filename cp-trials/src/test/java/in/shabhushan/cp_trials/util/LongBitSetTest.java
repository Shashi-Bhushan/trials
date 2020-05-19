package in.shabhushan.cp_trials.util;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.LongStream;

import static org.junit.Assert.assertArrayEquals;

public class LongBitSetTest {
  @Test
  public void testLongBitSet() {
    LongBitSet set = new LongBitSet();

    set.add(2);
    set.add(5);
    set.add(3);

    assertArrayEquals(new long[]{2, 3, 5}, set.getAllElements());

    set.remove(3);
    set.add(4);

    assertArrayEquals(new long[]{2, 4, 5}, set.getAllElements());

    LongBitSet anotherSet = new LongBitSet();

    anotherSet.add(4);
    anotherSet.add(37);
    anotherSet.add(63);

    assertArrayEquals(new long[]{4, 37, 63}, anotherSet.getAllElements());

    assertArrayEquals(new long[]{2, 4, 5, 37, 63}, set.union(anotherSet).getAllElements());
    assertArrayEquals(new long[]{4}, set.intersection(anotherSet).getAllElements());
    assertArrayEquals(new long[]{2, 5}, set.difference(anotherSet).getAllElements());
    assertArrayEquals(LongStream.range(0, 64).filter(i -> !Set.of(2L, 4L, 5L).contains(i)).toArray(), set.complement().getAllElements());
  }

  @Test
  public void testHashSet() {
    Set<Long> set = new HashSet<>();

    set.add(2L);
    set.add(5L);
    set.add(3L);

    assertArrayEquals(new long[]{2, 3, 5}, set.stream().mapToLong(Long::longValue).toArray());

    set.remove(3L);
    set.add(4L);

    assertArrayEquals(new long[]{2, 4, 5}, set.stream().mapToLong(Long::longValue).toArray());

    Set<Long> anotherSet = new HashSet<>();

    anotherSet.add(4L);
    anotherSet.add(37L);
    anotherSet.add(63L);

    assertArrayEquals(new long[]{4, 37, 63}, anotherSet.stream().mapToLong(Long::longValue).toArray());

    HashSet<Long> a = new HashSet<>(set);
    a.addAll(anotherSet);
    assertArrayEquals(new long[]{2, 4, 5, 37, 63}, a.stream().mapToLong(Long::longValue).toArray());

    HashSet<Long> b = new HashSet<>(set);
    b.retainAll(anotherSet);
    assertArrayEquals(new long[]{4}, b.stream().mapToLong(Long::longValue).toArray());

    HashSet<Long> c = new HashSet<>(set);
    c.removeAll(anotherSet);
    assertArrayEquals(new long[]{2, 5}, c.stream().mapToLong(Long::longValue).toArray());

    // doesn't have an equivalent
    //assertArrayEquals(LongStream.range(0, 64).filter(i -> !Set.of(2L, 4L, 5L).contains(i)).toArray(), set.complement().stream().mapToLong(Long::longValue).toArray());
  }
}
