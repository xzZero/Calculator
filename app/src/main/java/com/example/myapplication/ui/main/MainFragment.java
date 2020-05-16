package com.example.myapplication.ui.main;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.ArrayList;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private Button btnOK, btnCLR, btnMul, btnSub, btnDiv, btnAdd;
    private TextView txtInput;
    private ArrayList<Button> btnNumber;
    private String lastOperation = "";
    private String lastString = "";
    private String newString = null;
    private double lastNumber = 0;
    int i = 0;
    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        btnNumber = new ArrayList<>();

        btnNumber.add((Button) view.findViewById(R.id.ZBtn));
        btnNumber.add((Button) view.findViewById(R.id.OBtn));
        btnNumber.add((Button) view.findViewById(R.id.TwBtn));
        btnNumber.add((Button) view.findViewById(R.id.ThBtn));
        btnNumber.add((Button) view.findViewById(R.id.FBtn));
        btnNumber.add((Button) view.findViewById(R.id.FiBtn));
        btnNumber.add((Button) view.findViewById(R.id.SBtn));
        btnNumber.add((Button) view.findViewById(R.id.SeBtn));
        btnNumber.add((Button) view.findViewById(R.id.EBtn));
        btnNumber.add((Button) view.findViewById(R.id.NBtn));


        btnMul = view.findViewById(R.id.MultBtn);
        btnDiv = view.findViewById(R.id.DivBtn);
        btnAdd = view.findViewById(R.id.PlusBtn);
        btnSub = view.findViewById(R.id.MinusBtn);



        btnCLR = view.findViewById(R.id.CLRBtn);
        btnOK = view.findViewById(R.id.OKBtn);
        txtInput = view.findViewById(R.id.txtView);
        btnCLR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastNumber = 0;
                lastOperation = "";
                lastString = "";
                txtInput.setText(Double.toString(lastNumber));
            }
        });
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation("");
            }
        });
        btnNumber.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processNumber(0);
            }
        });
        btnNumber.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processNumber(1);
            }
        });
        btnNumber.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processNumber(2);
            }
        });
        btnNumber.get(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processNumber(3);
            }
        });
        btnNumber.get(4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processNumber(4);
            }
        });
        btnNumber.get(5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processNumber(5);
            }
        });
        btnNumber.get(6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processNumber(6);
            }
        });
        btnNumber.get(7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processNumber(7);
            }
        });
        btnNumber.get(8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processNumber(8);
            }
        });
        btnNumber.get(9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processNumber(9);
            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation("+");
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation("-");
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation("/");
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation("*");
            }
        });
        return view;


    }

    private void processOperation(String Op){
        double newNumber;
        if (lastString.equals("")){
            newNumber = Double.parseDouble("0");
        } else {
            newNumber = Double.parseDouble(lastString);
        }

        if (!lastOperation.equals("")) {
            //Toast.makeText(getContext(), lastOperation, Toast.LENGTH_SHORT);
            switch (lastOperation) {
                case "+":
                    lastNumber += newNumber;
                    break;
                case "-":
                    lastNumber -= newNumber;
                    break;
                case "*":
                    lastNumber *= newNumber;
                    break;
                case "/":
                    lastNumber /= newNumber;
                    break;
            }
        } else if (lastNumber == 0 || Op.equals("")){
            lastNumber = newNumber;
        }
//        if (lastOperation.equals("") && Op.equals("")){
//            lastNumber = newNumber;
//        }

        Toast.makeText(getContext(), lastOperation, Toast.LENGTH_LONG);
        txtInput.setText(Double.toString(lastNumber));
        lastOperation = Op;
        lastString = "";

    }

    private void processNumber(int i) {

        lastString += Integer.toString(i);
        txtInput.setText(lastString);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }


}
