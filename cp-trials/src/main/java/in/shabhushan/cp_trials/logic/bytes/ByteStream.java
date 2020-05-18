package in.shabhushan.cp_trials.logic.bytes;

import java.io.IOException;

public class ByteStream {

    byte[] buf = new byte[800000000];
    int pos = 0;
    int count = 0;
    private Boolean writeMode;

    /**
     * Flip stream between write and read mode.
     * Before the first call of this method, the stream is neither in read nor write mode.
     * The first call of this method switches the stream to write mode.
     * After a switch to write mode, the stream is empty and bytes may be written.
     * After a switch to read mode, written bytes may be read.
     *
     * @throws IOException if an I/O error occurs
     */
    public void flip() throws IOException {
        if (writeMode == null || writeMode.equals(Boolean.FALSE)) {
            writeMode = Boolean.TRUE;
        } else {
            writeMode = Boolean.FALSE;
        }
    }

    /**
     * Write byte to stream.
     *
     * @param b byte
     * @throws IOException if stream is not in write mode or an I/O error occurs
     */
    public void write(byte b) throws IOException {
        if (writeMode == null || !writeMode)
            throw new IOException("err-write-mode-not-enabled");

        buf[count] = b;
        count++;
    }

    /**
     * Read byte from stream.
     *
     * @return -1 if stream is empty, byte value (0 to 255) otherwise
     * @throws IOException if stream is not in read mode or an I/O error occurs
     */
    public int read() throws IOException {
        if (writeMode == null || writeMode)
            throw new IOException("err-write-mode-enabled");
        else
            return (pos < count) ? (buf[pos++] & 0xff) : -1;
    }
}
