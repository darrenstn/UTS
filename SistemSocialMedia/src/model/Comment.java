/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Darren
 */
public class Comment {
    private String commentId;
    private String text;
    private ConcentState status;

    public Comment(String commentId, String text, ConcentState status) {
        this.commentId = commentId;
        this.text = text;
        this.status = status;
    }

    public String getCommentId() {
        return commentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ConcentState getStatus() {
        return status;
    }

    public void setStatus(ConcentState status) {
        this.status = status;
    }
    
}
