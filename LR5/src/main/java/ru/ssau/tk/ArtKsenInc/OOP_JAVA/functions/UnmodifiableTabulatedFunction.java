package ru.ssau.tk.ArtKsenInc.OOP_JAVA.functions;

import java.util.Iterator;

public class UnmodifiableTabulatedFunction implements TabulatedFunction{
    private final TabulatedFunction tabulatedFunction;
    public UnmodifiableTabulatedFunction(TabulatedFunction tabulatedFunction){
        this.tabulatedFunction = tabulatedFunction;
    }
    @Override
    public int getCount() {
        return tabulatedFunction.getCount();
    }

    @Override
    public double getX(int index) {
        return tabulatedFunction.getX(index);
    }

    @Override
    public double getY(int index) {
        return tabulatedFunction.getY(index);
    }

    @Override
    public void setY(int index, double value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOfX(double x) {
        return tabulatedFunction.indexOfX(x);
    }

    @Override
    public int indexOfY(double y) {
        return tabulatedFunction.indexOfY(y);
    }

    @Override
    public double leftBound() {
        return tabulatedFunction.leftBound();
    }

    @Override
    public double rightBound() {
        return tabulatedFunction.rightBound();
    }

    @Override
    public double apply(double x) {
        return tabulatedFunction.apply(x);
    }
    @Override
    public void insert(double x, double y){
        tabulatedFunction.insert(x, y);
    }
    @Override
    public void remove(int index){
        tabulatedFunction.remove(index);
    }
    @Override
    public Iterator<Point> iterator() {
        return tabulatedFunction.iterator();
    }
}
