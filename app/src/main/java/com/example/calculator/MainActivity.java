package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    /*private Button mBtnNumber0;
    private Button mBtnNumber1;
    private Button mBtnNumber2;
    private Button mBtnNumber3;
    private Button mBtnNumber4;
    private Button mBtnNumber5;
    private Button mBtnNumber6;
    private Button mBtnNumber7;
    private Button mBtnNumber8;
    private Button mBtnNumber9;*/

    private EditText mEdtInput;
    private ListView mLvHistory;

    ArrayList<String> arrayResult;
    ArrayAdapter<String> arrayAdapter;
//    double a = Double.NaN;
//    double b = Double.NaN;
    double a,b;
    private boolean mAddition,mSub,mDiv,mMulti,mSqrt,mOne,mPer,mAddnDiv;
    private Button mBtnNumber1,mBtnNumber2,mBtnNumber3,mBtnNumber4,mBtnNumber5,mBtnNumber6,mBtnNumber7,mBtnNumber8,mBtnNumber9,mBtnNumber0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mBtnNumber1 = (Button)findViewById(R.id.btn_1);
//        mBtnNumber2 = (Button)findViewById(R.id.btn_2);
//        mBtnNumber3 = (Button)findViewById(R.id.btn_3);
//        mBtnNumber4 = (Button)findViewById(R.id.btn_4);
//        mBtnNumber5 = (Button)findViewById(R.id.btn_5);
//        mBtnNumber6 = (Button)findViewById(R.id.btn_6);
//        mBtnNumber7 = (Button)findViewById(R.id.btn_7);
//        mBtnNumber8 = (Button)findViewById(R.id.btn_8);
//        mBtnNumber9 = (Button)findViewById(R.id.btn_9);
//        mBtnNumber0 = (Button)findViewById(R.id.btn_0);

        mEdtInput = (EditText) findViewById(R.id.edt_input);
        mLvHistory = (ListView) findViewById(R.id.lv_history);
        arrayResult = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arrayResult);
        mLvHistory.setAdapter(arrayAdapter);
    }
    public void onClick(View view){
        Toast toast = Toast.makeText(MainActivity.this, "Input Again", Toast.LENGTH_SHORT);
        try{
            switch(view.getId()){
                case R.id.btn_1:
                    mEdtInput.append("1");
                    break;
                case R.id.btn_2:
                    mEdtInput.append("2");
                    break;
                case R.id.btn_3:
                    mEdtInput.append("3");
                    break;
                case R.id.btn_4:
                    mEdtInput.append("4");
                    break;
                case R.id.btn_5:
                    mEdtInput.append("5");
                    break;
                case R.id.btn_6:
                    mEdtInput.append("6");
                    break;
                case R.id.btn_7:
                    mEdtInput.append("7");
                    break;
                case R.id.btn_8:
                    mEdtInput.append("8");
                    break;
                case R.id.btn_9:
                    mEdtInput.append("9");
                    break;
                case R.id.btn_0:
                    mEdtInput.append("0");
                    break;
                case R.id.btn_dot:
                    mEdtInput.append(".");
            }
        }
        catch(NumberFormatException e){
            toast.show();
        }
    }
    public void DoClearC(View view){
        arrayResult.clear();
        arrayAdapter.notifyDataSetChanged();
        mEdtInput.setText("");
    }
    public void DoClearCE(View view){
        mEdtInput.setText("");
    }
    public void DoReset(View view){
        arrayResult.removeAll(arrayResult);
        arrayAdapter.notifyDataSetChanged();

        if(arrayResult.isEmpty()){
            arrayResult.add("There are no history yet!");
        }
    }
    public void DoAdd(View view){
        mAddition = true;
        a = Double.parseDouble(mEdtInput.getText().toString());

        String stringResult = a + "+";
        arrayResult.add(stringResult);
        arrayAdapter.notifyDataSetChanged();
        mEdtInput.setText(null);
    }

    public void DoSub(View view) {
        mSub = true;
        a = Double.parseDouble(mEdtInput.getText().toString());

        String stringResult = a + "-";
        arrayResult.add(stringResult);
        arrayAdapter.notifyDataSetChanged();
        mEdtInput.setText(null);
    }
    public void DoMulti(View view) {
        mMulti = true;
        a = Double.parseDouble(mEdtInput.getText().toString());

        String stringResult = a + "*";
        arrayResult.add(stringResult);
        arrayAdapter.notifyDataSetChanged();
        mEdtInput.setText(null);
    }
    public void DoDiv(View view) {
        mDiv = true;
        a = Double.parseDouble(mEdtInput.getText().toString());

        String stringResult = a + "/";
        arrayResult.add(stringResult);
        arrayAdapter.notifyDataSetChanged();
        mEdtInput.setText(null);
    }
    public void DoDEL(View view){
        String st = mEdtInput.getText().toString();
        if(st.length()>0){
            st = st.substring(0,st.length()-1);
            mEdtInput.setText(st);
        }
    }
    public void DoPer(View view){
        double a;
        a = Double.parseDouble(mEdtInput.getText().toString());
        double result = a /100;
        String stringResult = "%" + a + " = " + result;
        arrayResult.add(stringResult);
        arrayAdapter.notifyDataSetChanged();
        mEdtInput.setText(Double.toString(result));
    }
    public void DoSqrt(View view){
        double a;
        a = Double.parseDouble(mEdtInput.getText().toString());
        double result = Math.sqrt(a);
        String stringResult = "√" + a + " = " + result;
        arrayResult.add(stringResult);
        arrayAdapter.notifyDataSetChanged();
        mEdtInput.setText(Double.toString(result));
    }
    public void DoPow(View view){
        double a;
        a = Double.parseDouble(mEdtInput.getText().toString());
        double result = Math.pow(a,2);
        String stringResult = a + "^2" + " = " + result;
        arrayResult.add(stringResult);
        arrayAdapter.notifyDataSetChanged();
        mEdtInput.setText(Double.toString(result));
    }
    public void DoDivX(View view){
        double a;
        a = Double.parseDouble(mEdtInput.getText().toString());
        double result = 1/a;
        String stringResult = "1/" + a + " = " + result;
        arrayResult.add(stringResult);
        arrayAdapter.notifyDataSetChanged();
        mEdtInput.setText(Double.toString(result));
    }

    public void DoAdd_Sub(View view){
        double a;
        a = Double.parseDouble(mEdtInput.getText().toString());
        double result = a * -1;
        String stringResult = a + " = " + result;
        arrayResult.add(stringResult);
        arrayAdapter.notifyDataSetChanged();
        mEdtInput.setText(Double.toString(result));
    }
    public void Doequal(View view){
        double result = 0;
        if(mAddition) {
            if (!Double.isNaN(a)) {
                b = Double.parseDouble(mEdtInput.getText().toString());
                result = a + b;
            }
            mAddition = false;
        }
        else if(mSub){
            if (!Double.isNaN(a)) {
                b = Double.parseDouble(mEdtInput.getText().toString());
                result = a - b;
            }
            mSub = false;
        }
        else if(mMulti){
            if (!Double.isNaN(a)) {
                b = Double.parseDouble(mEdtInput.getText().toString());
                result = a * b;
            }
            mMulti = false;
        }
        else if(mDiv){
            if (!Double.isNaN(a)) {
                b = Double.parseDouble(mEdtInput.getText().toString());
                result = a / b;
            }
            mDiv = false;
        }
        arrayResult.add(0,Double.toString(result));
        arrayAdapter.notifyDataSetChanged();
        mEdtInput.setText(Double.toString(result));
    }
//    public void DoDel(View view){
//        double a;
//        a = Double.parseDouble(mEdtInput.getText().toString());
//        double result = 1/a;
//        String stringResult = "1/" + a + " = " + result;
//        arrayResult.add(stringResult);
//        arrayAdapter.notifyDataSetChanged();
//        mEdtInput.setText(Double.toString(result));
//    }
}
