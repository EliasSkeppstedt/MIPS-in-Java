package basicsupport;

import adder.Adder;
import adder.FullAdder;

public class ALU {
    private Adder adderALU = new Adder(new FullAdder());
    private int[] ALUControl = new int[3];
    private int[] srcA = new int[32], srcB = new int[32], result = new int[32];
    private int[] adderResult = new int[32];
    private int sub, zeroFlag;

    public void runALU() {
        int ALUControlDec = 2^ALUControl[1] + 2^ALUControl[0];
        switch (ALUControlDec) {
            case 0:
                runAnd();
                break;
            case 1:
                runOr();
                break;
            case 2:
                runAdder();
                break;
            case 3:
                runZeroExtend();
                break;
        }
        checkZeroFlag();
    }

    public int getZeroFlag() {
        return zeroFlag;
    }

    public int[] getResult() {
        return result;
    }

    public void setSrcA(int[] srcA) {
        this.srcA = srcA;
    }

    public void setSrcB(int[] srcB) {
        this.srcB = srcB;
    }

    private void runAnd() {
        for (int i = 31; i >= 0; i--) {
            result[i] = srcA[i] & srcB[i];
        }
    }

    private void runOr() {
        for (int i = 31; i >= 0; i--) {
            result[i] = srcA[i] | srcB[i];
        }
    }

    private void runAdder() {
        sub = ALUControl[2];
        adderALU.setSrcA(srcA);
        adderALU.setSrcB(srcB);
        adderALU.setOp(sub);
        result = adderALU.getResult();
    }

    private void runZeroExtend() {
        for (int i = 31; i >= 1; i--) {
            adderResult[i] = srcB[i];
        }
        result[0] = xor(adderResult[0], adderALU.getOverflow());
    }

    private int xor(int a, int b) {
        return (a == 1 && b == 0) || (a == 0 && b == 1) ? 1 : 0;
    }

    private void checkZeroFlag() {
        for (int i = 31; i >= 1; i--) {
            if (result[i] == 1 || result[i--] == 1) {
                zeroFlag = 0;
                return;
            }
        }
        zeroFlag = 1;
    }
}
