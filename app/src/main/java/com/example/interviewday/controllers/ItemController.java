package com.example.interviewday.controllers;

import java.util.ArrayList;
import java.util.List;

public class ItemController {
    // --Attributes--
    private List<String> items;//— ลิสต์เก็บชื่อไอเท็มทั้งหมดในเกม
    private List<String> secretItems;//— ลิสต์เก็บชื่อไอเท็มลับที่เก็บได้
    private List<String> collectedItems;//— ลิสต์เก็บชื่อไอเท็มปกติที่เก็บได้แล้ว
    // --Constructor--
    //สร้าง public ItemController() เพื่อกำหนดค่าเริ่มต้นให้กับ List ทั้ง 3 ตัว (จองพื้นที่ความจำด้วย new ArrayList<>()):
    public ItemController(){
        items = new ArrayList<>();
        secretItems = new ArrayList<>();
        collectedItems = new ArrayList<>();

        // ===== 1. เพิ่มรายการไอเท็มธรรมดาประจำแต่ละด่าน =====
        //ด่าน 1: ห้องนอน
        items.add("Dev Laptop");
        items.add("USB Flash Drive");
        items.add("Resume");

        // ด่าน 2: ห้องแล็บ
        items.add("Ethernet Cable");
        items.add("External HDD");
        items.add("Algorithm Paper");

        // ด่าน 3: บริษัท TechNova
        items.add("Whiteboard Marker");
        items.add("Architecture Diagram");
        items.add("Employee Card");

        // ===== 2. เพิ่มรายการไอเท็มลับประจำแต่ละด่าน =====
        secretItems.add("OOP Secret Flashcard");            // ไอเท็มลับด่าน 1
        secretItems.add("Special Microcontroller Board");   // ไอเท็มลับด่าน 2
        secretItems.add("Executive Recommendation Letter"); // ไอเท็มลับด่าน 3

    }
    // --Methods--
    //1.collectItem(String itemName) — เก็บไอเท็มปกติ*ถ้ายังไม่มีชื่อไอเท็มใน collectedItems ให้ใช้ .add(itemName) เพิ่มเข้าไป
    public void collectItem(String itemName) {
        if (!collectedItems.contains(itemName)) {
            collectedItems.add(itemName);
        }
    }
    //2.collectSecretItem(String itemName) — เก็บไอเท็มลับ*ถ้ายังไม่มีชื่อไอเท็มใน secretItems ให้ใช้ .add(itemName) เพิ่มเข้าไป
    public void collectSecretItem(String itemName){
        if (!secretItems.contains(itemName)){
            secretItems.add(itemName);
        }
    }
    //3.checkItemCollected(String itemName) — ตรวจสอบว่าเก็บไอเท็มปกตินี้ไปหรือยัง*คืนค่า boolean (true/false) โดยใช้ collectedItems.contains(itemName)
    public boolean checkItemCollected(String itemName) {
        return collectedItems.contains(itemName);
    }
    //4.checkSecretItem(String itemName) — ตรวจสอบว่าเก็บไอเท็มลับนี้ไปหรือยัง*คืนค่า boolean โดยใช้ secretItems.contains(itemName)
    public boolean checkSecretItem(String itemName){
        return secretItems.contains(itemName);
    }

    // --Getters--
    public List<String> getCollectedItems() {return collectedItems ;}
    public List<String> getSecretItems() {return secretItems ;}
}
