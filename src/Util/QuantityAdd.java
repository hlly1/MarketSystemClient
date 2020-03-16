package Util;

import Modle.Product;

public class QuantityAdd {

	
	public Product[] quantityAdd(Product[] product, int id, double add) {
		Product[] p = product;
		for(int i = 0; i < product.length;i++) {
			if(product[i].getId() == id) {
				Double quantityNew = p[i].addQuantity(add);
				p[i].setQuantity(quantityNew);
			}	
		}	
		return p;
	}
}
