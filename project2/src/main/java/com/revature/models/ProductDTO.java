	package com.revature.models;

	import java.time.LocalDateTime;

	public class ProductDTO {
		private int id1;
		private String name;
		private double price;
		private String image;
		private int available_quantity;
		private int qnt;
		private Categories product_category;
		private int id;
		private String category_name;
		private double eachprice;
		private int ownId;
		
		public ProductDTO() {
			super();
		}

		public ProductDTO(int id1, String name, double price, String image, int available_quantity, int qnt,
				Categories product_category, int id, String category_name, double eachprice, int ownId) {
			super();
			this.id1 = id1;
			this.name = name;
			this.price = price;
			this.image = image;
			this.available_quantity = available_quantity;
			this.qnt = qnt;
			this.product_category = product_category;
			this.id = id;
			this.category_name = category_name;
			this.eachprice = eachprice;
			this.ownId = ownId;
		}

		@Override
		public String toString() {
			return "ProductDTO [id1=" + id1 + ", name=" + name + ", price=" + price + ", image=" + image
					+ ", available_quantity=" + available_quantity + ", qnt=" + qnt + ", product_category="
					+ product_category + ", id=" + id + ", category_name=" + category_name + ", eachprice=" + eachprice
					+ ", ownId=" + ownId + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + available_quantity;
			result = prime * result + ((category_name == null) ? 0 : category_name.hashCode());
			long temp;
			temp = Double.doubleToLongBits(eachprice);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + id;
			result = prime * result + id1;
			result = prime * result + ((image == null) ? 0 : image.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ownId;
			temp = Double.doubleToLongBits(price);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + ((product_category == null) ? 0 : product_category.hashCode());
			result = prime * result + qnt;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ProductDTO other = (ProductDTO) obj;
			if (available_quantity != other.available_quantity)
				return false;
			if (category_name == null) {
				if (other.category_name != null)
					return false;
			} else if (!category_name.equals(other.category_name))
				return false;
			if (Double.doubleToLongBits(eachprice) != Double.doubleToLongBits(other.eachprice))
				return false;
			if (id != other.id)
				return false;
			if (id1 != other.id1)
				return false;
			if (image == null) {
				if (other.image != null)
					return false;
			} else if (!image.equals(other.image))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (ownId != other.ownId)
				return false;
			if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
				return false;
			if (product_category == null) {
				if (other.product_category != null)
					return false;
			} else if (!product_category.equals(other.product_category))
				return false;
			if (qnt != other.qnt)
				return false;
			return true;
		}

		public int getId1() {
			return id1;
		}

		public void setId1(int id1) {
			this.id1 = id1;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public int getAvailable_quantity() {
			return available_quantity;
		}

		public void setAvailable_quantity(int available_quantity) {
			this.available_quantity = available_quantity;
		}

		public int getQnt() {
			return qnt;
		}

		public void setQnt(int qnt) {
			this.qnt = qnt;
		}

		public Categories getProduct_category() {
			return product_category;
		}

		public void setProduct_category(Categories product_category) {
			this.product_category = product_category;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getCategory_name() {
			return category_name;
		}

		public void setCategory_name(String category_name) {
			this.category_name = category_name;
		}

		public double getEachprice() {
			return eachprice;
		}

		public void setEachprice(double eachprice) {
			this.eachprice = eachprice;
		}

		public int getOwnId() {
			return ownId;
		}

		public void setOwnId(int ownId) {
			this.ownId = ownId;
		}



		

	}

