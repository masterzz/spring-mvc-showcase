package datastructure;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.datastruct.ArraySort;
import org.springframework.ioc.enjoy.cap10.aop.Calculator;
import org.springframework.ioc.enjoy.cap10.config.Cap10MainConfig;

public class DataStructureTest {
    @Test
    public void testSort() {
        int[] array = {33,22,55,20,43};
//        ArraySort.insertSort(array);
//        ArraySort.bubbleSort(array);
        ArraySort.quickSort(array);
    }
}
