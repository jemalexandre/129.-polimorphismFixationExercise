package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		List<Product> list = new ArrayList<>();
		
		for (int i=0; i<n; i++) {
			System.out.println("Product #" + (i+1) + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if(ch == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				Product pro = new ImportedProduct(name, price, customsFee);
				list.add(pro);
			} else if(ch == 'c') {
				Product pro = new Product(name, price);
				list.add(pro);
			} else {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				Product pro = new UsedProduct(name, price, manufactureDate);
				list.add(pro);
			} //end if
		} //end for
		sc.close();
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		for(Product pro : list) {
			System.out.println(pro.priceTag());
		}
		
	} //end main
} //end class
