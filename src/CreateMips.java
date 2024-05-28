import basicsupport.ProgramMemory;

public class CreateMips {
    static ProgramMemory programMemory;

    public static void main(String[] args) {
        programMemory = new ProgramMemory("src/basicsupport/machinecode.txt");
    }
}
