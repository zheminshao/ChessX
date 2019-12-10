import data.Move;
import data.Position;

public class PawnDistance {
	public boolean whitePawnPos = false;
	public boolean blackPawnPos = false;

	public DistanceCheck(Position pstn) {
		for (i = 0; i < 8; i++) {
			for (j = 0; j < 8; j++){
				if (pstn.getSquare(i, j) == 7) {
					for (cb = i; !whitePawnPos; cb++){
						if (pstn.getSquare(cb, j) == 1) {
							whitePawnPos = true;
							return cb - i;

						} else {
							whitePawnPos = false;

						}

					}

				} else if (pstn.getSquare(i, j) == 1) {
					for (cw = i; !blackPawnPos; cw--){
						if (pstn.getSquare(cw, j) == 7) {
							blackPawnPos = true;
							return cw - i;

						} else {
							blackPawnPos = false;

						}

					}

				}

			}

		}
	}
	

}