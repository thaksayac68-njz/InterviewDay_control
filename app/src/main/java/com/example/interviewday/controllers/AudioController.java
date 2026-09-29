package com.example.interviewday.controllers;

public class AudioController {
    // --Attributes--
    private float volume;//— ระดับความดังเสียง (ค่าระหว่าง 0.0f ถึง 1.0f)
    private boolean isMuted;// — สถานะเปิด/ปิดเสียง (true/false)

    // --Constructor--
    public AudioController(){
        this.volume = 1.0f;// ตั้งค่าเสียงดังสุด 100% (1.0f)
        this.isMuted = false;
    }

    // --Methods--
    //1.playSentenceAudio() — เล่นเสียงอ่านประโยคภาษาอังกฤษ
    public void playSentenceAudio(){
        if (isMuted) return;
        // โค้ดสำหรับเล่นเสียงประโยคภาษาอังกฤษ
    }
    //2.playCorrectSound() — เล่นเสียงเอฟเฟกต์ตอบถูก
    public void playCorrectSound(){
        if (isMuted) return;
        // โค้ดสำหรับเล่นเสียงเอฟเฟกต์เมื่อตอบถูกต้อง
    }
    //3.playWrongSound() — เล่นเสียงเอฟเฟกต์ตอบผิด
    public void playWrongSound(){
        if (isMuted) return;
        // โค้ดสำหรับเล่นเสียงเอฟเฟกต์เมื่อตอบผิด
    }
    //4.playBackgroundMusic() — เล่นเพลงประกอบฉาก
    public void playBackgroundMusic(){
        if (isMuted) return;
        // โค้ดสำหรับเล่นเพลง BGM ในฉาก
    }
    //5.setVolume(float volume) — ตั้งระดับความดังเสียง
    public void setVolume(float volume){
        this.volume = volume;
        if (volume <= 0.0f){
            this.isMuted = true;
        }else {
            this.isMuted = false;
        }
    }
    //6.mute() — สลับสถานะเปิด/ปิดเสียง
    public void mute(){
        this.isMuted = !this.isMuted;
    }

    // --Getters & Setters--
    public float getVolume(){return volume;}
    public boolean isMuted(){return isMuted;}

}
