package basicsupport;



public class HelpMethods {

    static public int binToDec(int[] bin) {
        int dec = 0;
        int binLength = bin.length;

        for (int i = 0, pow = binLength; i < binLength; i++, pow++) {
            dec += bin[i] * Math.pow(2, pow);
        }

        return dec;
    }

    static public int[] decToBin(int dec) {
        int[] bin = new int[32];
        
        for (int i = 31; i >= 0; i--) {
            bin[i] = dec % 2;
            dec /= 2;
        }

        return bin;
    }

    static public int[] reverseArray(int[] arr) {
        int[] reversedArray = new int[32];
        
        for (int i = 0, j = 31; i < 32; i++, j--) {
            reversedArray[i] = arr[j];
        }

        return reversedArray;
    }

    static public void is32Bits(int[] var, String className) {
        boolean length = var.length == 32 ? true : false;
        System.out.print("File: " + className + ".\n      Checked array ");
        if (length) {
            System.out.println("IS 32 bits.");
        } else {
            System.out.println("IS NOT 32 bits.");
            System.exit(0);
        }
    }
    
    private enum hex {
        A(10), B(11), C(12), D(13), E(14), F(15);
        
        private int value;
        
        private hex(int value) {
            this.value = value;
        }
        
        public int getValue() {
            return value;
        }
    }
}
