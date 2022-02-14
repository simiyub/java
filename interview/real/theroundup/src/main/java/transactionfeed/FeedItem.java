package transactionfeed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import utils.Requirement;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedItem {
    String feedItemUid;
    String categoryUid;
   // String amount;
    String direction;
    String transactionTime;
    String status;
    //String sourceAmount_currency_minorUnits;


    public String getFeedItemUid() {
        return feedItemUid;
    }

    public void setFeedItemUid(String feedItemUid) {
        this.feedItemUid = feedItemUid;
    }

    public String getCategoryUid() {
        return categoryUid;
    }

    public void setCategoryUid(String categoryUid) {
        this.categoryUid = categoryUid;
    }

//    public String getAmount() {
//        return amount;
//    }
//
//    public void setAmount(String amount) {
//        this.amount = amount;
//    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FeedItem{" +
                "feedItemUid='" + feedItemUid + '\'' +
                ", categoryUid='" + categoryUid + '\'' +
                ", direction='" + direction + '\'' +
                ", transactionTime='" + transactionTime + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
