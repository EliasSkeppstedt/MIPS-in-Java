package basicsupport;

import java.util.ResourceBundle.Control;

public class RegisterFile {
    private int[] readRS = new int[5], readRT = new int[5], readRD = new int[5], readRTorRD = new int[5];
    private int[] writeReg = new int[32];
    private ControlUnit controlUnit;

    public RegisterFile(ControlUnit controlUnit) {
        this.controlUnit = controlUnit;
    }

    public void setRegisters(int[] instr) {
        if (!is32Bits(instr)) {
            System.out.println("Error: instruction is not 32 bits.");
            return;
        }
        chooseBitsXtoY(25, 5, instr, readRS);
        chooseBitsXtoY(20, 5, instr, readRT);
        chooseBitsXtoY(15, 5, instr, readRD);
        readRTorRD = controlUnit.getRegDst() == 0 ? readRT : readRD;
    }

    private boolean is32Bits(int[] var) {
        return var.length == 32 ? true : false;
    }

    private void chooseBitsXtoY(int toBit, int size, int[] instr, int[] address) {
        for (int a = size--, i = toBit; a >= 0; a--, i--) {
            address[a] = instr[i];
        }

    }
}
