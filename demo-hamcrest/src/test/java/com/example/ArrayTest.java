import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;

public class ArrayTest {
    @Test
    void testArray() {
        String[] strings = new String[] {"apple", "cherry", "banana"};
        assertThat(strings, arrayContaining("apple", "cherry", "banana"));
        assertThat(strings, not(arrayContaining("banana", "cherry", "apple")));
        assertThat(strings, not(arrayContaining("banana", "apple")));

        assertThat(strings,
                arrayContainingInAnyOrder("banana", "cherry", "apple"));
        assertThat(strings, not(arrayContainingInAnyOrder("banana", "apple")));
    }
}
