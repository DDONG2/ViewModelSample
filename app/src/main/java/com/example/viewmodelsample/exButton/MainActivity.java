package com.example.viewmodelsample.exButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.viewmodelsample.R;
import com.example.viewmodelsample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        setContentView(R.layout.activity_main);
        //dataBinding
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //해당 Activity 의 라이프사이클을 참조하면서 데이터변경등을 리프레시 시켜줌
        binding.setLifecycleOwner(this);

        CounterViewModel viewModel = new ViewModelProvider(this).get(CounterViewModel.class);
//        binding.tvCount.setText(viewModel.counter.getValue() + "");

        //bing에 뷰모델을 장착한다. (XML 에서 쓰기 위함)
        binding.setViewModel(viewModel);

        binding.floatingActionButtonPlus.setOnClickListener(v ->{
            viewModel.increase();
//            binding.tvCount.setText(viewModel.counter + "");
        });

        binding.floatingActionButtonMinus.setOnClickListener(v ->{
            viewModel.decrease();
//            binding.tvCount.setText(viewModel.counter + "");
        });

        //위 tvCount.setText 부분을 관찰하여 하나의 소스로 합칠 수 있다.(이마저도 XML 에서 dataBinding처리 할 수 있다.)
//        viewModel.counter.observe(this, new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer integer) {
//                //UI Update
//                binding.tvCount.setText(integer + "");
//            }
//        });




    }



}