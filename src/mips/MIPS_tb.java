package mips;

import adder.Adder;
import adder.FullAdder;
import basicsupport.AdderPCPlus4;
import basicsupport.InstructionHub;
import basicsupport.ProgramMemory;

public class MIPS_tb {
    static ProgramMemory programMemory;
    static Adder adder;
    static AdderPCPlus4 adderPCPlus4;

    public static void main(String[] args) {
        testOfAdder();
        testOfADDERPCPlus4();
    }

    static public void testOfAdder() {
        System.out.println("-------------------- Test of Adder");
        int[] srcA = {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0};
        int[] srcB = {1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0};
        int   cIn  = 0;

        adder = new Adder(new FullAdder());
        adder.setOp(cIn);
        adder.setSrcA(srcA);
        adder.setSrcB(srcB);
        int[] result = adder.getResult();

        for (int i = 0; i < 32; i++) {
            System.out.print(result[i]);
        }
        System.out.println("\n-------------------- End of test");
    }

    static public void testOfADDERPCPlus4() {
        System.out.println("-------------------- Test of ADDERPCPlus4");
        int[] srcB = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,0};
        int   cIn  = 0;
        adderPCPlus4 = new AdderPCPlus4(new FullAdder(), srcB, cIn);
        adderPCPlus4.setSrcA(srcB);
        adderPCPlus4.setSrcB(srcB);
        adderPCPlus4.setOp(0);
        int[] result = adderPCPlus4.getResult();
        System.out.print("B: ");
        for (int i = 0; i < 32; i++) {
            System.out.print(srcB[i]);
        }
        System.out.println();
        System.out.print("R: ");
        for (int i = 0; i < 32; i++) {
            System.out.print(result[i]);
        }
        System.out.println("\n-------------------- End of test");
    }

    static public void testOfProgramMemory() {
        System.out.println("-------------------- Test of ProgramMemory");
        //programMemory = new ProgramMemory(new InstructionHub(), "src/mips/machinecode.txt");
        System.out.println("-------------------- End of test");
    }

}
