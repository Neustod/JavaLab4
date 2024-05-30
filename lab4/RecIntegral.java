package lab1;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class RecIntegral implements Serializable {
    public RecIntegral()
    {
        limitL = "";
        limitR = "";
        dx = "";
        result = "";
    }
    
    public RecIntegral(IntegralCalculator src)
    {
        limitL = String.valueOf(src.A());
        limitR = String.valueOf(src.B());
        dx = String.valueOf(src.E());
        result = "";
    }
    
    public RecIntegral(double _limitL, double _limitR, double _dx, double _result) throws IntegralInputException
    {
        if (!(_limitL <= 1.0e+6 && _limitL >= -1.0e+6)) throw new IntegralInputException("Left limit is out of limit.");
        if (!(_limitR <= 1.0e+6 && _limitR >= -1.0e+6)) throw new IntegralInputException("Right limit is out of limit.");
        if (_dx == 0) throw new IntegralInputException("Step cannot be zero.");
        if (_dx > Math.abs(_limitL) + Math.abs(_limitR)) throw new IntegralInputException("Step is greater than integral limit.");
        if (!(_dx <= 1.0e+6 && _dx >= 1.0e-6) ) throw new IntegralInputException("Step is out of limit.");
        if (!(_result <= 1.0e+6 && _result >= -1.0e+6)) throw new IntegralInputException("Result is out of limit.");
        
        limitL = String.valueOf(_limitL);
        limitR = String.valueOf(_limitR);
        dx = String.valueOf(_dx);
        result = String.valueOf(_result);
    }
    
    private String limitL, limitR, dx, result;
    
    public String LimitL() { return limitL; }
    public String LimitR() { return limitR; }
    public String Dx() { return dx; }
    public String Result() { return result; }
    
    public void SetLimitL(double _limitL) throws IntegralInputException
    {
        if (!(_limitL <= 1.0e+6 && _limitL >= -1.0e+6)) throw new IntegralInputException("Left limit is out of limit.");
        if (Double.parseDouble(dx) > Math.abs(_limitL) + Math.abs(Double.parseDouble(limitR))) throw new IntegralInputException("Step is greater than integral limit.");
        
        limitL = String.valueOf(_limitL); 
    }
    public void SetLimitR(double _limitR) throws IntegralInputException 
    { 
        if (!(_limitR <= 1.0e+6 && _limitR >= -1.0e+6)) throw new IntegralInputException("Right limit is out of limit.");
        if (Double.parseDouble(dx) > Math.abs(Double.parseDouble(limitL)) + Math.abs(_limitR)) throw new IntegralInputException("Step is greater than integral limit.");
        
        limitR = String.valueOf(_limitR); 
    }
    public void SetDx(double _dx) throws IntegralInputException 
    { 
        if (_dx == 0) throw new IntegralInputException("Step cannot be zero.");
        if (!(_dx <= 1.0e+6 && _dx >= 1.0e-6) ) throw new IntegralInputException("Step is out of limit.");
        if (_dx > Math.abs(Double.parseDouble(limitL)) + Math.abs(Double.parseDouble(limitR))) throw new IntegralInputException("Step is greater than integral limit.");
        
        dx = String.valueOf(_dx); 
    }
    public void SetResult(double _result) throws IntegralInputException 
    { 
        if (!(_result <= 1.0e+6 && _result >= -1.0e+6)) throw new IntegralInputException("Result is out of limit.");
        
        result = String.valueOf(_result); 
    }
    
    public void Clear()
    {
        limitL = "";
        limitR = "";
        dx = "";
        result = "";
    }
}
