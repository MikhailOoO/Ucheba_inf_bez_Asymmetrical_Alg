import java.util.Scanner;
public class CRC16 {
    private static final int POLYNOMIAL = 0x1021;
    private static final int INITIAL_VALUE = 0xFFFF;

    public static int calculateCRC(byte[] data) {
        int crc = INITIAL_VALUE;

        for (byte b : data) {
            int currentByte = b;
            crc ^= currentByte << 8;

            for (int i = 0; i < 8; i++) {
                if ((crc & 0x8000) != 0) {
                    crc = (crc << 1) ^ POLYNOMIAL;
                } else {
                    crc <<= 1;
                }
            }
        }

        return crc & 0xFFFF;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input text: ");
        String text = in.nextLine();
        byte[] data = text.getBytes();
        int crc = calculateCRC(data);
        System.out.println("CRC16: " + Integer.toHexString(crc));
    }
}
