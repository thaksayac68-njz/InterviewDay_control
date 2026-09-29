package com.example.interviewday.controllers;

public class PronunciationController {
    // --Attributes--
    private String targetSentence;//— ประโยคโจทย์เป้าหมาย (เช่น "Encapsulation hides internal details")
    private String spokenText;//— ข้อความภาษาอังกฤษที่จับเสียงพูดของผู้เล่นได้
    private boolean isCorrect;//— ผลลัพธ์ว่าอ่านออกเสียงถูกต้องหรือไม่ (true/false)

    // --Constructor--
    public PronunciationController(){
        this.targetSentence = "";
        this.spokenText = "";
        this.isCorrect =false;
    }

    // --Methods--
    //1.recognizeSpeech(String speechInput) — รับข้อความเสียงผู้เล่นที่แปลงเป็นข้อความแล้ว
    public void recognizeSpeech(String speechInput){
        if (speechInput != null){
            this.spokenText = speechInput.trim();
        }
    }
    //2.compareSentence() — เปรียบเทียบข้อความที่ผู้เล่นพูด กับ ประโยคโจทย์
    public boolean compareSentence(){
        if (targetSentence == null || spokenText == null) return false;

        // ลบเครื่องหมายพิเศษออกเพื่อให้เปรียบเทียบเฉพาะคำพูด
        String cleanTarget = targetSentence.replaceAll("[^a-zA-Z0-9 ]","").trim();
        String cleanSpoken = spokenText.replaceAll("[^a-zA-Z0-9 ]", "").trim();

        this.isCorrect = cleanTarget.equalsIgnoreCase(cleanSpoken);
        return this.isCorrect;
    }
    //3.checkPronunciation() — เช็กการออกเสียง (เรียกใช้ compareSentence)
    public boolean checkPronunciation(){
        return compareSentence();
    }
    //4.stopRecording() — หยุดการบันทึกเสียง
    public void stopRecording(){} // คำสั่งหยุดการบันทึกเสียง (เมื่อจบการพูด)

    // --Getters & Setters--
    public String getTargetSentence(){
        return  targetSentence;
    }
    public void setTargetSentence(String targetSentence){this.targetSentence = targetSentence;}
    public String getSpokenText(){
        return spokenText;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
