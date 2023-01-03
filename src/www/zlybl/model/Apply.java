package www.zlybl.model;

public class Apply {
    private int applyId;
    private int userId;
    private int bookId;
    private boolean applyType; //申请类型 1为借阅 0为归还
    private int applyStatus; //申请状态 0为申请中 1为同意 2为拒绝

    public Apply() {
    }

    public Apply(int applyId, int userId, int bookId, boolean applyType, int applyStatus) {
        this.applyId = applyId;
        this.userId = userId;
        this.bookId = bookId;
        this.applyType = applyType;
        this.applyStatus = applyStatus;
    }

    public int getApplyId() {
        return applyId;
    }

    public void setApplyId(int applyId) {
        this.applyId = applyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public boolean isApplyType() {
        return applyType;
    }

    public void setApplyType(boolean applyType) {
        this.applyType = applyType;
    }

    public int getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(int applyStatus) {
        this.applyStatus = applyStatus;
    }

    @Override
    public String toString() {
        return "Apply{" +
                "applyId=" + applyId +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", applyType=" + applyType +
                ", applyStatus=" + applyStatus +
                '}';
    }
}
