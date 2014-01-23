package com.weixin.comm;

import java.util.List;

public class PageInfo<T> {

	private List<T> resultlist;
	private PageIndex pageIndex;
	private long totalrecond;
	private long firstindex = 1;
	private long maxresult = 3;
	private long pagecount;
	private long resultlistsize = 0;

	public PageInfo() {
		super();
	}

	public PageInfo(List<T> resultlist, Long totalrecond, Long firstindex, Long maxresult) {
		super();
		this.resultlist = resultlist;
		this.totalrecond = totalrecond;
		this.firstindex = firstindex;
		this.maxresult = maxresult;
		if (maxresult != null) {
			this.pagecount = this.totalrecond % this.maxresult > 0 ? this.totalrecond
					/ this.maxresult + 1
					: this.totalrecond / this.maxresult;
		}
		if (maxresult != null && firstindex != null) {
			getPageIndex(this.maxresult, this.firstindex, this.pagecount);
		}
		this.resultlistsize = resultlist.size();
	}

	public long getFirstindex() {
		return firstindex < 1 ? 1 : firstindex;
	}

	public void setFirstindex(Integer firstindex) {
		this.firstindex = firstindex;
	}

	public long getMaxresult() {
		return maxresult;
	}

	public void setMaxresult(Integer maxresult) {
		this.maxresult = maxresult;
	}

	public long getPagecount() {
		return pagecount;
	}

	public void setPagecount(Integer pagecount) {
		this.pagecount = pagecount;
	}

	public List<T> getResultlist() {
		return resultlist;
	}

	public void setResultlist(List<T> resultlist) {
		this.resultlist = resultlist;
	}

	public long getTotalrecond() {
		return totalrecond;
	}

	public void setTotalrecond(Integer totalrecond) {
		this.totalrecond = totalrecond;
	}

	public long getResultlistsize() {
		return resultlistsize;
	}

	public void setResultlistsize(Integer resultlistsize) {
		this.resultlistsize = resultlistsize;
	}

	public PageIndex getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(PageIndex pageIndex) {
		this.pageIndex = pageIndex;
	}

	public void getPageIndex(long viewpagecount, long currentPage, long totalpage) {
		long startpage = currentPage
				- (viewpagecount % 2 == 0 ? viewpagecount / 2 - 1
						: viewpagecount / 2);
		long endpage = currentPage + viewpagecount / 2;
		if (startpage < 1) {
			startpage = 1;
			if (totalpage >= viewpagecount)
				endpage = viewpagecount;
			else
				endpage = totalpage;
		}
		if (endpage > totalpage) {
			endpage = totalpage;
			if ((endpage - viewpagecount) > 0)
				startpage = endpage - viewpagecount + 1;
			else
				startpage = 1;
		}
		pageIndex = new PageIndex(startpage, endpage);
	}

	public class PageIndex {
		private long startindex;
		private long endindex;

		public PageIndex(long startindex, long endindex) {
			super();
			this.startindex = startindex;
			this.endindex = endindex;
		}

		public long getEndindex() {
			return endindex;
		}

		public void setEndindex(long endindex) {
			this.endindex = endindex;
		}

		public long getStartindex() {
			return startindex;
		}

		public void setStartindex(long startindex) {
			this.startindex = startindex;
		}
	}
}
