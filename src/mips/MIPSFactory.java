package mips;

import adder.FullAdder;
import basicsupport.AdderPCPlus4;
import basicsupport.HelpMethods;
import basicsupport.ControlUnit;
import basicsupport.InstructionHub;
import basicsupport.ProgramMemory;
import basicsupport.RegisterFile;
import basicsupport.SignExtend;
import basicsupport.State;
import basicsupport.ProgramCounter;

public class MIPSFactory {

    private AdderPCPlus4   adderPCPlus4   = new AdderPCPlus4(
        new FullAdder(), 
        HelpMethods.decToBin(0), 
        0
    );
    private ProgramCounter programCounter = new ProgramCounter(adderPCPlus4);
    private ControlUnit    controlUnit    = new ControlUnit();
    private State          State          = new State(controlUnit);
    private RegisterFile   registerFile   = new RegisterFile(controlUnit);
    private SignExtend     signExtend     = new SignExtend();
    private InstructionHub instructionHub = new InstructionHub(State, registerFile, signExtend);
    private ProgramMemory  programMemory  = new ProgramMemory(instructionHub, "src/mips/machinecode.txt");
    
    private MIPS           mips           = new MIPS(
        programMemory, 
        controlUnit, 
        registerFile, 
        adderPCPlus4
    );

    public MIPS generateNewMips() {
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