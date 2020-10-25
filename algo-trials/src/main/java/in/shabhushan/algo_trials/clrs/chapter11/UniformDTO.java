package in.shabhushan.algo_trials.clrs.chapter11;

public class UniformDTO {
  private int num;
  private static final int BASE = 0b1111111111111; // 2^13 - 1 = 8191

  public UniformDTO(int num) {
    this.num = num;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof UniformDTO)) return false;
    UniformDTO that = (UniformDTO) o;
    return num == that.num;
  }

  @Override
  public int hashCode() {
    return num & BASE; // mod base
  }
}
