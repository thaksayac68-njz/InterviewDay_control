package com.example.interviewday.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.interviewday.MainActivity;
import com.example.interviewday.R;

public class EndingActivity extends BaseActivity {

    private ImageView imgEndingBg;
    private ImageView imgDialogueBg;
    private TextView tvEndingDescription;
    private ImageView imgLogoLeft;
    private ImageView imgLogoRight;

    private LinearLayout layoutFailedButtons;
    private ImageButton btnMainMenu;
    private ImageButton btnRestart;
    private ImageButton btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending);

        // ผูก View กับ ID ใน activity_ending.xml
        imgEndingBg = findViewById(R.id.imgEndingBg);
        imgDialogueBg = findViewById(R.id.imgDialogueBg);
        tvEndingDescription = findViewById(R.id.tvEndingDescription);
        imgLogoLeft = findViewById(R.id.imgLogoLeft);
        imgLogoRight = findViewById(R.id.imgLogoRight);

        layoutFailedButtons = findViewById(R.id.layoutFailedButtons);
        btnMainMenu = findViewById(R.id.btnMainMenu);
        btnRestart = findViewById(R.id.btnRestart);
        btnNext = findViewById(R.id.btnNext);

        // รับค่าประเภทฉากจบที่ส่งมาจาก GameStageActivity
        String endingType = getIntent().getStringExtra("ENDING_TYPE");
        if (endingType == null) {
            endingType = "NORMAL";
        }

        setupEndingContent(endingType);
    }

    private void setupEndingContent(String endingType) {
        switch (endingType) {
            case "SPECIAL": // ฉากจบแบบพิเศษ
                imgEndingBg.setImageResource(R.drawable.bg_ending_special);
                imgDialogueBg.setImageResource(R.drawable.bg_dialogue_box);
                tvEndingDescription.setText("ด้วยความที่คุณเตรียมตัวมาอย่างดีทำให้ หลังจากเดินออกมาจากห้องสัมภาษณ์ HR เดินมาหาคุณและบอกว่าได้รับเลือกให้ฝึกงานที่บริษัทนี้ ทำให้คุณดีใจอย่างมาก");

                // โลโก้ Special Ending
                imgLogoLeft.setImageResource(R.drawable.ic_logo_special);
                imgLogoLeft.setVisibility(View.VISIBLE);
                imgLogoRight.setVisibility(View.GONE);

                // แสดงปุ่ม Next
                btnNext.setVisibility(View.VISIBLE);
                layoutFailedButtons.setVisibility(View.GONE);

                btnNext.setOnClickListener(v -> goToMainMenu());
                break;

            case "FAILED": //ฉากจบแบบล้มเหลว (เวลานับถอยหลังหมด)
                imgEndingBg.setImageResource(R.drawable.bg_ending_failed);
                imgDialogueBg.setImageResource(R.drawable.bg_dialogue_failed);
                tvEndingDescription.setText("คุณใช้เวลาในการหาของและเตรียมตัวนานเกินไปจน เกินเวลาที่ทางบริษัทนัดไว้ทำให้คุณพลาดโอกาสในการฝึกงาน");

                // โลโก้ INTERVIEW FAILED
                imgLogoLeft.setVisibility(View.GONE);
                imgLogoRight.setImageResource(R.drawable.ic_logo_failed);
                imgLogoRight.setVisibility(View.VISIBLE);

                // แสดงปุ่ม Main Menu และ Restart
                btnNext.setVisibility(View.GONE);
                layoutFailedButtons.setVisibility(View.VISIBLE);

                btnMainMenu.setOnClickListener(v -> goToMainMenu());
                btnRestart.setOnClickListener(v -> restartGame());
                break;

            case "NORMAL": //  ฉากจบแบบธรรมดา
            default:
                imgEndingBg.setImageResource(R.drawable.bg_ending_normal);
                imgDialogueBg.setImageResource(R.drawable.bg_dialogue_box);
                tvEndingDescription.setText("คุณนั่งรอผลการสัมภาษณ์งานอยู่ที่โต๊ะทำงานของตัวเอง และมี HR โทรมาบอกว่าผ่านการสัมภาษณ์ ทำให้คุณโล่งใจและดีใจมาก");

                // โลโก้ Normal Ending
                imgLogoLeft.setImageResource(R.drawable.ic_logo_normal);
                imgLogoLeft.setVisibility(View.VISIBLE);
                imgLogoRight.setVisibility(View.GONE);

                // แสดงปุ่ม Next
                btnNext.setVisibility(View.VISIBLE);
                layoutFailedButtons.setVisibility(View.GONE);

                btnNext.setOnClickListener(v -> goToMainMenu());
                break;
        }
    }

    private void goToMainMenu() {
        Intent intent = new Intent(this, MainMenuActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    private void restartGame() {
        Intent intent = new Intent(this, GameStageActivity.class);
        intent.putExtra("STAGE_NUMBER", 1);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
