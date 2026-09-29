package com.example.interviewday.controllers;

public class QuestController {
    // --Attributes--
    private int questProgress;
    private boolean questCompleted;
    private int targetProgress;

    // --Constructor--
    public QuestController(){
        this.questProgress = 0;
        this.questCompleted = false;
        this.targetProgress = 3; // เป้าหมายคือเก็บไอเท็มหลักให้ครบ 3 ชิ้น
    }

    // --Methods--
    //1.
    //startQuest() — เริ่มต้นภารกิจใหม่
    public void startQuest(){
        this.questProgress = 0;
        this.questCompleted = false;
    }
    //2.updateProgress() — อัปเดตความคืบหน้า (เช่น เก็บไอเท็มหลักได้ 1 ชิ้น)
    public void updateProgress(){
        if (!questCompleted){
            this.questProgress++;
            if (checkQuestComplete()){
                completeQuest();
            }
        }
    }
    //3.checkQuestComplete() — ตรวจสอบว่าทำเควสครบเป้าหมายหรือยัง
    public boolean checkQuestComplete(){
        return questProgress >= targetProgress;
    }
    //4.completeQuest() — สั่งให้เควสนี้สำเร็จ
    public void completeQuest(){
        this.questCompleted = true;
    }

    // --Getters & Setters--
    public int getQuestProgress(){return questProgress;}
    public boolean isQuestCompleted(){return questCompleted;}
    public int getTargetProgress(){return targetProgress;}
    public void setTargetProgress(int targetProgress){
        this.targetProgress = targetProgress;
    }
}
