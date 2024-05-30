package lab1;

/**
 *
 * @author User
 */
public class IntegralCalculator {
    
    public IntegralCalculator()
    {
        a = 0;
        b = 1;
        e = 1.0e-4;
    }
    
    public IntegralCalculator(double _a, double _b, double _e) throws IntegralInputException
    {
        if (!(_a <= 1.0e+6 && _a >= -1.0e+6)) throw new IntegralInputException("Left limit is out of limit.");
        if (!(_b <= 1.0e+6 && _b >= -1.0e+6)) throw new IntegralInputException("Right limit is out of limit.");
        if (_e == 0) throw new IntegralInputException("Step cannot be zero.");
        if (_e > Math.abs(_a) + Math.abs(_b)) throw new IntegralInputException("Step is greater than integral limit.");
        if (_e <= 1.0e+6 && _e >= 1.0e-6) e = Math.abs(_e); 
        else throw new IntegralInputException("Step is out of limit.");
        
        if (_a > _b)
        {
            a = _b;
            b = _a;
        }
        else 
        {
            a = _a;
            b = _b;
        }
    }
    
    private double e, a, b;
    
    public double E() { return e; }
    public double A() { return a; }
    public double B() { return b; }
    
    public void SetE(double _e) throws IntegralInputException 
    {
        if (_e == 0) throw new IntegralInputException("Step cannot be zero.");
        if (_e > Math.abs(a) + Math.abs(b)) throw new IntegralInputException("Step is greater than integral limit.");
        if (_e <= 1.0e+6 && _e >= 1.0e-6) e = Math.abs(_e); 
        else throw new IntegralInputException("Step is out of limit.");
    }
    
    public void SetArea(double _a, double _b) throws IntegralInputException {
        if (!(_a <= 1.0e+6 && _a >= -1.0e+6)) throw new IntegralInputException("Left limit is out of limit.");
        if(!(_b <= 1.0e+6 && _b >= -1.0e+6)) throw new IntegralInputException("Right limit is out of limit.");
        if (e > Math.abs(_a) + Math.abs(_b)) throw new IntegralInputException("Step is greater than integral limit.");
        
        if (_a > _b)
        {
            a = _b;
            b = _a;
        }
        else
        {
            a = _a;
            b = _b;
        }
    }
    
    public double F()
    {
        double result = 0;
        double lBound = a, rBound = a + e;
        
        while (rBound < b)
        {
            result += e * (Math.exp(-lBound) + Math.exp(-rBound)) / 2;
            
            lBound += e;
            rBound += e;
        }
        
        if (lBound < b) result += e * (Math.exp(-lBound) + Math.exp(-b)) / 2;
        
        return result;
    }
}
