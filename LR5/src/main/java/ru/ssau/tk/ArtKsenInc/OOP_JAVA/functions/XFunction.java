package ru.ssau.tk.ArtKsenInc.OOP_JAVA.functions;
import ru.ssau.tk.ArtKsenInc.OOP_JAVA.functions.myOwnFunctionsForEquation.MathDerivativeAndIntegral;

import java.lang.Math;

import ru.ssau.tk.ArtKsenInc.OOP_JAVA.ui.annotations.MathFunctionInfo;
@MathFunctionInfo(name = "X", priority = 1)
public class XFunction implements MathDerivativeAndIntegral {
    private final double constant;
    private double degree;
    public XFunction(double constant){
        this.constant = constant;
    }
    public XFunction(double constant, double degree){
        this.constant = constant;
        this.degree = degree;
    }
    public XFunction(){
        this.constant = 1;
        this.degree = 1;
    }
    @Override
    public double apply(double x) {
        return constant*Math.pow(x, degree);
    }

    @Override
    public double derivative(double x) {
        return constant*degree*Math.pow(x, degree-1);
    }

    @Override
    public double integral(double x0, double x) {
        if(degree!= 1)
            return constant*(Math.pow(x, degree+1)/(degree+1)) - constant*(Math.pow(x0, degree+1)/(degree+1));
        else return constant*(Math.log(x) - Math.log(x0));
    }
}
