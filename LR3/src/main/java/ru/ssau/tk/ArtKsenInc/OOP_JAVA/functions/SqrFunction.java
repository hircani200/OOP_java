package ru.ssau.tk.ArtKsenInc.OOP_JAVA.functions;
import java.lang.Math;
public class SqrFunction implements MathFunction{
    @Override
    public double apply(double x) {
        return Math.sqrt(x);
    }
}
