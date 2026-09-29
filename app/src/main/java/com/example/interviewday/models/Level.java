package com.example.interviewday.models;

import java.util.ArrayList;
import java.util.List;

/**
 * คลาสแม่: จัดเก็บข้อมูลพื้นฐานและสถานะของแต่ละด่าน
 * OOP: Abstraction (กำหนดโครงสร้างกลาง ไม่ลงรายละเอียดเนื้อหาด่านจริง)
 *      Encapsulation (status เป็น private/protected เข้าถึงผ่าน method เท่านั้น)
 */
public abstract class Level {
    protected int levelID;
    protected String levelName;
    protected LevelStatus status;
    protected String introStory;
    protected String failStory;
    protected List<Item> requiredItems = new ArrayList<>();
    protected Time timer = new Time();

    public Level(int levelID, String levelName) {
        this.levelID = levelID;
        this.levelName = levelName;
        this.status = LevelStatus.LOCKED;
    }

    // ลูกต้อง implement เอง ว่าโหลดเนื้อหาด่านของตัวเองอย่างไร
    public abstract void loadContent();

    // ลูกเรียกใน constructor ของตัวเองเพื่อกำหนดเนื้อเรื่องของด่าน
    protected void setStory(String introStory, String failStory) {
        this.introStory = introStory;
        this.failStory = failStory;
    }

    public String getIntroStory() {
        return introStory;
    }

    public String getFailStory() {
        return failStory;
    }

    // ลูกเรียกใน constructor ของตัวเองเพื่อกำหนดไอเทมที่ต้องหาให้ครบในด่านนี้
    protected void addRequiredItem(Item item) {
        requiredItems.add(item);
    }

    public List<Item> getRequiredItems() {
        return requiredItems;
    }

    // เช็คว่าไอเทมที่ต้องหาในด่านนี้ถูกเก็บครบหรือยัง
    public boolean isAllItemsFound() {
        for (Item item : requiredItems) {
            if (!item.isCollected()) {
                return false;
            }
        }
        return true;
    }

    public Time getTimer() {
        return timer;
    }

    // เรียกเมื่อผู้เล่นทำภารกิจ/มินิเกมของด่านไม่สำเร็จ
    public void triggerFail() {
        System.out.println(levelName + " : ผู้เล่นล้มเหลวในด่านนี้");
        System.out.println("เนื้อเรื่อง: " + failStory);
    }

    // เรียกเป็นระยะระหว่างเล่น (เช่นทุก 1 วินาที) เพื่อเดินเวลาถอยหลังของด่าน
    // ถ้าหมดเวลาแล้วยังหาไอเทมไม่ครบ -> แพ้ด่านทันที (triggerFail())
    public boolean updateTime(int elapsedSeconds) {
        timer.decreaseTime(elapsedSeconds);
        if (timer.isTimeUp() && !isAllItemsFound()) {
            triggerFail();
            return true;
        }
        return false;
    }

    public void startLevel() {
        if (status == LevelStatus.LOCKED) {
            System.out.println(levelName + " ยังไม่ถูกปลดล็อก");
            return;
        }
        loadContent();
        timer.reset();
        timer.start();
        System.out.println("เริ่มด่าน: " + levelName
                + " (มีเวลา " + timer.getMinutes() + " นาที " + timer.getSeconds() + " วินาที)");
    }

    public void completeLevel() {
        timer.stop();
        this.status = LevelStatus.COMPLETED;
        System.out.println(levelName + " ผ่านเรียบร้อยแล้ว");
    }

    public void unlock() {
        this.status = LevelStatus.UNLOCKED;
    }

    public LevelStatus getStatus() {
        return status;
    }

    public int getLevelID() {
        return levelID;
    }

    public String getLevelName() {
        return levelName;
    }
}