package reflection;

import executable.Executeble;
import executable.Unexecutable;
import human.Human;
import human.Student;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static reflection.ReflectionDemo.*;

public class ReflectionDemoTests {
    Human human = new Human();
    Human human1 = new Human();
    @Test
    public void reflectionFirstTest(){
        List<Object> list = new ArrayList<>();
        Collections.addAll(list, human, human1);

        assertEquals(reflectionFirst(list), 2);
    }

    @Test
    public void reflectionSecondTest(){
        List<String> expected = new ArrayList<>();
        Collections.addAll(expected, "Stringer", "Counter", "getTen", "setTen");
        Collections.sort(expected);
        assertEquals(reflectionSecond(human), expected);
    }

    @Test
    public void reflectionThirdTest(){
        Student student = new Student();
        List<String> expected = new ArrayList<>();
        Collections.addAll(expected, "Human", "Object");
        System.out.println(reflectionThird(student));
        assertTrue(reflectionThird(student).containsAll( expected));
        assertTrue(expected.containsAll(reflectionThird(student)));
    }

    @Test
    public void reflectionStarOneTest(){
        Executeble executeble = new Executeble();
        Unexecutable unexecutable = new Unexecutable();

        List<Object> list = new ArrayList<>();
        Collections.addAll(list, executeble, unexecutable);

        assertEquals(reflectionStarOne(list), 1);
    }

    @Test
    public void reflectionStarTwoTest(){
        List<String> expected = new ArrayList<>();
        Collections.addAll(expected, "getTen", "setTen");
        Collections.sort(expected);

        assertEquals(reflectionStarTwo(human), expected);
    }
}
