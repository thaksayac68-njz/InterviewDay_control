package com.example.interviewday.controllers;

public class GameStageController {
    // --Attributes--
    private int currentStage;
    private String gameState;
    private boolean isPlaying;
    private int questProgress;

    // --Constructor--
    public GameStageController(){
        this.currentStage = 1;
        this.gameState = "IDLE";
        this.isPlaying = false;
        this.questProgress = 0;
    }

    // --Methods--
    //1.startStage(int stage) — เริ่มต้นเล่นด่านตามด่านที่ระบุ
    public void startStage(int stage){
        this.currentStage = stage;
        this.gameState = "PLAYING";
        this.isPlaying = true;
        this.questProgress = 0;
    }
    //2.pauseStage() — หยุดเกมในด่านชั่วคราว
    public void pauseStage(){
        this.gameState = "PAUSED";
        this.isPlaying = false;
    }
    //3.resumeStage() — กลับมาเล่นเกมในด่านต่อ
    public void resumeStage(){
        this.gameState = "PLAYING";
        this.isPlaying = true;
    }
    //4.handlePlayerAction(String actionType) — รับการกระทำของผู้เล่น (เช่น กดเก็บไอเท็ม)
    public void handlePlayerAction(String actionType) {
        if (!isPlaying) return;

        if ("COLLECT_ITEM".equals(actionType)){
            this.questProgress++;
            checkGameRule();
        }
    }
    //5.updateGameUI() — อัปเดตการแสดงผลหน้าจอ
    public void updateGameUI(){}// โค้ดสำหรับสั่งอัปเดตหน้าจอ UI
    //6.checkGameRule() — เช็กกติกาว่าผ่านด่านหรือยัง (เช่น เก็บไอเท็มหลักครบ 3 ชิ้น)
    public boolean checkGameRule(){
        if (questProgress >= 3 ){
            finishStage();
            return true;
        }
        return false;
    }
    //7.finishStage() — เมื่อผ่านด่านหรือจบด่านแล้ว
    public void finishStage(){
        this.gameState = "FINISHED";
        this.isPlaying = false;
    }

    // --Getters--
    public int getCurrentStage() { return currentStage; }
    public void setCurrentStage(int currentStage) { this.currentStage = currentStage; }
    public String getGameState() { return gameState; }
    public boolean isPlaying() { return isPlaying; }
    public int getQuestProgress() { return questProgress; }

}
