package ru.ssau.tk.ArtKsenInc.OOP_JAVA.functions;

import ru.ssau.tk.ArtKsenInc.OOP_JAVA.exceptions.ArrayIsNotSortedException;
import ru.ssau.tk.ArtKsenInc.OOP_JAVA.exceptions.DifferentLengthOfArraysException;

import java.io.Serial;
import java.io.Serializable;

public abstract class AbstractTabulatedFunction implements TabulatedFunction, Serializable {
    @Serial
    private static final long serialVersionUID = -1336796703589571577L;
    protected int count;

    protected abstract int floorIndexOfX(double x);

    protected abstract double extrapolateLeft(double x);

    protected abstract double extrapolateRight(double x);

    protected abstract double interpolate(double x, int floorIndex);

    protected double interpolate(double x, double leftX, double rightX, double leftY, double rightY) {
        return leftY + ((rightY - leftY) / (rightX - leftX)) * (x - leftX);
    }

    protected static void checkLengthIsTheSame(double[] xValues, double[] yValues){
        if(xValues.length != yValues.length)
            throw new DifferentLengthOfArraysException("Количество x и y должны совпадать!");
    }

    protected static void checkSorted(double[] xValues) {
        for (int i = 0; i < xValues.length - 1; ++i) {
            if(xValues[i] > xValues[i+1])
                throw new ArrayIsNotSortedException("Значения x идут не по возрастанию!");
        }
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public double apply(double x) {
        //Если x меньше левой границы
        if (x < getX(0)) {
            return extrapolateLeft(x);
        }
        //Если x больше правой границы
        if (x > getX(getCount() - 1)) {
            return extrapolateRight(x);
        }
        //Смотрим, есть ли x в таблице
        int index = indexOfX(x);
        if (index != -1) {
            return getY(index);
        }
        //Если нет, ищем максимальный x из таблицы, который меньше указанного x
        index = floorIndexOfX(x);
        return interpolate(x, index);
    }
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(getClass().getName()).append(" size = ").append(getCount()).append('\n');
        for (Point point: this){
            str.append('[').append(point.x).append(", ").append(point.y).append(']').append('\n');
        }
        return str.toString();
    }
}
