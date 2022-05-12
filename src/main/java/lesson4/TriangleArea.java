package lesson4;

public class TriangleArea {

    private double a;
    private double b;
    private int alpha;

    public TriangleArea(double a, double b, int alpha) {
        this.a = a;
        this.b = b;
        this.alpha = alpha;
    }

    public double calcTriangleArea () throws NonExistentTriangle {
        if (alpha < 1 || alpha > 179 || a <= 0 || b <= 0) {
            throw new NonExistentTriangle("Некорректно заданы угол или стороны треугольника! Введите корректные данные и повторите попытку");
        } else {
        return (0.5 * a * b * (Math.sin(Math.toRadians(alpha))));
        }
    }

    @Override
    public String toString() {
        return "TriangleArea{" +
                "a=" + a +
                ", b=" + b +
                ", alpha=" + alpha +
                '}';
    }

    public static void main(String[] args) throws NonExistentTriangle {

        TriangleArea triangleArea = new TriangleArea(2,5,179);
        System.out.println(triangleArea.calcTriangleArea());
    }
}
