package com.rafspre.logika;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Plansza {
	private int szerokoscPola = 20;
	private int width, height;
	private GraphicsContext gc;
	private int[][] tabPlansza;

	public int[][] getTabPlansza() {
		return tabPlansza;
	}
	public void setTabPlansza(int[][] tabPlansza) {
		this.tabPlansza = tabPlansza;
	}
	public void setTabPlansza(int x, int y, int wartosc) {
		tabPlansza[x][y] = wartosc;
	}
	public int getTabPlansza(int x, int y) {
		return tabPlansza[x][y] ;
	}
	public int getSzerokoscPola() {
		return szerokoscPola;
	}

	// Konstruktor
	public Plansza(Canvas canvas, GraphicsContext gc, int width, int height) {
		tabPlansza = new int[width / szerokoscPola + 2][height / szerokoscPola + 2];
		// this.canvas=canvas;
		this.width = width;
		this.height = height;
		gc = canvas.getGraphicsContext2D();
		this.gc = gc;
		this.gc.setStroke(Color.RED);
		this.gc.setLineWidth(1);
		for (int i = 0; i <= width / szerokoscPola; i++)
			this.gc.strokeLine(i * szerokoscPola, 0, i * szerokoscPola, 800);
		for (int i = 0; i <= height / szerokoscPola; i++)
			this.gc.strokeLine(0, szerokoscPola * i, 800, szerokoscPola * i);
	}

	public void rysujKwadrat(int x, int y) {
		int pomX, pomY;
		pomX=x/szerokoscPola+1;
		pomY=y/szerokoscPola+1;
		if (tabPlansza[pomX][pomY] == 0)
			gc.setFill(Color.BLUE);
		else
			gc.setFill(Color.WHITE);
		gc.fillRect(x + 1, y + 1, szerokoscPola - 2, szerokoscPola - 2);
		tabPlansza[pomX][pomY] = 1 - tabPlansza[pomX][pomY];

	}

	public void rysujKwadraty() {
		for (int i = 1; i <= width / szerokoscPola; i++)
			for (int j = 1; j <= height / szerokoscPola; j++) {
				if (tabPlansza[i][j]==0)
					gc.setFill(Color.WHITE);
				else
					gc.setFill(Color.BLUE);
				gc.fillRect((i-1)*szerokoscPola + 1, szerokoscPola*(j-1) + 1, szerokoscPola - 2, szerokoscPola - 2);
			}
	}

}
