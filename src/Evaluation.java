import java.text.DecimalFormat;

/* Distance from center
 * Same color pawns around
 * Same color knights around
 * Opposing pieces around
 * Opposing pawns around
 */

public class Evaluation {
	public final double pawnV = 1;		/*///////////////////////*/
	public final double rookV = 5;		/*	Values of pieces	 */
	public final double knightV = 3.05;	/*						 */
	public final double bishopV = 3.45;	/*						 */
	public final double queenV = 9;		/*						 */
	
	public Evaluation() {
		
	}
	
	public double evaluatePieceValue(Position pos) {
		double score = 0.0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (pos.position[i][j] == 7) {
					score -= pawnV;
				} else if (pos.position[i][j] == 1) {
					score += pawnV;
				} else if (pos.position[i][j] == 10) {
					score -= rookV;
				} else if (pos.position[i][j] == 4) {
					score += rookV;
				} else if (pos.position[i][j] == 8) {
					score -= knightV;
				} else if (pos.position[i][j] == 2) {
					score += knightV;
				} else if (pos.position[i][j] == 9) {
					score -= bishopV;
				} else if (pos.position[i][j] == 3) {
					score += bishopV;
				} else if (pos.position[i][j] == 11) {
					score -= queenV;
				} else if (pos.position[i][j] == 5) {
					score += queenV;
				}
			}
		}
	
		DecimalFormat df = new DecimalFormat("#.##");
		score = Double.valueOf(df.format(score));
		if (score == 0.0) {
			score = 0.0;
		}
		return score;
	}
	
	public double evaluateKingSafety(Position pos) {
		double score = 0.0;
		byte piece;
		
		//Finds King
		int[] kingLocation = findKing(pos);
		int kingR = kingLocation[0];
		int kingC = kingLocation[1];
		
		//Checks first circle around King
		for (int r = kingR - 1; r < kingR + 2; r++) {
			for (int c = kingC - 1; c < kingC + 2; c++) {
				if (r > -1 && r < 8 && c > -1 && c < 8) {
					piece = pos.position[r][c];
					if (piece == 1) {
						score += 1;
					} if (piece == 7) {
						score += -1;
					} if (piece == 2 || piece == 3 || piece == 4) {
						score += 1.5;
					} if (piece == 8 || piece == 9 || piece == 10) {
						score += -1.5;
					} if (piece == 5) {
						score += 3;
					} if (piece == 11) {
						score += -3;
					}
				}
			}
		}
		
		//Checks second circle around King
		for (int r = kingR - 2; r < kingR + 3; r++) {
			for (int c = kingC - 2; c < kingC + 3; c++) {
				if (r > -1 && r < 8 && c > -1 && c < 8 && !(r > kingR -2 && r < kingR + 2 && c > kingC - 2 && c < kingC + 2)) {
					piece = pos.position[r][c];
					if (piece == 1) {
						score += 0.5;
					} if (piece == 7) {
						score += -0.5;
					} if (piece == 2 || piece == 3 || piece == 4) {
						score += 0.75;
					} if (piece == 8 || piece == 9 || piece == 10) {
						score += -0.75;
					} if (piece == 5) {
						score += 1.5;
					} if (piece == 11) {
						score += -1.5;
					}
				}
			}
		}
		
		//Checks for distance from center
		double distanceScore = (Math.abs(kingR - 3.5) + Math.abs(kingC - 3.5))/2.0;
		if (pos.blackToMove) {
			score -= distanceScore;
		} else {
			score += distanceScore;
		}
		
		return score;
	}
	
	/*Finds location of the king corresponding to which color's move it is.
	 * Returns an array of two integers for the row and column.
	 * Returns {-1, -1} if king is not found (this should never happen).
	 */
	private int[] findKing(Position pos) {
		byte targetKing;
		if (pos.blackToMove) {
			targetKing = 12;
		} else {
			targetKing = 6;
		}
		int[] kingLocation = {-1, -1};
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				if (pos.position[r][c] == targetKing) {
					kingLocation[0] = r;
					kingLocation[1] = c;
					return kingLocation;
				}
			}
		}
		return kingLocation;
	}
}