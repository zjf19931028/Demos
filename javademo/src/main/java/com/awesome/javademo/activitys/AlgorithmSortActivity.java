package com.awesome.javademo.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.awesome.javademo.R;
import com.awesome.javademo.algorithm.SolutionSort;
import com.awesome.sdk.util.ShowLogUtil;

public class AlgorithmSortActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algorithm_sort);

        int[] num1 = new int[]{1, 3, 4, 0, 0, 0};
        int[] num2 = new int[]{2, 5, 6};
        SolutionSort.merge(num1, 3, num2, 3);
        for (int i = 0; i < num1.length; i++) {
            ShowLogUtil.info(num1[i]);
        }

//        int[] arr = new int[]{1, 3, 4, 6, 7, 8};
//        int binarySearch = SolutionSort.binarySearch(arr, 0, arr.length - 1, 6);
//        ShowLogUtil.info(binarySearch);
    }
}