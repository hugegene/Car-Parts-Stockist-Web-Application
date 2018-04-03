package nus.iss.sa45.team13.stockist.validators;



import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import nus.iss.sa45.team13.stockist.model.Product;

@Component
public class ProductValidator implements Validator {

	private Pattern pattern;
	private Matcher matcher;

	String STRING_PATTERN = "[a-zA-Z\\s0-9]+";
	String MOBILE_PATTERN = "[0-9]{3}";
	String COUNTRY_PATTERN = "[a-zA-Z]+";
	String AZ_PATTERN = "[a-zA-Z]+";
	String INT_PATTERN = "[0-9]{10}";
	String PRICE_PATTERN = "([+-]?\\d*\\.\\d+)(?![-+0-9\\.])";;
	String SUPPLIER_PATTERN = "[1-3]{3}";
	String REORDERPOINT_PATTERN = "[0-5]{3}";
	String NO_PATTERN = "^[0-9]*$";
	String DOUBLE_PATTERN = "[\\x00-\\x20]*[+-]?(((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*";

	@Override
	public boolean supports(Class<?> arg0) {
		return Product.class.isAssignableFrom(arg0);

	}

	@Override
	public void validate(Object arg0, Errors arg1) throws NumberFormatException {
		Product p = (Product) arg0;
		ValidationUtils.rejectIfEmpty(arg1, "partName", "error.product.partName.empty");
		ValidationUtils.rejectIfEmpty(arg1, "unitPrice", "error.product.unitPrice.empty");
		ValidationUtils.rejectIfEmpty(arg1, "description", "error.product.description.empty");
		ValidationUtils.rejectIfEmpty(arg1, "color", "error.product.color.empty");
		ValidationUtils.rejectIfEmpty(arg1, "dimension", "error.product.dimension.empty");
		ValidationUtils.rejectIfEmpty(arg1, "supplierId", "error.product.supplierId.empty");
		ValidationUtils.rejectIfEmpty(arg1, "reorderPoint", "error.product.reorderPoint.empty");
		ValidationUtils.rejectIfEmpty(arg1, "minOrder", "error.product.minOrder.empty");
		ValidationUtils.rejectIfEmpty(arg1, "shelfLocation", "error.product.shelfLocation.empty");
		ValidationUtils.rejectIfEmpty(arg1, "category", "error.product.category.empty");

		// input string contains characters only for name
		if (!(p.getPartName() != null && p.getPartName().isEmpty())) {
			pattern = Pattern.compile(STRING_PATTERN);
			matcher = pattern.matcher(p.getPartName());
			if (!matcher.matches()) {

				arg1.rejectValue("partName", "partName.containNonChar", "Enter a valid Name.");
			}
		}

		// input string contains numeric values only for unitPrice
		if (p.getUnitPrice() != null) {
			String c = String.valueOf(p.getUnitPrice());
			if (!c.contains(".")) {
				pattern = Pattern.compile(DOUBLE_PATTERN);
				matcher = pattern.matcher(c);
				if (!matcher.matches()) {
					arg1.rejectValue("unitPrice", "unitPrice.incorrect", "UnitPrice should contain decimal.");
				}
			}
		}

		// input string contains characters only for description
		if (!(p.getDescription() != null && p.getDescription().isEmpty())) {
			pattern = Pattern.compile(STRING_PATTERN);
			matcher = pattern.matcher(p.getDescription());
			if (!matcher.matches()) {

				arg1.rejectValue("description", "description.containNonChar", "Enter a valid Description.");
			}
		}

		// input string contains characters only for color
		if (!(p.getColor() != null && p.getColor().isEmpty())) {
			pattern = Pattern.compile(STRING_PATTERN);
			matcher = pattern.matcher(p.getColor());
			if (!matcher.matches()) {

				arg1.rejectValue("color", "color.containNonChar", "Enter a valid Color.");
			}
		}
		
		// input string contains numeric values only for dimension
		if (p.getDimension() != null) {
			String c = String.valueOf(p.getDimension());
			if (!c.contains(".")) {
				pattern = Pattern.compile(DOUBLE_PATTERN);
				matcher = pattern.matcher(c);
				if (!matcher.matches()) {
					arg1.rejectValue("dimension", "dimension.incorrect", "Dimension should contain decimal.");
				}
			}
		}

		// input string contains numeric values only for supplierId
		if (p.getSupplierId() != null) {
			if (p.getSupplierId() < 100 || p.getSupplierId() > 139) {
				pattern = Pattern.compile(SUPPLIER_PATTERN);
				matcher = pattern.matcher(Integer.toString(p.getSupplierId()));
				if (!matcher.matches()) {
					arg1.rejectValue("supplierId", "supplierId.incorrect", "SupplierId should be between 100-139");
				}
			}

			// input string contains numeric values only for reOrderPoint
			if (p.getReorderPoint() != null) {
				if (p.getReorderPoint() < 0 || p.getReorderPoint() > 500) {
					pattern = Pattern.compile(REORDERPOINT_PATTERN);
					matcher = pattern.matcher(Integer.toString(p.getReorderPoint()));
					if (!matcher.matches()) {
						arg1.rejectValue("reorderPoint", "reorderPoint.incorrect",
								"ReOrderPoint should be between 0-500");
					}
				}

				// input string contains numeric values only for MinOrder
				if (p.getMinOrder() != null) {
					if (p.getMinOrder() < 1 || p.getMinOrder() > 200) {
						pattern = Pattern.compile(SUPPLIER_PATTERN);
						matcher = pattern.matcher(Integer.toString(p.getMinOrder()));
						if (!matcher.matches()) {
							arg1.rejectValue("minOrder", "minOrder.incorrect", "Min.Order should be between 1-200");
						}
					}

					// input string contains characters only for shelfLocation
					if (!(p.getShelfLocation() != null && p.getShelfLocation().isEmpty())) {
						pattern = Pattern.compile(STRING_PATTERN);
						matcher = pattern.matcher(p.getShelfLocation());
						if (!matcher.matches()) {

							arg1.rejectValue("shelfLocation", "shelfLocation.containNonChar",
									"Enter a valid Shelf Location.");
						}
					}

					// input string contains characters only for category
					if (!(p.getCategory() != null && p.getCategory().isEmpty())) {
						pattern = Pattern.compile(STRING_PATTERN);
						matcher = pattern.matcher(p.getCategory());
						if (!matcher.matches()) {

							arg1.rejectValue("category", "category.containNonChar", "Enter a valid Category.");
						}
					}

					System.out.println(p.toString());
				}
			}
		}
	}
}