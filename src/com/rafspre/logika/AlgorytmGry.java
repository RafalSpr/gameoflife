package com.rafspre.logika;

import java.util.Random;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class AlgorytmGry extends Plansza implements Runnable {
	private int szerokoscPola, width, height;
	private final int czestosc = 4;
	public boolean czyUruchomionoWatek = false;

	public AlgorytmGry(Canvas canvas, GraphicsContext gc, int width, int height) {
		super(canvas, gc, width, height);
		szerokoscPola = super.getSzerokoscPola();
		this.width = width;
		this.height = height;
	}

	public void losujBakterie() {
		Random r = new Random();
		for (int i = 1; i <= width / szerokoscPola; i++)
			for (int j = 1; j <= height / szerokoscPola; j++)
				if (r.nextInt() % czestosc == 0)
					super.setTabPlansza(i, j, 1);
	}

	public boolean czyZyje(int x, int y) {
		int policz = 0;
		policz = super.getTabPlansza(x - 1, y) + super.getTabPlansza(x + 1, y);
		policz += super.getTabPlansza(x, y - 1) + super.getTabPlansza(x, y + 1);
		policz += super.getTabPlansza(x - 1, y - 1) + super.getTabPlansza(x + 1, y + 1);
		policz += super.getTabPlansza(x + 1, y - 1) + super.getTabPlansza(x - 1, y + 1);
		if (super.getTabPlansza(x, y) == 0 && policz == 3)
			return true;
		if (super.getTabPlansza(x, y) == 1 && (policz == 3 || policz == 2))
			return true;

		return false;
	}

	public void aktualizujPlansze() {
		int[][] pomTabPlansza = new int[width / szerokoscPola + 3][height / szerokoscPola + 2];
		for (int i = 1; i <= width / szerokoscPola; i++)
			for (int j = 1; j <= height / szerokoscPola; j++)
				if (czyZyje(i, j))
					pomTabPlansza[i][j] = 1;
				else
					pomTabPlansza[i][j] = 0;
		int[][] pomTab = new int[width / szerokoscPola + 3][height / szerokoscPola + 2];
		pomTab = super.getTabPlansza();
		System.arraycopy(pomTabPlansza, 0, pomTab, 0, pomTab.length);
		super.setTabPlansza(pomTab);

	}

	@Override
	public void run() {
		while (czyUruchomionoWatek) {
			aktualizujPlansze();
			rysujKwadraty();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
