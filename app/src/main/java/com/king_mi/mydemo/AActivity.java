package com.king_mi.mydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AActivity extends AppCompatActivity {

    public static final int B_ACTIVITY = 100;

    public static final String FORM_ACT = "form_act";

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.btn_next)
    Button btnNext;
    @BindView(R.id.btn_next_2)
    Button btnNext2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.textView, R.id.btn_next, R.id.btn_next_2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textView:
                backMainActivity("copy form AActivity");
                break;
            case R.id.btn_next:
                Intent intent2 = new Intent(AActivity.this, BActivity.class);
                startActivity(intent2);
                finish();
                break;

            case R.id.btn_next_2:
                Intent intent3 = new Intent(AActivity.this, BActivity.class);
                startActivityForResult(intent3, B_ACTIVITY);
                break;
        }
    }

    private void backMainActivity(String text) {
        Intent intent = new Intent();
        intent.putExtra(FORM_ACT, text);
        setResult(RESULT_OK, intent);
        finish();
    }


    private void doCancelSelect() {
        setResult(RESULT_CANCELED);
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            doCancelSelect();
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (RESULT_OK == resultCode) {
            if (B_ACTIVITY == requestCode) {
                String str = data.getStringExtra(FORM_ACT);
                backMainActivity(str);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
