package com.example.interviewday.controllers;

public class LevelController{
    // --Attributes--
    private int currentStage;
    private int unlockedStage;

    // --Constructor--
    public LevelController(){
        this.currentStage = 1;
        this.unlockedStage = 1;
    }

    // --Methods--
    //1.electStage(int stage) — เลือกด่านที่จะเล่น
    public void selectStage(int stage){
        if (checkStageUnlock(stage)){
            this.currentStage = stage;
        }
    }
    //2.startStage(int stage) — เริ่มเล่นด่านที่ระบุ
    public void startStage(int stage){
        if (checkStageUnlock(stage)){
            this.currentStage = stage;
        }
    }
    //3.unlockNextStage() — ปลดล็อกด่านถัดไป (เรียกใช้เมื่อเล่นผ่านด่าน)
    public void unlockNextStage(){
        if (unlockedStage <3){ // สมมติว่าเกมเรามีสูงสุด 3 ด่าน
            unlockedStage++;
        }
    }
    //4.checkStageUnlock(int stage) — เช็กว่าด่านนี้ปลดล็อกแล้วหรือยัง
    public boolean checkStageUnlock(int stage){
        return stage <= unlockedStage;
    }

    // --Getters--
    public int getCurrentStage(){
        return currentStage;
    }

    public int getUnlockedStage() {
        return unlockedStage;
    }
}
