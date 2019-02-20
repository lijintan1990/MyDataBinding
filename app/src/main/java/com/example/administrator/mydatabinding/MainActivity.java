package com.example.administrator.mydatabinding;

import android.databinding.BaseObservable;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.mydatabinding.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private User user;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user = new User("li", "jintan");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setUser(user);
        //user.setIsShow(true);
        binding.setPresenter(new Presenter());
    }

    public class Presenter {
        //普通方法绑定
        public void onTextChanged( CharSequence s,int start,int before,int color){
            user.setFirstName(s.toString());
            binding.setUser(user);
        }
        //普通方法绑定
        public void onClick(View view){
            Toast.makeText(MainActivity.this.getApplicationContext(),"点击了", Toast.LENGTH_LONG).show();
        }
        //监听器绑定，可以返回数据
        public void onClickListenerBinding(User user){
            Toast.makeText(MainActivity.this.getApplicationContext(),user.getLastName(),Toast.LENGTH_LONG).show();
        }
    }
}