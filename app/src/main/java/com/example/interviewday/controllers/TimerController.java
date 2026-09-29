package com.example.interviewday.controllers;

import android.os.CountDownTimer;

public class TimerController {
    // --Attributes--
    private int timeLimit;
    private int remainingTime;
    private boolean isRunning;
    private CountDownTimer countDownTimer;

    // --Constructor--
    public TimerController(){
        this.timeLimit = 360;// กเปลี่ยนเป็น 360 วินาที (6 นาที)
        this.remainingTime = timeLimit;
        this.isRunning = false;
    }

    // --Methods--
    //1.เริ่มนับเวลาถอยหลัง สร้าง CountDownTimer ให้นับถอยหลังทีละ 1 วินาที (1000 ms)
    public void startTimer(){
        if (isRunning) return; // ถ้ากำลังเดินอยู่แล้วไม่ต้องเริ่มซ้ำ

        isRunning = true;
        countDownTimer = new CountDownTimer(remainingTime * 1000L,1000) {
            @Override
            public void onFinish() {
                remainingTime = 0;
                isRunning = false;
                checkTimeOut();
            }
            @Override
            public void onTick(long millisUntilFinished) {
                remainingTime = (int) (millisUntilFinished / 1000);
                updateTimer();
            }
        }.start();
    }
    //2.pauseTimer() — หยุดนับเวลาชั่วคราว
    public void pauseTimer(){
        if (countDownTimer != null){
            countDownTimer.cancel();
        }
        isRunning = false;
    }
   //3.resumeTimer() — นัดต่อจากเวลาที่เหลือ
    public void resumeTimer(){
        startTimer();// เรียก startTimer ต่อจาก remainingTime ที่ค้างอยู่
    }
    //4.stopTimer() — หยุดการนับเวลาทั้งหมด
    public void stopTimer(){
        if (countDownTimer != null){
            countDownTimer.cancel();
        }
        isRunning = false;
    }
    //5.resetTimer() — รีเซ็ตเวลาให้กลับมาเท่ากับ timeLimit
    public void resetTimer(){
        stopTimer();
        remainingTime = timeLimit;
    }
    //6. updateTime() — อัปเดตเวลา (เรียกใช้ตอนเวลาเดิน)
    public  void updateTimer(){
        // สามารถปล่อยว่างไว้ หรือใส่โค้ด Log ดูเวลาได้
    }
    //7.checkTimeOut() — เช็กว่าหมดเวลาหรือยัง
    public boolean checkTimeOut(){
        return remainingTime <= 0;
    }

    // --Getters & Setters--
    public int getTimeLimit(){return timeLimit;}
    public void setTimeLimit(int timeLimit){
        this.timeLimit = timeLimit;
        this.remainingTime = timeLimit;
    }
    public int getRemainingTime() {return remainingTime;}
    public boolean isRunning(){return isRunning;}

    // แปลงเวลาที่เหลือเป็นรูปแบบ MM:SS (เช่น 06:00)
    public String getFormattedTime() {
        int minutes = remainingTime / 60;
        int seconds = remainingTime % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}

