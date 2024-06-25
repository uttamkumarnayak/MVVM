package com.uttam.mvvm.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import com.uttam.mvvm.viewmodel.AppViewModel;
import com.uttam.mvvm.R;
import com.uttam.mvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding
                = DataBindingUtil.setContentView(
                this, R.layout.activity_main);
        activityMainBinding.setViewModel(
                new AppViewModel());
        activityMainBinding.executePendingBindings();

    }
    // any change in toastMessage attribute
// defined on the Button with bind prefix
// invokes this method
    @BindingAdapter({ "toastMessage" })
    public static void runMe(View view, String message)
    {
        if (message != null)
            Toast
                    .makeText(view.getContext(), message,
                            Toast.LENGTH_SHORT)
                    .show();
    }
}