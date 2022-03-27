import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class RSA {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Random rand1 = new Random(System.currentTimeMillis());
        Random rand2 = new Random(System.currentTimeMillis()*10);

        BigInteger p = BigInteger.probablePrime(32, rand1);
        BigInteger q = BigInteger.probablePrime(32, rand2);
        BigInteger n = p.multiply(q);

        BigInteger p_1 = p.subtract(new BigInteger("1"));
        BigInteger q_1 = q.subtract(new BigInteger("1"));
        BigInteger p_1_q_1 = p_1.multiply(q_1);

        System.out.println("Enter the public key : ");
        int pubkey = input.nextInt();

        while(true){
            BigInteger GCD = p_1_q_1.gcd(new BigInteger(""+ pubkey));
            if(GCD.equals(BigInteger.ONE)) break;
            pubkey++;
        }

        BigInteger Big_pubkey = new BigInteger("" + pubkey);
        BigInteger prvkey = Big_pubkey.modInverse(p_1_q_1);

        System.out.println("public key : " + pubkey);
        System.out.println("n : " + n);

        System.out.println("Enter plain text : ");
        BigInteger value = input.nextBigInteger();

        BigInteger cipherValue = value.modPow(Big_pubkey, n);
        System.out.println("Cipher text : " + cipherValue);

        BigInteger plainValue = cipherValue.modPow(prvkey,n);

        int plaintext = plainValue.intValue();
        System.out.println("Plain text : " + plainValue);

    }
}
