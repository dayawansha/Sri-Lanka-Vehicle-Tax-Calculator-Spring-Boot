package com.tax.carTax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarTaxApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarTaxApplication.class, args);


		double vehicalValueUSD = 21500;
		double engineSize = 1500;
		String fuelType = "ph";

		double vehicalValueLKR = 300 * vehicalValueUSD;
		double indurenceAndTraceport = 450000;
        double cif = vehicalValueLKR + indurenceAndTraceport ;

		double secondHandCif = 0.85 * cif;

		double exciseDuty = 0;


        if (engineSize <= 1000 && fuelType.equals("p")) {
			exciseDuty = engineSize * 2450;
        }
        else if (engineSize <= 1000 && fuelType.equals("ph")) {
			exciseDuty = engineSize * 2750;
        }

		else if (1000 < engineSize && engineSize <= 1300 && fuelType.equals("p")) {
			exciseDuty = engineSize * 3850;
        } else if (1000 < engineSize && engineSize <= 1300 && fuelType.equals("ph")) {
			exciseDuty = engineSize * 2750;
        }

		else if (1300 < engineSize && engineSize <= 1500 && fuelType.equals("p")) {
			exciseDuty = engineSize * 4450;
        } else if (1300 < engineSize && engineSize <= 1500 && fuelType.equals("ph")) {
			exciseDuty = engineSize * 3450;
        }

		else if (1500 < engineSize && engineSize <= 1600 && fuelType.equals("p")) {
			exciseDuty = engineSize * 5150;
        } else if (1500 < engineSize && engineSize <= 1600 && fuelType.equals("ph")) {
			exciseDuty = engineSize * 4800;
        }

//		double portClearingCharges = 150000;
		double customImportDuty_CID_And_Surcharge = secondHandCif * 0.3;  // ( CID=20%, Surcharge=10% )
		double portAndAirportLevy_PAL = 0.1 * secondHandCif;             // PAL=10%


///		luxury Tax calculation
		double luxuryTax =0;
		if(fuelType.equals("p")){
			if (secondHandCif > 5000000 ){
				luxuryTax = (secondHandCif - 5000000) ;
			}
		}else if(fuelType.equals("ph")){
			if (secondHandCif > 5500000 ){
				luxuryTax = 0.8 * (secondHandCif - 5000000) ;
			}
		}


//		double vat18 = 0.18 * (secondHandCif + portAndAirportLevy_PAL + exciseDuty + customImportDuty_CID_And_Surcharge );
		double vat18 = 0.18 * (secondHandCif + portAndAirportLevy_PAL  + customImportDuty_CID_And_Surcharge ); // no exciseDuty

		double vehicalTotal = vehicalValueLKR + exciseDuty + luxuryTax + portAndAirportLevy_PAL + customImportDuty_CID_And_Surcharge + vat18 ;

		int serviceCharge = 150000; // punchi car niwasa
		int finalValue = (int) vehicalTotal + serviceCharge;

		System.out.println( "FInala Vehical cost  " + finalValue );


	}

}
