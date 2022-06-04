package view;

import control.Control;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import event.ColorObservateur;
import event.NewColorValue;

public class View extends HBox implements ColorObservateur {
	
	private Control control;
	private Slider r;
	private Slider g;
	private Slider b;
	private TextField r_text;
	private TextField g_text;
	private TextField b_text;
	private TextField hexa;
	private Pane color;
	public View(Control control) {
		this.control = control;
		control.addObservateur(this);
		initialize();
	}
	public void initialize() {
		r = new Slider(0,255,0);
		g = new Slider(0,255,0);
		b = new Slider(0,255,0);
		r.setShowTickLabels(true);
		r.setShowTickMarks(true);
		b.setShowTickLabels(true);
		b.setShowTickMarks(true);
		g.setShowTickLabels(true);
		g.setShowTickMarks(true);
		r_text = new TextField("0");
		g_text = new TextField("0");
		b_text = new TextField("0");
		hexa = new TextField("000000");
		color = new Pane();
		color.setPrefSize(200, 200);
		r.valueProperty().addListener(new ChangeListener<Number>()
		{
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
				{
					control.valueRedChanged(newValue.intValue());
				}
			
		});
		r_text.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				try {
				int valueR = Integer.parseInt(newValue);
				if(valueR > 255 || valueR < 0)
				{
					System.out.println("Vous devez entrer un entier compris entre 0 et 255.");
					return;
				}
				control.valueRedChanged(valueR);
				}
				catch (Exception e)
				{
					System.out.println("Vous devez entrer un entier.");
					return;
				}
				
			}
			
		});
		g.valueProperty().addListener(new ChangeListener<Number>()
		{
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
				{
					control.valueGreenChanged(newValue.intValue());
				}
			
		});
		g_text.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				try {
					int valueG = Integer.parseInt(newValue);
					
					if(valueG > 255 || valueG < 0)
					{
						System.out.println("Vous devez entrer un entier compris entre 0 et 255.");
						return;
					}
					
					control.valueGreenChanged(valueG);
				}
				catch (Exception e)
				{
					System.out.println("Vous devez entrer un entier.");
					return;
				}
			}
			
		});
		b.valueProperty().addListener(new ChangeListener<Number>()
		{
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
				{
					control.valueBlueChanged(newValue.intValue());
				}
			
		});
		b_text.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				try {
					int valueB = Integer.parseInt(newValue);
					
					if(valueB > 255 || valueB < 0)
					{
						System.out.println("Vous devez entrer un entier compris entre 0 et 255.");
						return;
					}
					
					control.valueBlueChanged(valueB);
			}
				catch (Exception e)
				{
					System.out.println("Vous devez entrer un entier.");
					return;
				}
			}
		}
		);
		hexa.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				try {
					java.awt.Color color = java.awt.Color.decode("#" + newValue);
					int valueR = color.getRed();
					int valueG = color.getGreen();
					int valueB = color.getBlue();
					if((valueR > 255 || valueR < 0) && (valueG > 255 || valueG < 0) && (valueB > 255 || valueB < 0))
					{
						System.out.println("Vous devez entrer un entier compris entre 0 et 255.");
						return;
					}
					control.colorChanged(valueR, valueG, valueB);
				}
				catch (Exception e)
				{
					System.out.println("Vous devez entrer un entier.");
					return;
				}
			}
			
		});
		VBox sliders = new VBox(10);
		VBox droite = new VBox(10);
		HBox bloc1 = new HBox(15);
		HBox bloc2 = new HBox(15);
		HBox bloc3 = new HBox(15);
		bloc1.getChildren().addAll(r,r_text);
		bloc2.getChildren().addAll(g,g_text);
		bloc3.getChildren().addAll(b,b_text);
		sliders.getChildren().addAll(bloc1,bloc2,bloc3);
		droite.getChildren().addAll(hexa,color);
		this.setSpacing(10);
		HBox.setMargin(this, new Insets(20,20,20,20));
		this.getChildren().addAll(sliders,droite);
		
		
	}
	@Override
	public void NewColorObservateur(NewColorValue event) {
		r.setValue(event.getValueR());
		r_text.setText("" + event.getValueR());
		
		g.setValue(event.getValueG());
		g_text.setText("" + event.getValueG());
		
		b.setValue(event.getValueB());
		b_text.setText("" + event.getValueB());
		
		hexa.setText("" + event.getHexa());
		
		color.setStyle("-fx-background-color: #" + event.getHexa() + ";");
	}
}
