package com.example.interviewday.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.interviewday.MainActivity;
import com.example.interviewday.R;

public class SummaryActivity extends BaseActivity {

    private ImageView imgEndingTypeBadge;
    private TextView tvTotalTime;
    private TextView tvLevel1Time;
    private TextView tvLevel2Time;
    private TextView tvLevel3Time;
    private ImageButton btnMainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        // 1. ผูก View กับ ID ใน XML
        imgEndingTypeBadge = findViewById(R.id.imgEndingTypeBadge);
        tvTotalTime = findViewById(R.id.tvTotalTime);
        tvLevel1Time = findViewById(R.id.tvLevel1Time);
        tvLevel2Time = findViewById(R.id.tvLevel2Time);
        tvLevel3Time = findViewById(R.id.tvLevel3Time);
        btnMainMenu = findViewById(R.id.btnMainMenu);

        // 2. รับข้อมูลจาก Intent
        Intent intent = getIntent();
        String endingType = intent.getStringExtra("ENDING_TYPE"); // "NORMAL" หรือ "SPECIAL"
        String level1Time = intent.getStringExtra("LEVEL1_TIME");
        String level2Time = intent.getStringExtra("LEVEL2_TIME");
        String level3Time = intent.getStringExtra("LEVEL3_TIME");
        String totalTime = intent.getStringExtra("TOTAL_TIME");

        // 3. กำหนดรูปป้าย Normal / Special Ending
        setupEndingBadge(endingType);

        // 4. แสดงผลเวลา
        displayTimeData(level1Time, level2Time, level3Time, totalTime);

        // 5. ตั้งค่าปุ่มกลับหน้า Main Menu
        btnMainMenu.setOnClickListener(v -> goToMainMenu());
    }

    private void setupEndingBadge(String endingType) {
        if ("SPECIAL".equalsIgnoreCase(endingType)) {
            imgEndingTypeBadge.setImageResource(R.drawable.ic_special_ending_badge);
        } else {
            imgEndingTypeBadge.setImageResource(R.drawable.ic_normal_ending_badge);
        }
    }

    private void displayTimeData(String l1, String l2, String l3, String total) {
        tvLevel1Time.setText("LEVEL1 :   " + (l1 != null ? l1 : "00:00"));
        tvLevel2Time.setText("LEVEL2 :   " + (l2 != null ? l2 : "00:00"));
        tvLevel3Time.setText("LEVEL3 :   " + (l3 != null ? l3 : "00:00"));
        tvTotalTime.setText(total != null ? total : "00:00");
    }

    private void goToMainMenu() {
        Intent intent = new Intent(SummaryActivity.this, MainMenuActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}