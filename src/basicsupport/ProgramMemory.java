package basicsupport;

import java.io.File;
import java.util.Scanner;

public class ProgramMemory {

    private int[][] address     = new int[9][32];
    private int[][] instruction = new int[9][32];
    private File    mc;

    public ProgramMemory(String filePath) {

        if (!checkFilePath(filePath)) {
            System.out.println("File not found!");
        }

        loadMachineCodInstructions();
    }

    private boolean checkFilePath(String filePath) {
        mc = new File(filePath);
        return mc.exists();
    }

    private void loadMachineCodInstructions() {
        try {
            Scanner scanner = new Scanner(mc);
            int index = 0;
            String addressString;
            String instructionString;

            for (int i = 1; i <= 25; i += 3) {
                addressString     = scanner.nextLine();
                instructionString = scanner.nextLine();
                scanner.nextLine();

                for (int k = 0; k < 32; k++) {
                    address[index][k]     = addressString.charAt(k) - '0';
                    //System.out.print(addressString.charAt(k));
                    instruction[index][k] = instructionString.charAt(k) - '0';
                    //System.out.print(instructionString.charAt(k));
                }
                index++;
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
        for (int i = 0; i < 9; i++) {
            System.out.print("Address     " + i + " : ");
            for (int j = 0; j < 32; j++) {
                System.out.print(address[i][j]);
            }
            System.out.println();
            System.out.print("Instruction " + i + " : ");
            for (int j = 0; j < 32; j++) {
                System.out.print(instruction[i][j]);
            }
            System.out.println();
        }
        */
    } 

    public int[] getInstructionForPC(int pc) {
        return instruction[pc];
    }

}


