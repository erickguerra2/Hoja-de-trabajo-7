import static org.junit.Assert.*;
import org.junit.Test;

public class Prueba {

    @Test
    public void testBuscar() {
        BinaryTree<Association<String, String>> tree = new BinaryTree<>();
        tree.insert(new Association<>("car", "carro"));
        tree.insert(new Association<>("chair", "silla"));
        tree.insert(new Association<>("airplane", "avion"));
        assertEquals("carro", tree.search("car").getValue());
        assertEquals("silla", tree.search("chair").getValue());
        assertEquals("avion", tree.search("airplane").getValue());
    }

    @Test
    public void testFallo() {
        BinaryTree<Association<String, String>> tree = new BinaryTree<>();
        tree.insert(new Association<>("microwave", "microondas"));
        tree.insert(new Association<>("computer", "computadora"));
        tree.insert(new Association<>("mic", "microfono"));
        assertEquals("microondas", tree.search("microwave").getValue());
        assertEquals("compu", tree.search("computer").getValue());
        assertEquals("microfono", tree.search("mic").getValue());
        assertNull(tree.search("dog"));
    }
}

