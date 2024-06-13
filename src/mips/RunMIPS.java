package mips;

import basicsupport.ProgramCounter;
import basicsupport.ProgramMemory;
import basicsupport.RegisterFile;

public class RunMIPS {

    public void  main(String[] args) {
        MIPSFactory MIPSFactory = new MIPSFactory();
        RunMIPS runMIPS = new RunMIPS();

        runMIPS.runMIPS(
            MIPSFactory.generateNewMips(), 
            MIPSFactory.getProgramCounter(),
            MIPSFactory.getProgramMemory(),
            MIPSFactory.getRegisterFile()
        );
    }
    

    private void runMIPS(MIPS mips,ProgramCounter programCounter, ProgramMemory programMemory, RegisterFile registerFile) {
        while (programCounter.getClockCycle() < 32) {
            programCounter.updateProgramCounter();

            if (programCounter.risingEdge()) {
                programMemory.fetchInstruction();
                registerFile.onRisingEdge();
            }
        }
    }
    
}
