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

    public void setRegisters(int[] instr) {
        if (!is32Bits(instr)) {
            System.out.println("ERROR! Instruction is not 32 bits long.");
            return;
        }

        setRegister(sourceRegister, 25, instr);
        setRegister(targetRegister, 20, instr);
        setRegister(destinationRegister, 15, instr);

        targetOrDestRegister = controlUnit.getRegDst() == 0 ? targetRegister : destinationRegister;
    }

    private boolean is32Bits(int[] var) {
        return var.length == 32 ? true : false;
    }

    private void setRegister(int[] register, int fromBit, int[] instr) {
        int length = 5;
        // MSB of the register is at index 0, will count up to 4.
        // Instruction starts at highest bit, which should go to index 0, and goes down 1 every iteration, to the lowest bit which should go to index 4.
        for (int i = 0, j = fromBit; i < length; i++, j--) {
            register[i] = instr[j];
        }
    }

    public void onRisingEdge() {
        
    }
}
