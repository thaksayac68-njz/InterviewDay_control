package com.example.interviewday.controllers;

import android.content.Context;
import android.content.Intent;
import android.app.Activity;
import com.example.interviewday.activities.MainMenuActivity;
import com.example.interviewday.activities.StageSelectionActivity;
import com.example.interviewday.activities.GameStageActivity;
public class NavigationControllers {
    // --Attributes--
    private String currentScreen;
    private String previousScreen;
    private Context context;

    // --Constructor--
    public NavigationControllers(){
        this.currentScreen = "MainMenu";
        this.previousScreen = "";
    }
    public NavigationControllers(Context context){
        this.context = context;
        this.currentScreen = "MainMenu";
        this.previousScreen = "";
    }

    // --Methods--
    //1.goToMainMenu() — เปิดหน้าเมนูหลัก (MainMenuActivity)
    public void goToMainMenu(){
        this.previousScreen = currentScreen;
        this.currentScreen = "MainMenu";

        if (context != null) {
            Intent intent = new Intent(context, MainMenuActivity.class);
            context.startActivity(intent);
        }
    }
    //2.goToStageSelect() — เปิดหน้าเลือกด่าน (StageSelectionActivity)
    public void goToStageSelect(){
        this.previousScreen = currentScreen;
        this.currentScreen = "StageSelect";

        if (context != null){
            Intent intent = new Intent(context, StageSelectionActivity.class);
            context.startActivity(intent);
        }
    }
    //3.goToGameStage(int stageNumber) — เปิดหน้าเล่นเกมตามด่านที่ส่งมา (GameStageActivity)
    public void goToGameStage(int stageNumber){
        this.previousScreen = currentScreen;
        this.currentScreen = "GameStage";

        if (context != null){
            Intent intent = new Intent(context, GameController.class);
            intent.putExtra("STAGE_NUMBER", stageNumber);
            context.startActivity(intent);
        }
    }
    //4.goBack() — ปิดหน้าปัจจุบันเพื่อย้อนกลับไปหน้าก่อนหน้า
    public void goBack() {
        if (context instanceof Activity){
            ((Activity) context).finish();
        }
    }

    // --Getters--
    public String getCurrentScreen(){return currentScreen;}
    public String getPreviousScreen(){return previousScreen;}
    public void setContext(Context context) {this.context = context;}

}
