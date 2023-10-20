/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.ArrayList;
import java.util.List;
import model.*;
/**
 *
 * @author Darren
 */
public class Ctrlr {
    DummyCtrlr dummy = new DummyCtrlr();
    public String showUserPost(int userId) {
        String result = "";
        ArrayList<ContentState> order = new ArrayList<>(List.of(ContentState.PINNED, ContentState.SHOWED, ContentState.ARCHIVED, ContentState.DELETED));
        
        if(dummy.user.get(userId).getPost().isEmpty()){
            return "No post";
        }
        
        for (ContentState orderTmp : order) {
            for (int i = 1; i <= 12; i++) {
                for (Post postTmp : dummy.user.get(userId).getPost()) {
                    if (postTmp.getStatus().equals(orderTmp)) {
                        if (postTmp.getStatus().equals(ContentState.PINNED)) {
                            result += "Post id : " + postTmp.getPostId() + "\nStatus : " + postTmp.getStatus() + "\nTime Upload : " + postTmp.getTimeUpload() + "Content Type : " + postTmp.getPostType() + "\n";
                            if (postTmp instanceof Feed) {
                                Feed tmp = ((Feed) postTmp);
                                result += "Likes : " + tmp.getLikes();
                            } else if (postTmp instanceof Story) {
                                Story tmp = ((Story) postTmp);
                                result += "Views : " + tmp.getViews();
                            } else {
                                Reel tmp = ((Reel) postTmp);
                                result += "Played count : " + tmp.getPlayedCount();
                            }
                            result += "\n\n\n";
                        } else {
                            int month = postTmp.getTimeUpload().getMonth() + 1;
                            if (month == i) {
                                result += "Post id : " + postTmp.getPostId() + "\nStatus : " + postTmp.getStatus() + "\nTime Upload : " + postTmp.getTimeUpload() + "Content Type : " + postTmp.getPostType() + "\n";
                                if (postTmp instanceof Feed) {
                                    Feed tmp = ((Feed) postTmp);
                                    result += "Likes : " + tmp.getLikes();
                                } else if (postTmp instanceof Story) {
                                    Story tmp = ((Story) postTmp);
                                    result += "Views : " + tmp.getViews();
                                } else {
                                    Reel tmp = ((Reel) postTmp);
                                    result += "Played count : " + tmp.getPlayedCount();
                                }
                                result += "\n\n\n";
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
    
    public String showPost(int userId, int postId) {
        String result = "";
        if (dummy.user.get(userId).getPost().isEmpty()) {
            return "No post";
        }
        Post postTmp = dummy.user.get(userId).getPost().get(postId);
        result += "Post id : " + postTmp.getPostId() + "\nStatus : " + postTmp.getStatus() + "\nTime Upload : " + postTmp.getTimeUpload() + "Content Type : " + postTmp.getPostType() + "\n";
        if (postTmp instanceof Feed) {
            Feed tmp = ((Feed) postTmp);
            result += "Likes : " + tmp.getLikes() + "\nCaption : " + tmp.getCaption();
        } else if (postTmp instanceof Story) {
            Story tmp = ((Story) postTmp);
            result += "Views : " + tmp.getViews() + "\nDuration : " + tmp.getDuration();
        } else {
            Reel tmp = ((Reel) postTmp);
            result += "Played count : " + tmp.getPlayedCount() + "\nDuration : " + tmp.getDuration();
        }
        result += "\n\n";
        return result;
    }
    
    public boolean changePostState(int userId, int postId, ContentState newStatus) {
        ContentState tmpStatus = dummy.user.get(userId).getPost().get(postId).getStatus();
        int count = 0;
        for (Post postTmp : dummy.user.get(userId).getPost()) {
            if (postTmp.getStatus()==ContentState.PINNED){
                count++;
            }
        }
        if(tmpStatus==ContentState.DELETED) {
            return false;
        } else if (tmpStatus!=ContentState.ARCHIVED && newStatus==ContentState.DELETED) {
            return false;
        } else if (tmpStatus!=ContentState.SHOWED && newStatus==ContentState.PINNED) {
            return false;
        } else if (newStatus==ContentState.PINNED && !(dummy.user.get(userId).getPost().get(postId) instanceof Feed)) {
            return false;
        } else if (count>=3){
            return false;
        } else {
            dummy.user.get(userId).getPost().get(postId).setStatus(newStatus);
            return true;
        }
    }
}
