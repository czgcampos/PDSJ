import java.util.AbstractMap.SimpleEntry;
import java.util.function.Supplier;
public class testBox {
    public static <R> SimpleEntry<Double, R> testeBoxGenW(Supplier<? extends R> supplier) {
        for (int i = 1; i <= 10; i++) supplier.get();
        System.gc();
        Crono.start();
        R resultado = supplier.get();
        Double tempo = Crono.stop();
        return new SimpleEntry<Double, R>(tempo, resultado);
    }
}
