public class Point3d extends Point2d {
    /** координата Z **/
    private double zCoord;
    /** Конструктор инициализации **/
    public Point3d (double x, double y, double z){
        super (x, y);
        zCoord=z;
    }
    /** Конструктор по умолчанию. **/
    public Point3d() {
        this (0,0,0);
    }
    /** Возвращение координаты Z **/
    public double getZ () {
        return zCoord;
    }
    /** Установка значения координаты Z. **/
    public void setZ (double val) {
        zCoord = val;
    }
}