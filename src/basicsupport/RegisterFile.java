package basicsupport;

public class RegisterFile {
    private int[] 
        sourceRegister       = new int[5], 
        targetRegister       = new int[5], 
        destinationRegister  = new int[5], 
        targetOrDestRegister = new int[5];

    private int[] 
        writeReg   = new int[32], 
        readData_1 = new int[32], 
        readData_2 = new int[32];

    private int[][] regFileMemory = new int[32][32];

    private ControlUnit controlUnit;

    public RegisterFile(ControlUnit controlUnit) {
        this.controlUnit = controlUnit;
    }

    public void setInstruction(int[] instr) {
        targetOrDestRegister = controlUnit.getRegDst() == 0 ? targetRegister : destinationRegister;
    }

    public void setRegisters(int[] sourceRegister, int[] targetRegister, int[] destinationRegister) {
        this.sourceRegister = sourceRegister;
        this.targetRegister = targetRegister;
        this.destinationRegister = destinationRegister;
    }

    public void onRisingEdge() {
        
    }
}
