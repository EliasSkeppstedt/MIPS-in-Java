package basicsupport;



public class BaseConverter {

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
