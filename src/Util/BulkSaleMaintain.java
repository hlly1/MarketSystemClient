package Util;

import java.util.ArrayList;

import Modle.BulkSale;
import Modle.Sale;

public class BulkSaleMaintain {

	public ArrayList<BulkSale> addSaleReport(BulkSale newBulkSale){
			
		DataGetUtil dgu = new DataGetUtil();
		ArrayList<BulkSale> bs = dgu.bulkSaleGet();
		bs.add(newBulkSale);
		return bs;
	}
	
	
}
