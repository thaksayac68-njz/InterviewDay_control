package com.example.interviewday.controllers;

public class ResultController {
    // --Attributes--
    private int correctCount;// — จำนวนข้อที่ตอบถูกต้อง
    private int totalQuestion;//— จำนวนคำถามทั้งหมด
    private String result;//— ผลลัพธ์สรุป (เช่น "PASS", "FAIL", "PENDING")

    // --Constructor--
    public ResultController(){
        this.correctCount = 0;
        this.totalQuestion = 0;
        this.result = "PENDING";
    }

    // --Methods--
    //1.checkPass() — เช็กว่าเกณฑ์คะแนนสอบผ่านหรือไม่ (เช่น ตอบถูกตั้งเเต่ 50% ขึ้นไป)
    public boolean checkPass(){
        if (totalQuestion == 0) return false;
        double scorePercent = ((double) correctCount / totalQuestion)* 100;
        return scorePercent >= 50.0; // ผ่านเกณฑ์ 50%
    }
    //2.checkFail() — เช็กว่าตกเกณฑ์หรือไม่
    public boolean checkFail(){
        return !checkPass();
    }
    //3.checkResult(int correctCount, int totalQuestion) — ตรวจคำตอบและประมวลผลสรุป
    public String checkResult(int correctCount, int totalQuestion){
        this.correctCount = correctCount;
        this.totalQuestion = totalQuestion;

        if (checkPass()){
            this.result = "PASS" ;
        }else {
            this.result = "FAIL";
        }
        return this.result;
    }
    //4.getResult() — ดึงค่าผลลัพธ์
    public String getResult(){return result;}

    // --Getters & Setters--
    public int getCorrectCount(){return correctCount;}
    public void setCorrectCount(int correctCount){
        this.correctCount = correctCount;
    }
    public int getTotalQuestion(){return totalQuestion;}
    public void setTotalQuestion(int totalQuestion){
        this.totalQuestion = totalQuestion;
    }
}
