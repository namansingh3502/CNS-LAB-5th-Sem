import java.util.Scanner;

public class CRC {

    static int[] division(int[] divisor, int[] dividend, int[] remainder){
        int curr = 0;

        while (true){
            for ( int i = 0; i < divisor.length; i++ ){
                remainder[curr + i] = remainder[curr + i] ^ divisor[i];
            }
            while (remainder[curr] == 0 && curr != remainder.length-1 ){
                curr++;
            }

            if(remainder.length - curr < divisor.length){
                break;
            }
        }
        return remainder;
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int data_bits, divisor_bits, total_length;

        System.out.println("Enter number of data bits : ");
        data_bits = input.nextInt();
        int[] data = new int[data_bits];

        System.out.println("Enter data bits : ");
        for( int i = 0; i < data_bits; i++ ){
            data[i] = input.nextInt();
        }

        System.out.println("Enter number of divisor bits : ");
        divisor_bits = input.nextInt();
        int[] divisor = new int[divisor_bits];

        System.out.println("Enter divisor bits : ");
        for( int i = 0; i < divisor_bits; i++ ){
            divisor[i] = input.nextInt();
        }

        total_length = data_bits + divisor_bits - 1;

        int[] dividend = new int[total_length];
        int[] remainder = new int[total_length];
        int[] crc = new int[total_length];

        for(int i = 0; i < data_bits; i++){
            dividend[i] = data[i];
        }

        System.out.println("Dividend (after appending 0's) : ");
        for( int i = 0; i < total_length; i++ ){
            System.out.print(dividend[i] + " ");
            remainder[i] = dividend[i];
        }
        System.out.println();

        remainder = division( divisor, dividend, remainder );

        for(int i = 0; i < total_length; i++ ){
            crc[i] = dividend[i] ^ remainder[i];
        }

        System.out.println("CRC bit ");

        for(int i = 0; i < total_length; i++ ){
            System.out.print(crc[i] + " ");
        }
        System.out.println();

        System.out.println("Enter CRC code of " + total_length + "bits : ");

        for( int i = 0; i < total_length; i++ ){
            crc[i] = input.nextInt();
            remainder[i] = crc[i];
        }

        remainder = division( divisor, crc, remainder );

        int flag = 1;

        for( int i = 0 ; i < total_length; i++ ){
            if( remainder[i] != 0 ){
                System.out.println("Error");
                flag = 0;
                break;
            }
        }

        if( flag == 1 ) System.out.println("No Error");
    }

}
