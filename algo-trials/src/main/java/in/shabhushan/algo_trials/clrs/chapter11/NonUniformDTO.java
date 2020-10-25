package in.shabhushan.algo_trials.clrs.chapter11;

public class NonUniformDTO {
  private int num;
  private static final int BASE = 0b1111111111111; // 2^13 - 1 = 8191

  public NonUniformDTO(int num) {
    this.num = num;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof NonUniformDTO)) return false;
    NonUniformDTO that = (NonUniformDTO) o;
    return num == that.num;
  }

  @Override
  public int hashCode() {
    return BASE;
  }
}
