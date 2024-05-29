package basicsupport;

public class ProgramCounter {
    private int[] pc = new int[32];
    private int   clk;

    public ProgramCounter(int clk) {
        this.clk = clk;
    }

    public boolean runClock(int clk, int reset) {
        if (reset == 1) {
            for (int i = 0; i < 32; i++) {
                pc[i] = 0;
            }
        } else if (this.clk == 0 && clk == 1) {
            return true;
        }
        return false;
    }
    
}
