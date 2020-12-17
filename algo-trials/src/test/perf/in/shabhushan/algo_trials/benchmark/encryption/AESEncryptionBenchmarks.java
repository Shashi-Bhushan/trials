package in.shabhushan.algo_trials.benchmark.encryption;

import org.openjdk.jmh.annotations.*;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Warmup(iterations = 3, time = 2, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 2, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Thread)
@BenchmarkMode(Mode.Throughput)
public class AESEncryptionBenchmarks {
  /*
  private static final int SHORT_STRING_LENGTH = 1024;
  private static final int LONG_STRING_LENGTH = 6553700;

  private static final byte[] AES_PASSWORD = "random-32char-rek-for-encryption".getBytes(StandardCharsets.UTF_8);

  private static final String AES_ECB_ALGORITHM = "AES/ECB/PKCS5PADDING";
  private static final String AES_CBC_ALGORITHM = "AES/CBC/PKCS5PADDING";

  private Random random;
  private byte[] shortMessage;
  private byte[] longMessage;

  private Cipher aesEcbEncryptionCipher;
  private Cipher aesCbcEncryptionCipher;

  private Cipher aesEcbDecryptionCipher;
  private Cipher aesCbcDecryptionCipher;

  @Setup
  public void setup() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
    random = new Random(System.currentTimeMillis());
    shortMessage = getRandomMessage(SHORT_STRING_LENGTH).getBytes(StandardCharsets.UTF_8);
    longMessage = getRandomMessage(LONG_STRING_LENGTH).getBytes(StandardCharsets.UTF_8);

    // ECB Mode Setup
    aesEcbEncryptionCipher = Cipher.getInstance(AES_ECB_ALGORITHM);
    aesEcbEncryptionCipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(AES_PASSWORD, "AES"));

    aesEcbDecryptionCipher = Cipher.getInstance(AES_ECB_ALGORITHM);
    aesEcbDecryptionCipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(AES_PASSWORD, "AES"));


    // CBC Mode Decryption
    byte[] iv = new byte[128/8];
    new SecureRandom().nextBytes(iv);
    IvParameterSpec ivspec = new IvParameterSpec(iv);

    aesCbcEncryptionCipher = Cipher.getInstance(AES_CBC_ALGORITHM);
    aesCbcEncryptionCipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(AES_PASSWORD, "AES"), ivspec);

    aesCbcDecryptionCipher = Cipher.getInstance(AES_CBC_ALGORITHM);
    aesCbcDecryptionCipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(AES_PASSWORD, "AES"), ivspec);
  }

  @Benchmark
  public void testAESEncryption_ECB_shortString() throws BadPaddingException, IllegalBlockSizeException {
    byte[] encryptedMessage = aesEcbEncryptionCipher.doFinal(shortMessage);

    byte[] decryptedMessage = aesEcbDecryptionCipher.doFinal(encryptedMessage);

    assert Arrays.equals(shortMessage, decryptedMessage);
  }

  @Benchmark
  public void testAESEncryption_ECB_longString() throws BadPaddingException, IllegalBlockSizeException {
    byte[] encryptedMessage = aesEcbEncryptionCipher.doFinal(longMessage);

    byte[] decryptedMessage = aesEcbDecryptionCipher.doFinal(encryptedMessage);

    assert Arrays.equals(longMessage, decryptedMessage);
  }

  @Benchmark
  public void testAESEncryption_CBC_shortString() throws BadPaddingException, IllegalBlockSizeException {
    byte[] encryptedMessage = aesCbcEncryptionCipher.doFinal(shortMessage);

    byte[] decryptedMessage = aesCbcDecryptionCipher.doFinal(encryptedMessage);

    assert Arrays.equals(shortMessage, decryptedMessage);
  }

  @Benchmark
  public void testAESEncryption_CBC_longString() throws BadPaddingException, IllegalBlockSizeException {
    byte[] encryptedMessage = aesCbcEncryptionCipher.doFinal(longMessage);

    byte[] decryptedMessage = aesCbcDecryptionCipher.doFinal(encryptedMessage);

    assert Arrays.equals(longMessage, decryptedMessage);
  }

  public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
    Benchmarks clrs = new Benchmarks();

    clrs.setup();

    byte[] encryptedMessage = clrs.aesCbcEncryptionCipher.doFinal(clrs.longMessage);

    byte[] decryptedMessage = clrs.aesCbcDecryptionCipher.doFinal(encryptedMessage);

    assert Arrays.equals(clrs.longMessage, decryptedMessage);
  }


  private String getRandomMessage(int length) {
    int leftLimit = 97; // letter 'a'
    int rightLimit = 122; // letter 'z'

    return random
      .ints(leftLimit, rightLimit)
      .limit(length)
      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
      .toString();
  }
  */
}
