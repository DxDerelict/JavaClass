package elouisa.student.ysu.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private final Calculator calculator;
    private EditText display;

    public MainActivity() {
        super();
        calculator = new Calculator();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = this.findViewById(R.id.display);

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

        this.findViewById(R.id.plusButton).setOnClickListener(view -> {
            handleOperator(Operator.Add);
        });
    }

    private void handleInput(Integer number) {
        calculator.inputNumber(number);
        display.setText(calculator.getInput());
    }

    private void handleOperator(Operator operator) {
        calculator.inputOperator(operator);
        display.setText(calculator.getInput());
    }
}