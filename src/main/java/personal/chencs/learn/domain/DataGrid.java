package personal.chencs.learn.domain;

import java.util.List;

public class DataGrid<T> {
	
	private int page;
	private List<T> rows;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	

}
