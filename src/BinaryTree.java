/*
***********************************************************************************************************************
Author: Sriram Yadavalli
Date: 9/27/2021
Class: CMSC 350 6380
Assignment: Project 3
***********************************************************************************************************************
Description:
This class contains a static nested class to define the nodes of the binary tree. A string representation of the tree 
is supplied by the user and the methods in this function perform the appropriate function depending on the button that 
is pressed.
***********************************************************************************************************************
*/

import java.util.ArrayList;

public class BinaryTree{
    public static class Node{
        char data;
        Node leftChild = null;
        Node rightChild = null;

        //constructor
        Node(char data){
            this.data = data;
        }

        //setter methods
        public void setLeftChild(Node leftChild){
            this.leftChild = leftChild;
        }

        public void setRightChild(Node rightChild){
            this.rightChild = rightChild;
        }
    }

    public Node makeTree(String userInput){
        ArrayList<Node> nodes = new ArrayList<Node>();

        if(userInput == null || userInput.isEmpty()){
            return null;
        }

        for(int i = 0; i <= userInput.length() - 1; i++){
            if(Character.compare(userInput.charAt(i), '(') == 0){
                //skips the '('
                continue;
            }
            else if(Character.compare(userInput.charAt(i), '(') != 0 && Character.compare(userInput.charAt(i), ')') != 0){
                //creates a new node with the data
                nodes.add(new Node(userInput.charAt(i)));
            }
            else if(Character.compare(userInput.charAt(i), ')') == 0){
                for(int j = 0; j <= nodes.size() - 1; j++){
                    //loop through the nodes
                    if(j == nodes.size() - 1 && nodes.size() != 1){
                        //go to end of the nodes
                        if(nodes.get(j - 1).leftChild == null){
                            //set leftChilf of the last node to the current node if leftChild is null
                            nodes.get(j - 1).setLeftChild(nodes.get(j));
                            nodes.remove(j);
                            break;
                        }
                        else{
                            //set rightChild of the last node to the current node if leftChild is not null
                            nodes.get(j - 1).setRightChild(nodes.get(j));
                            nodes.remove(j);
                            break;
                        }
                    }
                }
            }
        }

        return nodes.get(0);
    }

    public boolean isBalanced(Node tree){
        int lHeight = 0;
        int rHeight = 0;

        if(tree == null){
            return true;
        }

        lHeight = height(tree.leftChild);
        rHeight = height(tree.rightChild);

        if(Math.abs(lHeight - rHeight) <= 1 && isBalanced(tree.leftChild) && isBalanced(tree.rightChild)){
            //if the difference between the left and right height is less than or equal to 1 and the left and right subtrees are balanced
            return true;
        }

        return false;
    }

    public boolean isFull(Node tree){
        if(tree == null){
            return true;
        }
        if(tree.leftChild == null && tree.rightChild == null){
            //if the node is a leaf
            return true;
        }
        if(tree.leftChild != null && tree.rightChild != null){
            //if the nodes is not a leaf
            return isFull(tree.leftChild) && isFull(tree.rightChild);
        }

        return false;
    }

    public boolean isProper(Node tree){
        if(tree == null){
            return true;
        }
        if(tree.leftChild != null && tree.rightChild != null){
            //if the node is not a leaf
            return isProper(tree.leftChild) && isProper(tree.rightChild);
        }
        if(tree.leftChild == null && tree.rightChild == null){
            //if the nodes is a leaf
            return isProper(tree.leftChild) && isProper(tree.rightChild);
        }

        return false;
    }

    public int height(Node tree){
        if(tree == null){
            return 0;
        }
        else{
            //recursive call to add the height of the left and right subtrees
            int leftDepth = height(tree.leftChild);
            int rightDepth = height(tree.rightChild);

            if(leftDepth > rightDepth){
                //if the left subtree is deeper
                return leftDepth + 1;
            }
            else{
                //if the right subtree is deeper
                return rightDepth + 1;
            }
        }
    }

    public int nodes(Node tree){
        if(tree == null){
            return 0;
        }
        
        //recursive calls to count nodes
        return 1 + nodes(tree.leftChild) + nodes(tree.rightChild);
    }

    public String inOrder(Node tree){
        if(tree == null){
            return "";
        }

        //recursive calls to add nodes into the string with brackets
        return "(" + inOrder(tree.leftChild) + tree.data + inOrder(tree.rightChild) + ")";
    }
}