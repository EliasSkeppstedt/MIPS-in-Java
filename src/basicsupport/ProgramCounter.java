package basicsupport;

public class ProgramCounter {
    private int[] programCounter = new int[32];
    private int counter = 0;
    private int clockCycle = 0;
    private AdderPCPlus4 adderPCPlus4;
    private ProgramMemory porgramMemory;

    public ProgramCounter(AdderPCPlus4 adderPCPlus4, ProgramMemory programMemory) {
        this.adderPCPlus4 = adderPCPlus4;
        this.porgramMemory = programMemory;
    }

    public void updateProgramCounter() {
        counter++;
        if (counter % 2 == 0) {
            return;
        }
        adderPCPlus4.setSrcB(programCounter);
        adderPCPlus4.setOp(0);
        programCounter = adderPCPlus4.getResult();

        String className = this.getClass().getSimpleName();
        HelpMethods.is32Bits(programCounter, className);

        porgramMemory.setAddressToNextInstruction(programCounter);
    }

    public void resetClk() {
        for (int i = 0; i < 32; i++) {
            programCounter[i] = 0;
        }
    }

    public boolean risingEdge() {
        return counter % 2 != 0 ? true : false;
    }

    public int getClockCycle() {
        return clockCycle;
    }
}
