package com.example.electricitybillcalculator;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity_billcalculation extends AppCompatActivity {

    private EditText lmEtv,cmEtv,oaEtv;
    private Button clearBtn, calculateBtn;
    private TextView ucTv,ucpTv,taTv,maTv;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_billcalculation);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lmEtv = (EditText) findViewById(R.id.lmETV);
        cmEtv = (EditText) findViewById(R.id.cmETV);
        oaEtv = (EditText) findViewById(R.id.oaETV);

        clearBtn = (Button) findViewById(R.id.clearBTN);
        calculateBtn = (Button) findViewById(R.id.calBTN);

        ucTv = (TextView) findViewById(R.id.ucTV);
        ucpTv = (TextView) findViewById(R.id.ucpTV);
        taTv = (TextView) findViewById(R.id.taTV);
        maTv = (TextView) findViewById(R.id.maTV);




        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lmEtv.setText("");
                cmEtv.setText("");
                oaEtv.setText("");
                ucTv.setVisibility(View.INVISIBLE);
                maTv.setVisibility(View.INVISIBLE);
                taTv.setVisibility(View.INVISIBLE);
                ucpTv.setText("");
            }
        });


        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double amount;
                double repoint;
                double amountOut;

                if(lmEtv.getText().toString().trim().isEmpty())
                {
                    lmEtv.setText("0");
                    lmEtv.setTextColor(Color.RED);
                }else if (cmEtv.getText().toString().trim().isEmpty())
                {
                    cmEtv.setText("0");
                    cmEtv.setTextColor(Color.RED);
                }else if (oaEtv.getText().toString().trim().isEmpty())
                {
                    oaEtv.setText("0");
                    oaEtv.setTextColor(Color.RED);
                }else
                {
                    double lm = Double.parseDouble(lmEtv.getText().toString());
                    double cm = Double.parseDouble(cmEtv.getText().toString());
                    double oa = Double.parseDouble(oaEtv.getText().toString());


                    double usePoint = cm-lm;

                    if(usePoint <= 100)
                    {
                         amount  = usePoint * 40;
                         amountOut = amount + oa;
                         ucTv.setText(Double.toString(usePoint));
                         ucpTv.setText(Double.toString(usePoint));
                         maTv.setText(Double.toString(amount));
                         taTv.setText(Double.toString(amountOut));
                         ucTv.setVisibility(View.VISIBLE);
                         maTv.setVisibility(View.VISIBLE);
                         taTv.setVisibility(View.VISIBLE);



                    } else if (usePoint > 100) {

                         repoint  = usePoint-100;
                         amount = (repoint * 56 ) + (100* 40);
                         amountOut = amount + oa;
                         ucTv.setText(Double.toString(usePoint));
                         ucpTv.setText(Double.toString(usePoint));
                         maTv.setText(Double.toString(amount));
                         taTv.setText(Double.toString(amountOut));
                            ucTv.setVisibility(View.VISIBLE);
                            maTv.setVisibility(View.VISIBLE);
                            taTv.setVisibility(View.VISIBLE);

                    }else if (usePoint >200)
                    {
                          repoint = usePoint - 200;
                          amount = (repoint * 70)+ (repoint * 56 ) + (100* 40);
                          amountOut = amount + oa;
                          ucTv.setText(Double.toString(usePoint));
                          ucpTv.setText(Double.toString(usePoint));
                          maTv.setText(Double.toString(amount));
                          taTv.setText(Double.toString(amountOut));
                            ucTv.setVisibility(View.VISIBLE);
                            maTv.setVisibility(View.VISIBLE);
                            taTv.setVisibility(View.VISIBLE);

                    } else if (usePoint > 300) {

                            repoint = usePoint - 300 ;
                            amount = (repoint * 100) + (repoint * 70)+ (repoint * 56 ) + (100* 40);
                            amountOut = amount + oa;
                            ucTv.setText(Double.toString(usePoint));
                            ucpTv.setText(Double.toString(usePoint));
                            maTv.setText(Double.toString(amount));
                            taTv.setText(Double.toString(amountOut));
                                ucTv.setVisibility(View.VISIBLE);
                                maTv.setVisibility(View.VISIBLE);
                                taTv.setVisibility(View.VISIBLE);

                    }


                }
            }
        });







    }
}