/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yccheok.quant;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yccheok
 */
public class LOGEST {
    private static double[] convertDoubles(List<Double> doubles)
    {
        double[] vals = new double[doubles.size()];
        int i = 0;
        for (Double d : doubles) {
            vals[i++] = d;
        }
        return vals;
    }

    public static double growth_rate(double[] y, double[] x) {
        final int length = y.length;
        
        if (length <= 1) {
            return Double.NaN;
        }
        
        if (x.length <= 1) {
            return Double.NaN;
        }
        
        if (x.length != length) {
            return Double.NaN;
        }
        
        ArrayList<Double> _y = new ArrayList<Double>();
        ArrayList<Double> _x = new ArrayList<Double>();
        
        for (int i=0; i<length; i++) {
            double y_value = y[i];
            
            if (y_value <= 0) {
                continue;
            }
            
            _y.add(y_value);
            _x.add(x[i]);
        }
                
        double growthRate = logest(convertDoubles(_y), convertDoubles(_x));
        
        return growthRate;
    }
    
    public static double logest(double[] y, double[] x) {
        final int length = y.length;
        
        if (length <= 0) {
            return Double.NaN;
        }
        
        if (x.length <= 0) {
            return Double.NaN;
        }
        
        if (x.length != length) {
            return Double.NaN;
        }

        double[] log10_y = new double[length];
        
        for (int i=0; i<length; i++) {
            log10_y[i] = Math.log10(y[i]);
        }
        
        double m = linest(log10_y, x);
        
        return Math.pow(10, m) - 1;
    }
    
    private static double linest(double[] y, double[] x) {
        final int length = y.length;
        
        double[] xy = new double[length];
        double[] xx = new double[length];
        
        for (int i=0; i<length; i++) {
            double _x = x[i];
            double _y = y[i];
            
            xy[i] = _x * _y;
            xx[i] = _x * _x;
        }
        
        double sum_xy = sum(xy);
        double sum_x = sum(x);
        double sum_y = sum(y);
        double sum_xx = sum(xx);
        double sum_x_sum_x = sum_x * sum_x;
        
        final double denominator = (length * sum_xx - sum_x_sum_x);
        
        if (denominator == 0.0) {
            return Double.NaN;
        }
        
        double m = (length * sum_xy - sum_x * sum_y) / denominator;
        
        return m;
    }
    
    private static double sum(double[] x) {
        double sum = 0.0;
        
        for (double _x : x) {
            sum = sum + _x;
        }
        
        return sum;
    }
}
