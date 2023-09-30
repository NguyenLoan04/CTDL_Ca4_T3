package Lab_1;

public class MyCaesar {
    public static final char[] ALPHABET = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private int n;// shift steps (right shift)

    public MyCaesar(int shiftSteps) {
        this.n = shiftSteps;
    }

    // Encrypt a character according to the given shift steps.
    // Encrypt: En(x) = (x + n) mod 26. x represents the index of c in the ALPHABET
    // array
    public char encryptChar(char c) {
        // TODO
        if (Character.isLetter(c)) {
            char upperC = Character.toUpperCase(c);
            for (int i = 0; i < ALPHABET.length; i++) {
                if (upperC == ALPHABET[i]) {
                    if (i != -1) {
                        char encryptC = ALPHABET[(i + n) % 26];
                        return Character.isUpperCase(c) ? encryptC : Character.toLowerCase(encryptC);
                    }
                }
            }
        } else {
            int digit = (Integer.parseInt("" + c) + n) % 10;
            return (char) digit;
        }
        return c;
    }

    // Encrypt a text using the above function for encrypting a character.
    public String encrypt(String input) {
        // TODO
        char[] tmp = input.toCharArray();
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = encryptChar(tmp[i]);
        }
        return print(tmp);
    }

    private String print(char[] tmp) {
        String result = " ";
        for (int i = 0; i < tmp.length; i++) {
            result += tmp[i];
        }
        return result;
    }

    // Decrypt a character according to the given shif steps.
    // Decrypt: Dn(x) = (x – n) mod 26. x represents the index of c in the ALPHABET
    // array
    public char decryptChar(char c) {
        // TODO
        if (Character.isLetter(c)) {
            char upperC = Character.toUpperCase(c);
            for (int i = 0; i < ALPHABET.length; i++) {
                if (upperC == ALPHABET[i]) {
                    if (i-n > 0) {
                        char decryptC = ALPHABET[(i - n) % 26];
                        return Character.isUpperCase(c) ? decryptC : Character.toLowerCase(decryptC);
                    }
                    if (i - n < 0) {
                        char decryptC = ALPHABET[(27+i - n) % 26];
                        return Character.isUpperCase(c) ? decryptC : Character.toLowerCase(decryptC);
                    }
                }
            }
        } else {
            int digit = (Integer.parseInt("" + c) - n) % 10;
            if (digit < 0) digit = (Integer.parseInt("" + c) - n +11) % 10;
            return (char) digit;
        }
        return c;
    }

    // Decrypt a encrypted text using the above function for decrypting a charater.
    public String decrypt(String input) {
        // TODO
        char[] tmp = input.toCharArray();
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = decryptChar(tmp[i]);
        }
        return print(tmp);
    }

    // Encrypt a encrypted the text content in the srcfile and save it into desFile.
    public void encrypt(String srcFile, String desFile) {
        // TODO
    }

    // Decrypt a encrypted the text content in the srcfile and save it into desFile.
    public void decrypt(String srcFile, String desFile) {
        // TODO
    }

    public static void main(String[] args) {
        MyCaesar test = new MyCaesar(3);
        System.out.println(test.encrypt("XYZ123"));
        System.out.println(test.decrypt("Abc123"));
    }
}