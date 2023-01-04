package www.zlybl.model;

import java.io.Serializable;

public class BorrowingHistory implements Serializable {
    private int historyId;
    private int bookId;
    private int userId;
    private String borrowingTime;
    private String returnedTime;

    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBorrowingTime() {
        return borrowingTime;
    }

    public void setBorrowingTime(String borrowingTime) {
        this.borrowingTime = borrowingTime;
    }

    public String getReturnedTime() {
        return returnedTime;
    }

    public void setReturnedTime(String returnedTime) {
        this.returnedTime = returnedTime;
    }

    @Override
    public String toString() {
        return "BorrowingHistory{" +
                "historyId=" + historyId +
                ", bookId=" + bookId +
                ", userId=" + userId +
                ", borrowingTime='" + borrowingTime + '\'' +
                ", returnedTime='" + returnedTime + '\'' +
                '}';
    }
}
