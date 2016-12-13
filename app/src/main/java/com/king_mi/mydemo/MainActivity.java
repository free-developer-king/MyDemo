package com.king_mi.mydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    public static final int TYPE_A = 100;
    public static final int TYPE_B = 101;

    @BindView(R.id.tv_show_info)
    TextView tvShowInfo;
    @BindView(R.id.btn_next)
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_next)
    public void onClick() {
        Intent intent = new Intent(MainActivity.this, AActivity.class);
        startActivityForResult(intent, TYPE_A);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (RESULT_OK == resultCode) {
            if (TYPE_A == requestCode) {
                String str = data.getStringExtra(AActivity.FORM_ACT);
                tvShowInfo.setText(str);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
