package com.example.interviewday.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.interviewday.R;
import com.example.interviewday.dialogs.GimmickDialog;
import com.example.interviewday.dialogs.PauseDialog;
import com.example.interviewday.dialogs.SettingsDialog;
import com.example.interviewday.controllers.TimerController;//เพิ่มเติมคุมเวลา

public class GameStageActivity extends BaseActivity {

    //Time
    private TimerController timerController;

    // UI Views
    private ImageView imgBackground;
    private ImageButton btnPause;
    private TextView tvTimer;
    private ImageButton btnNext;

    // Quest Item Slot Views (แถบด้านล่าง)
    private ImageView imgQuestItem1;
    private ImageView imgQuestItem2;
    private ImageView imgQuestItem3;

    // Hidden Item Views (ไอเท็มธรรมดาบนฉาก)
    private ImageView imgHiddenItem1;
    private ImageView imgHiddenItem2;
    private ImageView imgHiddenItem3;

    // Secret Item View (ไอเท็มลับบนฉาก)
    private ImageView imgSecretItem;

    // Status Tracking
    private int currentStage = 1;
    private boolean isItem1Found = false;
    private boolean isItem2Found = false;
    private boolean isItem3Found = false;
    private boolean isSecretFound = false;

    // Resource IDs และข้อมูลไอเท็ม
    private int colorRes1, colorRes2, colorRes3, secretRes;
    private String secretName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_stage);

        currentStage = getIntent().getIntExtra("STAGE_NUMBER", 1);

        initViews();
        setupStageUI(currentStage);
        setupItemClickListeners();

        setupTimer(); //  เพิ่มบรรทัดนี้เพื่อเปิดใช้งานตัวจับเวลา
    }

    private void initViews() {
        imgBackground = findViewById(R.id.imgBackground);
        btnPause = findViewById(R.id.btnPause);
        tvTimer = findViewById(R.id.tvTimer);
        btnNext = findViewById(R.id.btnNext);

        imgQuestItem1 = findViewById(R.id.imgQuestItem1);
        imgQuestItem2 = findViewById(R.id.imgQuestItem2);
        imgQuestItem3 = findViewById(R.id.imgQuestItem3);

        imgHiddenItem1 = findViewById(R.id.imgHiddenItem1);
        imgHiddenItem2 = findViewById(R.id.imgHiddenItem2);
        imgHiddenItem3 = findViewById(R.id.imgHiddenItem3);
        imgSecretItem = findViewById(R.id.imgSecretItem);
    }

    private void setupStageUI(int stage) {
        // แสดงไอเท็มทั้งหมดบนฉากก่อนเริ่ม
        imgHiddenItem1.setVisibility(View.VISIBLE);
        imgHiddenItem2.setVisibility(View.VISIBLE);
        imgHiddenItem3.setVisibility(View.VISIBLE);
        imgSecretItem.setVisibility(View.VISIBLE);
        btnNext.setVisibility(View.GONE);

        switch (stage) {
            case 1: // ด่าน 1: ห้องนอน
                imgBackground.setImageResource(R.drawable.bg_game_stage1);

                // รูปแถบ Quest ตั้งต้น (เงาดำ)
                imgQuestItem1.setImageResource(R.drawable.ic_s1_item1_shadow);
                imgQuestItem2.setImageResource(R.drawable.ic_s1_item2_shadow);
                imgQuestItem3.setImageResource(R.drawable.ic_s1_item3_shadow);

                colorRes1 = R.drawable.ic_s1_item1_color; // โน้ตบุ๊ก
                colorRes2 = R.drawable.ic_s1_item2_color; // แฟลชไดร์ฟ USB
                colorRes3 = R.drawable.ic_s1_item3_color; // เรซูเม่
                secretRes = R.drawable.ic_secret_stage1;   // การ์ด OOP ลับ
                secretName = "OOP Secret Flashcard";

                //  พิกัดไอเท็มธรรมดา
                setItemPosition(imgHiddenItem1, 0.78f, 0.42f); // โน้ตบุ๊กบนเตียง
                setItemPosition(imgHiddenItem2, 0.66f, 0.86f); // USB ใกล้ถ้วยมาม่า
                setItemPosition(imgHiddenItem3, 0.62f, 0.96f); // เรซูเม่มุมขวาล่าง

                //  พิกัดไอเท็มลับ
                setItemPosition(imgSecretItem, 0.24f, 0.38f);  // กล่องใส่กระดาษข้างจอคอม
                break;

            case 2: //  ด่าน 2: ห้องแล็บ
                imgBackground.setImageResource(R.drawable.bg_game_stage2);

                imgQuestItem1.setImageResource(R.drawable.ic_s2_item1_shadow);
                imgQuestItem2.setImageResource(R.drawable.ic_s2_item2_shadow);
                imgQuestItem3.setImageResource(R.drawable.ic_s2_item3_shadow);

                colorRes1 = R.drawable.ic_s2_item1_color; // สาย LAN
                colorRes2 = R.drawable.ic_s2_item2_color; // External HDD
                colorRes3 = R.drawable.ic_s2_item3_color; // กระดาษอัลกอริทึม
                secretRes = R.drawable.ic_secret_stage2;   // บอร์ดไมโครคอนโทรลเลอร์
                secretName = "Special Microcontroller Board";

                //  พิกัดไอเท็มธรรมดา
                setItemPosition(imgHiddenItem1, 0.51f, 0.92f); // สาย LAN บนพื้น
                setItemPosition(imgHiddenItem2, 0.38f, 0.50f); // External HDD บนโต๊ะซ้าย
                setItemPosition(imgHiddenItem3, 0.53f, 0.54f); // กระดาษอัลกอริทึมข้างลัง

                //  พิกัดไอเท็มลับ
                setItemPosition(imgSecretItem, 0.54f, 0.77f);  // บอร์ดสีเขียวบนพื้น
                break;

            case 3: // ด่าน 3: บริษัท TechNova
                imgBackground.setImageResource(R.drawable.bg_game_stage3);

                imgQuestItem1.setImageResource(R.drawable.ic_s3_item1_shadow);
                imgQuestItem2.setImageResource(R.drawable.ic_s3_item2_shadow);
                imgQuestItem3.setImageResource(R.drawable.ic_s3_item3_shadow);

                colorRes1 = R.drawable.ic_s3_item1_color; // ปากกาไวท์บอร์ด
                colorRes2 = R.drawable.ic_s3_item2_color; // กระดาษไดอะแกรม
                colorRes3 = R.drawable.ic_s3_item3_color; // บัตรพนักงาน
                secretRes = R.drawable.ic_secret_stage3;   // จดหมายรับรองพรีเมียม
                secretName = "Executive Recommendation Letter";

                //  พิกัดไอเท็มธรรมดา
                setItemPosition(imgHiddenItem1, 0.20f, 0.80f); // กล่องปากกาบนโต๊ะโซฟา
                setItemPosition(imgHiddenItem2, 0.43f, 0.31f); // กระดาษบนบอร์ด
                setItemPosition(imgHiddenItem3, 0.94f, 0.38f); // บัตรพนักงานบนเคาน์เตอร์ขวา

                //  พิกัดไอเท็มลับ
                setItemPosition(imgSecretItem, 0.64f, 0.30f);  // บนตู้กดน้ำ
                break;
        }

        // โหลดรูปสีลงไอเท็มบนฉาก
        imgHiddenItem1.setImageResource(colorRes1);
        imgHiddenItem2.setImageResource(colorRes2);
        imgHiddenItem3.setImageResource(colorRes3);
        imgSecretItem.setImageResource(secretRes);
    }

    //เพิ่มเติมการจับเวลา
    private void setupTimer() {
        // สร้าง TimerController และ override อัปเดตเวลาบนตัวหนังสือ tvTimer
        timerController = new TimerController() {
            @Override
            public void updateTimer() {
                super.updateTimer();
                // นำเวลาที่เหลือมาแปลงเป็นข้อความ MM:SS (เช่น 06:00) แสดงบน UI
                runOnUiThread(() -> {
                    if (tvTimer != null) {
                        tvTimer.setText(getFormattedTime());
                    }
                });
            }
        };

        // เริ่มนับเวลาถอยหลังทันทีที่เข้าด่าน!
        timerController.startTimer();
    }
    @Override
    protected void onPause() {
        super.onPause();
        if (timerController != null) {
            timerController.pauseTimer();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (timerController != null) {
            timerController.resumeTimer();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timerController != null) {
            timerController.stopTimer();
        }
    }

    private void setupItemClickListeners() {
        btnPause.setOnClickListener(v -> {
            PauseDialog dialog = PauseDialog.newInstance(tvTimer.getText().toString());
            dialog.setListener(new PauseDialog.PauseDialogListener() {
                @Override
                public void onContinueClicked() {}

                @Override
                public void onOpenSettingsClicked() {
                    SettingsDialog settingsDialog = SettingsDialog.newInstance();
                    settingsDialog.show(getSupportFragmentManager(), "SettingsDialog");
                }

                @Override
                public void onHomeClicked() {
                    Intent intent = new Intent(GameStageActivity.this, MainMenuActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onRestartClicked() {
                    recreate();
                }
            });
            dialog.show(getSupportFragmentManager(), "PauseDialog");
        });

        btnNext.setOnClickListener(v -> {
            GimmickDialog dialog = new GimmickDialog();
            dialog.setStageAndQuestion(currentStage, 0);
            dialog.show(getSupportFragmentManager(), "GimmickDialog");
        });

        // 1. ไอเท็มธรรมดา ชิ้นที่ 1
        imgHiddenItem1.setOnClickListener(v -> {
            imgHiddenItem1.setVisibility(View.GONE);
            imgQuestItem1.setImageResource(colorRes1);
            isItem1Found = true;
            checkAllItemsFound();
        });

        // 2. ไอเท็มธรรมดา ชิ้นที่ 2
        imgHiddenItem2.setOnClickListener(v -> {
            imgHiddenItem2.setVisibility(View.GONE);
            imgQuestItem2.setImageResource(colorRes2);
            isItem2Found = true;
            checkAllItemsFound();
        });

        // 3. ไอเท็มธรรมดา ชิ้นที่ 3
        imgHiddenItem3.setOnClickListener(v -> {
            imgHiddenItem3.setVisibility(View.GONE);
            imgQuestItem3.setImageResource(colorRes3);
            isItem3Found = true;
            checkAllItemsFound();
        });

        // 4.  ไอเท็มลับประจำด่าน
        imgSecretItem.setOnClickListener(v -> {
            imgSecretItem.setVisibility(View.GONE);
            isSecretFound = true;

            // แจ้งเตือนผู้เล่นเมื่อเจอไอเท็มลับ
            Toast.makeText(this, " ปลดล็อกไอเท็มลับ: " + secretName, Toast.LENGTH_LONG).show();

        });
    }

    // เช็กว่าเก็บไอเท็มหลักครบทั้ง 3 ชิ้นหรือยัง
    private void checkAllItemsFound() {
        if (isItem1Found && isItem2Found && isItem3Found) {
            btnNext.setVisibility(View.VISIBLE);
        }
    }

    // กำหนดตำแหน่งไอเท็มอิงตามอัตราส่วนหน้าจอ
    private void setItemPosition(ImageView item, float biasX, float biasY) {
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) item.getLayoutParams();
        params.horizontalBias = biasX;
        params.verticalBias = biasY;
        item.setLayoutParams(params);
    }

    // Public API สำหรับปรับเปลี่ยนเวลาบน UI
    public void updateTimerText(String timeFormatted) {
        if (tvTimer != null) {
            tvTimer.setText(timeFormatted);
        }
    }

    // Public API สำหรับดึงสถานะว่าเก็บไอเท็มลับได้หรือไม่ (ส่งให้ Controller)
    public boolean isSecretItemFound() {
        return isSecretFound;
    }
}