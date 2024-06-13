package mips;

import basicsupport.ProgramCounter;
import basicsupport.ProgramMemory;
import basicsupport.RegisterFile;

public class RunMIPS {

    public void  main(String[] args) {
        CreateMips createMips = new CreateMips();
        RunMIPS runMIPS = new RunMIPS();

        runMIPS.runMIPS(
            createMips.getNewMips(), 
            createMips.getProgramCounter(),
            createMips.getProgramMemory(),
            createMips.getRegisterFile()
        );
    }
    

    private void runMIPS(MIPS mips,ProgramCounter programCounter, ProgramMemory programMemory, RegisterFile registerFile) {
        while (programCounter.getClockCycle() < 32) {
            programCounter.updateCounter();

            if (programCounter.risingEdge()) {
                programMemory.fetchInstruction();
                registerFile.onRisingEdge();
            }
        }
    }
    
}
