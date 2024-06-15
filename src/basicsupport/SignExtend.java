package basicsupport;

import java.util.Arrays;

public class SignExtend {
    private int[] imm = new int[16];
    private int[] signImm = new int[32];
    
    private void extend() {
        for (int i = 0; i < 16; i++) {
            signImm[i] = imm[0];
        }
        for (int i = 16, j = 0; i < 32; i++, j++) {
            signImm[i] = imm[j];
        }
    }

    public void setImmidiate(int[] imm) {
        this.imm = Arrays.copyOfRange(imm, 16, 32);
        extend();
    }
    
    public int[] getSignImm() {
        return signImm;
    }
}