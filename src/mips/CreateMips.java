package mips;

import adder.FullAdder;
import basicsupport.AdderPCPlus4;
import basicsupport.ControlUnit;
import basicsupport.InstructionHub;
import basicsupport.ProgramMemory;
import basicsupport.RegisterFile;
import basicsupport.ProgramCounter;

public class CreateMips {
    private AdderPCPlus4 adderPCPlus4 = new AdderPCPlus4(
        new FullAdder(), 
        new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 
        0
    );
    private ProgramCounter programCounter = new ProgramCounter(adderPCPlus4);
    private InstructionHub instructionHub = new InstructionHub();
    private ProgramMemory programMemory = new ProgramMemory(instructionHub, "src/mips/machinecode.txt");
    private ControlUnit controlUnit = new ControlUnit();
    private RegisterFile registerFile = new RegisterFile(controlUnit);
    private MIPS mips = new MIPS(
        programMemory, 
        controlUnit, 
        registerFile, 
        adderPCPlus4
    );

    public MIPS getNewMips() {
        return mips;
    }

    public ProgramCounter getProgramCounter() {
        return programCounter;
    }

    public ProgramMemory getProgramMemory() {
        return programMemory;
    }

    public RegisterFile getRegisterFile() {
        return registerFile;
    }
}