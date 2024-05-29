package basicsupport;

import adder.Adder;
import adder.FullAdder;

public class AdderPCPlus4 extends Adder {
    private int[] srcAPCPlus4 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0};

    public AdderPCPlus4(FullAdder fullAdder, int[] srcB, int cIn) {

        super(fullAdder);
        super.setSrcA(srcAPCPlus4);
        super.setSrcB(srcB);
        super.setOp(cIn);
    }

    @Override
    public void setSrcA(int[] srcA) {
        System.out.println("setSrcA is not allowed on this adder.");
    }
}