import java.util.Scanner;

public class LeakyBucket {
    public static void main(String[] args){
        int capacity, outputRate, i=0, current=0, res, nsec, choice=1, dropped=0, x;
        int[] data_input = new int[25];

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the capacity of bucket : ");
        capacity = input.nextInt();

        System.out.println("Enter the output rate of bucket : ");
        outputRate = input.nextInt();

        while (choice == 1){
            System.out.print("Enter the incoming bit at time " + (i+1) + " : " );
            data_input[i] = input.nextInt();

            System.out.print("Enter 0 for exit 1 for another input : ");
            choice = input.nextInt();
            i++;
        }

        nsec = i;

        System.out.println("Time\t Received Packets\t Sent Packets\t In Bucket\t Dropped");
        for( i = 0; (current > 0) || (i < nsec); i++ ){

            res = Math.min(current+data_input[i], outputRate);

            if( (x = current + data_input[i] - outputRate) > 0 ){
                if( x > capacity ){
                    dropped = x -capacity;
                    current = capacity;
                }
                else{
                    current = x;
                    dropped = 0;
                }
            }
            else {
                current=0;
            }

            System.out.println((i+1) + "\t\t\t" + data_input[i] + "\t\t\t\t\t\t" + res + "\t\t\t" + current + "\t\t\t" + dropped );
        }
    }
}