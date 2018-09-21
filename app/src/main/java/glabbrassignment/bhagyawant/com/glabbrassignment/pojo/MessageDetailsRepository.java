package glabbrassignment.bhagyawant.com.glabbrassignment.pojo;

import java.util.ArrayList;
import java.util.Observable;

public class MessageDetailsRepository extends Observable {

    String message;
    ArrayList<StatusDetail> statusDetails;
    private static MessageDetailsRepository INSTANCE = null;

    public static MessageDetailsRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MessageDetailsRepository();
        }
        return INSTANCE;
    }

    public void setMessageDetails(String message, ArrayList<StatusDetail> statusDetails) {
        this.message = message;
        this.statusDetails = statusDetails;
        setChanged();
        notifyObservers();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<StatusDetail> getStatusDetails() {
        return statusDetails;
    }

    public void setStatusDetails(ArrayList<StatusDetail> statusDetails) {
        this.statusDetails = statusDetails;
    }

}
