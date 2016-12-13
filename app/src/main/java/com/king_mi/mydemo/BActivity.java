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

public class BActivity extends AppCompatActivity {

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
        btnNext.setVisibility(View.GONE);
        btnNext2.setVisibility(View.GONE);
    }

    @OnClick({R.id.textView, R.id.btn_next, R.id.btn_next_2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textView:
                backAActivity("copy form BActivity");
                break;

        }
    }

    private void backAActivity(String text) {
        Intent intent = new Intent();
        intent.putExtra(AActivity.FORM_ACT, text);
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
}
