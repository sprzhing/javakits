package com.baidu.phoenix.test;

public interface VasConst {
	public static enum SPecialCardHeadcount {
		HC1("20人以下"), HC2("20~99人"), HC3("100~499人"), HC4("500~999人"), HC5(
				"1000~9999人"), HC6("10000人以上");
		private String value;

		private SPecialCardHeadcount(String value) {
			this.value = value;
		}

		public String value() {
			return value;
		}
	}
}
