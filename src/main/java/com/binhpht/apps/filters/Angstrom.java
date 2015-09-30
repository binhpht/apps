package com.binhpht.apps.filters;

public class Angstrom {
	public static int calAngstrom(float t, float r) {
		double i = (r / 20) + (27 - t) / 10;
		int level = 1;
		if (i >= 4) {
			level = 1;
		} else {
			if (i < 4 && i >= 2.5) {
				level = 2;

			} else {
				if (i < 2.5 && i >= 2) {
					level = 3;

				} else {
					if (i < 2) {
						level = 4;

					}


				}
			}
		}
		System.out.println("Muc do canh bao"+level);
		return level;
	}

}
