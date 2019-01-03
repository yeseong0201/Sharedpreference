package com.example.ys020.sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView tv;
    EditText edt;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        tv = findViewById(R.id.tv);
        edt = findViewById(R.id.edt);


        pref = getSharedPreferences("ang", MODE_PRIVATE); // ang이라는 네임파일을 찾는다.
        String text = pref.getString("text", ""); // 저장된 값이 있는지 확인, 없으면 ""반환
        tv.setText(text);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getSharedPreferences("ang",MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                String text = edt.getText().toString(); // 입력한 텍스트 저장
                editor.putString("text",text); //String 타입으로 저장
                editor.commit();
            }
        });
    }
}
