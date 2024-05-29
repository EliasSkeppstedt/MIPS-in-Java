package basicsupport;

import adder.Adder;

public class ALU {
    private Adder adderALU;
    private int[] ALUControl = new int[3];
    private int[] srcA = new int[32], srcB = new int[32], result = new int[32];
    private int[] AandB = new int[32], AorB = new int[32], adderResult = new int[32], zeroExtendResult = new int[32];
    private int sub, op, zeroFlag;

    public ALU(Adder adderALU) {
        this.adderALU = adderALU;
    }

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
