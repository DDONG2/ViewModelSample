package com.example.viewmodelsample.exFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.example.viewmodelsample.R;
import com.example.viewmodelsample.databinding.FragmentSeekBarBinding;
import com.example.viewmodelsample.exButton.CounterViewModel;

public class SeekBarFragment extends Fragment {


    public SeekBarFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_seek_bar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        VmShareViewModel viewModel = new ViewModelProvider(requireActivity()).get(VmShareViewModel.class);

        FragmentSeekBarBinding binding = DataBindingUtil.bind(view);
        binding.setLifecycleOwner(requireActivity());
        binding.setViewModel(viewModel);

        binding.seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                viewModel.progress.setValue(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

//        viewModel.progress.observe(requireActivity(), new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer integer) {
//                binding.seekbar.setProgress(integer);
//            }
//        });

    }
}