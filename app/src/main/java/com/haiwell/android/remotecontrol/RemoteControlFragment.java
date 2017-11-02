package com.haiwell.android.remotecontrol;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Created by RJ-HXW on 2017/11/1.
 */

public class RemoteControlFragment extends Fragment {

    private TextView mSelectedTextView;
    private TextView mWorkingTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_remote_control, container, false);

        mSelectedTextView = ((TextView) view.findViewById(R.id.fragment_remote_control_selectedTextView));
        mWorkingTextView = ((TextView) view.findViewById(R.id.fragment_remote_control_workingTextView));

        View.OnClickListener numberButtonListener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = ((TextView) view);
                String working = mWorkingTextView.getText().toString();
                String text = textView.getText().toString();
                if (working.equals("0")) {
                    mWorkingTextView.setText(text);
                } else {
                    mWorkingTextView.setText(working + text);
                }
            }
        };

//        zeroButton = ((Button) view.findViewById(R.id.fragment_remote_control_zeroButton));
//        zeroButton.setOnClickListener(numberButtonListener);
//
//        oneButton = ((Button) view.findViewById(R.id.fragment_remote_control_oneButton));
//        oneButton.setOnClickListener(numberButtonListener);
        TableLayout tableLayout = ((TableLayout) view.findViewById(R.id.fragment_remote_control_tableLayout));
        int number = 1;
        for (int i = 2; i < tableLayout.getChildCount() - 1; i++) {
            TableRow row = ((TableRow) tableLayout.getChildAt(i));
            for (int j = 0; j < row.getChildCount(); j++) {
                Button button = ((Button) row.getChildAt(j));
                button.setText("" + number);
                button.setOnClickListener(numberButtonListener);
                number++;
            }
        }
//        enterButton = ((Button) view.findViewById(R.id.fragment_remote_control_enterButton));
//        enterButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                CharSequence working = mWorkingTextView.getText();
//                if (working.length() > 0) {
//                    mSelectedTextView.setText(working);
//                }
//                mWorkingTextView.setText("0");
//            }
//        });
        TableRow bottomRow = ((TableRow) tableLayout.getChildAt(tableLayout.getChildCount() - 1));
        Button deleteButton = ((Button) bottomRow.getChildAt(0));
        deleteButton.setText("Delete");
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWorkingTextView.setText("0");
            }
        });

        Button zeroButton = ((Button) bottomRow.getChildAt(1));
        zeroButton.setText("0");
        zeroButton.setOnClickListener(numberButtonListener);

        Button enterButton = ((Button) bottomRow.getChildAt(2));
        enterButton.setText("Enter");
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence working = mWorkingTextView.getText();
                if (working.length() > 0) {
                    mSelectedTextView.setText(working);
                }
                mWorkingTextView.setText("0");
            }
        });
        return view;
    }
}
