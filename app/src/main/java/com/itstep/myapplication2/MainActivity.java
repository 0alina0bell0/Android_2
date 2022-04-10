package com.itstep.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textViewTop = findViewById(R.id.textViewTop);
        textViewTop.setText("Отметье ваши навыки");
        textViewTop.setGravity(Gravity.CENTER_VERTICAL);
        LinearLayout linearLayout = findViewById(R.id.checkBox_layout);
        for (SkillsEnum skill : SkillsEnum.values()) {
            CheckBox checkBox = getConfiguredCheckBox(skill);
            linearLayout.addView(checkBox);
        }
    }

    private CheckBox getConfiguredCheckBox(SkillsEnum skill) {
        CheckBox checkBox = new CheckBox(this);
        checkBox.setText(skill.getSkill());
        checkBox.setOnClickListener(onCheckBoxClicked());
        return checkBox;
    }

    private View.OnClickListener onCheckBoxClicked() {
        return v -> {
            CheckBox checkBox = (CheckBox) v;
            TextView dynamicTextView = findViewById(R.id.textViewBottom);
            String text = String.valueOf(dynamicTextView.getText());
            if (checkBox.isChecked()) {
                dynamicTextView.setText(String.format(text + "%s\n", checkBox.getText()));
            } else {
                dynamicTextView.setText(text.replace(checkBox.getText() + "\n", ""));
            }
        };
    }


}