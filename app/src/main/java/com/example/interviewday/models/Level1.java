package com.example.interviewday.models;
/**
 * คลาสลูก: จัดการรายละเอียดและเนื้อหาของด่านที่ 1
 * OOP: Inheritance (สืบทอดจาก Level) + Polymorphism (override loadContent())
 */
public class Level1 extends Level {

    private String vocabularyTopic;

    public Level1() {
        super(1, "ห้องนอนสุดรก");
        this.vocabularyTopic = "OOP Concepts";
        setStory(
                "ผู้เล่นตื่นขึ้นในห้องสมุดเก่าแก่ที่เต็มไปด้วยหนังสือเกี่ยวกับ OOP "
                        + "ประตูทางออกถูกล็อกด้วยกลไกปริศนา มีเสียงลึกลับบอกว่าต้องพิสูจน์ความเข้าใจเรื่อง "
                        + "Encapsulation, Inheritance และ Polymorphism ก่อนจึงจะออกไปยังด่านถัดไปได้",
                "เวลาหมดลงก่อนที่ผู้เล่นจะหาของครบในห้อง หนังสือทุกเล่มในห้องสมุดปิดตัวลงพร้อมกัน "
                        + "ประตูทางออกล็อกสนิท ผู้เล่นติดอยู่ในห้องสมุดแห่งความรู้ และไม่มีโอกาสไปต่อยังด่านถัดไป"
        );
        addRequiredItem(new NormalItem(1, "Dev Laptop", "โน้ตบุ๊กติดสติ๊กเกอร์รวมเทคโนโลยี"));
        addRequiredItem(new SecretItem(101, "OOP Secret Flashcard", "ไอเทมลับด่าน 1", "เก็บครบเพื่อปลด True Ending"));
    }

    @Override
    public void loadContent() {
        System.out.println("โหลดเนื้อหาด่าน 1: หัวข้อ " + vocabularyTopic);
    }
}