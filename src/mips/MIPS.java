package mips;

import basicsupport.AdderPCPlus4;
import basicsupport.ControlUnit;
import basicsupport.ProgramMemory;
import basicsupport.RegisterFile;

public class MIPS {
    ProgramMemory programMemory;
    ControlUnit controlUnit;
    RegisterFile registerFile;
    AdderPCPlus4 adderPCPlus4;

    public MIPS(
        ProgramMemory programMemory, 
        ControlUnit controlUnit, 
        RegisterFile registerFile, 
        AdderPCPlus4 adderPCPlus4) {
            
        this.programMemory = programMemory;
        this.controlUnit = controlUnit;
        this.registerFile = registerFile;
        this.adderPCPlus4 = adderPCPlus4;
    }
}
