package test;

import java.io.Serializable;

public class TrainBean implements Serializable
{
	String trainId,trainName,fromStn,toStn;
	int avlBearth;
	
	public TrainBean() {
		// TODO Auto-generated constructor stub
	}

	public String getTrainId() {
		return trainId;
	}

	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getFromStn() {
		return fromStn;
	}

	public void setFromStn(String fromStn) {
		this.fromStn = fromStn;
	}

	public String getToStn() {
		return toStn;
	}

	public void setToStn(String toStn) {
		this.toStn = toStn;
	}

	public int getAvlBearth() {
		return avlBearth;
	}

	public void setAvlBearth(int avlBearth) {
		this.avlBearth = avlBearth;
	}
	
	
}
