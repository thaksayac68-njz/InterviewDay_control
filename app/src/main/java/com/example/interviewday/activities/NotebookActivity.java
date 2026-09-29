package com.example.interviewday.activities;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.interviewday.R;

public class NotebookActivity extends BaseActivity {

    //ATTRIBUTES
    private ImageButton btnHome;      // ปุ่มกดกลับหน้าหลัก
    private TextView tvContentLeft;   // พื้นที่แสดงกล่องข้อความ/คำศัพท์ บนกระดาษฝั่งซ้าย
    private TextView tvContentRight;  // พื้นที่แสดงกล่องข้อความ/คำศัพท์ บนกระดาษฝั่งขวา

    //METHODS

    // เมธอดที่ 1: สั่งการทำงานหลักเมื่อสร้างหน้าจอ
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notebook);

        initViews();       // เรียกเมธอดผูก View
        setupListeners();  // เรียกเมธอดดักฟังปุ่มกด
    }

    // เมธอดที่ 2: ผูก ID ในไฟล์ XML เข้ากับ Attributes ฝั่ง Java
    private void initViews() {
        btnHome = findViewById(R.id.btnHome);
        tvContentLeft = findViewById(R.id.tvContentLeft);
        tvContentRight = findViewById(R.id.tvContentRight);
    }

    // เมธอดที่ 3: กำหนดคำสั่งเมื่อผู้เล่นคลิกปุ่ม Home
    private void setupListeners() {
        btnHome.setOnClickListener(v -> {
            finish(); // ปิดหน้านี้แล้วย้อนกลับไปหน้า MainMenuActivity
        });
    }

    // เมธอดที่ 4:ใช้รับข้อความคำศัพท์มาอัปเดตลงหน้ากระดาษ
    public void updateNotebookContent(String leftPageText, String rightPageText) {
        if (tvContentLeft != null) {
            tvContentLeft.setText(leftPageText);   // แปะข้อความฝั่งซ้าย
        }
        if (tvContentRight != null) {
            tvContentRight.setText(rightPageText); // แปะข้อความฝั่งขวา
        }
    }
}