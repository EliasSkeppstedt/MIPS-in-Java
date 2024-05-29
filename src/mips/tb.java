package mips;

import adder.Adder;
import basicsupport.ProgramMemory;

public class tb {
    static ProgramMemory programMemory;
    static Adder adder;

    public static void main(String[] args) {
    }

    public String testOfAdder() {
        adder = new Adder();
        adder.setOp(0);
        int[] srcA = {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0};
        int[] srcB = {1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0};
        adder.setSrcA(srcA);
        adder.setSrcB(srcB);
        return adder.getResult().toString();
    }

    public String testOfProgramMemory() {
        programMemory = new ProgramMemory("src/basicsupport/machinecode.txt");
        return "Test not finished";
    }
}
