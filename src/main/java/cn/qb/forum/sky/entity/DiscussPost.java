package cn.qb.forum.sky.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 帖子数据的实体类
 */
public class DiscussPost implements Serializable {

    private static final long serialVersionUID = -3585695315208640815L;

    private Integer id;
    private Integer userId;
    private String title;
    private String content;
    private Integer type;
    private  Integer status;
    private Integer commentCount;
    private Double score;
    private Date createTime;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Integer getType() {
        return type;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public Double getScore() {
        return score;
    }

    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public String toString() {
        return "DiscussPost{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", commentCount=" + commentCount +
                ", score=" + score +
                ", createTime=" + createTime +
                '}';
    }
}
