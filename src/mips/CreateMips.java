package mips;

import adder.FullAdder;
import basicsupport.AdderPCPlus4;
import basicsupport.ControlUnit;
import basicsupport.ProgramMemory;
import basicsupport.RegisterFile;

public class CreateMips {

    public static void main(String[] args) {
        ProgramMemory programMemory = new ProgramMemory("src/mips/machinecode.txt");
        ControlUnit controlUnit = new ControlUnit();
        RegisterFile registerFile = new RegisterFile(
                                            controlUnit);
        AdderPCPlus4 adderPCPlus4 = new AdderPCPlus4(
                                            new FullAdder(), 
                                            new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 
                                            0);
        new MIPS(
            programMemory, 
            controlUnit, 
            registerFile, 
            adderPCPlus4
        );
    }
}