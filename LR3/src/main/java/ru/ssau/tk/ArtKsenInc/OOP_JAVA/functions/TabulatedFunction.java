package ru.ssau.tk.ArtKsenInc.OOP_JAVA.functions;

public interface TabulatedFunction extends MathFunction, Iterable<Point> {
    int getCount();
    double getX(int index);
    double getY(int index);
    void setY(int index, double value);
    int indexOfX(double x);
    int indexOfY(double y);
    double leftBound();
    double rightBound();
}
