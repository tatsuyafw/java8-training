package chapter2.exercise05;

import java.math.BigInteger;
import java.util.stream.Stream;

public class StreamUtils {
    // x(n+1) = (ax(n) + c) % m
    public static Stream<Long> linearCongruentialGenerator(long a, long c, long m, long seed) {
        if (m <= 0) {
            throw new IllegalArgumentException("Param m must be greater than zero");
        }
        BigInteger bigA = BigInteger.valueOf(a);
        BigInteger bigC = BigInteger.valueOf(c);
        BigInteger bigM = BigInteger.valueOf(m);
        BigInteger bigSeed = BigInteger.valueOf(seed);
        Stream<BigInteger> stream = Stream.iterate(bigSeed, x -> (x.multiply(bigA).add(bigC)).mod(bigM));
        return stream.map(x -> x.longValue());
    }
}
