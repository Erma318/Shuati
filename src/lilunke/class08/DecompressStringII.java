package lilunke.class08;

public class DecompressStringII {
    public String decompress(String input) {
        // Write your removeCho2 here.
        if (input.isEmpty()) {
            return input;
        }
        char[] array = input.toCharArray();
        return decodeLong(array, decodeShort(array));
    }

    private int decodeShort(char[] input) {
        int end = 0;
        for (int i = 0; i < input.length; i += 2) {
            int digit = getDigit(input[i + 1]);
            if (digit >= 0 && digit <= 2) {
                for (int j = 0; j < digit; j++) {
                    input[end++] = input[i];
                }
            } else {
                input[end++] = input[i];
                input[end++] = input[i + 1];
            }
        }
        return end;
    }

    private String decodeLong(char[] input, int length) {
        int newLength = length;
        for (int i = 0; i < length; i++) {
            int digit = getDigit(input[i]);
            if (digit > 2 && digit <= 9) {
                newLength += digit - 2;
            }
        }
        char[] result = new char[newLength];
        int end = newLength - 1;
        for (int i = length - 1; i >= 0; i--) {
            int digit  = getDigit(input[i]);
            if (digit > 2 && digit <= 9) {
                i--;
                for (int j = 0; j < digit; j++) {
                    result[end--] = input[i];
                }
            } else {
                result[end--] = input[i];
            }
        }
        return new String(result);
    }
    private int getDigit(char digit) {
        return digit - '0';
    }
}
