package model;

import java.util.ArrayList;
import java.util.List;
import event.ColorObservateur;
import event.NewColorValue;

public class Model implements ModelInterface{
	
	private int valueR = 0;
	private int valueG = 0;
	private int valueB = 0;
	
	private List<ColorObservateur> colorObservateurs = new ArrayList<ColorObservateur>();
	
	@Override
	public int getValueR() {
		return valueR;
	}

	@Override
	public void setValueR(int valueR) {
		this.valueR = valueR;
		notifyObservateur();
	}

	@Override
	public int getValueG() {
		return valueG;
	}

	@Override
	public void setValueG(int valueG) {
		this.valueG = valueG;
		notifyObservateur();
	}

	@Override
	public int getValueB() {
		return valueB;
	}

	@Override
	public void setValueB(int valueB) {
		this.valueB = valueB;
		notifyObservateur();
	}

	@Override
	public void setColor(int valueR, int valueG, int valueB) {
		this.valueR = valueR;
		this.valueG = valueG;
		this.valueB = valueB;
		notifyObservateur();
	}

	@Override
	public void addObservateur(ColorObservateur colorObservateur) {
		this.colorObservateurs.add(colorObservateur);
	}

	@Override
	public void deleteObservateur(ColorObservateur colorObservateur) {
		this.colorObservateurs.remove(colorObservateur);	
	}

	@Override
	public void notifyObservateur() {
		for(ColorObservateur colorObservateur : colorObservateurs) {
			colorObservateur.NewColorObservateur(new NewColorValue(this,valueR,valueG,valueB));
		}
	}
	
}
