package chapter2.exercise10;

import java.util.stream.Stream;

public class AverageStreamDouble {
    public static void main(String[] args) {
        Stream<Double> doubleStream = Stream.of(1.0, 2.0);
        long size = doubleStream.count();
        System.out.println(size);
    }
    
    public static Double doubleAverage(Stream<Double> stream) {
        Double result = stream.reduce(new MyAccumurator(), (ac, value) -> {
            ac.apply(value);
            return ac;
        }, (ac1, ac2) -> {
            ac1.combine(ac2);
            return ac1;
        }).result();
        
        return result;
    }
    
    public static Double doubleAverageIllegalState(Stream<Double> stream) {
        long size = stream.count();
        Double sum = stream.reduce(0.0, (x, y) -> x + y);        
        return sum / size;
    }
    
    static private class MyAccumurator {
        private Double total;
        private int count;
        public MyAccumurator() {
            this.total = 0.0;
            this.count = 0;
        }
        
        public void apply(Double value) {
            this.total += value;
            this.count++;
        }
        
        public void combine(MyAccumurator other) {
            this.total += other.total;
            this.count += other.count;
        }
        
        public Double result() {
            if (count == 0) {
                return 0.0;
            } else {
                return this.total / this.count;
            }
        }
    }
}
