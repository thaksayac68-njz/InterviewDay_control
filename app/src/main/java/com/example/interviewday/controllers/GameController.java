package com.example.interviewday.controllers;

public class GameController {
    // --Attribute--
    private int currentStage;//— ไว้จำด่านปัจจุบัน (เช่น 1, 2, 3)
    private String gameState;//— ไว้เก็บสถานะเกม เช่น "IDLE", "PLAYING", "PAUSED", "ENDED"

    // --Constructor--
    public GameController() {//สร้าง Constructor public GameController() เพื่อกำหนดค่าเริ่มต้นเมื่อสร้าง Object:
        currentStage = 1;
        gameState = "IDLE";
    }

    // --Method--
    //1. startGame() — เริ่มเล่นเกม
    public void startGame(){
        currentStage = 1;
        gameState = "PLAYING";
    }
    //2.pauseGame() — หยุดเกมชั่วคราว
    public void pauseGame(){
        gameState = "PAUSED";
    }
    //3.resumeGame() — เล่นเกมต่อ
    public void resumeGame(){
        gameState = "PLAYING";
    }
    //4.endGame() — จบเกม
    public void endGame(){
        gameState = "ENDED";
    }

    // --Getters & Setters สำหรับ currentStage--
    public int getCurrentStage(){
        return currentStage;
    }
    public void setCurrentStage(int currentStage){
        this.currentStage = currentStage;
    }

    // --Getter / Setter สำหรับ gameState--
    public String getGameState() {
        return gameState;
    }
    public void setGameState(String gameState){
        this.gameState = gameState;
    }
}
