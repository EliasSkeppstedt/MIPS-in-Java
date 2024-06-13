package basicsupport;

import java.util.Arrays;

public class SignExtend {
    private int[] instr = new int[16];
    private int[] signImm = new int[32];
    
    private void extend() {
        for (int i = 0; i < 16; i++) {
            signImm[i] = instr[0];
        }
        for (int i = 16, j = 0; i < 32; i++, j++) {
            signImm[i] = instr[j];
        }
    }

    public void setImmidiate(int[] instr) {
        this.instr = Arrays.copyOfRange(instr, 16, 32);
    }
    
    public int[] getSignImm() {
        extend();
        return signImm;
    }
}