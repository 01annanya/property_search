package project_property_search_app.entity;

import org.springframework.stereotype.Component;

@Component
public class Inquiry {
	private int inquiryId;
	private int buyerId;
    private int propertyId;
    private String message;
    private String response;
    private int seller_id;
    private transient String propertyTitle;
    private String status;
    
    public Inquiry() {}


	public Inquiry(int inquiryId, int buyerId, int propertyId, String message, String response, int seller_id,String status) {
		super();
		this.inquiryId = inquiryId;
		this.buyerId = buyerId;
		this.propertyId = propertyId;
		this.message = message;
		this.response = response;
		this.seller_id = seller_id;
		this.status=status;
	}

	public int getInquiryId() {
		return inquiryId;
	}

	public void setInquiryId(int inquiryId) {
		this.inquiryId = inquiryId;
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	public String getResponse() {
		return response;
	}


	public void setResponse(String response) {
		this.response = response;
	}


	public int getSeller_id() {
		return seller_id;
	}


	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}

	public String getPropertyTitle() {
		return propertyTitle;
	}


	public void setPropertyTitle(String propertyTitle) {
		this.propertyTitle = propertyTitle;
	}
	    

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Inquiry [inquiryId=" + inquiryId + ", buyerId=" + buyerId + ", propertyId=" + propertyId + ", message="
				+ message + ", response=" + response + ", seller_id=" + seller_id + ", status=" + status + "]";
	}


	

	


	
    
    
}
