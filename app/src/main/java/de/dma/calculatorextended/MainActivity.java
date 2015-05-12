package de.dma.calculatorextended;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class MainActivity extends Activity {

    private double result;
    private boolean ok = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_c = (Button) findViewById(R.id.button_c);

        button_c.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                TextView exp = (TextView) findViewById(R.id.expression);
                exp.setText("");
                return true;
            }
        });

        button_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView exp = (TextView) findViewById(R.id.expression);

                if (exp.getText().toString().length() > 0)
                    exp.setText(exp.getText().toString().substring(0, exp.getText().length() - 1));
            }
        });

        Button button_equals = (Button) findViewById(R.id.button_equals);

        button_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView expression = (TextView) findViewById(R.id.expression);
                if (expression.getText().toString() != "") {
                    if (expression.getText().toString().substring(expression.getText().length() - 1, expression.getText().length()).matches("-?\\d+(\\.\\d+)?")) {
                        try {
                            Expression e = new ExpressionBuilder(expression.getText().toString()).build();
                            result = e.evaluate();
                            expression.setText(Double.toString(result));
                        }
                        catch (ArithmeticException ex) {
                            Context context = getApplicationContext();

                            Toast.makeText(context, "Ungültige Rechenoperation!", Toast.LENGTH_LONG).show();
                        }
                        catch (NumberFormatException ex) {
                            Context context = getApplicationContext();

                            Toast.makeText(context, "Ungültige Rechenoperation!", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });
    }

    public void on1xClick(View v) {
        TextView exp = (TextView) findViewById(R.id.expression);

        if (exp.getText().length() > 0) {
            exp.setText(Double.toString(1 / Double.parseDouble(exp.getText().toString())));
        }
    }

    public void onX2Click(View v) {
        TextView exp = (TextView) findViewById(R.id.expression);

        if (exp.getText().length() > 0) {
            exp.setText(Double.toString(Math.pow(Double.parseDouble(exp.getText().toString()), 2)));
        }
    }

    public void onSqrtClick(View v) {
        TextView exp = (TextView) findViewById(R.id.expression);
            if (exp.getText().length() > 0) {
                exp.setText(Double.toString(Math.sqrt(Double.parseDouble(exp.getText().toString()))));
        }
    }

    public void onFacultyClick(View v) {
        TextView exp = (TextView) findViewById(R.id.expression);

        if (exp.getText().length() > 0) {

            double value = Double.parseDouble(exp.getText().toString());

            for (int i = 1; i <= value; i++) {
                value *= i;
            }
            exp.setText(Double.toString(value));
        }
    }

    public void onSinusClick(View v) {
        TextView exp = (TextView) findViewById(R.id.expression);

        if (exp.getText().length() > 0) {
            exp.setText(Double.toString(Math.sin(Double.parseDouble(exp.getText().toString()))));
        }
    }

    public void onCosinusClick(View v) {
        TextView exp = (TextView) findViewById(R.id.expression);

        if (exp.getText().length() > 0) {
            exp.setText(Double.toString(Math.cos(Double.parseDouble(exp.getText().toString()))));
        }
    }

    public void onTangensClick(View v) {
        TextView exp = (TextView) findViewById(R.id.expression);

        if (exp.getText().length() > 0) {
            exp.setText(Double.toString(Math.tan(Double.parseDouble(exp.getText().toString()))));
        }
    }

    public void onLogClick(View v) {
        TextView exp = (TextView) findViewById(R.id.expression);

        if (exp.getText().length() > 0) {
            exp.setText(Double.toString(Math.log(Double.parseDouble(exp.getText().toString()))));
        }
    }

    public void onEClick(View v) {
        TextView exp = (TextView) findViewById(R.id.expression);

        if (exp.getText().length() > 0) {

            String temp = "exp(" + exp.getText().toString() + ")";

            try {
                Expression e = new ExpressionBuilder(temp).build();
                result = e.evaluate();
                exp.setText(Double.toString(result));
            }
            catch (ArithmeticException ex) {
                Context context = getApplicationContext();

                Toast.makeText(context, "Ungültige Rechenoperation!", Toast.LENGTH_LONG).show();
            }
            catch (NumberFormatException ex) {
                Context context = getApplicationContext();

                Toast.makeText(context, "Ungültige Rechenoperation!", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v ) {

        TextView exp = (TextView) findViewById(R.id.expression);

        switch (v.getId()) {
            case R.id.button_plusminus:
                exp.append("");
                break;
            case  R.id.button_euro:
                exp.append("");
                break;
            case R.id.button_division:
                if (ok)
                    exp.append("/");
                ok = false;
                break;
            case R.id.button_7:
                exp.append("7");
                ok = true;
                break;
            case R.id.button_8:
                exp.append("8");
                ok = true;
                break;
            case R.id.button_9:
                exp.append("9");
                ok = true;
                break;
            case R.id.button_multiply:
                if (ok)
                    exp.append("*");
                ok = false;
                break;
            case R.id.button_4:
                exp.append("4");
                ok = true;
                break;
            case R.id.button_5:
                exp.append("5");
                ok = true;
                break;
            case R.id.button_6:
                exp.append("6");
                ok = true;
                break;
            case R.id.button_addition:
                if (ok)
                    exp.append("+");
                ok = false;
                break;
            case R.id.button_1:
                exp.append("1");
                ok = true;
                break;
            case R.id.button_2:
                exp.append("2");
                ok = true;
                break;
            case R.id.button_3:
                exp.append("3");
                ok = true;
                break;
            case R.id.button_minus:
                if (ok)
                    exp.append("-");
                ok = false;
                break;
            case R.id.button_0:
                exp.append("0");
                ok = true;
                break;
            case R.id.button_dot:
                if (ok)
                    exp.append(".");
                ok = false;
                break;
            case R.id.button_pi:
                if (ok)
                    exp.append(Double.toString(Math.PI));
                ok = true;
                break;
            default:
                break;
        }
    }
}
