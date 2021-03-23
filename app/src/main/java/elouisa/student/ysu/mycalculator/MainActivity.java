package elouisa.student.ysu.mycalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private final Calculator calculator;
    private EditText display;
    private EditText subDisplay;

    public MainActivity() {
        super();
        calculator = new Calculator();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = this.findViewById(R.id.display);
        subDisplay = this.findViewById(R.id.display2);
        {

        this.findViewById(R.id.zeroButton).setOnClickListener(view -> {
            handleInput(0);
        });

        this.findViewById(R.id.oneButton).setOnClickListener(view -> {
            handleInput(1);
        });

        this.findViewById(R.id.twoButton).setOnClickListener(view -> {
            handleInput(2);
        });

        this.findViewById(R.id.threeButton).setOnClickListener(view -> {
            handleInput(3);
        });

        this.findViewById(R.id.fourButton).setOnClickListener(view -> {
            handleInput(4);
        });

        this.findViewById(R.id.fiveButton).setOnClickListener(view -> {
            handleInput(5);
        });

        this.findViewById(R.id.sixButton).setOnClickListener(view -> {
            handleInput(6);
        });

        this.findViewById(R.id.sevenbutton).setOnClickListener(view -> {
            handleInput(7);
        });

        this.findViewById(R.id.eightButton).setOnClickListener(view -> {
            handleInput(8);
        });

        this.findViewById(R.id.nineButton).setOnClickListener(view -> {
            handleInput(9);
        });

        this.findViewById(R.id.decimalButton).setOnClickListener(view -> {
            decimal();
        });

        this.findViewById(R.id.additionButton).setOnClickListener(view -> {
            handleOperator(Operator.Add);
        });

        this.findViewById(R.id.subtractButton).setOnClickListener(view -> {
            handleOperator(Operator.Subtract);
        });

        this.findViewById(R.id.multiplicationButton).setOnClickListener(view -> {
            handleOperator(Operator.Multiply);
        });

        this.findViewById(R.id.divideButton).setOnClickListener(view -> {
            handleOperator(Operator.Divide);
        });
    }

        this.findViewById(R.id.equalButton).setOnClickListener(view -> {
            equal();
        });

        this.findViewById(R.id.acButton).setOnClickListener(view -> {
            resetCalc();
        });

        this.findViewById(R.id.plusMinusButton).setOnClickListener(view -> {
            signFlip();
        });

        this.findViewById(R.id.percentButton).setOnClickListener(view -> {
            percent();
        });

    }

    private void resetCalc(){
        calculator.clearValues();
        display.setText("0");
        subDisplay.setText("Clear");

    }
    private void signFlip(){
        calculator.signFlipTotal();
        display.setText(calculator.getInput());
    }

    private void equal(){
        calculator.equalTotal();
        display.setText(calculator.getInput());
    }
    private void percent(){
        calculator.percentInput();
        display.setText(calculator.getInput());

    }


    private void handleInput(Integer number) {
        calculator.inputNumber(number);
        display.setText(calculator.getInput());
        subDisplay.setText(calculator.getPreviousInput());
    }

    private void handleOperator(Operator operator) {
        calculator.inputOperator(operator);

        display.setText(calculator.getInput());
        subDisplay.setText(calculator.getPreviousInput());
    }
    private void decimal(){
        calculator.addDecimal();
        display.setText(calculator.getInput());
        subDisplay.setText(calculator.getPreviousInput());

    }

}