package glabbrassignment.bhagyawant.com.glabbrassignment.pojo;

public class StatusDetail {

    private String contactNumber;
    private int status;

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public StatusDetail(String contactNumber, int status) {
        this.contactNumber = contactNumber;
        this.status = status;
    }
}
