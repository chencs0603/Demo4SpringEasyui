package personal.chencs.learn.domain;

/**
 * 分页查询条件
 * @author chencs
 *
 */
public class Pagination {
	
	private int pageNo;//页码
	private int pageSize;//每页包含的行数
	
	private int startRowNo;//开始行
	private int endRowNo;//结束行
	
	public Pagination(int pageNo, int pageSize){
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}
	
	/**
	 * 计算起止行
	 */
	public void computeRowRange(){
		this.startRowNo = (pageNo - 1)*pageSize;
		this.endRowNo = pageNo*pageSize;
	}
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStartRowNo() {
		return startRowNo;
	}
	public void setStartRowNo(int startRowNo) {
		this.startRowNo = startRowNo;
	}
	public int getEndRowNo() {
		return endRowNo;
	}
	public void setEndRowNo(int endRowNo) {
		this.endRowNo = endRowNo;
	}
	
	

}
