package lesson4;

public class TriangleArea {

    private int a;
    private int b;
    private int c;

    public TriangleArea(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double calcTriangleArea () throws NonExistentTriangle {
        float p;
        if (c <= 0 || a <= 0 || b <= 0) {
            throw new NonExistentTriangle("Одна сторона треугольника отрицательная или равна 0!");
        } else {
            if ( (a + b) < c || (b + c) < a || (a + c) < b) {
                throw new NonExistentTriangle("Такого треугольника не существует!");
            } else {
                p = ((float) a + b + c) / 2;
                return (Math.sqrt(p * (p - a) * (p - b) * (p - c)));
            }
        }
    }

    @Override
    public String toString() {
        return "TriangleArea{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    public static void main(String[] args) throws NonExistentTriangle {

        TriangleArea triangleArea = new TriangleArea(25,20,6);
        System.out.println(triangleArea.calcTriangleArea());
    }
}
