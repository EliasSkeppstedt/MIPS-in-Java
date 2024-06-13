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
        if (!is32Bits(instr)) {
            System.out.println("ERROR! Instruction is not 32 bits long.");
            return;
        }

        targetOrDestRegister = controlUnit.getRegDst() == 0 ? targetRegister : destinationRegister;
    }

    private boolean is32Bits(int[] var) {
        return var.length == 32 ? true : false;
    }

    public void setRegisters(int[] sourceRegister, int[] targetRegister, int[] destinationRegister) {
        this.sourceRegister = sourceRegister;
        this.targetRegister = targetRegister;
        this.destinationRegister = destinationRegister;
    }

    public void onRisingEdge() {
        
    }
}
