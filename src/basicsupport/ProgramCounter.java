package basicsupport;

public class ProgramCounter {
    private int[] pc = new int[32];
    private int counter = 0;
    private int clockCycle = 0;
    private AdderPCPlus4 adderPCPlus4;	

    public ProgramCounter(AdderPCPlus4 adderPCPlus4) {
        this.adderPCPlus4 = adderPCPlus4;
    }

    public void updateCounter() {
        counter++;
        if (counter % 2 == 0) {
            clockCycle++;
        }
    }

    public void resetClk() {
        for (int i = 0; i < 32; i++) {
            pc[i] = 0;
        }
    }

    public boolean risingEdge() {
        return counter % 2 != 0 ? true : false;
    }

    public int getClockCycle() {
        return clockCycle;
    }
    
}
