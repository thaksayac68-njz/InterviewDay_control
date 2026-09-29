package com.example.interviewday.models;
/**
 * คลาสลูก: จัดการรายละเอียดและเนื้อหาของด่านที่ 3
 * OOP: Inheritance + Polymorphism (override loadContent())
 */
public class Level3 extends Level {

    private boolean isFinalLevel;

    public Level3() {
        super(3, "ห้องสัมภาษณ์งานกับทีมเทคนิคและวิศวกร");
        this.isFinalLevel = true;
        setStory(
                "ผู้เล่นเดินเข้าสู่ห้องสัมภาษณ์งานสุดท้าย เผชิญหน้ากับทีมเทคนิคและวิศวกรที่ตั้งคำถามเจาะลึก "
                        + "ทั้งเรื่อง OOP และฮาร์ดแวร์ที่เคยเรียนรู้มา นี่คือด่านตัดสินว่าผู้เล่นจะได้งานหรือไม่",
                "เวลาหมดลงก่อนที่ผู้เล่นจะเตรียมเอกสารครบสำหรับสัมภาษณ์ ทีมงานส่ายหน้าและกล่าวขอบคุณที่มาสัมภาษณ์ "
                        + "แต่ปฏิเสธการรับเข้าทำงาน ผู้เล่นเดินออกจากห้องสัมภาษณ์ด้วยความผิดหวัง"
        );
        addRequiredItem(new NormalItem(3, "System Architecture Diagram", "ผังโครงสร้างระบบ"));
        addRequiredItem(new SecretItem(103, "Executive Recommendation Letter", "ไอเทมลับด่าน 3", "จดหมายรับรองจากผู้บริหาร"));
    }

    @Override
    public void loadContent() {
        System.out.println("โหลดเนื้อหาด่าน 3: สัมภาษณ์งานวิศวกร (ด่านสุดท้าย)");
    }

    public boolean isFinalLevel() {
        return isFinalLevel;
    }
}