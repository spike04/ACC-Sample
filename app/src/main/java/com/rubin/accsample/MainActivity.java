package com.rubin.accsample;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rubin.accsample.model.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txtUser)
    TextView txtUser;

    @BindView(R.id.txtAge)
    TextView txtAge;

    @BindView(R.id.etName)
    EditText etName;

    @BindView(R.id.etAge)
    EditText etAge;

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        ButterKnife.bind(this);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        viewModel.getUser().observe(this, user -> {
            txtUser.setText(user.name);
            txtAge.setText(String.valueOf(user.age));
        });
    }

    @OnClick(R.id.btnSetUser)
    public void onSetUserClicked() {
        if (etName.getText().toString().trim().isEmpty() || etAge.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "EditText is Empty", Toast.LENGTH_SHORT).show();
        } else {
            User user = new User(etName.getText().toString(), Integer.valueOf(etAge.getText().toString()));
            viewModel.setUser(user);
        }
    }
}
