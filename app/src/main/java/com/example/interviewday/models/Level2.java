package com.example.interviewday.models;

/**
 * คลาสลูก: จัดการรายละเอียดและเนื้อหาของด่านที่ 2
 * OOP: Inheritance + Polymorphism (override loadContent())
 */
public class Level2 extends Level {

    private String grammarTopic;

    public Level2() {
        super(2, "ห้องเรียนเครื่องมือคอมพิวเตอร์และอุปกรณ์อิเล็กทรอนิกส์พื้นฐาน");
        this.grammarTopic = "Computer Hardware Tools";
        setStory(
                "ผู้เล่นก้าวเข้าสู่ห้องเรียนที่เต็มไปด้วยอุปกรณ์อิเล็กทรอนิกส์ สายไฟ และเครื่องมือช่าง "
                        + "อาจารย์ประจำห้องมอบหมายให้ประกอบวงจรและระบุชื่ออุปกรณ์คอมพิวเตอร์ให้ถูกต้องภายในเวลาที่กำหนด "
                        + "เพื่อพิสูจน์ว่าพร้อมสำหรับงานด้านวิศวกรรมจริง",
                "เวลาหมดลงก่อนที่ผู้เล่นจะหาอุปกรณ์ครบตามที่อาจารย์สั่ง อาจารย์ประกาศว่าสอบไม่ผ่าน "
                        + "ผู้เล่นถูกเชิญออกจากห้องเรียนและไม่สามารถเดินหน้าไปสู่ด่านสัมภาษณ์งานได้"
        );
        addRequiredItem(new NormalItem(2, "Ethernet Cable", "สาย LAN"));
        addRequiredItem(new SecretItem(102, "Special Microcontroller Board", "ไอเทมลับด่าน 2", "บอร์ดทดลองคอมพิวเตอร์"));
    }

    @Override
    public void loadContent() {
        System.out.println("โหลดเนื้อหาด่าน 2: หัวข้อ " + grammarTopic);
    }
}