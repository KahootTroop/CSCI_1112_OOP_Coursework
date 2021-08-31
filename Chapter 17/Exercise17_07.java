/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rmazorow
 */
import java.io.*;

public class Exercise17_07 {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException{
        Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);
        try (
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_07.dat"));
        ) {
            output.writeObject(loan1);
            output.writeObject(loan2);
        } 
        catch (IOException ex) {
            System.out.println("File could not be opened");
        }
        outputData();
    }
    public static void outputData() throws FileNotFoundException, ClassNotFoundException{
        double loanTotal = 0.0;
        try {
            try (
                ObjectInputStream input = new ObjectInputStream(new FileInputStream("Exercise17_07.dat"));
                ) {
                while(true) {
                Loan loanOut1 = new Loan();
                loanOut1 = (Loan)(input.readObject());
                System.out.println("Loan: " + loanOut1.getLoanAmount());
                loanTotal = loanTotal + loanOut1.getLoanAmount();       
                }     
            }
            catch(EOFException ex) {
                System.out.println("Loan Total: " + loanTotal);
            }
        }
        catch(IOException ex) {
            System.out.println("File could not be opened");
        }
    }
}



