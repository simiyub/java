package data;

public class SimpleCalculator {
    private double firstNumber, secondNumber;

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public double getAdditionResult() {
        return firstNumber+secondNumber;
    }

    public double getSubtractionResult() {
        return firstNumber-secondNumber;
    }

    public double getMultiplicationResult() {
        return firstNumber*secondNumber;
    }

    public double getDivisionResult() {
        double result=0;
        if(secondNumber!=0){
            result =firstNumber/secondNumber;
        }
        return result;
    }
}
