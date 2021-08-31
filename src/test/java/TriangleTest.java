import ch.qos.logback.classic.LoggerContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.Assert.*;
@ExtendWith(TimingExtention.class)
public class TriangleTest {
    private static callTriangleArea cal = new callTriangleArea();
    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);
    @Test
    public void testJudge() {// Невозможно сформировать треугольник 
        assertEquals(false, cal.judge(2, 1, 3));
    }
    @Test
    public void testJudge1() {// Может образовывать треугольник
        assertEquals(true, cal.judge(3, 4, 5));
    }
    @Test
    public void testJudge2() {// Невозможно сформировать отрицательное число треугольника
        assertEquals(false, cal.judge(-3, -4, -5));
    }
    @Test
    public void testCal() {//Равносторонний треугольник
        assertEquals(3.89711431,cal.cal(3, 3, 3),0.00001);
    }
    @Test
    public void testCal1() {// Общий треугольник
        assertEquals(6.0,cal.cal(3, 4, 5),0.00001);
    }
    @Test
    public void testCal2() {// Невозможно построить треугольник
        assertEquals(-1.0,cal.cal(2, 1, 3),0.00001);// Сравнение чисел с плавающей запятой означает, что разница меньше определенной точности. Чтобы сравнить два числа с плавающей запятой, добавьте третий параметр, чтобы указать точность
    }
    @Test
    public void testCal3() {// Невозможно построить отрицательное число треугольника 
        assertEquals(-1.0,cal.cal(-2, -1, -3),0.00001);
    }
}