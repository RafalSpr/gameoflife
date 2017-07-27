package com.rafspre.controller;

import com.rafspre.logika.AlgorytmGry;
import com.rafspre.logika.Watki;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class StackPaneController {
	@FXML
	private Pane panel;
	@FXML
	private Canvas canvas;
	@FXML
	private Button button;
	@FXML
	Button button1;
	GraphicsContext gc;
	// Plansza plansza;
	AlgorytmGry gra;
	private boolean czyUruchomionoWatek;
	private Runnable runnable;
	private Thread thread;

	public StackPaneController() {
		czyUruchomionoWatek = false;
	}

	@FXML
	void initialize() {

		// plansza = new
		// Plansza(canvas,gc,(int)canvas.getWidth(),(int)canvas.getHeight());
		gra = new AlgorytmGry(canvas, gc, (int) canvas.getWidth(), (int) canvas.getHeight());
		gra.losujBakterie();
		gra.rysujKwadraty();
		runnable = gra;
		thread = new Thread(runnable, "W¹tek");

	}

	public void onClick(MouseEvent e) {
		int x = (int) e.getX();
		int y = (int) e.getY();
		x = x / gra.getSzerokoscPola() * gra.getSzerokoscPola();
		y = y / gra.getSzerokoscPola() * gra.getSzerokoscPola();
		gra.rysujKwadrat(x, y);

	}

	public void onClickButton(ActionEvent e) {
		gra.aktualizujPlansze();
		gra.rysujKwadraty();
	}

	public void onClickButton1(ActionEvent e) {
		if (!gra.czyUruchomionoWatek) {
			gra.czyUruchomionoWatek = true;
			button1.setText("Zatrzymaj animacjê");
			thread = new Thread(runnable, "W¹tek");
			thread.start();
		} else {
			gra.czyUruchomionoWatek = false;
			button1.setText("Ci¹g³a animacja");
		}
	}

}
