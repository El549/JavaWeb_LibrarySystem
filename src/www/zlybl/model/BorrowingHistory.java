package www.zlybl.model;

import java.util.Date;

public class BorrowingHistory {
    private int historyId;
    private int bookId;
    private int userId;
    private Date borrowedTime;
    private Date returnedTime;

    public BorrowingHistory() {
    }

    public BorrowingHistory(int historyId, int bookId, int userId, Date borrowedTime, Date returnedTime) {
        this.historyId = historyId;
        this.bookId = bookId;
        this.userId = userId;
        this.borrowedTime = borrowedTime;
        this.returnedTime = returnedTime;
    }

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

    public Date getBorrowedTime() {
        return borrowedTime;
    }

    public void setBorrowedTime(Date borrowedTime) {
        this.borrowedTime = borrowedTime;
    }

    public Date getReturnedTime() {
        return returnedTime;
    }

    public void setReturnedTime(Date returnedTime) {
        this.returnedTime = returnedTime;
    }

    @Override
    public String toString() {
        return "borrowingHistory{" +
                "historyId=" + historyId +
                ", bookId=" + bookId +
                ", userId=" + userId +
                ", borrowedTime=" + borrowedTime +
                ", returnedTime=" + returnedTime +
                '}';
    }
}
