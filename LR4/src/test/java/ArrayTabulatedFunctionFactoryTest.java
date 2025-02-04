import ru.ssau.tk.ArtKsenInc.OOP_JAVA.functions.ArrayTabulatedFunction;
import ru.ssau.tk.ArtKsenInc.OOP_JAVA.functions.factory.ArrayTabulatedFunctionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayTabulatedFunctionFactoryTest {
    @Test
    void create() {
        ArrayTabulatedFunctionFactory obj = new ArrayTabulatedFunctionFactory();
        Assertions.assertInstanceOf(ArrayTabulatedFunction.class, obj.create(new double[]{1,2,3}, new double[]{1,4,9}));
    }
}