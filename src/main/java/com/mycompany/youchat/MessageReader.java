/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.youchat;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author 2020338 - Douglas Santos
 */
public class MessageReader implements Runnable {

    private BufferedReader reader;
    GoodbyeMessages goodbye = new GoodbyeMessages();

    /**
     * Builds a MessageReader object with the specified BufferedReader.
     *
     * @param reader: the BufferedReader
     */
    public MessageReader(BufferedReader reader) {
        super();
        this.reader = reader;
    }

    /**
     * Reads messages from the BufferedReader and prints them to the console.
     * Listens for messages until an IOException occurs or the connection is
     * closed.
     */
    @Override
    public void run() {
        try {
            String serverMessage;
            while ((serverMessage = reader.readLine()) != null) {
                System.out.println(serverMessage);
            }
        } catch (IOException e) {
            // Displays a goodbye and a random farewell message
            System.out.println("Sorry you have to leave!");
            System.out.println(goodbye.getMessage());
            System.out.println("Thank you for using YouChat!\n[----------- YouChat <Y> Instant Messenger -----------]\n");
        }
    }
}
