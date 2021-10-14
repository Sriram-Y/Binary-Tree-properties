/*
***********************************************************************************************************************
Author: Sriram Yadavalli
Date: 9/27/2021
Class: CMSC 350 6380
Assignment: Project 3
***********************************************************************************************************************
Description:
Errors in the syntax of the tree are detected in the main class and JOptionPane is display with reasoning.
***********************************************************************************************************************
*/

import javax.swing.JOptionPane;

public class InvalidTreeSyntax extends RuntimeException{

    public InvalidTreeSyntax() {
    }

    public InvalidTreeSyntax(String message) {
        super(message);
        JOptionPane.showMessageDialog(null, message);
    }

    public InvalidTreeSyntax(Throwable cause) {
        super(cause);
        JOptionPane.showMessageDialog(null, cause);
    }

    public InvalidTreeSyntax(String message, Throwable cause) {
        super(message, cause);
        JOptionPane.showMessageDialog(null, message);
    }

    public InvalidTreeSyntax(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        JOptionPane.showMessageDialog(null, message);
    }
}

