package pl.coderslab.filter.service;

import pl.coderslab.filter.entities.FilterInfo;
import pl.coderslab.filterDao.FilterInfoDao;

public class FilterInfoService {
	private FilterInfoDao filterInfoDao;
	
	public FilterInfoService() {
		filterInfoDao = new FilterInfoDao();
	}
	
	public void insertFilterInfo (FilterInfo filterInfo){
		filterInfoDao.insertFilter(filterInfo);
	}
	

}
