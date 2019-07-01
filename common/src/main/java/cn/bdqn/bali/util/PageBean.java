package cn.bdqn.bali.util;

import java.util.List;

/**
 * 分页的工具类
 * 
 * @author WindLin
 * 
 */
public class PageBean<T> {

	private int pageNo = 1; // 当前页
	private int pageSize = 8; // 每页的数量
	private int totalCount; // 总记录数
	private int totalPages; // 总页数
	private List<T> pageList; // 每页对应新闻的集合

	public int getPageNo() {
		return pageNo;
	}
	
	//对当前页面的判断: 不能小于1且不能大于总页数
	public void setPageNo(int pageNo) {
		if(pageNo<1){
			this.pageNo = 1;
		}else if(pageNo>totalPages && totalPages>0){
			this.pageNo = totalPages;
		}else{
			this.pageNo = pageNo;
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}
	
	//总页数由总记录数计算
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		if(this.totalCount>0){
			this.totalPages = (totalCount%pageSize==0)?totalCount/pageSize:totalCount/pageSize+1;
		}
	}

	//只读总页数
	public int getTotalPages() {
		return totalPages;
	}
	

	public List<T> getPageList() {
		return pageList;
	}

	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}

}
