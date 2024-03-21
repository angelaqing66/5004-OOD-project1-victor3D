package project01;

public class Vector3D {
    private double x;
    private double y;
    private double z;

    /**
     * Constructor of the project01.Vector3D class
     * @param X
     * @param Y
     * @param Z
     */
    public Vector3D(double X, double Y, double Z){
        x = X;
        y = Y;
        z = Z;
    }

    /**
     * get x method
     * @return x
     */
    public double getX() {
        return x;
    }
    /**
     * get y method
     * @return y
     */
    public double getY() {
        return y;
    }
    /**
     * get z method
     * @return z
     */
    public double getZ() {
        return z;
    }

    /**
     * Returns a string representation of the vector in the form (x,y,z).
     * @return the string representation of the vector
     */
    @Override
    public String toString() {
        return String.format("(%.2f,%.2f,%.2f)",x,y,z);
    }

    /**
     *Calculate and return the magnitude of the vector
     * @return the magnitude of the vector
     */
    public double getMagnitude(){
        double Magni = Math.sqrt(Math.pow(x,2) + Math.pow(y,2) + Math.pow(z,2));
        return Magni;
    }

    /**
     * calculate and return the normalized vector
     * @return the normalized vector
     * @throws IllegalStateException
     */
    public Vector3D normalize()throws IllegalStateException{
        double magnitude = getMagnitude();
        if(magnitude == 0){
            throw new IllegalStateException("This vector cannot be normalized");
        }
        Vector3D newVector = new Vector3D(x/magnitude,y/magnitude,z/magnitude);
        return newVector;
    }

    /**
     * calculate and return the vector add another vector
     * @param other
     * @return the result that this vector add another vector
     */
    public Vector3D add(Vector3D other){
        Vector3D newVector = new Vector3D(this.x + other.x,this.y+other.y,this.z+other.z);
        return newVector;
    }

    /**
     * To multiply the vector by a constant number
     * @param constant
     * @return the vector multiply the constant number
     */
    public Vector3D multiply(double constant){
        Vector3D newVector = new Vector3D(x*constant,y*constant,z*constant);
        return newVector;
    }

    /**
     * calculate and return the dot product of vector and another vector
     * @param other
     * @return the result of the dot product of this vector  and another vector
     */
    public double dotProduct(Vector3D other){
        double dotproduct = this.x * other.x+this.y * other.y+this.z * other.z;
        return dotproduct;
    }

    /**
     * To calculate angle between two vectors
     * @param other
     * @return angle between two vectors
     * @throws IllegalStateException
     */
    public double angleBetween(Vector3D other)throws IllegalStateException{
        if(this.getMagnitude() * other.getMagnitude() == 0){
            throw new IllegalStateException("These two vectors cannot calculate the angle");
        }
        double cos = this.dotProduct(other) / (this.getMagnitude() * other.getMagnitude());
        return Math.toDegrees(Math.acos(cos));
    }

    /**
     * get the cross product of two vectors
     * @param other
     * @return the cross product of two vectors
     */
    public Vector3D crossProduct(Vector3D other){
        double u_x = y*other.z - z*other.y;
        double u_y = z*other.x - x*other.z;
        double u_z = x*other.y - y*other.x;
        Vector3D newVector = new Vector3D(u_x,u_y,u_z);
        return newVector;
    }
}
