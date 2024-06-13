package adder;

public class Adder {
    private int[] srcA   = new int[32];
    private int[] srcB   = new int[32];
    private int[] result = new int[32];
    private int cIn, overflow;
    private FullAdder fullAdder;

    public Adder(FullAdder fullAdder2) {
        this.fullAdder = fullAdder2;
    }

    public void setSrcA(int[] srcA) {
        if (is32Bits(srcA, "srcA")) {
            for (int i = 0; i < 32; i++) {
                this.srcA[i] = srcA[i];
            }
        }
    }

    public void setSrcB(int[] srcB) {
        if (is32Bits(srcB, "srcB")) {
            for (int i = 0; i < 32; i++) {
                this.srcB[i] = srcB[i];
            }
        }
    }

    public void setOp(int cIn) {
        this.cIn = cIn;
    }

    public int[] getResult() {
        calcResult();
        return result;
    }

    public int getOverflow() {
        return overflow;
    }

    private void calcResult() {
        int lastCarryOver;
        int carryOver = cIn;

        for (int i = 31; i >= 0; i--) {
            fullAdder.prepareFullAdder(srcA[i], srcB[i], carryOver);
            result[i] = fullAdder.getResult();
            carryOver = fullAdder.getCarryOut();
        }
        
        lastCarryOver = cIn;
        fullAdder.prepareFullAdder(srcA[31], srcB[31], cIn);
        result[31] = fullAdder.getResult();

        checkOverflow(srcA[31], srcB[31], lastCarryOver);

    }

    private boolean is32Bits(int[] src, String srcName) {
        if (src.length != 32) {
            System.out.println("Error: " + srcName + " is not 32 bits.");
            return false;
        }
        return true;
    }
    
    private void checkOverflow(int a, int b, int carryOver) {
        fullAdder.prepareFullAdder(a, b, carryOver);
        int carryOut;
        carryOut = fullAdder.getCarryOut();
        overflow = carryOver == carryOut ? 0 : 1;
    }
}
