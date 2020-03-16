package Util;

import java.util.ArrayList;

import Modle.Sale;

public class SaleReportAdd {
	
	public ArrayList<Sale> addSaleReport(Sale newOrder){
		
		DataGetUtil dgu = new DataGetUtil();
		ArrayList<Sale> s = dgu.saleReportGet();
		s.add(newOrder);
		return s;
	}
	
}
