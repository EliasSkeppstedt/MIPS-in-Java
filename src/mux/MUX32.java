package mux;

import basicsupport.SignExtend;
import basicsupport.RegisterFile;
import basicsupport.ControlUnit;
import basicsupport.ALU;

public class MUX32 extends MUX {

    private String name;
    private RegisterFile registerFile;
    private SignExtend signExtend;
    private ALU alu;
    private ControlUnit controlUnit;

    public MUX32(String name, RegisterFile registerFile, SignExtend signExtend, ALU alu, ControlUnit controlUnit) {
        super(new int[32]);
        this.name = name;
        this.registerFile = registerFile;
        this.signExtend = signExtend;
        this.alu = alu;
        this.controlUnit = controlUnit;
    }

   // Beginning of implementing the observer pattern to "awake" this mux when needed. 
    public void update() {
        super.setInputA(RegisterFile.getReadData1());
        super.setInputB(SignExtend.getSignImm());
        super.
    }
}