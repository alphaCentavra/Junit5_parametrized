import com.company.Animal;
import com.company.Cat;
import com.company.Dog;
import com.company.Pig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class AnimalTest {

    @BeforeAll
    public static void init() {
        System.out.println("One time");
    }

    @BeforeEach
    public void initEveryTest() {
        System.out.println("Call me every time");
    }

    @Test
    public void testDog() {
        Animal dog = new Dog();
        Assertions.assertEquals("Dog", dog.whoIam());
    }

    public static List<Object[]> params() {
        List<Object[]> results = new ArrayList<>();
        results.add(new Object[] {new Dog(), "Dog"});
        results.add(new Object[] {new Cat(), "Cat"});
        results.add(new Object[] {new Pig(), "Pig"});
        return results;
    }

    @ParameterizedTest
    @MethodSource("params")
    public void testWithParams(Animal animal, String name) {
        Assertions.assertEquals(name, animal.whoIam());
    }

    @Test
    public void testAllAnimals() {
        Animal dog = new Dog();
        Animal cat = new Cat();
        Animal pig = new Pig();
      //  Exception ex =  Assertions.assertThrows(NullPointerException.class, () -> dog.whoIam());
         Assertions.assertAll(
                () -> Assertions.assertEquals("Dog", dog.whoIam()),
                () -> Assertions.assertEquals("Cat", cat.whoIam()),
                () -> Assertions.assertEquals("Pig", pig.whoIam()));
    
    }


    @Test
    public void testCat() {
        Animal cat = new Cat();
        Assertions.assertEquals("Cat", cat.whoIam());
    }

    @Test
    public void testPig() {
        Animal pig = new Pig();
        Assertions.assertEquals("Pig", pig.whoIam());
    }
}
