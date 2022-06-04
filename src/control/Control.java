package control;

import event.ColorObservateur;
import model.Model;

public class Control implements ControlInterface{

	@SuppressWarnings("unused")
	private Model modele;
	
	public Control(Model modele) {
		this.modele = modele;
	}
	
	@Override
	public void addObservateur(ColorObservateur colorObservateur) {
		modele.addObservateur(colorObservateur);
	}

	@Override
	public void deleteObservateur(ColorObservateur colorObservateur) {
		modele.deleteObservateur(colorObservateur);
	}

	@Override
	public void valueRedChanged(int valueR) {
		modele.setValueR(valueR);
	}

	@Override
	public void valueGreenChanged(int valueG) {
		modele.setValueG(valueG);	
	}

	@Override
	public void valueBlueChanged(int valueB) {
		modele.setValueB(valueB);
	}

	@Override
	public void colorChanged(int valueR, int valueG, int valueB) {
		modele.setColor(valueR, valueG, valueB);
	}
	
}
