package com.example.viewmodelsample.exButton;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CounterViewModel extends ViewModel {

    //수정가능 = MutableLiveData 셋할필요없으면 LiveData
    public MutableLiveData<Integer> counter = new MutableLiveData<>();

    public CounterViewModel(){
        counter.setValue(0);
    }

    public void increase(){
        counter.setValue(counter.getValue() + 1);
    }

    public void decrease(){
        counter.setValue(counter.getValue() - 1);
    }

}
