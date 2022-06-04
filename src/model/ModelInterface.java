package model;

import event.ColorObservateur;

public interface ModelInterface {
	
	public int getValueR();
	public void setValueR(int valueR);
	public int getValueG();
	public void setValueG(int valueG);
	public int getValueB();
	public void setValueB(int valueB);
	public void setColor(int valueR, int valueG, int valueB);
	public void addObservateur(ColorObservateur colorObservateur);
	public void deleteObservateur(ColorObservateur colorObservateur);
	public void notifyObservateur();
}
