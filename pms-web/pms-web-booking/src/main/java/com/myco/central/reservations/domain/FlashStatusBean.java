package com.myco.central.reservations.domain;

public class FlashStatusBean {
	private String[][] matrix;
	private String startDate;
	private int rows;
	private int cols;
	private int actualRow;
	private int actualCol;
	private int firstCol;
	private int lastCol;
	private boolean moreInfo;

	public String[][] getMatrix() {
		return matrix;
	}
	public void setMatrix(String[][] matrix) {
		this.matrix = matrix;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getCols() {
		return cols;
	}
	public void setCols(int cols) {
		this.cols = cols;
	}
	public int getActualRow() {
		return actualRow;
	}
	public void setActualRow(int actualRow) {
		this.actualRow = actualRow;
	}
	public int getActualCol() {
		return actualCol;
	}
	public void setActualCol(int actualCol) {
		this.actualCol = actualCol;
	}
	public int getFirstCol() {
		return firstCol;
	}
	public void setFirstCol(int firstCol) {
		this.firstCol = firstCol;
	}
	public int getLastCol() {
		return lastCol;
	}
	public void setLastCol(int lastCol) {
		this.lastCol = lastCol;
	}
	public boolean isMoreInfo() {
		return moreInfo;
	}
	public void setMoreInfo(boolean moreInfo) {
		this.moreInfo = moreInfo;
	}

	public void forward(int columns) {
		this.startDate = (matrix[0][lastCol + 1]);
		this.actualCol = actualCol + columns;
		this.firstCol = firstCol + columns;
		this.lastCol = lastCol + columns;
		this.moreInfo = ( cols > lastCol ? true : false );
	}

}
