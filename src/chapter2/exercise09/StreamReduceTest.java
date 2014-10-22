package chapter2.exercise09;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class StreamReduceTest {
    private ArrayList<Integer> firstIntegerList = new ArrayList<>(Arrays.asList(1, 2, 3));
    private ArrayList<Integer> secondIntegerList = new ArrayList<>(Arrays.asList(4, 5, 6));
    private ArrayList<Integer> expectedList;
    ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>(Arrays.asList(firstIntegerList, secondIntegerList));

    @Before
    public void setup() {
        expectedList = new ArrayList<>(firstIntegerList);
        expectedList.addAll(secondIntegerList);
    }

    @Test
    public void testReduceType1() {
        ArrayList<Integer> newList = StreamReduce.reduce1(arrayLists.stream());
        assertArrayEquals(expectedList.toArray(), newList.toArray());
    }

    @Test
    public void testReduceType2() {
        ArrayList<Integer> newList = StreamReduce.reduce2(arrayLists.stream());
        assertArrayEquals(expectedList.toArray(), newList.toArray());
    }

    @Test
    public void testReduceType3() {
        ArrayList<Integer> newList = StreamReduce.reduce3(arrayLists.stream());
        assertArrayEquals(expectedList.toArray(), newList.toArray());
    }

}
