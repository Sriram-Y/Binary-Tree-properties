/*
***********************************************************************************************************************
Author: Sriram Yadavalli
Date: 9/27/2021
Class: CMSC 350 6380
Assignment: Project 3
***********************************************************************************************************************
Description:
This program allows the user to enter a binary tree in a parenthesized prefix format and then allows it to be 
categorized and allows various features of that tree to be displayed.
This is the main class with the GUI.
***********************************************************************************************************************
*/

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI {
    public GUI(){
        BinaryTree bt = new BinaryTree();

        //GUI creation
        JFrame frame = new JFrame();

        JPanel panel = new JPanel();
        JPanel expressionPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel outputPanel = new JPanel();

        JButton buttonMakeTree = new JButton("Make Tree");
        JButton buttonIsBalanced = new JButton("Is Balanced?");
        JButton buttonIsFull = new JButton("Is Full?");
        JButton buttonIsProper = new JButton("Is Proper?");
        JButton buttonHeight = new JButton("Height");
        JButton buttonNodes = new JButton("Nodes");
        JButton buttonInOrder = new JButton("In order");

        JLabel labelEnterTree = new JLabel("Enter Tree: ");
        JLabel labelOutput = new JLabel("Output: ");

        JTextField textFieldBinaryTree = new JTextField(20);
        JTextField textFieldOutput = new JTextField(20);
        textFieldOutput.setEditable(false);

        buttonMakeTree.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String userInput = textFieldBinaryTree.getText();

                if(mismatchParenthesis(userInput)){
                    throw new InvalidTreeSyntax("Mismatch Parenthesis Error. Parenthesis missing.");
                }
                if(nullTree(userInput)){
                    throw new InvalidTreeSyntax("Null Tree Error. Tree is empty.");
                }
                if(missingNode(userInput)){
                    throw new InvalidTreeSyntax("Missing Node Error. Node is missing.");
                }

                BinaryTree.Node tree = bt.makeTree(userInput);
                String inOrderString = "";
                try{
                    inOrderString = bt.inOrder(tree);
                }
                catch(Exception ex){
                    throw new InvalidTreeSyntax(ex.getMessage());
                }

                textFieldOutput.setText(inOrderString);
            }
        });

        buttonIsBalanced.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String userInput = textFieldBinaryTree.getText();

                if(mismatchParenthesis(userInput)){
                    throw new InvalidTreeSyntax("Mismatch Parenthesis Error. Parenthesis missing.");
                }
                if(nullTree(userInput)){
                    throw new InvalidTreeSyntax("Null Tree Error. Tree is empty.");
                }
                if(missingNode(userInput)){
                    throw new InvalidTreeSyntax("Missing Node Error. Node is missing.");
                }

                BinaryTree.Node tree = bt.makeTree(userInput);
                boolean isBalanced = false;

                try{
                    isBalanced = bt.isBalanced(tree);
                }
                catch(Exception ex){
                    throw new InvalidTreeSyntax(ex.getMessage());
                }

                textFieldOutput.setText(String.valueOf(isBalanced));
            }
        });

        buttonIsFull.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String userInput = textFieldBinaryTree.getText();

                if(mismatchParenthesis(userInput)){
                    throw new InvalidTreeSyntax("Mismatch Parenthesis Error. Parenthesis missing.");
                }
                if(nullTree(userInput)){
                    throw new InvalidTreeSyntax("Null Tree Error. Tree is empty.");
                }
                if(missingNode(userInput)){
                    throw new InvalidTreeSyntax("Missing Node Error. Node is missing.");
                }

                BinaryTree.Node tree = bt.makeTree(userInput);
                boolean isFull = false;

                try{
                    isFull = bt.isFull(tree);
                }
                catch(Exception ex){
                    throw new InvalidTreeSyntax(ex.getMessage());
                }

                textFieldOutput.setText(String.valueOf(isFull));
            }
        });

        buttonIsProper.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String userInput = textFieldBinaryTree.getText();

                if(mismatchParenthesis(userInput)){
                    throw new InvalidTreeSyntax("Mismatch Parenthesis Error. Parenthesis missing.");
                }
                if(nullTree(userInput)){
                    throw new InvalidTreeSyntax("Null Tree Error. Tree is empty.");
                }
                if(missingNode(userInput)){
                    throw new InvalidTreeSyntax("Missing Node Error. Node is missing.");
                }

                BinaryTree.Node tree = bt.makeTree(userInput);
                boolean isProper = false;

                try{
                    isProper = bt.isProper(tree);
                }
                catch(Exception ex){
                    throw new InvalidTreeSyntax(ex.getMessage());
                }

                textFieldOutput.setText(String.valueOf(isProper));
            }
        });

        buttonHeight.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String userInput = textFieldBinaryTree.getText();

                if(mismatchParenthesis(userInput)){
                    throw new InvalidTreeSyntax("Mismatch Parenthesis Error. Parenthesis missing.");
                }
                if(nullTree(userInput)){
                    throw new InvalidTreeSyntax("Null Tree Error. Tree is empty.");
                }
                if(missingNode(userInput)){
                    throw new InvalidTreeSyntax("Missing Node Error. Node is missing.");
                }
                
                BinaryTree.Node tree = bt.makeTree(userInput);
                int height = 0;

                try{
                    height = bt.height(tree);
                }
                catch(Exception ex){
                    throw new InvalidTreeSyntax(ex.getMessage());
                }

                textFieldOutput.setText(String.valueOf(height));
            }
        });

        buttonNodes.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String userInput = textFieldBinaryTree.getText();

                if(mismatchParenthesis(userInput)){
                    throw new InvalidTreeSyntax("Mismatch Parenthesis Error. Parenthesis missing.");
                }
                if(nullTree(userInput)){
                    throw new InvalidTreeSyntax("Null Tree Error. Tree is empty.");
                }
                if(missingNode(userInput)){
                    throw new InvalidTreeSyntax("Missing Node Error. Node is missing.");
                }

                BinaryTree.Node tree = bt.makeTree(userInput);
                int numOfNodes = 0;

                try{
                    numOfNodes = bt.nodes(tree);
                }
                catch(Exception ex){
                    throw new InvalidTreeSyntax(ex.getMessage());
                }

                textFieldOutput.setText(String.valueOf(numOfNodes));
            }
        });

        buttonInOrder.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String userInput = textFieldBinaryTree.getText();

                if(mismatchParenthesis(userInput)){
                    throw new InvalidTreeSyntax("Mismatch Parenthesis Error. Parenthesis missing.");
                }
                if(nullTree(userInput)){
                    throw new InvalidTreeSyntax("Null Tree Error. Tree is empty.");
                }
                if(missingNode(userInput)){
                    throw new InvalidTreeSyntax("Missing Node Error. Node is missing.");
                }

                BinaryTree.Node tree = bt.makeTree(userInput);
                String inOrderString = "";
                try{
                    inOrderString = bt.inOrder(tree);
                }
                catch(Exception ex){
                    throw new InvalidTreeSyntax(ex.getMessage());
                }

                textFieldOutput.setText(inOrderString);
            }
        });

        panel.setLayout(new GridLayout(3, 1, 20, 20));
        expressionPanel.setLayout(new FlowLayout());
        buttonPanel.setLayout(new FlowLayout());

        expressionPanel.add(labelEnterTree);
        expressionPanel.add(textFieldBinaryTree);

        outputPanel.add(labelOutput);
        outputPanel.add(textFieldOutput);

        buttonPanel.add(buttonMakeTree);
        buttonPanel.add(buttonIsBalanced);
        buttonPanel.add(buttonIsFull);
        buttonPanel.add(buttonIsProper);
        buttonPanel.add(buttonHeight);
        buttonPanel.add(buttonNodes);
        buttonPanel.add(buttonInOrder);

        panel.add(expressionPanel);
        panel.add(buttonPanel);
        panel.add(outputPanel);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Binary Tree Categorizer");
        frame.pack();
        frame.setVisible(true);
    }

    private boolean mismatchParenthesis(String userInput){
        boolean check = false;
        int numOfLeftParenthesis = 0;
        int numOfRightParenthesis = 0;
        
        //get the number of ( and )
        for(int i = 0; i < userInput.length(); i++){
            if(userInput.charAt(i) == '('){
                numOfLeftParenthesis++;
            }
            else if(userInput.charAt(i) == ')'){
                numOfRightParenthesis++;
            }
        }

        //if the number of ( and ) are not equal
        if(numOfLeftParenthesis != numOfRightParenthesis){
            check = true;
        }
        else{
            check = false;
        }

        return check;
    }
    
    private boolean nullTree(String userInput){
        boolean check = false;

        //user input empty or not
        if(userInput.equals("")){
            check = true;
        }
        else{
            check = false;
        }

        return check;
    }

    private boolean missingNode(String userInput){
        boolean check = false;
        int numOfLeftParenthesis = 0;
        int numOfRightParenthesis = 0;
        int numOfParenthesis = 0;
        int numOfNodes = 0;

        //get the number of ( and )
        for(int i = 0; i < userInput.length(); i++){
            if(userInput.charAt(i) == '('){
                numOfLeftParenthesis++;
            }
            if(userInput.charAt(i) == ')'){
                numOfRightParenthesis++;
            }
            if(userInput.charAt(i) != ')' && userInput.charAt(i) != '('){
                numOfNodes++;
            }
        }

        //add the number of ( and )
        numOfParenthesis = numOfLeftParenthesis + numOfRightParenthesis;

        //if numOfParenthesis is not equal to numOfNodes there is a missing node
        if(numOfParenthesis / 2 == numOfNodes){
            check = false;
        }
        else{
            check = true;
        }

        return check;
    }

    public static void main(String[] args){
        new GUI();
    }
}
