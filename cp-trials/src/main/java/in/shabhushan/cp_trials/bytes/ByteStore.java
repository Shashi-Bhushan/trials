package in.shabhushan.cp_trials.bytes;

import java.io.IOException;

/**
 * A {@code ByteStore} stores bytes.
 */
public class ByteStore {

  byte[] buf = new byte[100000000];
  int pos = 0;
  int count = 0;
  private Boolean writeMode;

  /**
   * Switch store to write or read mode. After switch to write mode, store is empty
   * and bytes may be written. After switch to read mode, written bytes may be read.
   * Initially, store is neither in read nor write mode.
   *
   * @param write switch to write mode or read mode?
   * @throws IOException if store is already in given mode or an I/O error occurs
   */
  public void reset(boolean write) throws IOException {
    if (writeMode != null && writeMode == write)
      throw new IOException("Already in read/write mode");
    writeMode = write;
  }

  /**
   * Copy {@code len} bytes from {@code buf} starting at offset {@code off} into this store.
   *
   * @param buf bytes
   * @param off offset
   * @param len length
   * @return 0 if {@code len} is 0, -1 if store is full or not in write mode, number of written bytes otherwise
   * @throws IOException if an I/O error occurs
   */
  public int write(byte[] buf, int off, int len) throws IOException {
    if (writeMode == null || !writeMode || count + len > this.buf.length)
      return -1;

    System.arraycopy(buf, off, this.buf, count, len);
    count += len;

    return len;
  }

  /**
   * Copy at most {@code len} bytes from this store into {@code buf} starting at offset {@code off}.
   *
   * @param buf bytes
   * @param off offset
   * @param len length
   * @return 0 if {@code len} is 0, -1 if store is empty or not in read mode, number of read bytes otherwise
   * @throws IOException if an I/O error occurs
   */
  public int read(byte[] buf, int off, int len) throws IOException {
    if (writeMode == null || writeMode)
      return -1;

    if (len <= 0) {
      return 0;
    } else if (pos >= count) {
      return -1;
    }

    int avail = count - pos;
    if (len > avail) {
      len = avail;
    }

    System.arraycopy(this.buf, pos, buf, off, len);
    pos += len;
    return len;
  }
}
