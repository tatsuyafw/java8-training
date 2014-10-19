package chapter2.exercise10;

import java.util.stream.Stream;

public class AverageStreamDouble {
    public static void main(String[] args) {
        Stream<Double> doubleStream = Stream.of(1.0, 2.0);
        long size = doubleStream.count();
        //Optional<Double> result = doubleStream.reduce((x, y) -> x + y);
        System.out.println(size);
        //System.out.println(result.orElse(0.0));
    }
    
    public static Double doubleAverage(Stream<Double> stream) {
        Double result = stream.reduce(0.0, (x, y) -> (x + y) / 2);
        return result;
    }
    
    public static Double doubleAverageIllegalState(Stream<Double> stream) {
        long size = stream.count();
        Double sum = stream.reduce(0.0, (x, y) -> x + y);        
        return sum / size;
    }
}
