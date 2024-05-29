package mips;

import adder.Adder;
import adder.FullAdder;
import basicsupport.ProgramMemory;

public class tb {
    static ProgramMemory programMemory;
    static Adder adder;

    public static void main(String[] args) {
        testOfAdder();
    }

    static public void testOfAdder() {
        System.out.println("-------------------- Test of Adder");
        adder = new Adder(new FullAdder());
        adder.setOp(0);
        int[] srcA = {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0};
        int[] srcB = {1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0};
      //int[] srcB = {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0};
        adder.setSrcA(srcA);
        adder.setSrcB(srcB);
        int[] result = adder.getResult();
        for (int i = 0; i < 32; i++) {
            System.out.print(result[i]);
        }
        System.out.println("\n-------------------- End of test");
    }

    static public void testOfProgramMemory() {
        System.out.println("-------------------- Test of ProgramMemory");
        programMemory = new ProgramMemory("src/basicsupport/machinecode.txt");
        System.out.println("-------------------- End of test");
    }
}
