package hcmuaf.edu.tien.doanweb.entities;

public class comment {
    private  int commentId;
    private  String content;
    private  String username;
    private  int productId;

    public comment(int commentId, String content, String username, int productId) {
        this.commentId = commentId;
        this.content = content;
        this.username = username;
        this.productId = productId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "comment{" +
                "commentId=" + commentId +
                ", content='" + content + '\'' +
                ", username='" + username + '\'' +
                ", productId=" + productId +
                '}';
    }
}
