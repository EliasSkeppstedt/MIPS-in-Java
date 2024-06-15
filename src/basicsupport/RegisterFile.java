package basicsupport;

public class RegisterFile {
    private int[] 
        sourceRegister       = new int[5], 
        targetRegister       = new int[5], 
        destinationRegister  = new int[5], 
        targetOrDestRegister = new int[5];

    private int[] 
        writeReg      = new int[32], 
        readData_1    = new int[32], 
        readData_2    = new int[32];
        

    private int[][] regFileMemory = new int[32][32];

    private ControlUnit controlUnit;

    public RegisterFile(ControlUnit controlUnit) {
        this.controlUnit = controlUnit;
    }

    // Acts like MUX5
    public void setInstruction(int[] instr) {
        targetOrDestRegister = controlUnit.getRegDst() == 0 ? targetRegister : destinationRegister;
    }

    public void setRegisters(int[] sourceRegister, int[] targetRegister, int[] destinationRegister) {
        this.sourceRegister = sourceRegister;
        this.targetRegister = targetRegister;
        this.destinationRegister = destinationRegister;
    }

    public void onRisingEdge() {
        if (controlUnit.getRegWrite() == 1) {
            regFileMemory[HelpMethods.binToDec(targetOrDestRegister)] = writeReg;
        }
        readData_1 = regFileMemory[HelpMethods.binToDec(sourceRegister)];
        readData_2 = regFileMemory[HelpMethods.binToDec(targetRegister)];
    }

    public int[] fetchReadData_1() {
        return readData_1;
    }

    public int[] fetchReadData_2() {
        return readData_2;
    }
}
