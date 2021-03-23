package elouisa.student.ysu.mycalculator;

public class Calculator {
    private static final String INITIAL_VALUE = "0";

    private String input;
    private String previousInput;
    private Operator operator;
    private Operator previousOperator;
    private Boolean clearInput;

    public Calculator() {
        this.input = INITIAL_VALUE;
        this.previousInput = INITIAL_VALUE;
        this.previousOperator = null;
        this.clearInput = false;
    }

    public void clearValues(){
        this.input = INITIAL_VALUE;
        this.previousInput = INITIAL_VALUE;
        this.operator = null;
        this.clearInput = false;

    }

    public void inputNumber(Integer number) {
        if (clearInput) {
            previousInput = input;
            input = number.toString();
            clearInput = false;
        } else if (input.equals(INITIAL_VALUE)) {
            input = number.toString();
        } else {
            input += number.toString();
        }
    }

    public void inputOperator(Operator operator) {
        if (this.operator != null) {
            this.calculateTotal();
            this.previousOperator = this.operator;
        }
        this.operator = operator;
        this.previousOperator = this.operator;
        this.clearInput = true;
    }

    private void calculateTotal() {
        Double total = 0.0;
        Double valueOne = Double.parseDouble(previousInput);
        Double valueTwo = Double.parseDouble(input);

        switch (operator) {
            case Add:
                total = valueOne + valueTwo;
                break;
            case Subtract:
                total = valueOne - valueTwo;
                break;
            case Multiply:
                total = valueOne * valueTwo;
                break;
            case Divide:
                total = valueOne / valueTwo;
                break;
        }

        if ((total == Math.floor(total)) && !Double.isInfinite(total)) {
            input = total.toString();   //Working to remove zeros past decimal point

        }
        input = total.toString();
    }

    public void equalTotal(){
        this.calculateTotal();
        clearInput =true;
    }

    public void signFlipTotal(){
        if(input.contains("-")){
            double val =  Double.parseDouble(input);
            val = -val;
            input = String.valueOf(val);

        }else {
            input = '-' + input;
        }
    }

    public void addDecimal() {
        if (clearInput) {
            input = "0.";
            clearInput =false;
        }
        if (!input.contains(".")) {
            input = input + '.';
        }
    }

    public void percentInput(){
        double val =  Double.parseDouble(input);
        val = val/100;
        input = String.valueOf(val);
    }

    public String getInput() {
        return this.input;
    }

    public String getPreviousInput(){
        return this.previousInput;
    }
}
