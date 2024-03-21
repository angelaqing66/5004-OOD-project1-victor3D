import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import project01.Vector3D;

public class Vector3DTest {
    private Vector3D vector;

    /**
     * to set up the vector example
     */
    @Before
    public void setUp(){
        vector = new Vector3D(1.0,2.0,3.0);
    }

    /**
     * to test getters
     */
    @Test
    public void testGetters(){
        assertEquals(1.0, vector.getX(), 0.001);
        assertEquals(2.0, vector.getY(), 0.001);
        assertEquals(3.0, vector.getZ(), 0.001);
    }

    /**
     * to test to String method
     */
    @Test
    public void testToString(){
        assertEquals("(1.00,2.00,3.00)",vector.toString());
    }

    /**
     * to test if the calculation of magnitude is right
     */
    @Test
    public void testGetMagnitude(){
        assertEquals(Math.sqrt(1*1+2*2+3*3),vector.getMagnitude(),0.001);
    }

    /**
     *to test the normalize method result
     */
    @Test
    public void testNormalized(){
        Vector3D newVector = vector.normalize();
        assertEquals(1.0/ vector.getMagnitude(),newVector.getX(),0.001);
        assertEquals(2.0/ vector.getMagnitude(),newVector.getY(),0.001);
        assertEquals(3.0/ vector.getMagnitude(),newVector.getZ(),0.001);
    }

    /**
     * test whether the throw IllegalStateException in normalize method work
     */
    @Test(expected = IllegalStateException.class)
    public void testNormalizedError(){
        Vector3D vector1 = new Vector3D(0,0,0);
        vector1.normalize();
    }

    /**
     * to test the result of add method
     */
    @Test
    public void testAdd(){
        Vector3D vector2 = new Vector3D(4.0, 5.0, 6.0);
        Vector3D result = vector.add(vector2);
        assertEquals(5.0, result.getX(), 0.001);
        assertEquals(7.0, result.getY(), 0.001);
        assertEquals(9.0, result.getZ(), 0.001);
    }

    /**
     * to test multiply method
     */
    @Test
    public void testMultiply(){
        Vector3D result = vector.multiply(2.0);
        assertEquals(2.0, result.getX(), 0.001);
        assertEquals(4.0, result.getY(), 0.001);
        assertEquals(6.0, result.getZ(), 0.001);
    }

    /**
     * to test dot product method
     */
    @Test
    public void testDotProduct(){
        Vector3D vector2 = new Vector3D(4.0, 5.0, 6.0);
        double result = vector.dotProduct(vector2);
        assertEquals(32.0, result, 0.001);
    }

    /**
     * to test angle between two vectors method
     */
    @Test
    public void testAngleBetween(){
        Vector3D vector1 = new Vector3D(1.0, 0.0, 0.0);
        Vector3D vector2 = new Vector3D(0.0, 0.0, 1.0);
        double result = vector1.angleBetween(vector2);
        assertEquals(90.0, result, 0.001);
    }

    /**
     * to test the cross product method
     */
    @Test
    public void testCrossProduct(){
        Vector3D vector2 = new Vector3D(1.0, 1.0, 1.0);
        Vector3D result = vector.crossProduct(vector2);
        assertEquals(-1.0, result.getX(), 0.001);
        assertEquals(2.0, result.getY(), 0.001);
        assertEquals(-1.0, result.getZ(), 0.001);
    }

}
