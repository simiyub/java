package data;

public class ComplexNumber {
    private double imaginary;
    private double real;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary=imaginary;
    }

    public double getImaginary() {
        return imaginary;
    }

    public double getReal() {
        return real;
    }

    public void add(double real, double imaginary) {
        this.real=getReal()+real;
        this.imaginary=getImaginary()+imaginary;

    }

    public void add(ComplexNumber number) {
        this.real=getReal()+number.getReal();
        this.imaginary=getImaginary()+number.getImaginary();
    }

    public void subtract(ComplexNumber complexNumber) {
        this.real=getReal()-complexNumber.getReal();
        this.imaginary=getImaginary()-complexNumber.getImaginary();
    }

    public void subtract(double real, double imaginary) {
        this.real=getReal()-real;
        this.imaginary=getImaginary()-imaginary;
    }
}
