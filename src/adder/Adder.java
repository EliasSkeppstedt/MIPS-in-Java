package adder;

public class Adder {
    private int[] srcA   = new int[32];
    private int[] srcB   = new int[32];
    private int[] result = new int[32];
    private int cIn, overflow;
    private FullAdder fullAdder;

    public void setSrcA(int[] srcA) {
        if (is32Bits(srcA)) {
            for (int i = 0; i < 32; i++) {
                this.srcA[i] = srcA[i];
            }
        }
    }

    public void setSrcB(int[] srcB) {
        if (is32Bits(srcB)) {
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
        System.out.println("Overflow: " + overflow);
        for (int j = 0; j < 32; j++) {
            System.out.print(result[j]);
        }
        System.out.println();
        return result;
    }

    private void calcResult() {
        int lastCarryOver;
        for (int i = 0; i < 31; i++) {
            fullAdder.prepareFullAdder(srcA[i], srcB[i], cIn);
            result[i] = fullAdder.getResult();
            cIn       = fullAdder.getCarryOut() ? 1 : 0;
        }
        lastCarryOver = cIn;
        fullAdder.prepareFullAdder(srcA[31], srcB[31], cIn);
        result[31] = fullAdder.getResult();

        checkOverflow(srcA[31], srcB[31], lastCarryOver);

    }

    private boolean is32Bits(int[] var) {
        return var.length == 32 ? true : false;
    }
    
    private void checkOverflow(int a, int b, int carryOver) {
        fullAdder.prepareFullAdder(a, b, carryOver);
        int carryOut;
        carryOut = fullAdder.getCarryOut() == true ? 1 : 0;
        overflow = carryOver == carryOut ? 0 : 1;
    }
}
