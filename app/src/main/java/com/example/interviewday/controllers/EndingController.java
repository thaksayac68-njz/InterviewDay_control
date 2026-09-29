package com.example.interviewday.controllers;

public class EndingController {
    // --Attributes--
    private String endingType;//— ประเภทฉากจบ (เช่น "NORMAL_ENDING", "TRUE_ENDING")
    private int secretItemCount;// — จำนวนไอเท็มลับที่ผู้เล่นเก็บได้ทั้งหมด (0-3 ชิ้น)
    private boolean sideQuestCompleted;//— สถานะการทำเควสย่อยสำเร็จหรือไม่

    // --Constructor--
    public EndingController(){
        this.endingType = "NORMAL_ENDING";
        this.secretItemCount = 0;
        this.sideQuestCompleted = false;
    }

    // --Methods--
    //1.calculateEnding() — คำนวณฉากจบจากเงื่อนไข(ถ้าเก็บไอเท็มลับครบ 3 ชิ้น (และทำเควสผ่าน) จะได้ "TRUE_ENDING" นอกเหนือจากนั้นได้ "NORMAL_ENDING")
    public void calculateEnding(){
        if (secretItemCount >=3) {
            this.endingType = "TRUE_ENDING";
        }else{
            this.endingType = "NORMAL_ENDING";
        }
    }
    //2.checkEndingCondition(int secretItems, boolean sideQuest) — ตรวจสอบและอัปเดตเงื่อนไขฉากจบ
    public boolean checkEndingCondition(int secretItems, boolean sideQuest){
        this.secretItemCount = secretItems;
        this.sideQuestCompleted =sideQuest;
        calculateEnding();
        return endingType.equals("TRUE_ENDING");
    }
    //3.electEnding(String endingType) — เลือกประเภทฉากจบโดยตรง
    public void selectEnding(String endingType){
        this.endingType = endingType;
    }
    //4.getEndingType() — ดึงค่าประเภทฉากจบปัจจุบัน
    public String getEndingType(){return endingType;}

    // --Getters & Setters--
    public int getSecretItemCount() { return secretItemCount; }
    public void setSecretItemCount(int secretItemCount) {
        this.secretItemCount = secretItemCount; }
    public boolean isSideQuestCompleted() { return sideQuestCompleted; }
    public void setSideQuestCompleted(boolean sideQuestCompleted) {
        this.sideQuestCompleted = sideQuestCompleted; }
}
