package ru.ssau.tk.ArtKsenInc.OOP_JAVA.functions;
import ru.ssau.tk.ArtKsenInc.OOP_JAVA.functions.myOwnFunctionsForEquation.MathDerivativeAndIntegral;

import java.lang.Math;
import ru.ssau.tk.ArtKsenInc.OOP_JAVA.ui.annotations.MathFunctionInfo;
@MathFunctionInfo(name = "Косинус", priority = 3)
public class CosFunction implements MathDerivativeAndIntegral {
    private final double constant;
    public CosFunction(double constant){
        this.constant = constant;
    }
    public CosFunction(){
        this.constant = 1;
    }
    @Override
    public double apply(double x) {
        return constant*Math.cos(x);
    }

    @Override
    public double derivative(double x) {
        return -constant*Math.sin(x);
    }

    @Override
    public double integral(double x0, double x) {
        return constant*(Math.sin(x) - Math.sin(x0));
    }
}