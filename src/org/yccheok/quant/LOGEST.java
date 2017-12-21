/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yccheok.quant;

/**
 *
 * @author yccheok
 */
public class LOGEST {
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
